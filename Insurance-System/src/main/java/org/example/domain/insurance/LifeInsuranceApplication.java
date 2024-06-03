package org.example.domain.insurance;

/**
 * @author USER
 * @version 1.0
 */
public class LifeInsuranceApplication extends InsuranceApplication {

    private String exclusions;
    private String medicalHistory;

    public LifeInsuranceApplication() {

    }

    public String getExclusions() {
        return exclusions;
    }

    public void setExclusions(String exclusions) {
        this.exclusions = exclusions;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }


    public void finalize() throws Throwable {
        super.finalize();
    }

}