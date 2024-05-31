package org.example.business.education.view;


import org.example.common.dto.RequestDto;
import org.example.common.dto.ResponseDto;
import org.example.common.view.DepartmentView;
import org.example.planTeam.Status;

public class EducationView extends DepartmentView {

    public static final String EDUCATION_SCHEDULE = "schedule";
    public static final String EDUCATION_NAME = "name";
    public static final String EDUCATION_LOCATION = "location";
    public static final String EDUCATION_TEACHER = "teacher";
    public static final String EDUCATION_CONTENTS = "contents";
    public static final String EDUCATION_TEXTBOOK = "textbook";


    public void intro() {
        println("안녕하세요. 영업 교육팀입니다.");
    }

    public void completeMessage(ResponseDto responseDto) {
        println("성공적으로 업무를 완료하였습니다");
        println("상태 메시지 : " + responseDto.get(Status.key()));
    }

    public RequestDto manageEducation() {
        return null;
    }

    public RequestDto prepareEducation() {
        RequestDto requestDto = new RequestDto();
        println("교육을 추가하기 전 정보를 입력해주세요");
        print("교육 이름 :");
        requestDto.add(EDUCATION_NAME, writeString());
        print("교육 장소 :");
        requestDto.add(EDUCATION_LOCATION, writeString());
        print("교육 일자 :");
        requestDto.add(EDUCATION_SCHEDULE, writeString());
        print("교육 내용 :");
        requestDto.add(EDUCATION_CONTENTS, writeString());
        print("강사 이름 :");
        requestDto.add(EDUCATION_TEACHER, writeString());
        print("교재 이름 :");
        requestDto.add(EDUCATION_TEXTBOOK, writeString());
        return requestDto;
    }

    public RequestDto manageEducationStudent() {
        return null;
    }
}
