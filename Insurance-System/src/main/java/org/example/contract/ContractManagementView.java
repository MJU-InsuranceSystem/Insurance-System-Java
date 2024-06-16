package org.example.contract;

import org.example.common.dto.RequestDto;
import org.example.common.view.DepartmentView;

public class ContractManagementView extends DepartmentView {

    public static final String CONTRACT_ID = "contractId";

    public void retrieveContracts(ContractList contractList) {
        contractList.getContracts().stream()
                .map(Contract::toString)
                .forEach(System.out::println);
    }

    public RequestDto requireDeleteContractNumber() {
        RequestDto requestDto = new RequestDto();
        print("파기할 계약 번호 : ");
        requestDto.add(CONTRACT_ID, writeString());
        return requestDto;
    }

    public void successTask() {
        println("업무 수행을 완료하였습니다.");
    }
}
