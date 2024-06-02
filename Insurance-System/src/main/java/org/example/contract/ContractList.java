package org.example.contract;

import org.example.domain.insurance.Insurance;

import java.util.List;

/**
 * @author USER
 * @version 1.0
 */
public interface ContractList {

  void add(Contract contract);

  void remove(Contract contract);

  Insurance findById(int contractId);

  List<Contract> getContracts();

  void update(Contract contract);
}