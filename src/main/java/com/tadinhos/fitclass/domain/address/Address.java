package com.tadinhos.fitclass.domain.address;

import com.tadinhos.fitclass.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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

    @OneToMany(mappedBy = "address", fetch = FetchType.LAZY)
    private List<User> users;
}
