package Model;

public class EnrollInActivity {
	
	private String pid;
	private String aid;
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public EnrollInActivity(String pid, String aid) {
		super();
		this.pid = pid;
		this.aid = aid;
	}
	

}
