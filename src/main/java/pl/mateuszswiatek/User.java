package pl.mateuszswiatek;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity //encja
@Table(name="users")//tabela users
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //strategia tworzenia ID
    private Long id;
    private String username;
    private String password;
    private String email;
}
