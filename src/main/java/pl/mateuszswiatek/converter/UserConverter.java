package pl.mateuszswiatek.converter;

import pl.mateuszswiatek.dto.request.CreateUserRequest;
import pl.mateuszswiatek.dto.response.UserResponse;
import pl.mateuszswiatek.entity.User;

public class UserConverter {
    public static UserResponse toResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail()
        );
    }

    public static User toEntity(CreateUserRequest request) {
        return new User(
                request.getUsername(),
                request.getPassword(),
                request.getEmail()
        );
    }
}
