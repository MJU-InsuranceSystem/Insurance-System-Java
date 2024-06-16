package org.example.team.plan.design.model.proposal;


import java.util.List;

/**
 * @author yoon
 * @version 1.0
 */
public interface ProposalList {

    void add(Proposal proposal);

    void delete();

    Object read();

    void update();

    int getSize();

    List<Proposal> getList();

    Proposal findById(int insuranceId);
}