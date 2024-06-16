package org.example.insurance.apply;

import java.util.List;

public interface InsuranceApplyList {
  void add(InsuranceApplication insurance);

  void remove(InsuranceApplication insurance);

  void remove(int index);

  InsuranceApplication findById(int insuranceId);

  InsuranceApplication findFirst();

  void update(InsuranceApplication insurance);

  List<InsuranceApplication> findAll();
}
