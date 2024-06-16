package org.example.rewardSupportTeam.model;


/**
 * @author USER
 * @version 1.0
 */
public interface AccidentList {

    boolean add(Accident accident);

    boolean delete(int accidentID);

    Accident read(int accidentID);

    Accident update(int accidentID, Accident accident);

}