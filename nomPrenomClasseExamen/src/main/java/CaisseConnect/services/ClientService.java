package CaisseConnect.services;

import CaisseConnect.entities.Client;
import CaisseConnect.entities.dto.ClientDto;
import CaisseConnect.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository cr;
@Scheduled(fixedRate = 2000)
    public List<Client> getAll(){
      return cr.findAll() ;
    }

    public List<Client> add(Client c){
        cr.save(c);
        return getAll();
    }

    public List<Client> updateClient(Client c){
        cr.save(c);
        return getAll();
    }

    public void deleteClient(Long id ){
        cr.deleteById(id);
    }

    public ClientDto getClientByRib(String rib) {
        Client client = cr.findByRIB(rib);
        if (client == null) {
            throw new RuntimeException("Client avec RIB " + rib + " introuvable");
        }
        return new ClientDto(
                client.getIdClient(),
                client.getNom(),
                client.getPrenom(),
                client.getRIB(),
                client.getTel()
        );
    }




}
