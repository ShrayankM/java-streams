package org.example.byteByteGo.fileSearch;

public class NotPredicate implements CompositePredicate {
	private Predicate predicate;

	public NotPredicate(Predicate predicate) {
		this.predicate = predicate;
	}

	@Override
	public boolean isMatches(File file) {
		return !predicate.isMatches(file);
	}
}
