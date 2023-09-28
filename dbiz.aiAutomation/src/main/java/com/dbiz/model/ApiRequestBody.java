package com.dbiz.model;

import com.dbiz.pojo.SubmitApiPojo;

public class ApiRequestBody {
	SubmitApiPojo object=new SubmitApiPojo();
	public SubmitApiPojo submitApiPayLoad()
	{
	object.setFirst_name("Testing");
	object.setLast_name("qa");
	object.setEmail("testingqa@gmail.com");
	object.setPhone_number("7401648775");
	object.setMobile_number("9755487552");
	object.setCompany_name("testingAutomation");
	object.setJob_title("tester");
	object.setIndustry("IT");
	object.setCountry_region("Karnataka");
	object.setMessage("Testing submit API");
	object.setConsent(true);
	object.setNewsletter(true);
	object.setWebform_id("contact_us");
	return object;
	}
	 
}
