package org.example.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import org.example.common.AuthGuideMessage;

public class InsuranceSystemView implements SystemView {

    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public void introduce() {
        println("안녕하세요. MJU 보험사 시스템입니다.");
    }

    @Override
    public int selectAuthOption() {
        println("아래 선택지 중 원하는 것을 선택해주세요");
        println("1. 로그인 / 2. 회원가입 / 3. 종료");
        return writeInt(); // 예외처리?
    }

    @Override
    public Map<String, String> getLoginInfo() {
        Map<String, String> loginInfo = new HashMap<>();
        println("아래 로그인 위한 정보를 입력해주세요");
        print("아이디 : ");
        loginInfo.put(AuthGuideMessage.AUTH_ID_KEY, writeString());
        print("비밀번호 : ");
        loginInfo.put(AuthGuideMessage.AUTH_PASSWORD_KEY, writeString());
        return loginInfo;
    }

    @Override
    public Map<String, String> getSignUpInfo() {
        Map<String, String> signUpInfo = new HashMap<>();
        println("아래 회원가입을 위한 정보를 입력해주세요");
        print("이름 : ");
        signUpInfo.put(AuthGuideMessage.AUTH_NAME_KEY, writeString());
        print("나이 : ");
        signUpInfo.put(AuthGuideMessage.AUTH_AGE_KEY, writeString());
        print("성별(남/여) : ");
        signUpInfo.put(AuthGuideMessage.AUTH_SEX_KEY, writeString());
        print("전화번호 : ");
        signUpInfo.put(AuthGuideMessage.AUTH_PHONE_NUMBER_KEY, writeString());
        print("고객/직원 선택 : ");
        signUpInfo.put(AuthGuideMessage.AUTH_CUSTOMER_WORKER_KEY, writeString());
        print("아이디 : ");
        signUpInfo.put(AuthGuideMessage.AUTH_ID_KEY, writeString());
        print("비밀번호 : ");
        signUpInfo.put(AuthGuideMessage.AUTH_PASSWORD_KEY, writeString());
        return signUpInfo;
    }

    @Override
    public void successLogin() {
        println("로그인에 성공하였습니다.");
    }

    @Override
    public void successSignUp() {
        println("회원가입에 성공하였습니다.");
    }

    @Override
    public void exitSystem() {
        println("시스템이 종료됩니다");
    }

    private String writeString() {
        return scanner.next();
    }

    private int writeInt() {
        return scanner.nextInt();
    }

    private void println(String message) {
        System.out.println(message);
    }

    private void print(String message) {
        System.out.print(message);
    }
}
