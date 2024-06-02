package org.example.contract;

import org.example.domain.insurance.InsuranceApplication;

import java.util.List;

/**
 * @author USER
 * @version 1.0
 */
public interface ContractList {

  void add(Contract contract);

  void remove(Contract contract);

  InsuranceApplication findById(int contractId);

  List<Contract> getContracts();

  void update(Contract contract);
}