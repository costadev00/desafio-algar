package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import com.example.service.UserService;
import com.example.service.PurchaseService;
import com.example.model.User;
import com.example.model.Purchase;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);

        // Obtendo os serviços do contexto do Spring
        UserService userService = context.getBean(UserService.class);
        PurchaseService purchaseService = context.getBean(PurchaseService.class);

        // Criando um usuário
        User newUser = userService.createUser("João", "12345678900", "joao@example.com", 0.0);
        System.out.println("Novo usuário criado: " + newUser.getName());

        // Incrementando o saldo do usuário
        userService.IncrementUserBalance("12345678900", 100.0);

        // Realizando uma compra para o usuário
        Purchase newPurchase = new Purchase("Compra de exemplo", 50.0);
        boolean isPurchaseSuccessful = purchaseService.makePurchase(newUser, newPurchase);
        if (isPurchaseSuccessful) {
            System.out.println("Compra realizada com sucesso para o usuário: " + newUser.getName());
        } else {
            System.out.println("Saldo insuficiente para realizar a compra.");
        }

        // Fechando o contexto do Spring ao finalizar
        context.close();
    }
}
