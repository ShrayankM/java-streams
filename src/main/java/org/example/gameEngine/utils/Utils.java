package org.example.gameEngine.utils;


import java.util.function.Supplier;

public class Utils {
	public static Object getIfNull(Object object, Supplier<Object> supplier) {
		if (object == null) {
			object = supplier.get();
		}
		return object;
	}
}
