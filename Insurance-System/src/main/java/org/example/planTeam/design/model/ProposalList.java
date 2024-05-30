package org.example.planTeam.design.model;


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

}