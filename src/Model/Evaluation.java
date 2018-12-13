package Model;

public class Evaluation {
	
	private int aid;
	private String pid;
	private String email;
	private String score;
	private String remarks;
	
	
	public Evaluation(int aid, String pid, String email, String score, String remarks) {
		super();
		this.aid = aid;
		this.pid = pid;
		this.email = email;
		this.score = score;
		this.remarks = remarks;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
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
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
}
