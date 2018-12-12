package Model;

public class Judge {
	private String email;
	private String name;
	private String phone;
	private String pass;
	
	public Judge(String email, String name, String phone, String pass) {
		super();
		this.email = email;
		this.name = name;
		this.phone = phone;
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	

}
