package com.instagram.clone.model.biz.member;

import java.util.List;
import java.util.Map;

import com.instagram.clone.model.vo.MemberJoinProfileVo;
import com.instagram.clone.model.vo.MemberProfileVo;
import com.instagram.clone.model.vo.MemberVo;

public interface MemberBiz {

	/*
	 * 로그인
	 */
	//
	public Map<String, Object> login(MemberVo vo);

	public MemberVo snsLogin(MemberVo vo);

	public int emailCheck(MemberVo vo);

	public int idCheck(MemberVo vo);

	public int join(MemberVo vo);

	public MemberProfileVo selectMemberProfile(int member_code);

	public int updateMemberProfileImage(MemberProfileVo member_profile);

	public List<MemberJoinProfileVo> nameSearchAutoComplete(int my_member_code, String id_name);

}
