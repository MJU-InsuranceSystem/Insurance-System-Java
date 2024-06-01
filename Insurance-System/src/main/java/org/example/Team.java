package org.example;

import org.example.common.dto.RequestDto;
import org.example.common.dto.ResponseDto;

/**
 * @author yoon
 * @version 1.0
 */
public abstract class Team {

    private int team_Id;
    private String team_name;

    public Team() {

    }

    public abstract ResponseDto manage(RequestDto request);

    public abstract ResponseDto process(RequestDto request);

    public abstract ResponseDto register(RequestDto request);

    public abstract ResponseDto remove(RequestDto request);

    public abstract ResponseDto retrieve(RequestDto request);


}