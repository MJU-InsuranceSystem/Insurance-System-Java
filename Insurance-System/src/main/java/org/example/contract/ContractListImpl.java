package org.example.contract;

import java.util.ArrayList;
import java.util.List;
import org.example.domain.insurance.Insurance;

/**
 * @author USER
 * @version 1.0

 */
public class ContractListImpl implements ContractList {

  private static final List<Contract> CONTRACTS = new ArrayList<>();

  @Override
  public void add(Contract contract) {
    CONTRACTS.add(contract);
  }

  @Override
  public void remove(Contract contract) {

  }

  @Override
  public Insurance findById(int contractId) {
    return null;
  }

  @Override
  public List<Contract> getContracts() {
    return CONTRACTS;
  }

  @Override
  public void update(Contract contract) {

  }
}