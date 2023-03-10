package pl.mateuszswiatek.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserResponse {
    private Long id;
    private String username;
    private String password;
    private String email;
}
