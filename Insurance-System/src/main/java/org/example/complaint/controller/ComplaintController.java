package org.example.complaint.controller;

import org.example.TeamController;
import org.example.common.dto.RequestDto;
import org.example.complaint.ComplaintManagementTeam;
import org.example.complaint.usecase.ComplaintUseCase;
import org.example.complaint.view.ComplaintView;

public class ComplaintController implements TeamController {

    private final ComplaintView complaintView;
    private final ComplaintManagementTeam complaintManagementTeam;

    public ComplaintController(ComplaintView complaintView, ComplaintManagementTeam complaintManagementTeam) {
        this.complaintView = complaintView;
        this.complaintManagementTeam = complaintManagementTeam;
    }

    @Override
    public void process() {
        complaintView.intro("민원 관리");
        int selectNumber = complaintView.selectUsecase(ComplaintUseCase.class);
        ComplaintUseCase useCase = ComplaintUseCase.findByNumber(selectNumber);
        RequestDto requestDto = showUseCaseRequireInfo(useCase);
        complaintManagementTeam.process(requestDto);
    }

    private RequestDto showUseCaseRequireInfo(ComplaintUseCase useCase) {
        switch (useCase) {
            case REGISTER_COMPLAINT -> {
                return complaintView.registerComplaint();
            }
            case REQUEST_PROCESSING_STATUS -> {
                return null; // 아직 고민 중
            }
            case EVALUATE_COMPLAINT -> {
                return complaintView.evaluateComplaint();
            }
            default -> throw new IllegalArgumentException("해당 유스케이스 번호는 존재하지 않습니다.");
        }
    }
}
