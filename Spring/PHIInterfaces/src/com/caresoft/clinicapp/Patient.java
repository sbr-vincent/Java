package com.caresoft.clinicapp;
import java.util.ArrayList;
import java.util.Date;

public class Patient extends User implements PHICompliantUser {

	private String firstName;
	private String lastName;
	// .. other personal identifying information .. //
	
	Physician primaryCarePhysician;
	ArrayList<Integer> currentPrescriptionByRX;
	int providerCode;
	int memberNumber;
	PatientRecord medicalHistory;
	
	public Patient(String firstName, String lastName, Physician primaryCarePhysician,
			ArrayList<Integer> currentPrescriptionByRX, int providerCode, int memberNumber,
			PatientRecord medicalHistory) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.primaryCarePhysician = primaryCarePhysician;
		this.currentPrescriptionByRX = currentPrescriptionByRX;
		this.providerCode = providerCode;
		this.memberNumber = memberNumber;
		this.medicalHistory = medicalHistory;
	}
	
	public boolean requestAppointment(Date date, Physician doctor) {
		boolean successfullyAdded = false;
		//you see existing code to find and schedule an appointment
		// (Leave as is for the assignment, no need to implement anything here.)
		return successfullyAdded;
	}
	
	void addChartNotes(String notes) {
		this.medicalHistory.getCharts().add(notes);
	}

	@Override
	public boolean assignPin(int pin) {
		// TODO Auto-generated method stub\
		int length = String.valueOf(pin).length();
		String num = String.valueOf(pin);
		if(length < 4 || length > 4 ) {
			return false;
		}else if(num.equals("1234") || num.equals("4321")) {
			return false;
		}
		else{
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Physician getPrimaryCarePhysician() {
		return primaryCarePhysician;
	}

	public void setPrimaryCarePhysician(Physician primaryCarePhysician) {
		this.primaryCarePhysician = primaryCarePhysician;
	}

	public ArrayList<Integer> getCurrentPrescriptionByRX() {
		return currentPrescriptionByRX;
	}

	public void setCurrentPrescriptionByRX(ArrayList<Integer> currentPrescriptionByRX) {
		this.currentPrescriptionByRX = currentPrescriptionByRX;
	}

	public int getProviderCode() {
		return providerCode;
	}

	public void setProviderCode(int providerCode) {
		this.providerCode = providerCode;
	}

	public int getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}

	public PatientRecord getMedicalHistory() {
		return medicalHistory;
	}

	public void setMedicalHistory(PatientRecord medicalHistory) {
		this.medicalHistory = medicalHistory;
	}

}
