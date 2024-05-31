package org.example.complaint.view;

import org.example.common.view.DepartmentView;
import org.example.common.dto.RequestDto;

public class ComplaintView extends DepartmentView {

    private static final String COMPLAINT_TITLE = "title";
    private static final String COMPLAINT_CONTENT = "content";
    private static final String COMPLAINT_SCORE = "score";
    private static final String COMPLAINT_OPINION = "opinion";

    public RequestDto registerComplaint() {
        RequestDto requestDto = new RequestDto();
        println("[ 민원 신청하기 ]");
        print("제목 : ");
        requestDto.add(COMPLAINT_TITLE, writeString());
        print("민원 내용 : ");
        requestDto.add(COMPLAINT_CONTENT, writeString());
        println("");
        println("성공적으로 민원 신청이 완료되었습니다. 회신까지는 1 ~ 2일정도 소요됩니다");
        return requestDto;
    }

    public RequestDto evaluateComplaint() {
        RequestDto requestDto = new RequestDto();
        println("[ 민원 평가하기 ]");
        print("별점 (1 ~ 10) : ");
        requestDto.add(COMPLAINT_SCORE, writeString());
        print("평가 내용 : ");
        requestDto.add(COMPLAINT_OPINION, writeString());
        println("");
        println("감사합니다. 성공적으로 평가가 완료되었습니다.");
        return requestDto;
    }
}
