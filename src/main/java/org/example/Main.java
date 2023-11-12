package org.example;

import org.example.model.AccountStatus;
import org.example.model.AccoutType;
import org.example.model.BankAccount;
import org.example.model.BankDirector;
import org.example.repository.AccountRepoImpl;
import org.example.repository.AccountRepository;
import org.example.util.JsonSerializer;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        JsonSerializer<BankAccount> bankAccountJsonSerializer=new JsonSerializer<>();

        AccountRepoImpl accountRepo=AccountRepoImpl.getInstance();

        for (int i=0;i<10;i++){
            new Thread(()->{
                accountRepo.populateData();
            }).start();
        }


        List<BankAccount> bankAccounts= accountRepo.findAll();
        bankAccounts.stream()
                .map(bankAccountJsonSerializer::toJson)
                .forEach(System.out::println);
        bankAccounts.stream()
                .map(bankAccountJsonSerializer::toJson)
                .forEach(System.out::println);





















        /*findAll
        List<BankAccount> bankAccounts= accountRepo.findAll();
        bankAccounts.stream()
                .map(bankAccountJsonSerializer::toJson)
                .forEach(System.out::println);
        */
        //search selon critere donne ou predicat
       /* List<BankAccount> bankAccounts= accountRepo.searchAccounts(bankAccount -> {
            // On cherche en fct de ce qu'on veut clqssifier par exemple  avec le type de compte dans cet cas
            return bankAccount.getType().equals(AccoutType.SAVING_ACCOUNT);
        });
        //to Json
        bankAccounts.stream()
                .map(bankAccountJsonSerializer::toJson)
                .forEach(System.out::println);
        System.out.println("=============");
        BankAccount account= accountRepo.findById(1L).orElse(null);
        if (account!=null){
            System.out.println(bankAccountJsonSerializer.toJson(account));
        }*/


       BankAccount account=new BankAccount();
       account.setAccountId(3L);
       account.setCurrency("Euro");
       account.setBalance(8797);
       account.setType(AccoutType.SAVING_ACCOUNT);
       account.setStatus(AccountStatus.CREATED);


//Pattern Builder est une solution pour construire un objet au lieu de la methode classique setter et getters

        BankAccount bankAccount = BankDirector.accountBuilder().accountId(1L)
                .currency("MAD")
                .status(AccountStatus.CREATED)
                .type(AccoutType.SAVING_ACCOUNT)
                .balance(70000).build();


        //Methode classique
        /*BankAccount bankAccount=BankAccount.builder()
                .accountId(1L)
                .currency("MAD")
                .status(AccountStatus.CREATED)
                .type(AccoutType.SAVING_ACCOUNT)
                .balance(70000)
                .build();
        System.out.println(bankAccount.toString());

*/

    }
}