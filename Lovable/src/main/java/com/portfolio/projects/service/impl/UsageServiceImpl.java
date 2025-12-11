package com.portfolio.projects.service.impl;

import com.portfolio.projects.dto.subscription.PlanLimitsResponse;
import com.portfolio.projects.dto.subscription.UsageTodayResponse;
import com.portfolio.projects.service.UsageService;
import org.springframework.stereotype.Service;

@Service
public class UsageServiceImpl implements UsageService {
    @Override
    public UsageTodayResponse getTodayUsageOfUser(Long userId) {
        return null;
    }

    @Override
    public PlanLimitsResponse getCurrentSubscriptionLimitsOfUser(Long userId) {
        return null;
    }
}
