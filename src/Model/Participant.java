package Model;

public class Participant {

	private String pid;
	private String email;
	private String name;
	private String contact;
	private String batch;
	private String pass;
	public Participant(String pid, String email, String name, String contact, String batch, String pass) {
		super();
		this.pid = pid;
		this.email = email;
		this.name = name;
		this.contact = contact;
		this.batch = batch;
		this.pass = pass;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
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
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
}
