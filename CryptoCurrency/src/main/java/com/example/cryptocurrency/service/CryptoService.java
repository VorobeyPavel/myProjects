package com.example.cryptocurrency.service;


import com.example.cryptocurrency.dto.CryptoCurrencyJSON;

import java.util.List;

public interface CryptoService {

    List<CryptoCurrencyJSON> getAvailableCryptoCurrencies();

    void startCurrencyMonitoring(String id, String name);

    void getIdAndPriceFirstCryptoCurrency();

    void currencyMonitoring();

    void priceMonitoring();

    double getPriceCryptoCurrency(String currencyCode);

    List<CryptoCurrencyJSON> getAllCryptoCurrencyJSON(String url);


}
