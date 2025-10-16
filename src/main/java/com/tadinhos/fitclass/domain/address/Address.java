package com.tadinhos.fitclass.domain.address;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Address")
@Table(name = "addresses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String address;
    private String cep;
    private String number;
}
