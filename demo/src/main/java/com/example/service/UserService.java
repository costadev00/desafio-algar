package com.example.service;
import com.example.model.User;
import java.util.*;

import org.springframework.stereotype.Service;

@Service // Garante que UserService seja reconhecido como um bean pelo Spring


public class UserService {
    private List<User> users = new ArrayList<>();

    public UserService(){
        this.users = new ArrayList<>(); 
    }

    public User createUser(String name, String cpf, String email, double balance){
        User user = new User(name, cpf, email, balance);
        users.add(user);
        return user;
    }

    public User getUserByCPF(String cpf){
        for(User user : users){
            if(user.getCpf().equals(cpf)){
                return user;
            }
        }
        return null;
    }

    public User IncrementUserBalance(String cpf, double amount){
        User user = getUserByCPF(cpf);
        if(user != null){
            user.setBalance(user.getBalance() + amount);
            return user;
        }
        return null;
    }

}
