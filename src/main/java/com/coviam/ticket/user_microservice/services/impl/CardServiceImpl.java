package com.coviam.ticket.user_microservice.services.impl;

import com.coviam.ticket.user_microservice.entities.Card;
import com.coviam.ticket.user_microservice.repositories.CardRepository;
import com.coviam.ticket.user_microservice.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    CardRepository cardRepository;

    @Override
    public List<Card> getAll() {
        return cardRepository.findAll();
    }
}
