package org.example.byteByteGo.fileSearch;

public class SimplePredicate<T> implements Predicate {
	private final FileAttribute fileAttribute;
	private final ComparisonOperator<T> comparisonOperator;
	private final T expectedAttributeValue;

	public SimplePredicate(FileAttribute fileAttribute, ComparisonOperator<T> comparisonOperator,
			T expectedAttributeValue) {
		this.fileAttribute = fileAttribute;
		this.comparisonOperator = comparisonOperator;
		this.expectedAttributeValue = expectedAttributeValue;
	}

	@Override
	public boolean isMatches(File file) {
		Object actualAttributeValue = file.extractFileAttribute(fileAttribute);
		if (expectedAttributeValue.getClass().isInstance(actualAttributeValue)) {
			return comparisonOperator.isMatches((T) actualAttributeValue, expectedAttributeValue);
		} else {
			return false;
		}
	}
}
