package org.example.domain.team;


/**
 * @author USER
 * @version 1.0
 *
 */
public interface AccidentList {

	public boolean add(Accident accident);

	public boolean delete(int accidentID);

	public Accident read(int accidentID);

	public Accident update(int accidentID, Accident accident);

}