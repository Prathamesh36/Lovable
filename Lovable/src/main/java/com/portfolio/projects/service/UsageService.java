package com.portfolio.projects.service;

import com.portfolio.projects.dto.subscription.PlanLimitsResponse;
import com.portfolio.projects.dto.subscription.UsageTodayResponse;

public interface UsageService {
    public UsageTodayResponse getTodayUsageOfUser(Long userId);

    PlanLimitsResponse getCurrentSubscriptionLimitsOfUser(Long userId);
}
