package com.coviam.ticket.user_microservice.dto;

import java.util.Date;
import java.util.StringJoiner;

public class CardDTO {

    private String id;
    private String number;
    private Date expiryDate;

    private UserDTO owner;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public UserDTO getOwner() {
        return owner;
    }

    public void setOwner(UserDTO owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", this.getClass().getSimpleName() + "[", "]")
                .add("expiryDate = " + expiryDate)
                .add("id = " + id)
                .add("number = " + number)
                .add("owner = " + owner)
                .toString();
    }
}
