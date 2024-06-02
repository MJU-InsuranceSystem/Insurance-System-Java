package org.example.planTeam.design.model.proposal;


import java.util.List;
import org.example.planTeam.design.model.insurance.Insurance;

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