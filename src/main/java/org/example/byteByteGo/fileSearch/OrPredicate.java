package org.example.byteByteGo.fileSearch;

import java.util.List;

public class OrPredicate implements CompositePredicate {
	private List<Predicate> predicateList;

	public OrPredicate(List<Predicate> predicateList) {
		this.predicateList = predicateList;
	}

	@Override
	public boolean isMatches(File file) {
		return predicateList.stream().anyMatch(p -> p.isMatches(file));
	}
}
