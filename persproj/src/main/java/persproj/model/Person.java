package persproj.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "Person")
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
	
	
	@Id
	@Column (name = "persno")
	public int getPersNo() {
		return persNo;
	}
	public void setPersNo(int persNo) {
		this.persNo = persNo;
	}
	
	@Column (name = "fname")
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	@Column (name = "lname")
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	
	@ManyToOne
	@JoinColumn (name = "department")
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	@Column (name = "salary")
	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	
	@Column (name = "fdate")
	public LocalDate getfDate() {
		return fDate;
	}
	public void setfDate(LocalDate fDate) {
		this.fDate = fDate;
	}
	
	@Column (name = "ldate")
	public LocalDate getlDate() {
		return lDate;
	}
	public void setlDate(LocalDate lDate) {
		this.lDate = lDate;
	}
	
	@Column (name = "gender")
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	@ManyToMany
	@JoinTable(name = "pers_proj", 
			  joinColumns = @JoinColumn(name = "persno"), 
			  inverseJoinColumns = @JoinColumn(name = "projno"))
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
	
	@Override
	public String toString() {
		return fname + " " + lname;
	}
	
}
