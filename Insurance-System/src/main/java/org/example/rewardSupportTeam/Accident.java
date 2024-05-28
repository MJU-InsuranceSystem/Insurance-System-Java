package org.example.rewardSupportTeam;


import org.example.domain.ClaimInsurance;

/**
 * @author USER
 * @version 1.0
 *
 */
public class Accident {

    private int accidentID;
    private ClaimInsurance ClaimInsurance;
    private String content;
    private org.example.user.Customer Customer;
    private int customerId;
    private String customerName;


    public Accident() {

    }

    public int getAccidentID() {
        return accidentID;
    }

    public void setAccidentID(int accidentID) {
        this.accidentID = accidentID;
    }

    public org.example.domain.ClaimInsurance getClaimInsurance() {
        return ClaimInsurance;
    }

    public void setClaimInsurance(org.example.domain.ClaimInsurance claimInsurance) {
        ClaimInsurance = claimInsurance;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public org.example.user.Customer getCustomer() {
        return Customer;
    }

    public void setCustomer(org.example.user.Customer customer) {
        Customer = customer;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }


    public void finalize() throws Throwable {

    }

}