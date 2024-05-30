package org.example.planTeam.design.model;


/**
 * @author yoon
 * @version 1.0
 */
public interface ProposalList {

    public void add(Proposal proposal);

    public void delete();

    public Object read();

    public void update();

    public int getSize();

}