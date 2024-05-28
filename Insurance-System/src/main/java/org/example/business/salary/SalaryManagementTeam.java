package org.example.business.salary;

import org.example.Team;
import org.example.business.design.controller.dto.Request;
import org.example.business.design.controller.dto.Response;
import org.example.business.design.view.DesignInspectionController.Function;

public class SalaryManagementTeam extends Team {

    public SalaryApplication m_SalaryApplication;
    public SalaryApplicationListImpl m_SalaryApplicationListImpl;

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
