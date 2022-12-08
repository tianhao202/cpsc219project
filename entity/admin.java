package entity;

public class admin implements java.io.Serializable {


	private Integer id;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	private String username;
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	private String Password;
	public String getPassword() {
		return this.Password;
	}
	public void setPassword(String Password) {
		this.Password = Password;
	}
	

}
