package org.dei.payment.api.dto;

import lombok.Data;
import org.dei.payment.api.model.CardAuthorizationInfo;

@Data
public class UserDetailsDTO {
    String username;

    CardAuthorizationInfo cardAuthorizationInfo;
}