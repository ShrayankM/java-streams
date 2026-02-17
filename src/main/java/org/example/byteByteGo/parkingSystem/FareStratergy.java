package org.example.byteByteGo.parkingSystem;

import java.math.BigDecimal;

public interface FareStratergy {
	BigDecimal calculcateFare(Ticket ticket, BigDecimal inputFare);
}
