package ru.popov.accounting.users.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ru.popov.accounting.users.service.AccountService;
import ru.popov.accounting.users.service.UserService;

@RestController
public class AccountController {

    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;



}
