package com.caresoft.clinicapp;
import java.util.ArrayList;

public interface PHIAdminCompliant {
	
	//Expected to return a list of strings (incidents reported)
	abstract ArrayList<String> reportSecurityIncidents();
	
	// Default Implemented methods
	// Used to print implementations return values.
	public default boolean adminQATest(ArrayList<String> expectedIncidents) {
		if(reportSecurityIncidents().equals(expectedIncidents)) {
			System.out.println("PASS");
		}else {
			System.out.println("FAIL");
		}
		
		return reportSecurityIncidents().equals(expectedIncidents);
	}

}
