package ru.popov.accounting.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.popov.accounting.users.model.Account;
import ru.popov.accounting.users.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByEmailOrPhone(String email, String phone);

    User findUserById(Long id);

    @Query("SELECT account FROM Account account WHERE account.user = :user")
    List<Account> findAccounts(@Param("user") User user);

}
