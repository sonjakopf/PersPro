package persproj.model;

import java.util.List;

public class Project {

	private int projNo;
	private String projName;
	private Person projHead;
	private Project inProj;
	
	
	private List<Person> persons;
	private List<Project> subprojects;

	public int getProjNo() {
		return projNo;
	}
	public void setProjNo(int projNo) {
		this.projNo = projNo;
	}
	
	public String getProjName() {
		return projName;
	}
	public void setProjName(String projName) {
		this.projName = projName;
	}
	
	public Person getProjHead() {
		return projHead;
	}
	public void setProjHead(Person projHead) {
		this.projHead = projHead;
	}
	
	public Project getInProj() {
		return inProj;
	}
	public void setInProj(Project inProj) {
		this.inProj = inProj;
	}
	
	public List<Person> getPersons() {
		return persons;
	}
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	
	public List<Project> getSubprojects() {
		return subprojects;
	}
	public void setSubprojects(List<Project> subprojects) {
		this.subprojects = subprojects;
	}
	
	public String toString() {
		return projNo + " " + projName;
	}
}
