package com.example.cryptocurrency.dao;

import com.example.cryptocurrency.entity.CryptoCurrency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface CryptoCurrencyRepository extends JpaRepository<CryptoCurrency, Long> {

    CryptoCurrency findFirstByOrderByIdDesc();

    @Query("Select priceCryptoCurrency From CryptoCurrency  where idCryptoCurrency=:code and " +
            "id = (select MAX(id) from CryptoCurrency where idCryptoCurrency=:code)")
    double getPriceCryptoCurrency(@Param("code") String code);

}
