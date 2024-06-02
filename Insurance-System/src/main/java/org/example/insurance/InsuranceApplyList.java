package org.example.insurance;

import org.example.domain.insurance.InsuranceApplication;

public interface InsuranceApplyList {
  void add(InsuranceApplication insurance);

  void remove(InsuranceApplication insurance);

  void remove(int index);

  InsuranceApplication findById(int insuranceId);

  InsuranceApplication findFirst();

  void update(InsuranceApplication insurance);
}
