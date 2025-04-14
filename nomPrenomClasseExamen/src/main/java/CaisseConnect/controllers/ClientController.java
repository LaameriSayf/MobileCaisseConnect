    package CaisseConnect.controllers;

    import CaisseConnect.entities.Client;
    import CaisseConnect.entities.dto.ClientDto;
    import CaisseConnect.services.ClientService;
    import lombok.NonNull;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;
    import java.util.concurrent.ExecutionException;

    @RestController
    @RequestMapping("Client")
    @CrossOrigin(origins = "http://192.168.1.102:8089")

    public class ClientController {

        @Autowired
        ClientService cs;
        @CrossOrigin(origins = "http://192.168.1.102:8080")

        @GetMapping("getAll")

        public ResponseEntity<?>getAllClient(){

            try{
             List<Client> l= cs.getAll();
              return  ResponseEntity.status(200).body(l);
            }catch (Exception e){
                e.getCause().getMessage();
                return ResponseEntity.status(500).body("Ereure dans fonction affichage de Client");

            }
        }
        @PostMapping("add")
        @CrossOrigin(origins = "http://192.168.1.102:8080")

        public ResponseEntity<?>addClient(@RequestBody Client c){

            try{
                cs.add(c);
                return ResponseEntity.status(200).body("Ajout effectuer avec succes"+c);
            }catch (Exception e){
                e.getCause().getMessage();
                return ResponseEntity.status(500).body("Ereure dans Ajout de Client");
            }
        }

        @PutMapping("/update/{id}")
        @CrossOrigin(origins = "http://192.168.1.102:8080")

        public ResponseEntity<?> updateClient(@RequestBody Client c,@PathVariable Long id ){
            try{
            c.setIdClient(id);
            cs.updateClient(c);
            return ResponseEntity.status(200).body("Update succesfuly"+c);
            } catch (Exception e){
                e.getCause().getMessage();
                return ResponseEntity.status(500).body("Ereure dans update de Client");
            }
        }


        @DeleteMapping("/delete/{id}")
        public ResponseEntity<?> deleteClient(@PathVariable @NonNull Long id){
            try{
                cs.deleteClient(id);
                return ResponseEntity.status(200).body("Supprsion de client est effectuer avec sucess");
            }catch (Exception e){
                e.getCause().getMessage();
                return ResponseEntity.status(500).body("Ereure dans supprsion de client");
            }
        }

        @GetMapping("/getClientByRib/{rib}")
        public ClientDto getClientByRib(@PathVariable String rib){
            return cs.getClientByRib(rib);
        }


    }
