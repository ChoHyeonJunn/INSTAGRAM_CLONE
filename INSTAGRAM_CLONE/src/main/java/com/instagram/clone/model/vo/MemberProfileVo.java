package com.instagram.clone.model.vo;

public class MemberProfileVo {

	private int member_code;

	private String member_profile_image_name;
	private String member_profile_image_s_name;
	private String member_profile_image_path;

	private String member_profile_website;
	private String member_profile_introduce;
	private String member_profile_gender;

	public MemberProfileVo() {
		super();
	}

	public MemberProfileVo(int member_code) {
		super();
		this.member_code = member_code;
	}

	public MemberProfileVo(int member_code, String member_profile_image_name, String member_profile_image_s_name,
			String member_profile_image_path, String member_profile_website, String member_profile_introduce,
			String member_profile_gender) {
		super();
		this.member_code = member_code;
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
		return "MemberProfileVo [member_code=" + member_code + ", member_profile_image_name="
				+ member_profile_image_name + ", member_profile_image_s_name=" + member_profile_image_s_name
				+ ", member_profile_image_path=" + member_profile_image_path + ", member_profile_website="
				+ member_profile_website + ", member_profile_introduce=" + member_profile_introduce
				+ ", member_profile_gender=" + member_profile_gender + "]";
	}

}
