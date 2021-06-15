package poly.dto;

public class BoardDTO {
	
	private String reg_name;
	private String title;
	private String content;
	private String reg_date;
	private String qst_seq;
	private String value;
	private String rfe_seq;
	
	public String getRfe_seq() {
		return rfe_seq;
	}
	public void setRfe_seq(String rfe_seq) {
		this.rfe_seq = rfe_seq;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getQst_seq() {
		return qst_seq;
	}
	public void setQst_seq(String qst_seq) {
		this.qst_seq = qst_seq;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public String getReg_name() {
		return reg_name;
	}
	public void setReg_name(String reg_name) {
		this.reg_name = reg_name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	

}
