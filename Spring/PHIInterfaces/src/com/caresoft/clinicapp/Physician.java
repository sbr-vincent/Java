package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

public class Physician extends User implements PHICompliantUser, PHIAdminCompliant {

	private HashSet<Patient> patients;
	private ArrayList<String> securityIncidents;
	
	// ... you see other existing member variables ...
	
	//TO DO : Constructor
	public Physician(HashSet<Patient> patients, ArrayList<String> securityIncidents) {
		super();
		this.patients = patients;
		this.securityIncidents = securityIncidents;
	}
	
	public void prescribedRXTo(Patient patient, Integer rxNumber) {
		patient.currentPrescriptionByRX.add(rxNumber);
	}
	
	public void newIncident(String notes) {
		String report = String.format("Datetime submitted: %s \n, Reported By ID: %s\n Notes: %s \n", new Date(), this.id, notes);
		securityIncidents.add(report);
	}
	
	public void authIncident() {
		 String report = String.format("Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", new Date(), this.id, "Authorization Attempt Failed For This User");
		 securityIncidents.add(report);
	}
	
	@Override
	public ArrayList<String> reportSecurityIncidents() {
		// TODO Auto-generated method stub
		return securityIncidents;
	}

	@Override
	public boolean assignPin(int pin) {
		// TODO Auto-generated method stub
		int length = String.valueOf(pin).length();
		if(length < 6 || length > 6 ) {
			return false;
		}else{
			return true;			
		}
	}

	@Override
	public boolean isAuthorized(Integer confirmedAuthID) {
		// TODO Auto-generated method stub
		if(this.id.equals(confirmedAuthID)) {
			return true;
		}else {
			return false;			
		}
	}

	public HashSet<Patient> getPatients() {
		return patients;
	}

	public void setPatients(HashSet<Patient> patients) {
		this.patients = patients;
	}

	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}

	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}
	
	

}
