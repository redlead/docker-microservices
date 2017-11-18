package org.redlead.demo.service.client;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @RequestMapping("/client/{id}")
    public ClientDTO getClient(@PathVariable Long id){
        return new ClientDTO(id, "Zaphod", "Zaphod Biblebrox");
    }
}
