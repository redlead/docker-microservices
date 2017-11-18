package org.redlead.demo.service.product;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDTO {

    private Long id;
    private String key;
    private String name;
    private String description;
}
