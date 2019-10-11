package org.dei.payment.domain;

import javax.validation.constraints.NotNull;

public class UserDetailsDto {
    @NotNull
    String username;

    @NotNull
    CardAuthorizationInfo cardAuthorizationInfo;
}