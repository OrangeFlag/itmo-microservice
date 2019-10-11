package org.dei.storehouse.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


public class StoreHouse {
    @Id
    Long id;
    String name;
}
