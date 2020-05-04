package com.instagram.clone.model.biz.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.instagram.clone.model.dao.member.MemberDao;
import com.instagram.clone.model.vo.MemberJoinProfileSimpleVo;
import com.instagram.clone.model.vo.MemberJoinProfileVo;
import com.instagram.clone.model.vo.MemberProfileVo;
import com.instagram.clone.model.vo.MemberVo;

@Service
public class MemberBizImpl implements MemberBiz {

	@Autowired
	private MemberDao dao;

	@Override
	public Map<String, Object> login(MemberVo vo) {
		Map<String, Object> map = null;

		MemberVo mres = dao.login(vo);
		MemberProfileVo mpres = dao.selectMemberProfile(mres.getMember_code());

		if (mres != null && mpres != null) {
			map = new HashMap<>();

			map.put("login", mres);
			map.put("profile", mpres);
			return map;
		} else {
			return map; // 멤버 정보를 가져오지 못했다면 null인 객체를 return
		}
	}

	@Override
	public MemberVo snsLogin(MemberVo vo) {
		return dao.snsLogin(vo);
	}

	@Override
	public int emailCheck(MemberVo vo) {
		return dao.emailCheck(vo);
	}

	@Override
	public int idCheck(MemberVo vo) {
		return dao.idCheck(vo);
	}

	@Override
	@Transactional
	public int join(MemberVo vo) {
		int jres = dao.join(vo);
		int pres = dao.insertProfile(new MemberProfileVo(dao.login(vo).getMember_code()));
		return (jres > 0 && pres > 0) ? 1 : 0;
	}

	@Override
	public MemberProfileVo selectMemberProfile(int member_code) {
		return dao.selectMemberProfile(member_code);
	}

	@Override
	public int updateMemberProfileImage(MemberProfileVo member_profile) {
		return dao.updateMemberProfileImage(member_profile);
	}

	@Override
	public List<MemberJoinProfileVo> nameSearchAutoComplete(int my_member_code, String id_name) {
		return dao.nameSearchAutoComplete(my_member_code, id_name);
	}

	@Override
	public List<MemberJoinProfileSimpleVo> selectMemberList(List<Integer> codeList) {
		return dao.selectMemberList(codeList);
	}

}
