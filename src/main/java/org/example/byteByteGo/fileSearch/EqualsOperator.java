package org.example.byteByteGo.fileSearch;

import java.util.Objects;

public class EqualsOperator <T> implements ComparisonOperator<T> {
	@Override
	public boolean isMatches(T actualAttributeValue, T expectedAttributeValue) {
		return Objects.equals(actualAttributeValue, expectedAttributeValue);
	}
}
