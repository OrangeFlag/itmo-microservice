package org.dei.order.model;

import lombok.Data;
import org.dei.order.api.model.Status;
import org.javamoney.moneta.Money;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;

    @NotNull
    private Money totalCost;

    @NotNull
    private Long totalAmount;

    @NotNull
    private String username;

    @OneToMany
    private List<Product> products;
}
