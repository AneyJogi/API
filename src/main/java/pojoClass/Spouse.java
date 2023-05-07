package pojoClass;

public class Spouse {
	
	String name;
	long[] mobNo;
	
	
	public Spouse(String name, long[] mobNo) {
		this.name = name;
		this.mobNo = mobNo;
	}


	public Spouse() {
		super();
	}


	public String getName() {
		return name;
	}


	public long[] getMobNo() {
		return mobNo;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setMobNo(long[] mobNo) {
		this.mobNo = mobNo;
	}
	
	
	
	
	

}
