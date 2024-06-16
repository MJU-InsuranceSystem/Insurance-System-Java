package org.example.contract;

import org.example.common.view.DepartmentView;

public class ContractManagementView extends DepartmentView {

    public void retrieveContracts(ContractList contractList) {
        contractList.getContracts().stream()
                .map(Contract::toString)
                .forEach(System.out::println);
    }
}
