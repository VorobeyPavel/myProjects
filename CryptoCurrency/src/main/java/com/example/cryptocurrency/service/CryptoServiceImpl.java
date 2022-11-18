package com.example.cryptocurrency.service;


import com.example.cryptocurrency.dao.CryptoCurrencyRepository;
import com.example.cryptocurrency.dto.CryptoCurrencyJSON;
import com.example.cryptocurrency.entity.CryptoCurrency;
import com.example.cryptocurrency.exeptions.CryptoCurrencyFoundException;
import com.example.cryptocurrency.exeptions.MethodArgumentNotValid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.AopInvocationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Configuration
@EnableScheduling
@Slf4j
public class CryptoServiceImpl implements CryptoService{

    @Autowired
    private CryptoCurrencyRepository cryptoCurrencyRepository;

    public static final String ALL_CRYPTO_CURRENCY = "https://api.coinlore.net/api/ticker/?id=90,80,48543";
    public static final String CURRENCY = "https://api.coinlore.net/api/ticker/?id=";
    public String CURRENCY_MONITORING;
    public String nameUser;
    public String codeCurrency;
    public int idFirstCryptoCurrency = 0;
    public double startingPrice = 0;
    public double previousPrice = 0;
    public double currentPrice = 0;


    @Override
    public List<CryptoCurrencyJSON> getAvailableCryptoCurrencies(){
        return getAllCryptoCurrencyJSON(ALL_CRYPTO_CURRENCY);
    }

    @Override
    public List<CryptoCurrencyJSON> getAllCryptoCurrencyJSON(String url){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<CryptoCurrencyJSON>> responseEntity =
                restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
        return responseEntity.getBody();
    }


    @Override
    public void startCurrencyMonitoring(String id, String name) {

        CURRENCY_MONITORING = CURRENCY+id;
        nameUser = name;
        codeCurrency = id;

        List<CryptoCurrencyJSON> allCryptoCurrency = getAllCryptoCurrencyJSON(CURRENCY_MONITORING);

        CryptoCurrency cryptoCurrency = new CryptoCurrency();
        assert allCryptoCurrency != null;
        cryptoCurrency.setNameCryptoCurrency(allCryptoCurrency.get(0).getName());
        cryptoCurrency.setPriceCryptoCurrency(Double.parseDouble(allCryptoCurrency.get(0).getPrice_usd()));
        cryptoCurrency.setNameUser(nameUser);
        cryptoCurrency.setIdCryptoCurrency(codeCurrency);
        cryptoCurrency.setLocalDateTime(LocalDateTime.now());

        try {
            cryptoCurrencyRepository.save(cryptoCurrency);
            getIdAndPriceFirstCryptoCurrency();
        }catch (ConstraintViolationException e){
            throw new MethodArgumentNotValid("nameUser must be min 2 symbols");
        }

    }


    @Override
    public void getIdAndPriceFirstCryptoCurrency() {
        CryptoCurrency cryptoCurrency = cryptoCurrencyRepository.findFirstByOrderByIdDesc();
        idFirstCryptoCurrency = cryptoCurrency.getId();
        startingPrice = cryptoCurrency.getPriceCryptoCurrency();
        previousPrice = startingPrice;
    }


    @Override
    @Scheduled(fixedRate = 60000)
    public void currencyMonitoring() {

        if (idFirstCryptoCurrency!=0){
            List<CryptoCurrencyJSON> allCryptoCurrency = getAllCryptoCurrencyJSON(CURRENCY_MONITORING);

            CryptoCurrency cryptoCurrency = new CryptoCurrency();
            assert allCryptoCurrency != null;
            cryptoCurrency.setNameCryptoCurrency(allCryptoCurrency.get(0).getName());
            cryptoCurrency.setPriceCryptoCurrency(Double.parseDouble(allCryptoCurrency.get(0).getPrice_usd()));
            cryptoCurrency.setNameUser(nameUser);
            cryptoCurrency.setIdCryptoCurrency(codeCurrency);
            cryptoCurrency.setLocalDateTime(LocalDateTime.now());

            if (cryptoCurrency.getNameUser()!=null && cryptoCurrency.getNameCryptoCurrency()!=null){
                cryptoCurrencyRepository.save(cryptoCurrency);
            }
        }
    }


    @Override
    @Scheduled(fixedRate = 60000)
    public void priceMonitoring() {

        if (idFirstCryptoCurrency!=0){
            CryptoCurrency cryptoCurrency = cryptoCurrencyRepository.findFirstByOrderByIdDesc();
            currentPrice = cryptoCurrency.getPriceCryptoCurrency();

            if (Math.abs(previousPrice-currentPrice)>previousPrice*0.01){
                double priceChangePercentage = (currentPrice-startingPrice)/startingPrice*100;

                log.warn("currencyCode: "+cryptoCurrency.getIdCryptoCurrency()+", nameUser: "+cryptoCurrency.getNameUser()+", "+
                        " priceChangePercentage: "+priceChangePercentage);
                previousPrice = currentPrice;
            }
        }
    }


    @Override
    public double getPriceCryptoCurrency(String currencyCode) {
        try {
            return cryptoCurrencyRepository.getPriceCryptoCurrency(currencyCode);
        }catch (AopInvocationException e){
            throw new CryptoCurrencyFoundException("CryptoCurrency with id = " + currencyCode + " not found!");
        }
    }


}
