package week1day1practice;

public class StudentVO {
	private int no;
	private String name;
	private String major;
	private int grade;
	private String phone;
	private String id;
	private String password;
	
	public StudentVO() {}

	public StudentVO(int no, String name, String major, int grade, String phone, String id, String password) {
		this.no = no;
		this.name = name;
		this.major = major;
		this.grade = grade;
		this.phone = phone;
		this.id = id;
		this.password = password;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

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
}