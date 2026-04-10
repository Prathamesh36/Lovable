package com.portfolio.projects.mapper;

import com.portfolio.projects.dto.subscription.PlanResponse;
import com.portfolio.projects.dto.subscription.SubscriptionResponse;
import com.portfolio.projects.entity.Plan;
import com.portfolio.projects.entity.Subscription;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubscriptionMapper {

    SubscriptionResponse toSubscriptionResponse(Subscription subscription);

    PlanResponse toPlanResponse(Plan plan);
}
