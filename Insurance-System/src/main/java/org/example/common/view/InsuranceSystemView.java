package org.example.common.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import org.example.team.Department;
import org.example.user.auth.AuthGuideMessage;
import org.example.user.customer.CustomerProcess;

public class InsuranceSystemView implements SystemView {
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
    public int selectTeam() {
        println("직원용 보험사 시스템입니다. 작업하실 팀을 고르세요");
        println("0번 : 종료하기");
        for (Department department : Department.values()) {
            println(department.getOrder() + "번 :" + department.getName());
        }
        return writeInt();
    }

    @Override
    public int selectCustomerProcess() {
        println("고객용 보험사 시스템입니다. 원하시는 업무를 고르세요");
        println("0번 : 종료하기");
        for (CustomerProcess process : CustomerProcess.values()) {
            println(process.getProcessNumber() + "번 :" + process.getDescription());
        }
        return writeInt();
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
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          return br.readLine();
        } catch (IOException e) {
            throw new IllegalArgumentException("잘못 입력하였습니다.");
        }
    }

    private int writeInt() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            return Integer.parseInt(br.readLine());
        } catch (IOException e) {
            throw new IllegalArgumentException("잘못 입력하였습니다.");
        }
    }

    private void println(String message) {
        System.out.println(message);
    }

    private void print(String message) {
        System.out.print(message);
    }
}
