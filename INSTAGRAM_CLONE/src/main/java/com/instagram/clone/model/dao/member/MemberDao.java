package com.instagram.clone.model.dao.member;

import java.util.List;

import com.instagram.clone.model.vo.MemberJoinProfileSimpleVo;
import com.instagram.clone.model.vo.MemberJoinProfileVo;
import com.instagram.clone.model.vo.MemberProfileVo;
import com.instagram.clone.model.vo.MemberVo;

public interface MemberDao {

	String NAMESPACE = "member.";

	public MemberVo login(MemberVo vo);

	public MemberVo snsLogin(MemberVo vo);

	public int emailCheck(MemberVo vo);

	public int idCheck(MemberVo vo);

	public int join(MemberVo vo);

	public int insertProfile(MemberProfileVo memberProfileVo);

	public MemberProfileVo selectMemberProfile(int member_code);

	public int updateMemberProfileImage(MemberProfileVo member_profile);

	public List<MemberJoinProfileVo> nameSearchAutoComplete(int my_member_code, String id_name);

	public List<MemberJoinProfileSimpleVo> selectMemberList(List<Integer> codeList);
}
