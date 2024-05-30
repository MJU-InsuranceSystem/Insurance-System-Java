package org.example.complaint;

import org.example.user.Customer;

/**
 * @author USER
 * @version 1.0
 */
public class Complaint {

	private ComplaintCategory category;
	private String content;
	private Customer submitCustomer;
	private String title;
	public ComplaintStatus complaintStatus;
	public ComplaintEvaluation complaintEvaluation;

	public Complaint(){

	}

	public void finalize() throws Throwable {

	}

	public ComplaintCategory getCategory() {
		return category;
	}

	public void setCategory(ComplaintCategory category) {
		this.category = category;
	}

	public ComplaintEvaluation getComplaintEvaluation() {
		return complaintEvaluation;
	}

	public void setComplaintEvaluation(ComplaintEvaluation complaintEvaluation) {
		this.complaintEvaluation = complaintEvaluation;
	}

	public ComplaintStatus getComplaintStatus() {
		return complaintStatus;
	}

	public void setComplaintStatus(ComplaintStatus complaintStatus) {
		this.complaintStatus = complaintStatus;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Customer getSubmitCustomer() {
		return submitCustomer;
	}

	public void setSubmitCustomer(Customer submitCustomer) {
		this.submitCustomer = submitCustomer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}