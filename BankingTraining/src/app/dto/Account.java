package com.app.dto;

import java.util.List;

public record Account(String accountNumber, double balance, List<Beneficiary> beneficiaries) {}
