package org.dei.payment.converter;

import org.dei.payment.api.dto.UserDetailsDTO;
import org.dei.payment.model.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsConvert {
    public UserDetails DTOtoUserDetails(UserDetailsDTO userDetailsDTO) {
        UserDetails userDetails = new UserDetails();
        userDetails.setUsername(userDetailsDTO.getUsername());
        userDetails.setCardAuthorizationInfo(userDetailsDTO.getCardAuthorizationInfo());
        return userDetails;
    }

    public UserDetailsDTO UserDetailsToDTO(UserDetails userDetails) {
        UserDetailsDTO userDetailsDTO = new UserDetailsDTO();
        userDetails.setUsername(userDetails.getUsername());
        userDetails.setCardAuthorizationInfo(userDetails.getCardAuthorizationInfo());
        return userDetailsDTO;
    }
}
