package org.example.rewardSupportTeam;


import java.util.ArrayList;
import java.util.stream.IntStream;

/**
 * @author USER
 * @version 1.0
 *
 */
public class AccidentListImpl implements AccidentList {
    public Accident accident;
    private final ArrayList<Accident> accidentList;
    private int generatorId;

    public AccidentListImpl() {
        this.accidentList = new ArrayList<>();
    }

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

    private int generateId() {
        return generatorId++;
    }
}