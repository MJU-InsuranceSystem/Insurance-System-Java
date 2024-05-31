package org.example.contract;

import org.example.domain.insurance.Insurance;

/**
 * @author USER
 * @version 1.0
 */
public interface ContractList {

  void add(Contract contract);

  void remove(Contract contract);

  Insurance findById(int contractId);

  void update(Contract contract);
}