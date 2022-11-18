package com.example.cryptocurrency.controller;

import com.example.cryptocurrency.dto.CryptoCurrencyJSON;
import com.example.cryptocurrency.service.CryptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Validated
@RequestMapping("/api")
public class Controller {

    @Autowired
    private CryptoService cryptoService;


    @GetMapping("/getAvailableCryptoCurrencies")
    public List<CryptoCurrencyJSON> getAvailableCryptoCurrencies(){
        return cryptoService.getAvailableCryptoCurrencies();
    }

    @GetMapping("/startCurrencyMonitoring/{idCryptoCurrency}/{name}")
    public void startCurrencyMonitoring(@PathVariable String idCryptoCurrency, @PathVariable String name){
        cryptoService.startCurrencyMonitoring(idCryptoCurrency, name);
    }

    @GetMapping("/getPriceCryptoCurrency/{idCryptoCurrency}")
    public double getPriceCryptoCurrency(@PathVariable String idCryptoCurrency){
        return cryptoService.getPriceCryptoCurrency(idCryptoCurrency);
    }


}
