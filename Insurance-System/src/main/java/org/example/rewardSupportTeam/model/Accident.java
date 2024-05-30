package org.example.rewardSupportTeam.model;


/**
 * @author USER
 * @version 1.0
 */
public class Accident {


    private int accidentID;
    private String content;
    private String customerName;
    private ClaimInsurance claimInsurance;

    public Accident() {

    }

    public int getAccidentID() {
        return accidentID;
    }

    public void setAccidentID(int accidentID) {
        this.accidentID = accidentID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public ClaimInsurance getClaimInsurance() {
        return claimInsurance;
    }

    public void setClaimInsurance(ClaimInsurance claimInsurance) {
        this.claimInsurance = claimInsurance;
    }


    public void finalize() throws Throwable {

    }

}