package org.example.team;

import org.example.common.dto.RequestVO;
import org.example.common.dto.ResponseVO;

/**
 * @author yoon
 * @version 1.0
 */
public abstract class Team {

    private int team_Id;
    private String team_name;

    public Team() {

    }

    public abstract ResponseVO manage(RequestVO request);

    public abstract ResponseVO process(RequestVO request);

    public abstract ResponseVO register(RequestVO request);

    public abstract ResponseVO remove(RequestVO request);

    public abstract ResponseVO retrieve(RequestVO request);


}