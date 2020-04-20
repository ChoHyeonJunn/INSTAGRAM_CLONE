package com.instagram.clone.model.vo;

import java.sql.Date;
import java.util.List;

public class DmVo {
	private int room_code; // 방번호

	private int member_code; // 작성자
	private List<Integer> member_code_list; // 참여인원

	private Date message_date; // 작성일

	private String message; // 작성한 글

}
