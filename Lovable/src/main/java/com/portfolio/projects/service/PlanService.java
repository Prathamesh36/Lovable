package com.portfolio.projects.service;

import com.portfolio.projects.dto.subscription.PlanResponse;

import java.util.List;

public interface PlanService {
    List<PlanResponse> getAllActivePlans();
}
