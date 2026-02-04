package org.example.traffic.entities;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Intersection {
	private Map<String, Road> roadMap = new ConcurrentHashMap<>();

	public void createRoad() {
		Road road = new Road();
		roadMap.put(road.getId(), road);
	}
}
