package org.example.workerManagementTeam;

import org.example.Team;
import org.example.common.dto.RequestVO;
import org.example.common.dto.ResponseVO;
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

	public List<Worker> retrieveWorkerInfo() {
		return workerList.getWorkerList();
	}

}