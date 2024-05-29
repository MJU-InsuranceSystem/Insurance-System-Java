package org.example.business.manager;

import org.example.Team;
import org.example.business.design.controller.dto.Request;
import org.example.business.design.controller.dto.Response;
import org.example.business.design.view.DesignInspectionController.Function;

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
	public void manage() {

	}

	@Override
	public Response process(Function function, Request request) {
		return null;
	}

	@Override
	public void register() {

	}

	@Override
	public void remove() {

	}

	@Override
	public Object retrieve() {
		return null;
	}
}