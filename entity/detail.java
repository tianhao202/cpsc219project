package entity;

public class detail implements java.io.Serializable {


	private Integer id;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	private String details;
	public String getDetails() {
		return this.details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	private String time;
	public String getTime() {
		return this.time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	private String amount;
	public String getAmount() {
		return this.amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	private String user;
	public String getuser() {
		return this.user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	private String note;
	public String getNote() {
		return this.note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	

}
