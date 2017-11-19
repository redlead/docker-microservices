package org.redlead.demo.service.client;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ClientFullDTO {

    private Long id;
    private String Name;
    private String Description;
    private List<ProductDTO> products;

}
