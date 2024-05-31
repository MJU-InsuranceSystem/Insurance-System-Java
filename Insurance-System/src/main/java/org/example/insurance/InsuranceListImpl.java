package org.example.insurance;

import java.util.ArrayList;
import java.util.List;
import org.example.domain.insurance.Insurance;

/**
 * @author USER
 * @version 1.0
 */
public class InsuranceListImpl implements InsuranceList {

	private static final List<Insurance> insurances = new ArrayList<>();

	@Override
	public void add(Insurance insurance) {

	}

	@Override
	public void remove(Insurance insurance) {

	}

	@Override
	public Insurance findById(int insuranceId) {
		return null;
	}

	@Override
	public void update(Insurance insurance) {

	}
}