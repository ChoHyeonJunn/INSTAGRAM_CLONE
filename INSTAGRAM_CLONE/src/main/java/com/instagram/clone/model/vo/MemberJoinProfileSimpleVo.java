package com.instagram.clone.model.vo;

public class MemberJoinProfileSimpleVo {

	private int member_code;

	private String member_email;
	private String member_phone;
	private String member_name;
	private String member_id;

	private String member_profile_image_s_name;

	public MemberJoinProfileSimpleVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberJoinProfileSimpleVo(int member_code, String member_email, String member_phone, String member_name,
			String member_id, String member_profile_image_s_name) {
		super();
		this.member_code = member_code;
		this.member_email = member_email;
		this.member_phone = member_phone;
		this.member_name = member_name;
		this.member_id = member_id;
		this.member_profile_image_s_name = member_profile_image_s_name;
	}

	public int getMember_code() {
		return member_code;
	}

	public void setMember_code(int member_code) {
		this.member_code = member_code;
	}

	public String getMember_email() {
		return member_email;
	}

	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}

	public String getMember_phone() {
		return member_phone;
	}

	public void setMember_phone(String member_phone) {
		this.member_phone = member_phone;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_profile_image_s_name() {
		return member_profile_image_s_name;
	}

	public void setMember_profile_image_s_name(String member_profile_image_s_name) {
		this.member_profile_image_s_name = member_profile_image_s_name;
	}

	@Override
	public String toString() {
		return "MemberJoinProfileSimpleVo [member_code=" + member_code + ", member_email=" + member_email
				+ ", member_phone=" + member_phone + ", member_name=" + member_name + ", member_id=" + member_id
				+ ", member_profile_image_s_name=" + member_profile_image_s_name + "]";
	}

}
