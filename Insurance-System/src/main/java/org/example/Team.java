package org.example;

import org.example.common.dto.RequestDto;
import org.example.common.dto.ResponseDto;
import org.example.domain.insurance.Insurance;

/**
 * @author yoon
 * @version 1.0
 */
public abstract class Team {

    private int team_Id;
    private String team_name;
    public Insurance m_Insurance;

    public Team() {

    }

    public abstract void manage();

    public abstract ResponseDto process(int usecaseNumber, RequestDto request);

    public abstract void register();

    public abstract void remove();

    public abstract ResponseDto retrieve();
}