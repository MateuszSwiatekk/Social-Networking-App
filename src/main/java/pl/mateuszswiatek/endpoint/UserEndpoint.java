package pl.mateuszswiatek.endpoint;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.mateuszswiatek.dto.request.CreateUserRequest;
import pl.mateuszswiatek.dto.response.UserResponse;
import pl.mateuszswiatek.service.UserService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserEndpoint {
    private UserService userService;

    @GetMapping
    public Page<UserResponse> getUsers(
            @PageableDefault(size = 3, sort = "username", direction = Sort.Direction.ASC) Pageable pageable) {
        return userService.getUsers(pageable);
    }
    @GetMapping("/{userID}")
    public UserResponse getUserByID(@PathVariable Long userID){
        return userService.getUserById(userID);
    }
    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody CreateUserRequest request) {
        return new ResponseEntity<>(userService.createUser(request), HttpStatus.CREATED); //set status manually
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }
}
