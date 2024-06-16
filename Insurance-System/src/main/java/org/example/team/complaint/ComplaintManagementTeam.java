package org.example.team.complaint;

import org.example.team.Team;
import org.example.common.dto.RequestVO;
import org.example.common.dto.ResponseVO;
import org.example.team.complaint.model.Complaint;
import org.example.team.complaint.model.ComplaintList;
import org.example.team.complaint.model.ComplaintListImpl;

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
	public ResponseVO manage(RequestVO request) {
		return null;
	}

	@Override
	public ResponseVO process(RequestVO request) {
		return null;
	}

	@Override
	public ResponseVO register(RequestVO request) {
		return null;
	}

	@Override
	public ResponseVO remove(RequestVO request) {
		return null;
	}

	@Override
	public ResponseVO retrieve(RequestVO request) {
		return null;
	}

	public void finalize() throws Throwable {

	}

	public void analyze(){

	}

}