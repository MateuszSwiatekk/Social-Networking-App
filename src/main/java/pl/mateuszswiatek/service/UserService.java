package pl.mateuszswiatek.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.mateuszswiatek.converter.UserConverter;
import pl.mateuszswiatek.dto.request.CreateUserRequest;
import pl.mateuszswiatek.dto.response.UserResponse;
import pl.mateuszswiatek.entity.User;
import pl.mateuszswiatek.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public List<UserResponse> getUsers() {
        return userRepository
                .findAll()
                .stream()
                .map(user -> UserConverter.toResponse(user))
                .collect(Collectors.toList());
    }

    public UserResponse createUser(CreateUserRequest request) {
        var user = UserConverter.toEntity(request); //convert user request without ID to User entity
        var savedUser = userRepository.save(user);

        return UserConverter.toResponse(savedUser);
    }
}
