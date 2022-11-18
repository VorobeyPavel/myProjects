package com.example.cryptocurrency;

import com.example.cryptocurrency.dao.CryptoCurrencyRepository;
import com.example.cryptocurrency.dto.CryptoCurrencyJSON;
import com.example.cryptocurrency.entity.CryptoCurrency;
import com.example.cryptocurrency.exeptions.CryptoCurrencyFoundException;
import com.example.cryptocurrency.exeptions.MethodArgumentNotValid;
import com.example.cryptocurrency.service.CryptoService;
import com.example.cryptocurrency.service.CryptoServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest
class CryptoCurrencyApplicationTests {

    @Autowired
    private CryptoService cryptoService;

    @Autowired
    private CryptoServiceImpl cryptoServiceImpl;

    @MockBean
    private CryptoCurrencyRepository cryptoCurrencyRepository;



    @Test
    void getIdAndPriceFirstCryptoCurrency() {

        CryptoCurrency cryptoCurrencyOne = new CryptoCurrency(1,"Pavel","90", "Bitcoin", 20555.0, LocalDateTime.now());
        CryptoCurrency cryptoCurrencyTwo = new CryptoCurrency(2,"Pavel","90", "Bitcoin", 21777.0, LocalDateTime.now());
        CryptoCurrency cryptoCurrencyThree = new CryptoCurrency(3,"Pavel","90", "Bitcoin", 22888.0, LocalDateTime.now());

        when(cryptoCurrencyRepository.findFirstByOrderByIdDesc()).thenReturn(cryptoCurrencyThree);

        cryptoService.getIdAndPriceFirstCryptoCurrency();

        verify(cryptoCurrencyRepository, times(1)).findFirstByOrderByIdDesc();

        assertEquals(cryptoCurrencyThree.getId(), cryptoServiceImpl.idFirstCryptoCurrency);
        assertEquals(cryptoCurrencyThree.getPriceCryptoCurrency(), cryptoServiceImpl.startingPrice);
    }


    @Test
    void getPriceCryptoCurrency() {

        CryptoCurrency cryptoCurrencyOne = new CryptoCurrency(7,"Pavel","90", "Bitcoin", 21500.0, LocalDateTime.now());
        CryptoCurrency cryptoCurrencyTwo = new CryptoCurrency(8,"Pavel","90", "Bitcoin", 21888.0, LocalDateTime.now());
        CryptoCurrency cryptoCurrencyThree = new CryptoCurrency(9,"Pavel","90", "Bitcoin", 21999.0, LocalDateTime.now());

        when(cryptoCurrencyRepository.getPriceCryptoCurrency("90")).thenReturn(cryptoCurrencyThree.getPriceCryptoCurrency());

        double cryptoCurrencyPrice = cryptoService.getPriceCryptoCurrency("90");

        verify(cryptoCurrencyRepository, times(1)).getPriceCryptoCurrency("90");

        assertEquals(cryptoCurrencyThree.getPriceCryptoCurrency(), cryptoCurrencyPrice);
    }


    @Test
    void getPriceCryptoCurrencyThrowException(){
        when(cryptoCurrencyRepository.getPriceCryptoCurrency("@@@")).thenThrow(CryptoCurrencyFoundException.class);

        assertThrows(CryptoCurrencyFoundException.class, ()->cryptoService.getPriceCryptoCurrency("@@@"));
    }



}
