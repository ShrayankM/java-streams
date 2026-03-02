package org.example.byteByteGo.fileSearch;

import java.util.regex.Pattern;

public class RegexOperator<T extends String> implements ComparisonOperator <T>{

	@Override
	public boolean isMatches(T actualAttributeValue, T expectedAttributeValue) {
		final Pattern pattern = Pattern.compile(expectedAttributeValue);
		return pattern.matcher(actualAttributeValue).matches();
	}
}
