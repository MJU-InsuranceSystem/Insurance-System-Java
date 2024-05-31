package org.example.insurance;

import java.util.ArrayList;
import java.util.List;
import org.example.domain.insurance.Insurance;

public class InsuranceApplyList implements InsuranceList {
  private static final List<Insurance> INSURANCES = new ArrayList<>();

  @Override
  public void add(Insurance insurance) {
    INSURANCES.add(insurance);
  }

  @Override
  public void remove(Insurance insurance) {
    INSURANCES.remove(insurance);
  }

  @Override
  public void remove(int index) {

  }

  @Override
  public Insurance findById(int insuranceId) {
    return INSURANCES.stream()
        .filter(insurance -> insurance.getInsuranceID() == insuranceId)
        .findFirst()
        .orElse(null);
  }

  @Override
  public Insurance findFirst() {
    if (!INSURANCES.isEmpty()) {
      return INSURANCES.get(0);
    }
    return null;
  }

  @Override
  public void update(Insurance insurance) {

  }
}
