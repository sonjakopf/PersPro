package persproj.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Person {
	
	private int persNo;
	private String fname;
	private String lname;
	private Department department;
	private BigDecimal salary;
	private LocalDate fDate;
	private LocalDate lDate;
	private char gender;
	private List<Project> projects;
	

	public int getPersNo() {
		return persNo;
	}
	public void setPersNo(int persNo) {
		this.persNo = persNo;
	}
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	

	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public LocalDate getfDate() {
		return fDate;
	}
	public void setfDate(LocalDate fDate) {
		this.fDate = fDate;
	}

	public LocalDate getlDate() {
		return lDate;
	}
	public void setlDate(LocalDate lDate) {
		this.lDate = lDate;
	}

	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	public void addProject(Project p) {
		projects.add(p);
		p.getPersons().add(this);
	}
	
	public String toString() {
		return fname + " " + lname;
	}
	
}
