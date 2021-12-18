package kr.co.sist.aws.team2.vo;

public class TechStackVO {

	private int idx;
	private String subject;

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "TechStack [idx=" + idx + ", subject=" + subject + "]";
	}

}
