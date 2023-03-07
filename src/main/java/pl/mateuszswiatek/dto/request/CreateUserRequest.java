package pl.mateuszswiatek.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class CreateUserRequest {
    private String username;
    private String password;
    private String email;
}
