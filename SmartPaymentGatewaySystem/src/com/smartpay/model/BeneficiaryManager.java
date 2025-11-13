package com.smartpay.model;

import java.util.HashMap;
import java.util.Map;
import com.smartpay.exceptions.BeneNotFoundException;

public class BeneficiaryManager {

    private Map<String, Beneficiary> beneficiaries = new HashMap<>();

    public BeneficiaryManager() {
        // Pre-populate some beneficiaries
        beneficiaries.put("Aashish", new Beneficiary("Aashish"));
        beneficiaries.put("Riya", new Beneficiary("Riya"));
        beneficiaries.put("Joshika", new Beneficiary("Joshika"));
    }

    public boolean isBeneficiaryExists(String name) throws BeneNotFoundException {
        if (!beneficiaries.containsKey(name)) {
            throw new BeneNotFoundException("Beneficiary '" + name + "' not found!");
        }
        return true;
    }

    // Accepts 2 parameters to match main class call
    public void addBeneficiary(String upiId, String name) {
        beneficiaries.put(name, new Beneficiary(name));
    }
}
