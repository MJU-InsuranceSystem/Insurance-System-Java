package org.example.complaint;

import org.example.Team;
import org.example.common.dto.RequestDto;
import org.example.common.dto.ResponseDto;
import org.example.complaint.model.Complaint;
import org.example.complaint.model.ComplaintList;
import org.example.complaint.model.ComplaintListImpl;

/**
 * @author USER
 * @version 1.0

 */
public class ComplaintManagementTeam extends Team {

	public Complaint complaint;

	private final ComplaintList complaintList = new ComplaintListImpl();

	public ComplaintManagementTeam(){

	}

	@Override
	public ResponseDto manage(RequestDto request) {
		return null;
	}

	@Override
	public ResponseDto process(RequestDto request) {
		return null;
	}

	@Override
	public ResponseDto register(RequestDto request) {
		return null;
	}

	@Override
	public ResponseDto remove(RequestDto request) {
		return null;
	}

	@Override
	public ResponseDto retrieve(RequestDto request) {
		return null;
	}

	public void finalize() throws Throwable {

	}

	public void analyze(){

	}

}