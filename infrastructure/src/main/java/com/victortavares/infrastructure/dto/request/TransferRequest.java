package com.victortavares.infrastructure.dto.request;

import java.math.BigDecimal;

public record TransferRequest(String toTaxNumber, BigDecimal value , String pin) {
}
