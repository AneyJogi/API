package pojoClass;

public class EmployeeDetailsInArray {
	String name;
	int empid;
	String mailId;
	long[] mobNo;
	
	
	
	public EmployeeDetailsInArray(String name, int empid, String mailId, long[] mobNo) {
		this.name = name;
		this.empid = empid;
		this.mailId = mailId;
		this.mobNo = mobNo;
	}


	public EmployeeDetailsInArray() {
		
	}

    //To call methods in other classes to get variables there.
	public String getName() {
		return name;
	}


	public int getEmpid() {
		return empid;
	}


	public String getMailId() {
		return mailId;
	}


	public long[] getMobNo() {
		return mobNo;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setEmpid(int empid) {
		this.empid = empid;
	}


	public void setMailId(String mailId) {
		this.mailId = mailId;
	}


	public void setMobNo(long[] mobNo) {
		this.mobNo = mobNo;
	}
	
	
	
	

}
