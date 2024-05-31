package org.example.business.salary;

import org.example.Team;
import org.example.common.dto.RequestDto;
import org.example.common.dto.ResponseDto;

import java.util.function.Function;

public class SalaryManagementTeam extends Team {

    public SalaryApplication m_SalaryApplication;
    public SalaryApplicationListImpl m_SalaryApplicationListImpl;

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
