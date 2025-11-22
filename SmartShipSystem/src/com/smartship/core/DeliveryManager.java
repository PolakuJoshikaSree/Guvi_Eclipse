package com.smartship.core;

import java.util.*;
import java.util.stream.Collectors;

import com.smartship.exceptions.*;

public class DeliveryManager {

    private List<DeliveryAgent> agents = new ArrayList<>();
    private Map<String, Route> routes = new HashMap<>();
    private Set<String> packageIds = new HashSet<>();

    public void addAgent(DeliveryAgent agent) throws DuplicateEntryException {
        if (agents.stream().anyMatch(a -> a.getAgentId().equals(agent.getAgentId())))
            throw new DuplicateEntryException("Agent already exists: " + agent.getAgentId());
        agents.add(agent);
    }

    public void addRoute(Route route) throws RouteUnavailableException, DuplicateEntryException {
        String key = route.getFromCity() + "-" + route.getToCity();
        if (routes.containsKey(key))
            throw new DuplicateEntryException("Route already exists: " + key);
        route.validate();
        routes.put(key, route);
    }

    public void assignPackageToAgent(DeliveryPackage pkg) throws AgentNotAvailableException, OverloadException {
        List<DeliveryAgent> availableAgents = agents.stream()
            .filter(a -> a.getCity().equalsIgnoreCase(pkg.getDestinationCity()))
            .sorted(Comparator.comparingInt(DeliveryAgent::getPackageCount))
            .collect(Collectors.toList());

        if (availableAgents.isEmpty())
            throw new AgentNotAvailableException("No available agent in " + pkg.getDestinationCity());

        for (DeliveryAgent agent : availableAgents) {
            try {
                agent.assignPackage(pkg);
                return;
            } catch (OverloadException e) {
            }
        }

        throw new OverloadException("All agents in " + pkg.getDestinationCity() + " are overloaded.");
    }
}
