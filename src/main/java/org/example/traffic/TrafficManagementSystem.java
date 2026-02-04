package org.example.traffic;

import org.example.traffic.entities.Intersection;

public class TrafficManagementSystem {
	private Intersection intersection;
	private static TrafficManagementSystem trafficManagementSystem;

	private TrafficManagementSystem() {
		this.intersection = new Intersection();
	};

	public static synchronized TrafficManagementSystem getInstance() {
		if (trafficManagementSystem == null) {
			trafficManagementSystem = new TrafficManagementSystem();
		}
		return trafficManagementSystem;
	}

	void addRoadToIntersection() {
		this.intersection.createRoad();
	}
}
