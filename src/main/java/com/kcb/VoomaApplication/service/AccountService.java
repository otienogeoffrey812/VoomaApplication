package com.kcb.VoomaApplication.service;

import com.kcb.VoomaApplication.Exceptions.NotFoundException;
import com.kcb.VoomaApplication.model.Account;
import com.kcb.VoomaApplication.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }


    public Account getAccount(Long accountId) {
        return accountRepository.findById(accountId)
                .orElseThrow(
                        () -> {
                            NotFoundException notFoundException = new NotFoundException(
                                    "Account with id '" + accountId + "' doesn't exist!");
                            return notFoundException;
                        });

    }

    public Account createAccount(Account account){
        if (!accountRepository.findById(account.getAccountId()).isPresent()){
            throw new NotFoundException("Account with id '"+account.getAccountId()+"' doesn't exist!");
        }
        return accountRepository.save(account);
    }

    public Account updateAccount(Long accountId, Account account) {

        Account fetchedAccount = accountRepository.findById(accountId).orElseThrow(
                () -> {
                    NotFoundException notFoundException = new NotFoundException(
                            "Account with id '" + accountId + "' doesn't exist");
                    return notFoundException;
                });

        fetchedAccount.setIban(account.getIban());
        fetchedAccount.setBankCode(account.getBankCode());

        return accountRepository.save(fetchedAccount);
    }
}
