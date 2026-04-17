package com.portfolio.projects.service;

import com.portfolio.projects.dto.subscription.PlanLimitsResponse;
import com.portfolio.projects.dto.subscription.UsageTodayResponse;

public interface UsageService {
    void recordTokenUsage(Long userId, int actualTokens);
    void checkDailyTokensUsage();
}
