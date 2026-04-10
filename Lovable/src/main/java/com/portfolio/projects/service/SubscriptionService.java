package com.portfolio.projects.service;

import com.portfolio.projects.dto.subscription.CheckoutRequest;
import com.portfolio.projects.dto.subscription.CheckoutResponse;
import com.portfolio.projects.dto.subscription.PortalResponse;
import com.portfolio.projects.dto.subscription.SubscriptionResponse;
import com.portfolio.projects.enums.SubscriptionStatus;

import java.time.Instant;

public interface SubscriptionService {
    SubscriptionResponse getCurrentSubscription();

    void activateSubscription(Long userId, Long planId, String subscriptionId, String customerId);

    void updateSubscription(String subscriptionId, SubscriptionStatus status, Instant periodStart, Instant periodEnd, Boolean cancelAtPeriodEnd, Long planId);

    void cancelSubscription(String subscriptionId);

    void renewSubscriptionPeriod(String subId, Instant periodStart, Instant periodEnd);

    void markSubscriptionPastDue(String subId);

    boolean canCreateNewProject();

}
