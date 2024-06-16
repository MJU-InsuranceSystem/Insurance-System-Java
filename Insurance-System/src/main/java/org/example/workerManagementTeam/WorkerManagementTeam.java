package org.example.workerManagementTeam;

import org.example.Team;
import org.example.common.dto.RequestDto;
import org.example.common.dto.ResponseDto;
import org.example.user.Customer;
import org.example.user.CustomerList;
import org.example.user.Worker;
import org.example.user.WorkerList;

import java.util.List;

/**
 * @author USER
 * @version 1.0
 */
public class WorkerManagementTeam extends Team {

	private final WorkerList workerList = WorkerList.getInstance();

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

	public List<Worker> retrieveWorkerInfo() {
		return workerList.getWorkerList();
	}

}