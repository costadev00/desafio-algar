package com.example.service;

import com.example.model.Purchase;
import com.example.model.User;
import org.springframework.stereotype.Service;


@Service // Garante que PurchaseService seja reconhecido como um bean pelo Spring
public class PurchaseService {
    public boolean makePurchase(User user, Purchase purchase) {
        if (user.getBalance() >= purchase.getAmount()) {
            user.setBalance(user.getBalance() - purchase.getAmount());
            return true;
        }
        return false;
    }
}
