/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.dataaggregation.api.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;
import org.openmrs.Patient;
import org.openmrs.api.context.Context;

import java.util.HashMap;

import org.openmrs.api.impl.BaseOpenmrsService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.module.dataaggregation.api.DataAggregationService;
import org.openmrs.module.dataaggregation.api.db.DataAggregationDAO;

/**
 * It is a default implementation of {@link DataAggregationService}.
 */
public class DataAggregationServiceImpl extends BaseOpenmrsService implements DataAggregationService {
	
	protected final Log log = LogFactory.getLog(this.getClass());
	
	private DataAggregationDAO dao;
	
	/**
     * @param dao the dao to set
     */
    public void setDao(DataAggregationDAO dao) {
	    this.dao = dao;
    }
    
    /**
     * @return the dao
     */
    public DataAggregationDAO getDao() {
	    return dao;
    }
    
    public String getAllPatientNames() {
		String toReturn = new String();
		List<Patient> patients = Context.getPatientService().getAllPatients();
		for (Patient patient : patients) {
		  toReturn = toReturn + ("\n Patient: " + patient.getGivenName() + " " + patient.getFamilyName());
		}
		return toReturn;
    }
    
    
    public String getQuestionAnswer(String testName, 
    								String diseaseList, String cityList, 
    								String startDate, String endDate, 
    								Integer minNumber, Integer maxNumber) {
    	
    	
    	//String result = state.execute(testName, par1, par2, par3);
    	
    	if (testName.equalsIgnoreCase("Disease")) {
    		
    	}
    	else if (testName.equalsIgnoreCase("Tests")) {
    		
    	}
		else if (testName.equalsIgnoreCase("Pulse")) {		    		
		
		}
		else if (testName.equalsIgnoreCase("Weight")) {
			
		}
		else if (testName.equalsIgnoreCase("etc..")) {
			
		}
		else if (testName.equalsIgnoreCase("Goodbye")) {
			
		}
		else if (testName.equalsIgnoreCase("Goodbye")) {
			
		}
		else if (testName.equalsIgnoreCase("Goodbye")) {
			
		}
		else if (testName.equalsIgnoreCase("Goodbye")) {
			
		}
		else if (testName.equalsIgnoreCase("Goodbye")) {
			
		}
		else if (testName.equalsIgnoreCase("Goodbye")) {
			
		}
		else if (testName.equalsIgnoreCase("Goodbye")) {
			
		}
		else if (testName.equalsIgnoreCase("Goodbye")) {
			
		}
		else if (testName.equalsIgnoreCase("Goodbye")) {
			
		}
		else if (testName.equalsIgnoreCase("Goodbye")) {
			
		}
		else if (testName.equalsIgnoreCase("Goodbye")) {
			
		}
		else if (testName.equalsIgnoreCase("Goodbye")) {
			
		}
		else if (testName.equalsIgnoreCase("Goodbye")) {
			
		}
		else if (testName.equalsIgnoreCase("Goodbye")) {
			
		}
		else if (testName.equalsIgnoreCase("Goodbye")) {
			
		}
		else if (testName.equalsIgnoreCase("Goodbye")) {
			
		}
		else if (testName.equalsIgnoreCase("Goodbye")) {
			
		}
    	
    	return "";
    }
    
    /*
    public String getDiseaseCounts(String startDate, String endDate) {
    	
    	String SQL_Query = "select o.value_coded, c.name, count(*) from obs o, concept_name c "
				+ "where o.value_coded = c.concept_id and o. and o.concept_id= :coded_id and c.concept_name_type = 'FULLY_SPECIFIED'"
				+ "group by o.value_coded";
				
				select o.value_coded, c.name, count(*) from obs o, concept_name c where o.value_coded = 
				c.concept_id and c.concept_id = :coded_id and c.concept_name_type = 'FULLY_SPECIFIED' group by o.value_coded
    	
    	return "";
    }*/
    
    
    /**
     * 
     */
    public String getDiseaseBurden(String diseaseList, String cityList,
    								String startDate, String endDate,
    								Integer minNumber, Integer maxNumber) {  
    	
    	DiseaseBurdenQuery dbq = new DiseaseBurdenQuery(dao);    	
    	return dbq.getQueryInfo(diseaseList, cityList, startDate, endDate, minNumber, maxNumber);
		
    }

    /**
     * 
     */
    public String getTestsOrdered(String testsOrderedList,
    								String startDate, String endDate, 
    								Integer minNumber, Integer maxNumber) {
    	
    	TestsOrderedQuery toq = new TestsOrderedQuery(dao);    	
    	return toq.getQueryInfo(testsOrderedList, startDate, endDate, minNumber, maxNumber);
    }
    
    public String getWeights(Character gender, Integer minAge, Integer maxAge) {
    	
    	WeightQuery wq = new WeightQuery(dao);
    	return wq.getQueryInfo(gender, minAge, maxAge);
    }
    
	@Override
	public HashMap<String, Integer> getDiseaseBurden() {
		//make up fake data for now
		HashMap<String, Integer> diseaseBurden = new HashMap<String, Integer>();
		
		diseaseBurden.put("malaria", 1202);
		diseaseBurden.put("cholera", 1202);
		diseaseBurden.put("typhoid", 1202);
		diseaseBurden.put("hiv/aids", 1202);
		diseaseBurden.put("syphilis", 1202);
		
		return diseaseBurden;
	}
	
}