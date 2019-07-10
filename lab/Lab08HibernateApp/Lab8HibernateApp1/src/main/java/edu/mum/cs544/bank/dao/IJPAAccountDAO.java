package edu.mum.cs544.bank.dao;

import edu.mum.cs544.bank.domain.Account;

import java.util.Collection;

public interface IJPAAccountDAO {
    public void saveAccount(Account account);

    public void updateAccount(Account account);

    public Account loadAccount(long accountnumber);

    public Collection<Account> getAccounts();
}
