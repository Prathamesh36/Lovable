package com.portfolio.project.account_service.mapper;


import com.portfolio.project.account_service.dto.auth.SignupRequest;
import com.portfolio.project.account_service.dto.auth.UserProfileResponse;
import com.portfolio.project.account_service.entity.User;
import com.portfolio.project.common_lib.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(SignupRequest signupRequest);

    UserProfileResponse toUserProfileResponse(User user);

    UserDto toUserDto(User user);

}
