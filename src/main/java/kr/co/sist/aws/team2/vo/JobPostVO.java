package kr.co.sist.aws.team2.vo;

public class JobPostVO {

	private int idx, career, tech_idx;
	private String company, img, address, input_date, id, homepage, description, subject;

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public int getCareer() {
		return career;
	}

	public void setCareer(int career) {
		this.career = career;
	}

	public int getTech_idx() {
		return tech_idx;
	}

	public void setTech_idx(int tech_idx) {
		this.tech_idx = tech_idx;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "JobPostVO [idx=" + idx + ", career=" + career + ", tech_idx=" + tech_idx + ", company=" + company
				+ ", img=" + img + ", address=" + address + ", input_date=" + input_date + ", id=" + id + ", homepage="
				+ homepage + ", description=" + description + ", subject=" + subject + "]";
	}

}
