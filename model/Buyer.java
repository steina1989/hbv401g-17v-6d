package model;

public class Buyer {
	private String name;
	private int age;
	private String gender;
	private int cellphone;
	private String email;
	
	
	
	public Buyer(String name, int age, String gender, int cellphone, String email) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.cellphone = cellphone;
		this.email = email;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getCellphone() {
		return cellphone;
	}
	public void setCellphone(int cellphone) {
		this.cellphone = cellphone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
