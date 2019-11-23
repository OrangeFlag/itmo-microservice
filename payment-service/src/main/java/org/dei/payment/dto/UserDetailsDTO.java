package org.dei.payment.dto;

import lombok.Data;
import org.dei.payment.model.CardAuthorizationInfo;

@Data
public class UserDetailsDTO {
    String username; // Is it id?

    CardAuthorizationInfo cardAuthorizationInfo;
}