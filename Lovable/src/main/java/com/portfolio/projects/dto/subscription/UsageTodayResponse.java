package com.portfolio.projects.dto.subscription;

public record UsageTodayResponse(
        Integer tokensUsed,
        Integer tokenLimit,
        Integer previewRunning,
        Integer previewLimit
) {
}
