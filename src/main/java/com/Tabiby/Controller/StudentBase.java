package com.Tabiby.Controller;

import java.util.ArrayList;
import java.util.List;

import com.Tabiby.Model.PatientHistory;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class StudentBase implements JRDataSource
{
	private List<PatientHistory> listStudent;
	private int index = -1;

	public StudentBase()
	{
		super();
		prepareDataSource();
	}

	public void prepareDataSource()
	{
		listStudent = new ArrayList<PatientHistory>();


	}

	@Override
	public Object getFieldValue(JRField field) throws JRException
	{
        PatientHistory student = listStudent.get(index);

		if(field.getName().equals("visitNum"))
		{
			return student.getVisitNum();
		}
		else if(field.getName().equals("visitDate"))
		{
			return student.getVisitDate();
		}
		else if(field.getName().equals("symtops"))
		{
			return student.getSymtops();
		}
		else if(field.getName().equals("assignedMedecine"))
		{
			return student.getAssignedMedecine();
		}
        else if(field.getName().equals("comment"))
        {
            return student.getComment();        }
//        else if(field.getName().equals("clinicname"))
//        {
//            return student.getClinicName();       }
//        else if(field.getName().equals("username"))
//        {
//            return student.getUserName();        }
		return null;
	}

	@Override
	public boolean next() throws JRException
	{
		if(index < listStudent.size()-1)
		{
			index++;
			return true;
		}
		return false;
	}
}
