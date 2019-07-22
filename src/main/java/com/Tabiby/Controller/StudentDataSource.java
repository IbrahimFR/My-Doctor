package com.Tabiby.Controller;

import java.util.ArrayList;
import java.util.List;

import com.Tabiby.Model.MedecineList;
import com.Tabiby.Model.PatientHistory;
import com.Tabiby.service.MedecineService;
import com.Tabiby.service.PatientHistoryService;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRAbstractBeanDataSourceProvider;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentDataSource extends JRAbstractBeanDataSourceProvider {


	private List<PatientHistory> patientHistoryList;
	private List<PatientHistory> mHistoryList;
	@Autowired
	private PatientHistoryService patientHistoryService;

	public StudentDataSource(List<PatientHistory> patientHistories) {
		super(PatientHistory.class);
		mHistoryList=patientHistories;

	}

	/**
	 * Creates the provider. Superclasses must pass a valid class that will be
	 * used to introspect the available bean fields.
	 *
	 * @param beanClass the bean class to be introspected.
	 */
	public StudentDataSource(Class<?> beanClass) {
		super(beanClass);
	}

	@Override
	public JRDataSource create(JasperReport jrReport) throws JRException {

		patientHistoryList = new ArrayList<PatientHistory>();
		patientHistoryList = mHistoryList;


		return new JRBeanCollectionDataSource(patientHistoryList);
	}


	@Override
	public void dispose(JRDataSource jrds) throws JRException {
		patientHistoryList.clear();
		patientHistoryList= null;
	}

}
