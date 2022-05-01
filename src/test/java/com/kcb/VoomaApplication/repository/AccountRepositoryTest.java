package com.kcb.VoomaApplication.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kcb.VoomaApplication.controller.AccountController;
import com.kcb.VoomaApplication.model.Account;
import com.kcb.VoomaApplication.service.AccountService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest({AccountController.class})
class AccountRepositoryTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    @MockBean
    AccountService accountService;

    Account RECORD_1 = new Account("Iban 1", "236727", "2678823889");
    Account RECORD_2 = new Account("Iban 2", "2367275", "2699378823889");
    Account RECORD_3 = new Account( "Iban 3", "2636727", "267778823889");

    @Test
    public void getAllRecords_success() throws Exception {
        List<Account> records = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2, RECORD_3));

        Mockito.when(accountService.findAll()).thenReturn(records);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/account/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(3)));

    }



}