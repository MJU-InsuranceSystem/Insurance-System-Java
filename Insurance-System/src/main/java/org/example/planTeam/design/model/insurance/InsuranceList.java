package org.example.planTeam.design.model.insurance;

import java.util.List;

/**
 * @author USER
 * @version 1.0
 */
public interface InsuranceList {

    void add(Insurance insurance);

    void remove(Insurance insurance);

    void remove(int index);

    Insurance findById(int insuranceId);

    Insurance findFirst();

    void update(Insurance insurance);

    List<Insurance> findAll();
}