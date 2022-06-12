package persproj.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Project {

	private int projNo;
	private String projName;
	private Person projHead;
	private Project inProj;
	
	
	private List<Person> persons;
	private List<Project> subprojects;
	
	@Id
	@Column (name = "projno")
	public int getProjNo() {
		return projNo;
	}
	public void setProjNo(int projNo) {
		this.projNo = projNo;
	}
	
	@Column (name = "projname")
	public String getProjName() {
		return projName;
	}
	public void setProjName(String projName) {
		this.projName = projName;
	}
	
	@ManyToOne
	@JoinColumn (name = "projhead")
	public Person getProjHead() {
		return projHead;
	}
	public void setProjHead(Person projHead) {
		this.projHead = projHead;
	}
	
	@ManyToOne
	@JoinColumn (name = "in_proj")
	public Project getInProj() {
		return inProj;
	}
	public void setInProj(Project inProj) {
		this.inProj = inProj;
	}
	
	@OneToMany (mappedBy = "inProj")	
	public List<Project> getSubprojects() {
		return subprojects;
	}
	public void setSubprojects(List<Project> subprojects) {
		this.subprojects = subprojects;
	}
	
	@ManyToMany (mappedBy = "projects")
	public List<Person> getPersons() {
		return persons;
	}
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	
	public String toString() {
		return projNo + " " + projName;
	}
}
