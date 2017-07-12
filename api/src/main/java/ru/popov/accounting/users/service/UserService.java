package ru.popov.accounting.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.popov.accounting.users.model.Account;
import ru.popov.accounting.users.model.User;
import ru.popov.accounting.users.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> loadAll() {
        return userRepository.findAll();
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public User findUserByEmailOrPhone(String email, String phone) {
        return userRepository.findUserByEmailOrPhone(email, phone);
    }

    public User findUserById(Long id) {
        return userRepository.findUserById(id);
    }

    public List<Account> getAccountsByUser(User user) {
        return userRepository.findAccounts(user);
    }


}
