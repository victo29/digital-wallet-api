package com.victortavares.infrastructure.mapper;

import com.victortavares.core.domain.TaxNumber;
import com.victortavares.core.domain.User;
import com.victortavares.infrastructure.dto.request.CreateUserRequest;
import com.victortavares.infrastructure.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserEntity toUserEntity(User user){
        return new UserEntity(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                user.getTaxNumber().getValue(),
                user.getFullname(),
                user.getType(),
                user.getCreatedAt(),
                user.getUpdateAt()
        );
    }

    public User toUser(CreateUserRequest request) throws Exception {
        return new User(
            request.email(),
            request.password(),
            new TaxNumber(request.taxNumber()),
            request.fullName(),
            request.type()
        );
    }

    public User toUser(UserEntity userEntity) throws Exception {
        return new User(
                userEntity.getId(),
                userEntity.getEmail(),
                userEntity.getPassword(),
                new TaxNumber(userEntity.getTaxNumber()),
                userEntity.getFullName(),
                userEntity.getType(),
                userEntity.getCreatedAt(),
                userEntity.getUpdateAt()
        );
    }
}
