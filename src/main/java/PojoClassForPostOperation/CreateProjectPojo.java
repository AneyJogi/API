package PojoClassForPostOperation;

public class CreateProjectPojo {
	
	String projectName;
	String status;
	String createdBy;
	int teamSize;
	
	public CreateProjectPojo(String projectName, String status, String createdBy, int teamSize) {
		super();
		this.projectName = projectName;
		this.status = status;
		this.createdBy = createdBy;
		this.teamSize = teamSize;
	}

	public String getProjectName() {
		return projectName;
	}

	public String getStatus() {
		return status;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public int getTeamSize() {
		return teamSize;
	}
	
	

}
