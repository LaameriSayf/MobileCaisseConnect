package CaisseConnect.repositories;

import CaisseConnect.entities.Client;
import CaisseConnect.entities.dto.ClientDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
    Client findByRIB(String rib);
}
