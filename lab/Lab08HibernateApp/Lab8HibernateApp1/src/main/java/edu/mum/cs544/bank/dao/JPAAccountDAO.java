package edu.mum.cs544.bank.dao;

import edu.mum.cs544.bank.domain.Account;
import edu.mum.cs544.bank.util.EntityManagerHelper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JPAAccountDAO extends Thread implements IJPAAccountDAO {

    public void saveAccount(Account account) {
        EntityManager em = EntityManagerHelper.getCurrent();
        em.persist(account);
    }

    public void updateAccount(Account account) {
        EntityManager em = EntityManagerHelper.getCurrent();
        em.merge(account);
    }

    public Account loadAccount(long accountnumber) {
        EntityManager em = EntityManagerHelper.getCurrent();
        Account account = em.find(Account.class, accountnumber);

        return account;
    }

    public Collection<Account> getAccounts() {

        EntityManager em = EntityManagerHelper.getCurrent();
        List<Account> accounts = em.createQuery("from Account a " +
                "join fetch a.entryList ", Account.class).getResultList();

        return accounts;
    }

}
