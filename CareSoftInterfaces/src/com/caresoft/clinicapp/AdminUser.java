package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {
//... imports class definition...

	// Inside class:
	private String role;
	private ArrayList<String> securityIncidents;

	// TO DO: Implement a constructor that takes an ID and a role

	public AdminUser(Integer id, String role) {
		super(id);
		this.role = role;
		
	}

	// TO DO: Implement HIPAACompliantUser!

	
	@Override
	public boolean assignPin(int pin) {
		// TODO Auto-generated method stub
		if (pin >= 100000 ) {
			this.pin = pin;
			return true;
		} else {
			return false;
		}
			
	}
	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		// TODO Auto-generated method stub
		if (confirmedAuthID == this.id) {
			return true;
		} else {
			this.securityIncidents = new ArrayList<String>();
			this.authIncident();
			this.newIncident("AUTHORIZATION ATTEMPT FAILED FOR THIS USER");
			return false;
		}

	}
	
	// TO DO: Implement HIPAACompliantAdmin!

	@Override
	public ArrayList<String> reportSecurityIncidents() {
		// TODO Auto-generated method stub

		return getSecurityIncidents();
	}
	
	
	public void printSecurityIncidents() {
		// TODO Auto-generated method stub
		HIPAACompliantAdmin.super.printSecurityIncidents();
	}
	

	public boolean adminQATest(ArrayList<String> expectedIncidents) {
		// TODO Auto-generated method stub
		return HIPAACompliantAdmin.super.adminQATest(expectedIncidents);
	}
	
	
	
	
	
	
	public void newIncident(String notes) {
		String report = String.format("Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", new Date(),
				this.id, notes);
		securityIncidents.add(report);
	}


	public void authIncident() {
		String report = String.format("Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", new Date(), this.id,
				"AUTHORIZATION ATTEMPT FAILED FOR THIS USER");
		securityIncidents.add(report);
	}


	// TO DO: Setters & Getters

	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}
	
	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}
	
}
