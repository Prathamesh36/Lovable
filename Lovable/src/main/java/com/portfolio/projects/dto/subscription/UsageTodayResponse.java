package com.portfolio.projects.dto.subscription;

public record UsageTodayResponse(
        int tokensUsed,
        int tokenLimit,
        int previewRunning,
        int previewLimit
) {
}
