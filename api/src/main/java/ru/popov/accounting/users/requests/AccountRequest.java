package ru.popov.accounting.users.requests;


public class AccountRequest {

    private String name;

    public AccountRequest() {
    }

    public AccountRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
