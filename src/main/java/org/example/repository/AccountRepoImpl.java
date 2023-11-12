package org.example.repository;

import org.example.model.AccountStatus;
import org.example.model.AccoutType;
import org.example.model.BankAccount;
import org.example.model.BankDirector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AccountRepoImpl implements AccountRepository{

    private Map<Long,BankAccount> bankAccountMap=new HashMap<>();
    private long accountsCount=0;

    //Pattern Singleton
    private final static  AccountRepoImpl accountRepo;
    static {
        System.out.println("Instantiation de singleton");
        accountRepo=new AccountRepoImpl();
    }
   //le fait de declarer un Constructeur prive cad je ne peux pas instancier cette classe au dehors de notre class interdiction de new
    private AccountRepoImpl(){}



    @Override
    public synchronized BankAccount save(BankAccount bankAccount) {
 //verouiller l'objet dans une structure multithread
            Long accountId=++accountsCount;
            bankAccount.setAccountId(accountId);
            bankAccountMap.put(accountId,bankAccount);
            return bankAccount;

    }

    @Override
    public List<BankAccount> findAll() {
        return bankAccountMap.values().stream().toList();
    }

    @Override
    public Optional<BankAccount> findById(Long id) {
       BankAccount account=bankAccountMap.get(id);
       if(account==null)
           return Optional.empty();
       else
           return Optional.of(account);
    }

    @Override
    public List<BankAccount> searchAccounts(Predicate<BankAccount> predicate) {
        return bankAccountMap.values().stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public BankAccount update(BankAccount account) {
        bankAccountMap.put(account.getAccountId(),account);
        return account;
    }

    @Override
    public void deleteById(Long id) {
         bankAccountMap.remove(id);
    }

    public void populateData(){
        for(int i=0 ; i<10;i++){
            BankAccount bankAccount= BankDirector.accountBuilder()
                    .currency(Math.random()>0.5?"MAD":"USD")
                    .status(Math.random()>0.5?AccountStatus.CREATED:AccountStatus.ACTIVATED)
                    .type(Math.random()>0.5?AccoutType.SAVING_ACCOUNT:AccoutType.CURRENT_ACCOUNT)
                    .balance(90000+Math.random()*50000)
                    .build();
            save(bankAccount);

        }
    }
// ca nous garentie la creation d'une suel instance de classe car on charge une seul adresse de memoire pour un seul onjet meme si on fait appel eu getInstance pas mal de fois ca est utiliser pour singleton Connection

    public synchronized static AccountRepoImpl getInstance(){
        //les methodes getInstance son generallement des methodes synchronised
         /* if(accountRepo==null){
              accountRepo=new AccountRepoImpl();
              accountRepo.populateData();
          }*/
          return accountRepo;

    }
}
