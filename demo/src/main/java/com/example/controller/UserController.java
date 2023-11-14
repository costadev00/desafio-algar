package com.example.controller;

import com.example.model.Purchase;
import com.example.model.User;
import com.example.service.UserService;
import com.example.service.PurchaseService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;
    private PurchaseService purchaseService;

    public UserController(UserService userService, PurchaseService purchaseService) {
        this.userService = userService;
        this.purchaseService = purchaseService;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user.getName(), user.getCpf(), user.getEmail(), user.getBalance());
    }
    @GetMapping("/{cpf}")
    public User getUserByCPF(@PathVariable String cpf) {
        return userService.getUserByCPF(cpf);
    }
    @PostMapping("/{cpf}/balance")
    public User incrementUserBalance(@PathVariable String cpf, @RequestBody double amount) {
        return userService.IncrementUserBalance(cpf, amount);
    }
    @PostMapping("/{cpf}/purchase")
    public boolean makePurchase(@PathVariable String cpf, @RequestBody Purchase purchase) {
        User user = userService.getUserByCPF(cpf);
        return purchaseService.makePurchase(user, purchase);
    }
}
