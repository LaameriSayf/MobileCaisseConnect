package CaisseConnect.entities.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClientDto {

    private Long idClient;
    private String nom;
    private String prenom;
    private String tel;
    private String rib;

    public ClientDto(Long idClient,String nom, String prenom, String rib,String tel ) {
        this.idClient=idClient;
        this.nom = nom;
        this.prenom = prenom;
        this.rib = rib;
        this.tel = tel;
    }
}
