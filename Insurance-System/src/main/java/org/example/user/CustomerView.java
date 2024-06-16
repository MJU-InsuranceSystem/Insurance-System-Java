package org.example.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import org.example.common.dto.RequestDto;
import org.example.common.dto.ResponseDto;
import org.example.contract.Contract;
import org.example.insurance.InsuranceType;
import org.example.planTeam.Status;
import org.example.planTeam.design.model.insurance.Insurance;

public class CustomerView {

    public static final String INSURANCE_APPLICATION_ID = "applicationId";
    public static final String INSURANCE_NUMBER = "number";
    public static final String FIRE_INFO = "fireInfo";
    public static final String SUBSCRIBER_NAME = "name";
    public static final String FAMILY_HISTORY = "accountNumber";
    public static final String FINANCE_STATUS = "financeStatus";
    public static final String PERSONAL_INFO = "personalInfo";
    public static final String REQUEST_INSURANCE = "requestInsurance";
    private static int INSURANCE_COUNT = 0;
    public static final String CHARGE_ANSWER = "chargeAnswer";
    public static final String SUBSCRIBE_INSURANCE = "insurances";
    public static final String TOTAL_ACCOUNT = "totalAccount";
    public static final String PREMIUM_ANSWER = "premiumAnswer";
    public static final String CHECK_PAID = "checkPaid";

    // 보험금 청구 정보
    public static final String ACCIDENT_CONTENT = "content";
    public static final String ACCIDENT_NAME = "name";
    // claimInsurance
    public static final String CLAIMINSURANCE_ACCOUNT = "account";
    public static final String CLAIMINSURANCE_ADDRESS = "address";
    public static final String CLAIMINSURANCE_PHONENUMBER = "phoneNumber";
    public static final String CLAIMINSURANCE_RESIDENTNUMBER = "residentNumber";
    public static final String CLAIMINSURANCE_SUPPORTINGFILE = "supportingFile";

    public void successTask() {
        println("업무 수행을 완료하였습니다.");
    }

    public int selectInsuranceNumber() {
        println("보험 종류를 먼저 선택해 주세요");
        for (InsuranceType insuranceType : InsuranceType.values()) {
            println(insuranceType.getInsuranceNumber() + ". : " + insuranceType.getDescription());
        }
        return writeInt();
    }

    public RequestDto requireInsuranceInfo(List<Insurance> selectInsurances) {
        RequestDto requestDto = new RequestDto();
        requestDto.add(INSURANCE_APPLICATION_ID, String.valueOf(++INSURANCE_COUNT));
        println("아래는 선택한 보험의 정보입니다.");
        println(">>");
        for (Insurance insurance : selectInsurances) {
            println(insurance.toString());
        }
        println("=================================");
        print("위 보험 중 원하시는 보험 ID를 고르세요 : ");
        requestDto.add(INSURANCE_NUMBER, writeString());
        print("보험 가입자 이름 : ");
        requestDto.add(SUBSCRIBER_NAME, writeString());
        print("개인 정보(건강 상태, 과거 의료 기록, 현재 병력, 만성 질환 여부, 직업 및 취업 상황) : ");
        requestDto.add(PERSONAL_INFO, writeString());
        print("가입하려는 보험 상품(보장 범위, 가입 기간, 부가 보험): ");
        requestDto.add(REQUEST_INSURANCE, writeString());
        print("가족력(유전적 질병 여부, 가족 내 의료 기록) : ");
        requestDto.add(FAMILY_HISTORY, writeString());
        print("금융 상태(보험금 납부 능력, 재정 상태, 기존 보험상품 가입여부) : ");
        requestDto.add(FINANCE_STATUS, writeString());
        return requestDto;
    }

    public RequestDto requireFireInfo() {
        RequestDto requestDto = new RequestDto();
        println("화재 보험을 선택하였습니다. 화재 보험 가입에 필요한 정보를 입력해 주세요");
        requestDto.add(INSURANCE_NUMBER, "1");
        print("화재 보험 가입자 이름 : ");
        requestDto.add(SUBSCRIBER_NAME, writeString());
        print("화재 보험 정보 : ");
        requestDto.add(FIRE_INFO, writeString());
        print("계좌 번호 : ");
        requestDto.add(FAMILY_HISTORY, writeString());
        return requestDto;
    }

