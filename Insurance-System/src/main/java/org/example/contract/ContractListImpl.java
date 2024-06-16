package org.example.contract;

import java.util.ArrayList;
import java.util.List;
import org.example.domain.insurance.InsuranceApplication;

/**
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
    CONTRACTS.remove(contract);
  }

  @Override
  public void removeById(int contractId) {
    CONTRACTS.removeIf(contract -> contract.getContractId() == contractId);
  }

  @Override
  public InsuranceApplication findById(int contractId) {
    for (Contract contract : CONTRACTS) {
      if (contract.getContractId() == contractId) {
        return contract.getInsuranceApplication();
      }
    }
    return null;
  }

  @Override
  public List<Contract> getContracts() {
    return new ArrayList<>(CONTRACTS);
  }

  @Override
  public void update(Contract contract) {
    for (int i = 0; i < CONTRACTS.size(); i++) {
      if (CONTRACTS.get(i).getContractId() == contract.getContractId()) {
        CONTRACTS.set(i, contract);
        return;
      }
    }
  }
}