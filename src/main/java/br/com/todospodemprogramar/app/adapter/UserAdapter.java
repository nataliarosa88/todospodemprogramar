package br.com.todospodemprogramar.app.adapter;

import br.com.todospodemprogramar.app.dto.UserDTO;
import br.com.todospodemprogramar.app.model.User;

public class UserAdapter {

    public static User toUser(UserDTO userDTO){

        User user = new User();

        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setContact(userDTO.getContact());
        user.setExperience(userDTO.getExperience());
        user.setHobby(userDTO.getHobby());
        user.setName(userDTO.getName());

        return user;

    }

    public static UserDTO toUserDTO(User user){

        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(null);
        userDTO.setContact(user.getContact());
        userDTO.setExperience(user.getExperience());
        userDTO.setHobby(user.getHobby());
        userDTO.setName(user.getName());

        return userDTO;

    }

    public static UserDTO toUserDTOResponse(User user){

        UserDTO userDTO = new UserDTO();

        userDTO.setUsername(user.getUsername());
        userDTO.setContact(user.getContact());
        userDTO.setExperience(user.getExperience());
        userDTO.setHobby(user.getHobby());
        userDTO.setName(user.getName());

        return userDTO;

    }
}
