package pojoClass;

public class EmployeeDetails {
	
	String name;
	int empid;
	String mailid;
	long phonenumber;
	
	public EmployeeDetails(String name, int empid, String mailid, long phonenumber) {

		this.name = name;
		this.empid = empid;
		this.mailid = mailid;
		this.phonenumber=phonenumber;
	}
	
	//empty constructor for trigger serialization and deserialization
	public EmployeeDetails() {
		 
	}
	
	
	
	public String getName() {
		return name;
	}

	public int getEmpid() {
		return empid;
	}
	public String getMailid() {
		return mailid;
	}
	public long getPhonenumber() {
		return phonenumber;
	}
}
