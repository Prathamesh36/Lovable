package com.portfolio.projects.service.impl;

import com.portfolio.projects.dto.subscription.CheckoutRequest;
import com.portfolio.projects.dto.subscription.CheckoutResponse;
import com.portfolio.projects.dto.subscription.PortalResponse;
import com.portfolio.projects.dto.subscription.SubscriptionResponse;
import com.portfolio.projects.service.SubscriptionService;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Override
    public SubscriptionResponse getCurrentSubscription(Long userId) {
        return null;
    }

    @Override
    public CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request, Long userId) {
        return null;
    }

    @Override
    public PortalResponse openCustomerPortal(Long userId) {
        return null;
    }
}
