package org.example.business.design.controller.dto;

import java.util.HashMap;
import java.util.Map;
import org.example.business.design.view.DesignInspectionController.Function;

public class RequestFactory {

    private final Map<Function, Request> requests = new HashMap<>();
    private static final RequestFactory instance = new RequestFactory();

    public static RequestFactory getInstance() {
        return instance;
    }

    private RequestFactory() {
        requests.put(Function.planProposal, new DesignRequest());

    }

    public Request getRequest(Function function) {
        return requests.get(function);
    }
}
