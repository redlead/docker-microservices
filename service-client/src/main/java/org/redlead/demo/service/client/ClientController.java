package org.redlead.demo.service.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/client/{id}")
    public ClientDTO getClient(@PathVariable Long id){
        return new ClientDTO(id, "Zaphod", "Zaphod Biblebrox");
    }

    @RequestMapping("/client/{id}/full")
    public ClientFullDTO getClientFull(@PathVariable Long id) {
        List<ProductDTO> products = new ArrayList<>();
        products.add(restTemplate.getForObject("http://SERVICE-PRODUCT/product/1", ProductDTO.class));
        products.add(restTemplate.getForObject("http://SERVICE-PRODUCT/product/2", ProductDTO.class));
        return new ClientFullDTO(id, "Zaphod", "Zaphod Biblebrox", products);
    }
}
