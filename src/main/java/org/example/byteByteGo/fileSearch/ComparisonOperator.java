package org.example.byteByteGo.fileSearch;

public interface ComparisonOperator<T> {
	boolean isMatches(final T actualAttributeValue, final T expectedAttributeValue);
}
