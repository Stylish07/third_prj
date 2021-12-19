package kr.co.sist.aws.team2.vo;

public class CertificateVO {

	private String title, get_date, description, id;
	private int idx;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGet_date() {
		return get_date;
	}

	public void setGet_date(String get_date) {
		this.get_date = get_date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	@Override
	public String toString() {
		return "CertificateVO [title=" + title + ", get_date=" + get_date + ", description=" + description + ", id="
				+ id + ", idx=" + idx + "]";
	}

}
