package ru.popov.accounting.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.popov.accounting.users.model.Account;
import ru.popov.accounting.users.model.User;
import ru.popov.accounting.users.requests.AccountRequest;
import ru.popov.accounting.users.service.AccountService;
import ru.popov.accounting.users.service.UserService;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public HttpEntity<List<User>> loadAll() {
        return new ResponseEntity<>(userService.loadAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST, consumes = "application/json")
    public HttpEntity<User> create(@RequestBody @Validated User userRequest) {

        User userExistEmail = userService.findUserByEmailOrPhone(userRequest.getEmail(), userRequest.getPhone());

        if (userExistEmail != null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(userService.create(userRequest), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public HttpEntity<User> getUserById(@PathVariable Long id) {

        User user = userService.findUserById(id);

        if (user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @RequestMapping(value = "/users/{id}/accounts", method = RequestMethod.POST)
    public HttpEntity<Account> createAccount(@PathVariable Long id,
                                             @RequestBody AccountRequest accountRequest) {

        User user = userService.findUserById(id);

        if (user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Account account = accountService.createAccount(new Account(accountRequest.getName(), user));
        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/users/{id}/accounts", method = RequestMethod.GET)
    public HttpEntity<List<Account>> getAccountsOfUser(@PathVariable Long id) {

        User user = userService.findUserById(id);

        if (user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<Account> accounts= userService.getAccountsByUser(user);
        return new ResponseEntity<>(accounts, HttpStatus.CREATED);
    }



}
