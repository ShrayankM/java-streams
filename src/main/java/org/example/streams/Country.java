package org.example.streams;

import java.util.List;

public record Country(String name, List<City> cities) {
}
