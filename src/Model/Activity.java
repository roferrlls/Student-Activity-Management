package Model;

public class Activity {
	
	private String name;
	private String  time;
	private String  date;
	private String  venue;
	private String  description;
	private String  ex_aud;
	private String  club;
	private String  dept;
	private String contact;
	private String deadline;
	
	public Activity(String name, String time, String date, String venue, String description, String ex_aud, String club,
			String dept, String contact, String deadline) {
		super();
		this.name = name;
		this.time = time;
		this.date = date;
		this.venue = venue;
		this.description = description;
		this.ex_aud = ex_aud;
		this.club = club;
		this.dept = dept;
		this.contact = contact;
		this.deadline = deadline;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEx_aud() {
		return ex_aud;
	}
	public void setEx_aud(String ex_aud) {
		this.ex_aud = ex_aud;
	}
	public String getClub() {
		return club;
	}
	public void setClub(String club) {
		this.club = club;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	
	

}
