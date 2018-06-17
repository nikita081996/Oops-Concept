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
	private String mAddress;
	private long mContactNo;
	private String mOrganisationName;
	
	Organisation(String name,String address,long contact_no){
		this.mAddress=address;
		this.mOrganisationName=name;
		this.mContactNo=contact_no;
	}
	
	public String getAddress() {
		return mAddress;
	}
	
	public long getContact_no() {
		return mContactNo;
	}
	
	public String getOrganisation_name() {
		return mOrganisationName;
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
