package org.example.planTeam.design.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yoon
 * @version 1.0
 */
public class ProposalListImpl implements ProposalList {

    private final List<Proposal> proposalList;
    public Proposal proposal;

    public ProposalListImpl() {
        this.proposalList = new ArrayList<>();
    }

    public void finalize() throws Throwable {

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

}