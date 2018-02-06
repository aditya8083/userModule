package com.coviam.ticket.user_microservice.services;

import com.coviam.ticket.user_microservice.dto.CardDTO;
import com.coviam.ticket.user_microservice.dto.UserDTO;
import com.coviam.ticket.user_microservice.entities.User;

import java.util.List;

public interface UserService {

    User add(UserDTO userDTO);

    UserDTO get(String userId);

    User update(String userId, UserDTO updatedInformation);

    List<User> getAll();

    Integer deleteAll();

    void delete(String userId);

    void addCardInfo(String userId, CardDTO cardInfo);
}
