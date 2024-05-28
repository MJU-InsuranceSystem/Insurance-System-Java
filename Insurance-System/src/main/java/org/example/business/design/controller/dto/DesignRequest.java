package org.example.business.design.controller.dto;

public class DesignRequest implements Request {

    private String title;

    private int proposlId;

    private String productOverView;
    private String MarketReserach;
    private String saleStrategy;
    private String insurancePayment;
    private String saleTarget;

    public String getProductOverView() {
        return productOverView;
    }

    public void setProductOverView(String productOverView) {
        this.productOverView = productOverView;
    }

    public String getMarketReserach() {
        return MarketReserach;
    }

    public void setMarketReserach(String marketReserach) {
        MarketReserach = marketReserach;
    }

    public String getSaleStrategy() {
        return saleStrategy;
    }

    public void setSaleStrategy(String saleStrategy) {
        this.saleStrategy = saleStrategy;
    }

    public String getInsurancePayment() {
        return insurancePayment;
    }

    public void setInsurancePayment(String insurancePayment) {
        this.insurancePayment = insurancePayment;
    }

    public String getSaleTarget() {
        return saleTarget;
    }

    public void setSaleTarget(String saleTarget) {
        this.saleTarget = saleTarget;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getProposlId() {
        return proposlId;
    }

    public void setProposlId(int proposlId) {
        this.proposlId = proposlId;
    }


}
