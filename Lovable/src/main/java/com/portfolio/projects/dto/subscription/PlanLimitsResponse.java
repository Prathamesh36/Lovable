package com.portfolio.projects.dto.subscription;

public record PlanLimitsResponse(
        String planName,
        Integer meaTokensPerDay,
        Integer maxProjects,
        Boolean unlimitedAi
) {
}
