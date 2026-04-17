package com.portfolio.projects.mapper;

import com.portfolio.projects.dto.auth.SignupRequest;
import com.portfolio.projects.dto.auth.UserProfileResponse;
import com.portfolio.projects.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(SignupRequest signupRequest);

    UserProfileResponse toUserProfileResponse(User user);

}
