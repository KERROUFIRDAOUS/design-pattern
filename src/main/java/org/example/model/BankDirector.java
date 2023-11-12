package org.example.model;

public class BankDirector {
    //Dans cette classe ou on va construire les builder de notre application
    public static BankAccount.AccountBuilder accountBuilder(){
        return new BankAccount.AccountBuilder();

    }
}
