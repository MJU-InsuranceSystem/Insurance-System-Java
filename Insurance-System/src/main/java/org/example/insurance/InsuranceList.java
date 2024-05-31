package org.example.insurance;

import org.example.domain.insurance.Insurance;

/**
 * @author USER
 * @version 1.0
 */
public interface InsuranceList {

  void add(Insurance insurance);

  void remove(Insurance insurance);

  Insurance findById(int insuranceId);

  void update(Insurance insurance);
}