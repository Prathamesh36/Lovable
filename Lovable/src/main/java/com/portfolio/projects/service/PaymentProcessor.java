package com.portfolio.projects.service;

import com.portfolio.projects.dto.subscription.CheckoutRequest;
import com.portfolio.projects.dto.subscription.CheckoutResponse;
import com.portfolio.projects.dto.subscription.PortalResponse;
import com.stripe.model.StripeObject;
import org.springframework.stereotype.Service;

import java.util.Map;


public interface PaymentProcessor {
    CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request);

    PortalResponse openCustomerPortal();

    void handleWebhookEvent(String type, StripeObject stripeObject, Map<String, String> metadata);
}
