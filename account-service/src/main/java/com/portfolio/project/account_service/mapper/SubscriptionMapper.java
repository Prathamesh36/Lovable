package com.portfolio.project.account_service.mapper;

import com.portfolio.project.account_service.dto.subscription.SubscriptionResponse;
import com.portfolio.project.account_service.entity.Plan;
import com.portfolio.project.account_service.entity.Subscription;
import com.portfolio.project.common_lib.dto.PlanDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubscriptionMapper {

    SubscriptionResponse toSubscriptionResponse(Subscription subscription);

    PlanDto toPlanResponse(Plan plan);
}
