package com.instagram.clone.model.vo;

public class MemberJoinProfileVo {

	private int member_code;

	private String member_email;
	private String member_phone;
	private String member_name;
	private String member_id;
	private String member_pw;

	private String sns_type;
	private String sns_id;

	private String member_profile_image_name;
	private String member_profile_image_s_name;
	private String member_profile_image_path;

	private String member_profile_website;
	private String member_profile_introduce;
	private String member_profile_gender;

	public MemberJoinProfileVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberJoinProfileVo(int member_code, String member_email, String member_phone, String member_name,
			String member_id, String member_pw, String sns_type, String sns_id, String member_profile_image_name,
			String member_profile_image_s_name, String member_profile_image_path, String member_profile_website,
			String member_profile_introduce, String member_profile_gender) {
		super();
		this.member_code = member_code;
		this.member_email = member_email;
		this.member_phone = member_phone;
		this.member_name = member_name;
		this.member_id = member_id;
		this.member_pw = member_pw;
		this.sns_type = sns_type;
		this.sns_id = sns_id;
		this.member_profile_image_name = member_profile_image_name;
		this.member_profile_image_s_name = member_profile_image_s_name;
		this.member_profile_image_path = member_profile_image_path;
		this.member_profile_website = member_profile_website;
		this.member_profile_introduce = member_profile_introduce;
		this.member_profile_gender = member_profile_gender;
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

	public String getMember_pw() {
		return member_pw;
	}

	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}

	public String getSns_type() {
		return sns_type;
	}

	public void setSns_type(String sns_type) {
		this.sns_type = sns_type;
	}

	public String getSns_id() {
		return sns_id;
	}

	public void setSns_id(String sns_id) {
		this.sns_id = sns_id;
	}

	public String getMember_profile_image_name() {
		return member_profile_image_name;
	}

	public void setMember_profile_image_name(String member_profile_image_name) {
		this.member_profile_image_name = member_profile_image_name;
	}

	public String getMember_profile_image_s_name() {
		return member_profile_image_s_name;
	}

	public void setMember_profile_image_s_name(String member_profile_image_s_name) {
		this.member_profile_image_s_name = member_profile_image_s_name;
	}

	public String getMember_profile_image_path() {
		return member_profile_image_path;
	}

	public void setMember_profile_image_path(String member_profile_image_path) {
		this.member_profile_image_path = member_profile_image_path;
	}

	public String getMember_profile_website() {
		return member_profile_website;
	}

	public void setMember_profile_website(String member_profile_website) {
		this.member_profile_website = member_profile_website;
	}

	public String getMember_profile_introduce() {
		return member_profile_introduce;
	}

	public void setMember_profile_introduce(String member_profile_introduce) {
		this.member_profile_introduce = member_profile_introduce;
	}

	public String getMember_profile_gender() {
		return member_profile_gender;
	}

	public void setMember_profile_gender(String member_profile_gender) {
		this.member_profile_gender = member_profile_gender;
	}

	@Override
	public String toString() {
		return "MemberJoinProfileVo [member_code=" + member_code + ", member_email=" + member_email + ", member_phone="
				+ member_phone + ", member_name=" + member_name + ", member_id=" + member_id + ", member_pw="
				+ member_pw + ", sns_type=" + sns_type + ", sns_id=" + sns_id + ", member_profile_image_name="
				+ member_profile_image_name + ", member_profile_image_s_name=" + member_profile_image_s_name
				+ ", member_profile_image_path=" + member_profile_image_path + ", member_profile_website="
				+ member_profile_website + ", member_profile_introduce=" + member_profile_introduce
				+ ", member_profile_gender=" + member_profile_gender + "]";
	}

}
