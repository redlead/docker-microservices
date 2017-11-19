package org.redlead.demo.service.product;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @RequestMapping("/product/{id}")
    public ProductDTO getProduct(@PathVariable Long id) {
        return new ProductDTO(id, "product name", "product description");
    }
}
