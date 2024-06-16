package org.example.planTeam.design.model.proposal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yoon
 * @version 1.0
 */
public class ProposalListImpl implements ProposalList {
    private static final List<Proposal> proposalList = new ArrayList<>();;
    static {
        for (int i = 0; i <4; i++) {
            Proposal proposal = new Proposal();
            proposal.setProposalId(i);
            proposal.setTitle("기획서" + i);
            proposalList.add(proposal);
        }
    }
    public void add(Proposal proposal) {
        proposalList.add(proposal);
    }

    public void delete() {

    }

    public Object read() {
        return null;
    }

    public void update() {

    }

    @Override
    public int getSize() {
        return proposalList.size();
    }

    @Override
    public List<Proposal> getList() {
        return proposalList;
    }

    @Override
    public Proposal findById(int insuranceId) {
        return proposalList.get(insuranceId);
    }

}