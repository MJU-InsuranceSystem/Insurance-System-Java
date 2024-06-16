package org.example.team.contract;

import org.example.insurance.apply.InsuranceApplication;

import java.util.List;

/**
 * @author USER
 * @version 1.0
 */
public interface ContractList {

  void add(Contract contract);

  void remove(Contract contract);

  void removeById(int contractId);

  InsuranceApplication findById(int contractId);

  List<Contract> getContracts();

  void update(Contract contract);

  boolean isEmpty();
}