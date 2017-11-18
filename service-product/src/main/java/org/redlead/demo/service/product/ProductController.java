package org.redlead.demo.service.product;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @RequestMapping("/product/{key}")
    public ProductDTO getProduct(@PathVariable String key) {
        return new ProductDTO(0L, key, "product name", "product description");
    }
}
