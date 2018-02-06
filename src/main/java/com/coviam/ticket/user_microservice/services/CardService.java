package com.coviam.ticket.user_microservice.services;

import com.coviam.ticket.user_microservice.entities.Card;

import java.util.List;

public interface CardService {

    List<Card> getAll();
}
