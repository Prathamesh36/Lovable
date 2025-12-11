package com.portfolio.projects.service.impl;

import com.portfolio.projects.dto.subscription.PlanResponse;
import com.portfolio.projects.service.PlanService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {
    @Override
    public List<PlanResponse> getAllActivePlans() {
        return List.of();
    }
}

