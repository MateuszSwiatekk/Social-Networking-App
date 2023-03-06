package pl.mateuszswiatek;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserEndpoint {
    private UserService userService;
    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }
}
