package org.example.byteByteGo.fileSearch;

import java.util.List;

public class AndPredicate implements CompositePredicate {
	private List<Predicate> predicateList;

	public AndPredicate(List<Predicate> predicateList) {
		this.predicateList = predicateList;
	}

	@Override
	public boolean isMatches(File file) {
		return predicateList.stream().allMatch(p -> p.isMatches(file));
	}
}