    public RequestDto requireLifeInfo() {
        RequestDto requestDto = new RequestDto();
        println("생명 보험을 선택하였습니다. 생명 보험 가입에 필요한 정보를 입력해 주세요");
        requestDto.add(INSURANCE_NUMBER, "2");
        print("생명 보험 가입자 이름 : ");
        requestDto.add(SUBSCRIBER_NAME, writeString());
        print("생명 보험 정보 : ");
        requestDto.add(FIRE_INFO, writeString());
        print("계좌 번호 : ");
        requestDto.add(FAMILY_HISTORY, writeString());
        return requestDto;
    }

    public RequestDto requireTravelInfo() {
        RequestDto requestDto = new RequestDto();

        return requestDto;
    }

    public RequestDto requireCarInfo() {
        RequestDto requestDto = new RequestDto();

        return requestDto;
    }

    public RequestDto requireCancerInfo() {
        RequestDto requestDto = new RequestDto();

        return requestDto;
    }

    public RequestDto payInsurancePremiumInfo() {
        RequestDto requestDto = new RequestDto();
        println("보험료를 납부하시곘습니까? (Y/N) ");
        requestDto.add(PREMIUM_ANSWER, writeString());
        return requestDto;
    }

    public RequestDto requireInsuranceBenefitInfo() {
        RequestDto requestDto = new RequestDto();

        println("보험금 청구를 위한 '사건 정보'를 입력해주세요.");
        print("사고 내용 : ");
        requestDto.add(ACCIDENT_CONTENT, writeString());
        print("고객 이름 : ");
        requestDto.add(ACCIDENT_NAME, writeString());

        println("보험금 청구를 위한 '보험금 청구정보'를 입력해주세요.");
        print("계좌 : ");
        requestDto.add(CLAIMINSURANCE_ACCOUNT, writeString());
        print("주소 : ");
        requestDto.add(CLAIMINSURANCE_ADDRESS, writeString());
        print("전화번호 : ");
        requestDto.add(CLAIMINSURANCE_PHONENUMBER, writeString());
        print("주민번호 : ");
        requestDto.add(CLAIMINSURANCE_RESIDENTNUMBER, writeString());
        print("증빙 서류 : ");
        requestDto.add(CLAIMINSURANCE_SUPPORTINGFILE, writeString());

        println("");
        println("개인정보처리 동의서\n" +
                "본인은 '보험사'이(가) 제공하는 서비스 이용을 위해 성명, 연락처 등의 개인정보를 수집·이용하는 것에 동의합니다.");
        println("");
        println("보험금을 청구하시곘습니까? (Y/N) ");
        requestDto.add(CHARGE_ANSWER, writeString());
        return requestDto;
    }
    public void retrieveContract(List<Contract> contractList) {
        contractList.stream()
            .map(Contract::toString)
            .forEach(System.out::println);
    }

    public void completeSubmitAccident(ResponseDto responseDto) {
        if (responseDto.get(Status.getKey()).equals(Status.SUCCESS.getStatus())) {
            println("성공적으로 사고가 접수되었습니다.");
        } else {
            println("사고 접수에 실패하였습니다. 다시 시도해주세요.");
        }
    }

    public void emptyInsuranceInfo() {
        println("해당 보험은 현재 준비되어 있지 않습니다.");
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

    public boolean showAccountOfInsurance(ResponseDto responseDto) {
        if(responseDto.get(CHECK_PAID).equals("Y")) {
            println("이미 납부하였습니다.");
            return false;
        }
        String insurances = responseDto.get(SUBSCRIBE_INSURANCE);
        int totalAccount = Integer.parseInt(responseDto.get(TOTAL_ACCOUNT));
        println("가입한 보험 : " + insurances);
        println("납부할 금액 : " + totalAccount);
        return true;
    }
}