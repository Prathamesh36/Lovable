package com.portfolio.projects.dto.subscription;

public record PlanLimitsResponse(
        String planName,
        int meaTokensPerDay,
        int maxProjects,
        boolean unlimitedAi
) {
}
