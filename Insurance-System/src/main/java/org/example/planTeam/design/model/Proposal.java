package org.example.planTeam.design.model;

/**
 * @author USER
 * @version 1.0
 */
public class Proposal {

    private final int proposalId;
    private final String title;
    private final String productOverview;
    private final String marketResearch;
    private final String insurancePayment;
    private final String saleStrategy;
    private final String saleTarget;
    private final String reward;

    private Proposal(ProposalBuilder proposalBuilder) {
        this.proposalId = proposalBuilder.proposalId;
        this.title = proposalBuilder.title;
        this.productOverview = proposalBuilder.productOverview;
        this.marketResearch = proposalBuilder.marketResearch;
        this.insurancePayment = proposalBuilder.insurancePayment;
        this.saleStrategy = proposalBuilder.saleStrategy;
        this.saleTarget = proposalBuilder.saleTarget;
        this.reward = proposalBuilder.reward;
    }

    public static class ProposalBuilder {

        private int proposalId;
        private String title;
        private String productOverview;
        private String marketResearch;
        private String insurancePayment;
        private String saleStrategy;
        private String saleTarget;
        private String reward;

        public ProposalBuilder proposalId(int proposalId) {
            this.proposalId = proposalId;
            return this;
        }

        public ProposalBuilder title(String title) {
            this.title = title;
            return this;
        }

        public ProposalBuilder productOverview(String productOverview) {
            this.productOverview = productOverview;
            return this;
        }

        public ProposalBuilder marketResearch(String marketResearch) {
            this.marketResearch = marketResearch;
            return this;
        }

        public ProposalBuilder insurancePayment(String insurancePayment) {
            this.insurancePayment = insurancePayment;
            return this;
        }

        public ProposalBuilder saleStrategy(String saleStrategy) {
            this.saleStrategy = saleStrategy;
            return this;
        }

        public ProposalBuilder saleTarget(String saleTarget) {
            this.saleTarget = saleTarget;
            return this;
        }

        public ProposalBuilder reward(String reward) {
            this.reward = reward;
            return this;
        }

        public Proposal build() {
            return new Proposal(this);
        }
    }

    @Override
    protected void finalize() throws Throwable {
        // Cleanup logic
    }
}
