package com.tadinhos.fitclass.domain.address;

import com.tadinhos.fitclass.domain.address.dto.DataAddressCreate;
import com.tadinhos.fitclass.domain.gym.Gym;
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

    private String street;
    private String cep;
    private String number;
    private String neighborhood;
    private String town;
    private String province;

    @OneToMany(mappedBy = "address", fetch = FetchType.LAZY)
    private List<User> users;

    @OneToMany(mappedBy = "address", fetch = FetchType.LAZY)
    private List<Gym> gyms;

    public Address(DataAddressCreate data) {
        this.street = data.street();
        this.cep = data.cep();
        this.number = data.number();
        this.neighborhood = data.neighborhood();
        this.town = data.town();
        this.province = data.province();
    }
}
