package com.portfolio.projects.service;

import com.portfolio.projects.dto.subscription.CheckoutRequest;
import com.portfolio.projects.dto.subscription.CheckoutResponse;
import com.portfolio.projects.dto.subscription.PortalResponse;
import com.portfolio.projects.dto.subscription.SubscriptionResponse;

public interface SubscriptionService {
    SubscriptionResponse getCurrentSubscription(Long userId);

}
