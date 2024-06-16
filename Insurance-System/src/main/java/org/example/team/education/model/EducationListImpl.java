package org.example.team.education.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kosun
 * @version 1.0
 */
public class EducationListImpl implements EducationList {

	private final List<Education> educations = new ArrayList<>();
	{
		for (int i = 1; i < 5 ; i++) {
			Education education = new Education();
			education.setName(i + " 번째 교육 제목");
			educations.add(education);
		}
	}
	@Override
	public void add(Education education) {
		if (education != null) {
			educations.add(education);
			return;
		}
		throw new NullPointerException("해당 교육이 Null 값입니다.");
	}

	@Override
	public void delete(Education education) {

	}

	@Override
	public Education read(int educationId) {
		return null;
	}

	@Override
	public void update(Education education) {

	}
	public List<Education> findAll() {
		return educations;
	}
}