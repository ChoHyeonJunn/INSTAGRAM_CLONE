package com.instagram.clone.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.instagram.clone.model.biz.member.MemberBiz;
import com.instagram.clone.model.vo.MemberJoinProfileVo;

@RestController
@RequestMapping("/dm")
public class DmController {

	private static final Logger logger = LoggerFactory.getLogger(FeedController.class);

	@Autowired
	private MemberBiz memberBiz;

	// dm.jsp 로 이동
	@GetMapping(value = "/dm")
	public ModelAndView dmPage() {
		logger.info("DM/DM.GET");
		return new ModelAndView("dm/dm");
	}

	// nameSearchAutoComplete
	@PostMapping(value = "/nameSearchAutoComplete")
	public List<MemberJoinProfileVo> nameSearchAutoComplete(int my_member_code, String id_name) {
		logger.info("DM/nameSearchAutoComplete.POST");
		return memberBiz.nameSearchAutoComplete(my_member_code, id_name);
	}
}
