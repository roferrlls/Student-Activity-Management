package Model;

public class Contains {

	private int Aid;
	private String jemail;
	public Contains(int aid, String jemail) {
		super();
		Aid = aid;
		this.jemail = jemail;
	}
	public int getAid() {
		return Aid;
	}
	public void setAid(int aid) {
		Aid = aid;
	}
	public String getJemail() {
		return jemail;
	}
	public void setJemail(String jemail) {
		this.jemail = jemail;
	}
	
}
