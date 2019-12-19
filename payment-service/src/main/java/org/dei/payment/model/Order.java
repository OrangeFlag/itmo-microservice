package org.dei.payment.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "orders")
@AllArgsConstructor
public class Order {
    @Id
    private Long id;
}