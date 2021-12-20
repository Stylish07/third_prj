package kr.co.sist.aws.team2.vo;

public class PortfolioVO {

	private String proj_title, team, url_link, description, id;
	private int idx, year;

	public String getProj_title() {
		return proj_title;
	}

	public void setProj_title(String proj_title) {
		this.proj_title = proj_title;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getUrl_link() {
		return url_link;
	}

	public void setUrl_link(String url_link) {
		this.url_link = url_link;
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

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "PortfolioVO [proj_title=" + proj_title + ", team=" + team + ", url_link=" + url_link + ", description="
				+ description + ", id=" + id + ", idx=" + idx + ", year=" + year + "]";
	}

}
