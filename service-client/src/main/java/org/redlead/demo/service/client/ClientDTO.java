package org.redlead.demo.service.client;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientDTO {

    private Long id;
    private String Name;
    private String Description;

}
