package org.example.byteByteGo.fileSearch;

public class FileSearchCriteria {
	private final Predicate predicate;

	public FileSearchCriteria(Predicate predicate) {
		this.predicate = predicate;
	}

	public boolean isMatches(File file) {
		return predicate.isMatches(file);
	}
}
