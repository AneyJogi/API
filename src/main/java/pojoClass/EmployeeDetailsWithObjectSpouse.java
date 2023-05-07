package pojoClass;

public class EmployeeDetailsWithObjectSpouse{
	
	String name;
	long mobNo;
	Spouse spouse;
	
	
	public EmployeeDetailsWithObjectSpouse(String name, long mobNo, Spouse spouse) {
		this.name = name;
		this.mobNo = mobNo;
		
	}

	public EmployeeDetailsWithObjectSpouse() {
		super();	
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMobNo() {
		return mobNo;
	}

	public void setMobNo(long mobNo) {
		this.mobNo = mobNo;
	}

	public Spouse getSpouse() {
		return spouse;
	}

	public void setSpouse(Spouse spouse) {
		this.spouse = spouse;
	}
	
	
	

}
