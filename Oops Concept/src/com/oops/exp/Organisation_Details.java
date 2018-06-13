/* 
 * Creating 
 * package for Encapsulation
 */
package com.oops.exp;

class Organisation{
	/* 
	 * declaring private 
	 * member function for
	 * Abstraction
	 */
	private String maddress;
	private long mcontact_no;
	private String morganisation_name;
	
	Organisation(String name,String address,long contact_no){
		this.maddress=address;
		this.morganisation_name=name;
		this.mcontact_no=contact_no;
	}
	
	public String getAddress() {
		return maddress;
	}
	
	public long getContact_no() {
		return mcontact_no;
	}
	
	public String getOrganisation_name() {
		return morganisation_name;
	}
	
	/*
	 * function overriding for Polymorphism
	 */
	
	public void organisationInfo() {
		System.out.println("In Organisation Class");
		System.out.println("Company name is "+getOrganisation_name()+"\nNo Department "
				+"\nAddress is "+getAddress()+"\nContact no. is "+getContact_no());
	}
}
/*
 *  Inheriting class
 *  for Inheritance
 */
class Department extends Organisation{
	private String mdeptname;
	
	Department(String name,String address,long contact_no,String mdeptname){
		super(name,address,contact_no);
		this.mdeptname=mdeptname;
	}

	public String getDeptName() {
		return mdeptname;
	}
	
	public void organisationInfo() {
		System.out.println("In Department Class");
		System.out.println("Company name is "+getOrganisation_name()+"\nDepartment name is "
		+getDeptName()+"\nAddress is "+getAddress()+"\nContact no. is "+getContact_no());
	}
}

public class Organisation_Details {
	public static void main(String[] args) {
		Department dept = new Department("Mindfire","sector 62, Noida",Long.parseLong("9675467865"),"Android");
		Organisation org = new Department("Mindfire","sector 62, Noida",Long.parseLong("9675467865"),"Android");
		dept.organisationInfo();
		org.organisationInfo();
	}
}
