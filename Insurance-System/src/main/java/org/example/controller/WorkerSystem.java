package org.example.controller;

import java.util.HashMap;
import java.util.Scanner;
import org.example.Department;
import org.example.TeamView;
import org.example.config.WorkerConfig;

public class WorkerSystem {

    private final WorkerConfig workerConfig;

    private final HashMap<Integer, TeamView> teamList = new HashMap<>();
    private Scanner sc;

    public WorkerSystem() {
        this.workerConfig = new WorkerConfig();
        for (Department department : Department.values()) {
            teamList.put(department.getOrder(), department.getTeamController());
        }
        sc = new Scanner(System.in);
    }

    public void process() {
        while (true) {
            System.out.println("직원용 보험사 시스템입니다. 작업하실 팀을 고르세용");
            for (Department department : Department.values()) {
                System.out.println(department.getOrder() + "번 " + department.getName());
            }
            selectTeam(sc.nextInt());
        }
    }

    private void selectTeam(int i) {
        teamList.get(i).process();
    }


}
