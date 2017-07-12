package ru.popov.accounting.users.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.popov.accounting.users.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{



}
