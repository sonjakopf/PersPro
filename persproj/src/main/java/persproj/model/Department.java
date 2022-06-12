package persproj.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "department")
public class Department {

	private int deptNo; 
	private String deptName;
	private Person deptHead;
	private BigDecimal budget; 
	private Department inDept;
	private LocalDate founded;
	private List<Person> persons;
	private List<Department> subdepartments;
	
	
	@Id
	@Column (name = "deptno")
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	
	@Column (name = "deptname")
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	@ManyToOne
	@JoinColumn (name = "depthead")
	public Person getDeptHead() {
		return deptHead;
	}
	public void setDeptHead(Person deptHead) {
		this.deptHead = deptHead;
	}
	
	@Column (name = "budget")
	public BigDecimal getBudget() {
		return budget;
	}
	public void setBudget(BigDecimal budget) {
		this.budget = budget;
	}
	
	@ManyToOne
	@JoinColumn (name = "in_dept")
	public Department getInDept() {
		return inDept;
	}
	public void setInDept(Department inDept) {
		this.inDept = inDept;
	}
	
	@Column (name = "founded")
	public LocalDate getFounded() {
		return founded;
	}
	public void setFounded(LocalDate founded) {
		this.founded = founded;
	}
	
	public String toString() {
		return deptName;
	}
	
	@OneToMany (mappedBy = "inDept")
	public List<Department> getSubdepartments() {
		return subdepartments;
	}
	public void setSubdepartments(List<Department> subdepartments) {
		this.subdepartments = subdepartments;
	}
	
	
	@OneToMany (mappedBy = "department")
	public List<Person> getPersons() {
		return persons;
	}
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	
}
