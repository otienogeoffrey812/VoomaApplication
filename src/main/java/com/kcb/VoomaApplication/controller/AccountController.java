package com.kcb.VoomaApplication.controller;

import com.kcb.VoomaApplication.model.Account;
import com.kcb.VoomaApplication.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<Account>> findAll(){
        return ResponseEntity.ok().body(accountService.findAll());
    }
    @GetMapping("/find/{accountId}")
    public ResponseEntity<Account> findAccount(@PathVariable("accountId") Long accountId){
        return new ResponseEntity<Account>(accountService.getAccount(accountId), HttpStatus.OK);
    }

    @PostMapping("/create")
    public Account createAccount(@RequestBody Account account){
        return accountService.createAccount(account);
    }

    @PutMapping("/update/{accountId}")
    public Account updateAccount(@PathVariable("accountId") Long accountId,
                                  @RequestBody Account account) {
        return accountService.updateAccount(accountId, account);
    }
}
