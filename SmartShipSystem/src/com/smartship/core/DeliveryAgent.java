package com.smartship.core;

import com.smartship.exceptions.OverloadException;
import java.util.ArrayList;
import java.util.List;

public class DeliveryAgent {
    private String agentId;
    private String city;
    private List<DeliveryPackage> assignedPackages = new ArrayList<>();
    private final int maxPackages;

    public DeliveryAgent(String agentId, String city, int maxPackages) {
        this.agentId = agentId;
        this.city = city;
        this.maxPackages = maxPackages;
    }

    public String getAgentId() { return agentId; }
    public String getCity() { return city; }
    public List<DeliveryPackage> getAssignedPackages() { return assignedPackages; }

    public void assignPackage(DeliveryPackage pkg) throws OverloadException {
        if (assignedPackages.size() >= maxPackages)
            throw new OverloadException("Agent " + agentId + " cannot take more packages.");
        assignedPackages.add(pkg);
    }

    public int getPackageCount() {
        return assignedPackages.size();
    }
}
