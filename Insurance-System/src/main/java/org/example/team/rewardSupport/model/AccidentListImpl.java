package org.example.team.rewardSupport.model;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author USER
 * @version 1.0
 */
public class AccidentListImpl implements AccidentList {
    public Accident accident;
    private static final ArrayList<Accident> accidentList = new ArrayList<>();
    private int generatorId = 0;

//    public AccidentListImpl() {
//        this.accidentList = new ArrayList<>();
//    }

    public void finalize() throws Throwable {
    }

    public boolean add(Accident accident) {
        if (accident != null) {
            accident.setAccidentID(generateId());
            accidentList.add(accident);
            return true;
        }
        return false;
    }

    public boolean delete(int accidentID) {
        return accidentList.removeIf(accident -> accident.getAccidentID() == accidentID);
    }

    public Accident read(int accidentID) {
        return accidentList.stream()
                .filter(accident -> accident.getAccidentID() == accidentID)
                .findFirst()
                .orElse(null);
    }

    public Accident update(int accidentID, Accident udateAccident) {
        IntStream.range(0, accidentList.size())
                .filter(i -> accidentList.get(i).getAccidentID() == accidentID)
                .findFirst()
                .ifPresent(i -> accidentList.set(i, udateAccident));
        return accidentList.stream()
                .filter(accident -> accident.getAccidentID() == accidentID)
                .findFirst()
                .orElse(null);
    }

    public List<Accident> getAllAccidents() {
        return new ArrayList<>(accidentList);
    }

    private int generateId() {
        return generatorId++;
    }
}