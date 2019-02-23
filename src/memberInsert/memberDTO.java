package memberInsert;

public class memberDTO {
	
	private String id;
	private String pwd;
	private String name;
	private String email;
	private String phone;
	private String gender;
	private int age;
	private String address;
	private String etc;
	private int point;
	private int auth;
	
	public memberDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public memberDTO(String id, String pwd, String name, String email, String phone, String gender, int age,
			String address, String etc, int point, int auth) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.age = age;
		this.address = address;
		this.etc = etc;
		this.point = point;
		this.auth = auth;
	}
	







	@Override
	public String toString() {
		return "memberDTO [id=" + id + ", PWD=" + pwd + ", name=" + name + ", email=" + email + ", phone=" + phone
				+ ", gender=" + gender + ", age=" + age + ", address=" + address + ", etc=" + etc + ", point=" + point
				+ ", auth=" + auth + "]";
	}






	public String getid() {
		return id;
	}

	public void setid(String id) {
		this.id = id;
	}

	public String getpwd() {
		return pwd;
	}

	public void setPWD(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEtc() {
		return etc;
	}

	public void setEtc(String etc) {
		this.etc = etc;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getAuth() {
		return auth;
	}

	public void setAuth(int auth) {
		this.auth = auth;
	}
	
	
	
	
	
	
	
}
