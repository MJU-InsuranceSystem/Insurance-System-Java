package org.example.domain.insurance;

import org.example.CarKind;

/**
 * @author USER
 * @version 1.0
 *
 */
public class CarInsurance extends Insurance {

	private CarKind carKind;
	private int percentageOfBlame;
	private int userDuration;

	public CarInsurance(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

}