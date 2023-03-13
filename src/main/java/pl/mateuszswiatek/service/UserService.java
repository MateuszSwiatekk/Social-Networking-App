package pl.mateuszswiatek.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Page<UserResponse> getUsers(Pageable pageable) {
        return userRepository
                .findAll(pageable)
                .map(user -> UserConverter.toResponse(user));
    }

    public UserResponse getUserById(Long userID) {
        return userRepository
                .findById(userID)
                .map(user -> UserConverter.toResponse(user))
                .orElseThrow(() -> new NullPointerException("User does not exist"));

    }

    public UserResponse createUser(CreateUserRequest request) {
        var user = UserConverter.toEntity(request); //convert user request without ID to User entity
        var savedUser = userRepository.save(user);

        return UserConverter.toResponse(savedUser);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }


}
