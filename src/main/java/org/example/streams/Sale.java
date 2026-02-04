package org.example.streams;

import java.time.LocalDate;

public record Sale(String product, LocalDate date, int amount) {
}
