package pojo;

public class EmpMarshelling {
	String name;
	int id;
	String mailId;
	long mob;
	
	public EmpMarshelling(String name,int id,String mailId,long mob)
	{
		this.name= name;
		this.id=id;
		this.mailId= mailId;
		this.mob= mob;
	}
	
	public EmpMarshelling() {
		 
	}

	public String getName()
	{
		return name;
	}
	
	public int getId()
	{
		return id;
		
	}
	public String getMailId()
	{
		return mailId;
		
	}
	
	public long getMob()
	{
		return mob;
		
	}
	
	

}
