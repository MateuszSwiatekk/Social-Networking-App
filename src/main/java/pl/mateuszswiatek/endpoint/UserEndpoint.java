package pl.mateuszswiatek.endpoint;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mateuszswiatek.dto.request.CreateUserRequest;
import pl.mateuszswiatek.dto.response.UserResponse;
import pl.mateuszswiatek.service.UserService;
import pl.mateuszswiatek.entity.User;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserEndpoint {
    private UserService userService;

    @GetMapping
    public List<UserResponse> getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public UserResponse createUser(CreateUserRequest request) {
        return userService.createUser(request);
    }
}
