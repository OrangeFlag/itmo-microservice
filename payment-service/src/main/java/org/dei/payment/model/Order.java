package org.dei.payment.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "orders")
class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
