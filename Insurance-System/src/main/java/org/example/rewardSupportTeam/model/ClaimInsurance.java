package org.example.rewardSupportTeam.model;

/**
 * @author USER
 * @version 1.0
 */
public class ClaimInsurance {

    private String account;
    private String address;
    private String phoneNumber;
    private String residentNumber;
    private String supportingFile;

    public ClaimInsurance() {

    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getResidentNumber() {
        return residentNumber;
    }

    public void setResidentNumber(String residentNumber) {
        this.residentNumber = residentNumber;
    }

    public String getSupportingFile() {
        return supportingFile;
    }

    public void setSupportingFile(String supportingFile) {
        this.supportingFile = supportingFile;
    }


    public void finalize() throws Throwable {

    }

    @Override
    public String toString() {
        return "\n" + "계좌 : " + account + "\n" +
                "주소 : " + address + "\n" +
                "전화번호 : " + phoneNumber + "\n" +
                "주민번호 : " + residentNumber + "\n" +
                "증빙 서류 : " + supportingFile + "\n" +
                "--------------------------------------------" + "\n";
    }

}