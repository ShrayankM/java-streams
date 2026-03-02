package org.example.byteByteGo.fileSearch;

public class LessThanOperator<T extends Number> implements ComparisonOperator<T>{
	@Override
	public boolean isMatches(T actualAttributeValue, T expectedAttributeValue) {
		return Double.compare(actualAttributeValue.doubleValue(), expectedAttributeValue.doubleValue()) < 0;
	}
}
