package com.example.demo.controller;

import com.example.demo.model.CurrencyExchangeShort;
import com.example.demo.repository.CurrencyExchangeShortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@RestController
public class CurrencyExchangeShortController {
    private CurrencyExchangeShortRepository repository;

    @Autowired
    public CurrencyExchangeShortController(CurrencyExchangeShortRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/currencies")
    public List<CurrencyExchangeShort> getCurrencies(){
        return repository.findAll();
    }

    //Выводит список всех кодов валюты, которые имеются в БД. Endpoint: /currencies/code;
    @GetMapping("/currencies/code")
    public List<String> getCurrencyCodes(){
        List<CurrencyExchangeShort> currencyExchangeShorts =  repository.findAll();
        List<String> currencyCodes = new ArrayList<>();
        for(CurrencyExchangeShort currencyExchangeShort: currencyExchangeShorts){
            currencyCodes.add(currencyExchangeShort.getCurrencyCode());
        }
        return currencyCodes;
    }

    //Выводит список всех валют, которые имеют value < maxValue. Endpoint: /currencies/value?maxValue=100;
    @GetMapping("/currencies/value")
    public List<CurrencyExchangeShort> getCurrencyExchangeShortsWithLowerValue(@RequestParam("maxValue") Integer maxValue){
        List<CurrencyExchangeShort> currencyExchangeShorts =  repository.findAll();
        currencyExchangeShorts.removeIf(x -> x.getValue() > maxValue);
        return currencyExchangeShorts;
    }
}
