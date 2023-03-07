package pl.mateuszswiatek.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class UserResponse {
    private Long id;
    private String username;
    private String password;
    private String email;
}
