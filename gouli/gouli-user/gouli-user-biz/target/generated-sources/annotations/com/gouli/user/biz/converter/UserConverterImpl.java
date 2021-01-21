package com.gouli.user.biz.converter;

import com.gouli.user.biz.beans.Users;
import com.gouli.user.biz.dtos.UsersDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-20T14:52:45+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_60 (Oracle Corporation)"
)
@Component
public class UserConverterImpl implements UserConverter {

    @Override
    public UsersDTO usersToUsersDTO(Users users) {
        if ( users == null ) {
            return null;
        }

        UsersDTO usersDTO = new UsersDTO();

        usersDTO.setId( users.getId() );
        usersDTO.setUsername( users.getUsername() );
        usersDTO.setPassword( users.getPassword() );
        usersDTO.setEnabled( users.getEnabled() );

        return usersDTO;
    }

    @Override
    public Users UsersDTOToUsers(UsersDTO usersDTO) {
        if ( usersDTO == null ) {
            return null;
        }

        Users users = new Users();

        users.setId( usersDTO.getId() );
        users.setUsername( usersDTO.getUsername() );
        users.setPassword( usersDTO.getPassword() );
        users.setEnabled( usersDTO.getEnabled() );

        return users;
    }

    @Override
    public List<Users> UsersDTOToUsersList(List<UsersDTO> usersDTOList) {
        if ( usersDTOList == null ) {
            return null;
        }

        List<Users> list = new ArrayList<Users>( usersDTOList.size() );
        for ( UsersDTO usersDTO : usersDTOList ) {
            list.add( UsersDTOToUsers( usersDTO ) );
        }

        return list;
    }

    @Override
    public List<UsersDTO> usersToUsersDTOList(List<Users> usersList) {
        if ( usersList == null ) {
            return null;
        }

        List<UsersDTO> list = new ArrayList<UsersDTO>( usersList.size() );
        for ( Users users : usersList ) {
            list.add( usersToUsersDTO( users ) );
        }

        return list;
    }
}
