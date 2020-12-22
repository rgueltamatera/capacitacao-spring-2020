package com.example.capacitacaospring.entities;

public class ClientDto {
    private Integer clientId;
    private String firstName;

    public ClientDto(Integer clientId, String firstName) {
        this.clientId = clientId;
        this.firstName = firstName;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
