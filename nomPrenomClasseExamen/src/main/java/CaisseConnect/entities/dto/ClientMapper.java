package CaisseConnect.entities.dto;

import CaisseConnect.entities.Client;

public class ClientMapper {

    public static ClientDto toDto(Client client) {
        return new ClientDto(
                client.getIdClient(),
                client.getNom(),
                client.getPrenom(),
                client.getTel(),
                client.getRIB()
        );
    }

    public static Client toEntity(ClientDto clientDto) {
        Client client = new Client();
        client.setIdClient(clientDto.getIdClient());
        client.setNom(clientDto.getNom());
        client.setPrenom(clientDto.getPrenom());
        client.setTel(clientDto.getTel());
        client.setRIB(clientDto.getRib());
        return client;
    }
}
