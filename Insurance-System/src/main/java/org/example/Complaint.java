package org.example;
/**
 * @author USER
 * @version 1.0
 */
public class Complaint {

	private ComplaintCategory catagory;
	private ComplaintEvaluation ComplaintEvaluation;
	private ComplaintStatus ComplaintStatus;
	private String content;
	private Customer submitCustomer;
	private String title;
	public ComplaintStatus m_ComplaintStatus;
	public ComplaintEvaluation m_ComplaintEvaluation;

	public Complaint(){

	}

	public void finalize() throws Throwable {

	}

}