package com.esiea.fr.arch.mapper;

import java.util.Date;

//import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import com.esiea.fr.arch.dto.UserDTO;
import com.esiea.fr.arch.entity.User;


@Component
public class MapperUser {

    public User userDTOToUser(UserDTO userDTO1) {
        if ( userDTO1 == null ) {
            return null;
        }

        User user = new User();

        user.setFirstname( userDTO1.getFirstname() );
        user.setLastname( userDTO1.getLastname() );
        user.setMobile(userDTO1.getMobile());
        user.setBirthday( userDTO1.getBirthday() );

        return user;
    }
}
