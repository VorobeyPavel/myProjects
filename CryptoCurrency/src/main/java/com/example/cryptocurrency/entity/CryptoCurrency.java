package com.example.cryptocurrency.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cryptocurrency")
public class CryptoCurrency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @NotNull
    @Size(min = 2, message = "nameUser must be min 2 symbols")
    private String nameUser;

    private String idCryptoCurrency;

    private String nameCryptoCurrency;

    private Double priceCryptoCurrency;

    @Column(name = "timestamp")
    private LocalDateTime localDateTime;


}
