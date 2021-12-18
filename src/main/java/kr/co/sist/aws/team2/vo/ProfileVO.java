package kr.co.sist.aws.team2.vo;

public class ProfileVO {
	
	private String gender, phone, description, url, img, input_date, id;
	private int idx, tech_idx;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getInput_date() {
		return input_date;
	}

	public void setInput_date(String input_date) {
		this.input_date = input_date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public int getTech_idx() {
		return tech_idx;
	}

	public void setTech_idx(int tech_idx) {
		this.tech_idx = tech_idx;
	}

	@Override
	public String toString() {
		return "ProfileVO [gender=" + gender + ", phone=" + phone + ", description=" + description + ", url=" + url
				+ ", img=" + img + ", input_date=" + input_date + ", id=" + id + ", idx=" + idx + ", tech_idx="
				+ tech_idx + "]";
	}

}
