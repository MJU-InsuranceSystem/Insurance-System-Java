package org.example.team;

import org.example.common.config.DepartmentConfig;

import java.util.Arrays;

public enum Department {
    DESIGN_PLAN_TEAM(1,
        (DepartmentConfig.designInspectionController()), "상품 기획팀"),
    UNDER_WRITE_TEAM(2, DepartmentConfig.underwriteController(), "U/W팀"),
    BUSINESS_EDUCATION_TEAM(3, DepartmentConfig.educationController(), "영업 교육 팀"),
    MARKETING_TEAM(4, null, "마케팅 팀"),
    EMPLOYEE_MANAGEMENT_TEAM(5, null, "영업 관리 팀"),
    RECRUITMENT_TEAM(6, null, "채용 관리 팀"),
    SALARY_MANAGEMENT_TEAM(7, null, "급여 관리 팀"),
    REWARD_SUPPORT_TEAM(8, DepartmentConfig.rewardSupportController(), "보상 지원 팀"),
    CONTRACT_MANAGEMENT_TEAM(9, DepartmentConfig.contractManagementController(), "계약 관리 팀"),
    CUSTOMER_MANAGEMENT_TEAM(10, DepartmentConfig.customerManagementController(), "고객 관리 팀"),
    WORKER_MANAGEMENT_TEAM(11, DepartmentConfig.workerManagementController(), "직원 관리 팀")
    ;
    private final int order;
    private final TeamController teamController;
    private final String name;

    Department(int order, TeamController teamController, String name) {
        this.order = order;
        this.teamController = teamController;
        this.name = name;
    }

    public static Department findTeamByNumber(int selectTeamNumber) {
        return Arrays.stream(Department.values())
            .filter(department -> department.getOrder() == selectTeamNumber)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("해당 팀 번호를 찾을 수 없습니다."));
    }

    public int getOrder() {
        return order;
    }

    public TeamController getTeamController() {
        return teamController;
    }

    public String getName() {
        return name;
    }
}
