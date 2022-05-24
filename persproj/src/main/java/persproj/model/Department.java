package persproj.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Department {

	private int deptNo; 
	private String deptName;
	private Person deptHead;
	private BigDecimal budget; 
	private Department inDept;
	private LocalDate founded;
	
	private List<Person> persons;
	private List<Department> subdepartments;
	
	
	public int getDeptNo() {
		return deptNo;
	}
	
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	
	public String getDeptName() {
		return deptName;
	}
	
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	public Person getDeptHead() {
		return deptHead;
	}
	public void setDeptHead(Person deptHead) {
		this.deptHead = deptHead;
	}
	
	public BigDecimal getBudget() {
		return budget;
	}
	
	public void setBudget(BigDecimal budget) {
		this.budget = budget;
	}
	

	public Department getInDept() {
		return inDept;
	}
	public void setInDept(Department inDept) {
		this.inDept = inDept;
	}
	
	public LocalDate getFounded() {
		return founded;
	}
	public void setFounded(LocalDate founded) {
		this.founded = founded;
	}

	public List<Department> getSubdepartments() {
		return subdepartments;
	}
	public void setSubdepartments(List<Department> subdepartments) {
		this.subdepartments = subdepartments;
	}
	
	public List<Person> getPersons() {
		return persons;
	}
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	
	public String toString() {
		return deptName;
	}
	
}
