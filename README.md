# Patterns Builder, Singleton et Prototype


## Description du Projet
Ce projet consiste en le développement d'une application orientée objet permettant la gestion de comptes bancaires. Chaque compte est défini par les attributs suivants :
- `accountId` de type String
- `balance` de type double
- `currency` : String
- `accountType` : AccountType (SAVING_ACCOUNT, CURRENT_ACCOUNT)
- `accountStatus` : AccountStatus (CREATED, ACTIVATED, BLOCKED, SUSPENDED)

## Travail Demandé
1. **Créer la classe BankAccount**
2. **Créer l'interface AccountRepository** déclarant les opérations suivantes :
    - Ajouter un compte
    - Consulter tous les comptes
    - Consulter un compte en connaissant son ID
    - Chercher un compte avec un prédicat quelconque
3. **Créer une implémentation (BankRepositoryImpl) de cette interface** en stockant les comptes dans une collection de type HashMap.
4. **Implémenter le pattern Builder pour la classe Compte**
5. **Implémenter le pattern Singleton** pour créer une instance unique de BankRepositoryImpl
6. **Implémenter le pattern Prototype pour la classe Compte**
7. **Appliquer d'autres design patterns utiles pour cette application**

## Exécution

![Capture6](https://github.com/KERROUFIRDAOUS/design-pattern/assets/52587545/f91f286a-4255-46b1-bf01-2a94612f3d2c)


## Utilisation
1. Clonez le dépôt : `git clone https://KERROUFIRDAOUS/design-pattern.git`
2. Compilez et exécutez le projet avec votre environnement de développement préféré.


