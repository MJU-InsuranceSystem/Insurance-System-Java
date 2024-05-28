package org.example.business.education.view;

import java.util.Scanner;
import org.example.business.education.controller.RequestDto;
import org.example.business.education.usecase.EducationUseCase;

public class EducationView {

  public static final String EDUCATION_SCHEDULE = "schedule";
  public static final String EDUCATION_NAME = "name";
  public static final String EDUCATION_LOCATION = "location";
  public static final String EDUCATION_TEACHER = "teacher";
  public static final String EDUCATION_CONTENTS = "contents";
  public static final String EDUCATION_TEXTBOOK = "textbook";


  public void intro() {
    println("안녕하세요. 영업 교육팀입니다.");
  }

  public int selectUsecase() {
    println("아래 중 수행하실 번호를 입력해주세요.");
    for (EducationUseCase usecase : EducationUseCase.values()) {
      println(usecase.getOrder() + " : " + usecase.getDescription());
    }
    return writeInt();
  }

  private String writeString() {
    Scanner scanner = new Scanner(System.in);
    String text = scanner.next();
    scanner.close();
    return text;
  }

  private int writeInt() {
    Scanner scanner = new Scanner(System.in);
    int text = scanner.nextInt();
    scanner.close();
    return text;
  }

  private void println(String message) {
    System.out.println(message);
  }

  private void print(String message) {
    System.out.print(message);
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
