package org.example.business.manager;

import org.example.Team;
import org.example.common.dto.RequestDto;
import org.example.common.dto.ResponseDto;

import java.util.function.Function;

/**
 * @author USER
 * @version 1.0
 */
public class EmployeeManagementTeam extends Team {

	public OperationPolicyListImpl m_OperationPolicyListImpl;
	public OperationPolicy m_OperationPolicy;
	public EmployeeListImpl m_EmployeeListImpl;
	public Employee m_Employee;

	public EmployeeManagementTeam(){

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
}