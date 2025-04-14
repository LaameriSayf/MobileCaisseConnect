package CaisseConnect.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString


public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    private String login;
    private  String password;

    @OneToOne
    private Client client;
}
