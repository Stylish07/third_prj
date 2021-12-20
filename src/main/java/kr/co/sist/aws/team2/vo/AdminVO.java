package kr.co.sist.aws.team2.vo;

public class AdminVO {

	private String id, password, input_date;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getInput_date() {
		return input_date;
	}

	public void setInput_date(String input_date) {
		this.input_date = input_date;
	}

	@Override
	public String toString() {
		return "AdminVO [id=" + id + ", password=" + password + ", input_date=" + input_date + "]";
	}

}
