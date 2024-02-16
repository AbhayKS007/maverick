package com.maveric.bank.controller;

import com.maveric.bank.exception.ResourceNotFoundException;
import com.maveric.bank.model.Account;
import com.maveric.bank.model.Balance;
import com.maveric.bank.model.Transaction;
import com.maveric.bank.model.User;
import com.maveric.bank.repository.UserRepository;
import com.maveric.bank.security.CurrentUser;
import com.maveric.bank.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.logging.Logger;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;
    private Account account =new Account();
    private Transaction transaction = new Transaction();
    private Balance balance = new Balance();
    private User user = new User();

    Logger logger =  Logger.getLogger(UserController.class.getName());
    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        user=userRepository.findById(userPrincipal.getId()).get();
        Optional<User> user1 = Optional.ofNullable(createDummyTransaction(user));
        logger.info("User added successfully: "+user.getFirstName());
        return user1
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }

    private User createDummyTransaction(User user) {
        account.setAccountId(98766);
        account.setAccountType("Savings");
        balance.setId(12345);
        balance.setAmount(1000000L);
        balance.setCurrency(1);
        balance.setCreatedAt();
        balance.setUpdatedAt("2020-01-01");
        account.setBalance(balance);
        transaction.setTransactionId(12345);
        transaction.setAmount(1000);
        transaction.setCreatedAt();
        transaction.setType("Credit");
        account.setTransaction(transaction);
        user.setAccount(account);
        return user;
    }
}
