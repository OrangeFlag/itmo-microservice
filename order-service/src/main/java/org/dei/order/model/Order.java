package org.dei.order.model;

import lombok.Data;
import org.dei.order.api.model.Status;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;

    @NotNull
    private Long totalCost;

    @NotNull
    private Long totalAmount;

    @NotNull
    private String username;

    @OneToMany
    private List<Product> products;

}
