package org.dei.payment.model;

import lombok.Data;
import org.dei.payment.api.model.CardAuthorizationInfo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class UserDetails {
    @Id
    @NotNull
    String username; // Is it id?

    @NotNull
    CardAuthorizationInfo cardAuthorizationInfo;
}