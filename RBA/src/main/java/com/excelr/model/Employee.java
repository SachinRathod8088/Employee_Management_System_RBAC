package com.excelr.model;



//import jakarta.persistence.CascadeType;
import jakarta.persistence.*;
//import jakarta.validation.constraints.Size;
//import jakarta.persistence.OneToMany;
//import jakarta.persistence.OneToOne;
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(unique = true, nullable = false, length = 6)
  private String empId;
  private String password;
  private String personalEmail;
  private String fullName;
  private String gender;
  private String age;
  private String dob;
  private String caddressLine1;
  private String caddressLine2;
  private String city2;
  private String pinCode1;
  private String paddressLine1;
  private String paddressLine2; 
  private String city1;
  private String pinCode2;
  private String mobile;
  private String emergencyContactName;
  private String emergencyContactMob_no;
	/* Professional_Details */
	private String companyMail;
	private String officePhone;
  private String city;
  private String addressLine1;
  private String addressLine2;
  private String pinCode;
  private String reportingManagerCode;
  private String hrName; 
  private String dateOfJoining;
//  Employment History
  private String companyName;
  private String joiningDate;
  private String endDate1;
  
  
public String getCity1() {
	return city1;
}
public void setCity1(String city1) {
	this.city1 = city1;
}
public String getCity2() {
	return city2;
}
public void setCity2(String city2) {
	this.city2 = city2;
}
public String getCaddressLine1() {
	return caddressLine1;
}
public void setCaddressLine1(String caddressLine1) {
	this.caddressLine1 = caddressLine1;
}
public String getCaddressLine2() {
	return caddressLine2;
}
public void setCaddressLine2(String caddressLine2) {
	this.caddressLine2 = caddressLine2;
}
public String getPinCode1() {
	return pinCode1;
}
public void setPinCode1(String pinCode1) {
	this.pinCode1 = pinCode1;
}
public String getPaddressLine1() {
	return paddressLine1;
}
public void setPaddressLine1(String paddressLine1) {
	this.paddressLine1 = paddressLine1;
}
public String getPaddressLine2() {
	return paddressLine2;
}
public void setPaddressLine2(String paddressLine2) {
	this.paddressLine2 = paddressLine2;
}
public String getPinCode2() {
	return pinCode2;
}
public void setPinCode2(String pinCode2) {
	this.pinCode2 = pinCode2;
}
  public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPersonalEmail() {
		return personalEmail;
	}
	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmergencyContactName() {
		return emergencyContactName;
	}
	public void setEmergencyContactName(String emergencyContactName) {
		this.emergencyContactName = emergencyContactName;
	}
	public String getEmergencyContactMob_no() {
		return emergencyContactMob_no;
	}
	public void setEmergencyContactMob_no(String emergencyContactMob_no) {
		this.emergencyContactMob_no = emergencyContactMob_no;
	}
	
    

	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public String getCompanyMail() {
		return companyMail;
	}
	public void setCompanyMail(String companyMail) {
		this.companyMail = companyMail;
	}
	public String getOfficePhone() {
		return officePhone;
	}
	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}
	public String getReportingManagerCode() {
		return reportingManagerCode;
	}
	public void setReportingManagerCode(String reportingManagerCode) {
		this.reportingManagerCode = reportingManagerCode;
	}
	public String getHrName() {
		return hrName;
	}
	public void setHrName(String hrName) {
		this.hrName = hrName;
	}
	public String getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	
	/* Project_Details */
    private String projectCode;   
    private String startDate;
    private String endDate;
    private String clientProjectName;
    private String reportingManager;

public String getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getClientProjectName() {
		return clientProjectName;
	}
	public void setClientProjectName(String clientProjectName) {
		this.clientProjectName = clientProjectName;
	}

/* Finance_Details */
  private String panCard;    
  private String aadharCard;    
  private String bankName;    
  private String branch;   
  private String ifscCode;    
  private String ctcBreakup;
  
  
public String getPanCard() {
	return panCard;
}
public void setPanCard(String panCard) {
	this.panCard = panCard;
}
public String getAadharCard() {
	return aadharCard;
}
public void setAadharCard(String aadharCard) {
	this.aadharCard = aadharCard;
}
public String getBankName() {
	return bankName;
}
public void setBankName(String bankName) {
	this.bankName = bankName;
}
public String getBranch() {
	return branch;
}
public void setBranch(String branch) {
	this.branch = branch;
}
public String getIfscCode() {
	return ifscCode;
}
public void setIfscCode(String ifscCode) {
	this.ifscCode = ifscCode;
}
public String getCtcBreakup() {
	return ctcBreakup;
}
public void setCtcBreakup(String ctcBreakup) {
	this.ctcBreakup = ctcBreakup;
}
public String getEndDate1() {
	return endDate1;
}
public void setEndDate1(String endDate1) {
	this.endDate1 = endDate1;
}
public String getReportingManager() {
	return reportingManager;
}
public void setReportingManager(String reportingManager) {
	this.reportingManager = reportingManager;
}

}