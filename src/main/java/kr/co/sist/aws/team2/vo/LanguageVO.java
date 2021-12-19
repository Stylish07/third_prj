package kr.co.sist.aws.team2.vo;

public class LanguageVO {

	private String lang, exam_title, score, id;
	private int idx;

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getExam_title() {
		return exam_title;
	}

	public void setExam_title(String exam_title) {
		this.exam_title = exam_title;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
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
		return "LanguageVO [lang=" + lang + ", exam_title=" + exam_title + ", score=" + score + ", id=" + id + ", idx="
				+ idx + "]";
	}

}
