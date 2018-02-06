package com.coviam.ticket.user_microservice.services.impl;

import com.coviam.ticket.user_microservice.dto.CardDTO;
import com.coviam.ticket.user_microservice.dto.UserDTO;
import com.coviam.ticket.user_microservice.entities.Card;
import com.coviam.ticket.user_microservice.entities.User;
import com.coviam.ticket.user_microservice.exceptions.RecordNotFoundException;
import com.coviam.ticket.user_microservice.repositories.CardRepository;
import com.coviam.ticket.user_microservice.repositories.UserRepository;
import com.coviam.ticket.user_microservice.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CardRepository cardRepository;

    @Override
    public User add(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        return userRepository.save(user);
    }

    @Override
    public UserDTO get(String userId) {
        User user = userRepository.findOne(userId);
        if (null == user)
            throw new RecordNotFoundException(userId);
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }

    @Override
    public User update(String userId, UserDTO updatedInformation) {
        if (!userRepository.exists(userId))
            throw new RecordNotFoundException(userId);
        updatedInformation.setId(userId);
        User user = new User();
        BeanUtils.copyProperties(updatedInformation, user);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();

    }

    @Override
    public Integer deleteAll() {
        userRepository.deleteAll();
        return (int) userRepository.count();
    }

    @Override
    public void delete(String userId) {
        userRepository.delete(userId);
    }

    /**
     * Update card list with a new card
     * @param userId : user id
     * @param cardInfo
     * @throws RecordNotFoundException
     */
    @Override
    public void addCardInfo(String userId, CardDTO cardInfo) throws RecordNotFoundException{
        User user = userRepository.findOne(userId);
        if (null == user)
            throw new RecordNotFoundException(userId);
        Card card = new Card();
        BeanUtils.copyProperties(cardInfo, card);
        card.setOwner(user);

        cardRepository.save(card);

        user.getCardList().add(card);
        userRepository.save(user);
    }
}
