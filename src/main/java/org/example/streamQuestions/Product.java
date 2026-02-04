package org.example.streamQuestions;

import java.time.LocalDate;

public record Product(String id, Double price, LocalDate createdAt) {
}
