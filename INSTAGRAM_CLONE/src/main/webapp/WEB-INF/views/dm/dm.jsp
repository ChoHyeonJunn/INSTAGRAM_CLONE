<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- START :: HEADER FORM -->
	<%@ include file="../form/header.jsp"%>
<!-- END :: HEADER FORM -->

<!-- START :: css -->
	<style type="text/css">
		#mask{
			position:absolute; 
			z-index:9000; 
			background-color:#000000; 
			left:0; 
			top:0;
		}
		#searchFriendsForm{
			position:absolute; 
			z-index:9999; 
			top:30%; 
			left:30%; 
			width: 40%; 
			height:40%; 
			background-color: white;
		}
	</style>
<!-- END :: css -->

<!-- START :: chat -->
	<script type="text/javascript">
		function searchFriends() {
		    //화면의 높이와 너비를 구합니다.
		    var maskHeight = $(document).height();
		    var maskWidth  = window.document.body.clientWidth;
		     
		    //화면에 출력할 마스크를 설정해줍니다.
		    var mask = $("#mask");
		    var searchFriendsForm = $("#searchFriendsForm");
		    
		    //마스크의 높이와 너비를 화면 것으로 만들어 전체 화면을 채웁니다.
		    $('#mask').css({
		            'width' : maskWidth,
		            'height': maskHeight,
		            'opacity' :'0.6'
		    });
		    	  
		    //마스크 표시
		    $('#mask, #searchFriendsForm').show();
		}
		
		$(function(){
			$("#mask").hide();
			$("#searchFriendsForm").hide();
			
			$(document).on("click", "#mask", function(){
			    $('#mask, #searchFriendsForm').hide(); 
			})
			$(document).on("click", "#searchFriendsForm", function(){
				return false;
			})
		})
		function hideSearchFriendsForm(){
		    $('#mask, #searchFriendsForm').hide(); 
		}
	
		var ws
	    function openSocket(){
	        if(ws !== undefined && ws.readyState !== WebSocket.CLOSED){
	            writeResponse("WebSocket is already opened.")
	            return
	        }
	        //웹소켓 객체 만드는 코드
	        ws = new WebSocket("ws://localhost:8787/echo.do");
	        
	        ws.onopen=function(event){
	            if(event.data === undefined) {
	            	return
	            } else {
		            writeResponse(event.data)
	            }
	            
	        };
	        
	        ws.onmessage=function(event){
	            writeResponse(event.data)
	        };
	        
	        ws.onclose=function(event){
	            writeResponse("Connection closed")
	        }
	    }
	    
	    function send(){
	        ws.send($("#sender").val() + "," + $("#messageinput").val())
	    }
	    
	    function closeSocket(){
	        ws.close();
	    }
	    
	    function writeResponse(text){
	    	console.log(text)
	        $("#messages").append($("<div>").text(text))
		}

	</script>
<!-- END :: chat -->
	
</head>

<body>
	
	<section class="container w-75">
		<article class="row">
			
			<!-- 채팅중인 친구 리스트 -->
			<div class="col-sm-4">
				<div class="text-center">
					Direct
					<span class="float-right"><i class="far fa-edit" onclick="searchFriends();"></i></span>				
				</div>
				
				<div id="onChatList">
				
				</div>
			</div>
			
			<!-- 채팅창 OR 채팅하기버튼 -->
			<div class="col-sm-8">
				<div>
			        <input type="text" id="sender" value="${sessionLoginMember.member_email }" style="display: none;">
			        <input type="text" id="messageinput">
			    </div>
			    <div>
			        <button type="button" onclick="openSocket();">Open</button>
			        <button type="button" onclick="send();">Send</button>
			        <button type="button" onclick="closeSocket();">Close</button>
			    </div>
			    <!-- Server responses get written here -->
			    <div id="messages">
			    
			    </div>
			</div>
		</article>		
	</section>
	
	
	<div id="mask">
		<div id="searchFriendsForm" class="card rounded-lg">
			<div class="border text-center">
				<span class="float-left"><i class="fas fa-times" onclick="hideSearchFriendsForm();"></i></span>
				<strong>새로운 메시지</strong>
				<span class="float-right"><a href="">다음</a></span>
			</div>
			
			<div class="d-flex align-items-center border h-25 overflow-scroll">
				<strong>받는 사람 : </strong>
				<input type="text" name="searchFriends" autocapitalize="none" placeholder="검색..." style="border:none;border-right:0px; border-top:0px; boder-left:0px; boder-bottom:0px;">
			</div>
			
			<div id="searchedMemberList" class="border h-75 overflow-scroll">
				
			</div>		
		</div>
	</div>
	
</body>


<!-- START :: 회원 검색 자동 완성 -->
	<script type="text/javascript">
		$(function(){
			$("input[name='searchFriends']").autocomplete({
				source: function(request, response){
				    $.ajax({
				        type: "POST",
				        url: "/dm/nameSearchAutoComplete",
				        data: {
				        	my_member_code : '${sessionLoginMember.member_code}',
				        	id_name : request.term
				        },
				        datatType: "JSON",
		
				        success: function (data) {
					        response(
				        		$.map(data, function(item){
				        			return{
				        				label: item.member_id,
				        				value: item.member_id,
				        				name: item.member_name,
				        				image: item.member_profile_image_s_name
				        				
				        			}
				        		})	
				        	)
				        },
				        error: function () {
				           alert("통신 실패");
				        }
				     })
				},
				minLength : 1,
				focus : function(event, ui){
					$("input[name='searchFriends']").val(ui.item.value)
					return false;
				}
			}).autocomplete("instance")._renderItem = function(item){
				var li_item = $("<div>").attr({"class":"my-auto ml-2"});
				li_item.append($("<img>").attr({
									"class" : "m-1 w-40 h-40 bg-white vertical-align-baseline",
									"src" : <c:choose>
												<c:when test="${not empty item.image}">'/resources/images/profileupload/${item.image}'</c:when>
												<c:otherwise>'/resources/images/profile/add.png'</c:otherwise>
											</c:choose>
								}))
								.append($("<span>").attr({"class":"mx-1"}).text(item.name))
								.append($("<span>").attr({"class":"mx-1"}).text(item.label))
								
				return $("<div>").append(li_item).appendTo($("#searchedMemberList"));
			}
		
		})
	</script>
<!-- END :: 회원 검색 자동 완성 -->



</html>