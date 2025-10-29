package com.tadinhos.fitclass.domain.gym;

import com.tadinhos.fitclass.domain.address.Address;
import com.tadinhos.fitclass.domain.gym.dto.DataGymCreate;
import com.tadinhos.fitclass.domain.gymclass.GymClass;
import com.tadinhos.fitclass.domain.gymowner.GymOwner;
import com.tadinhos.fitclass.domain.personal.Personal;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "Gym")
@Table(name = "gyms")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Gym {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String cnpj;
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Address address;

    @ManyToOne(fetch = FetchType.LAZY)
    private GymOwner gymOwner;

    @ManyToMany(mappedBy = "gyms")
    private List<Personal> personals;

    @OneToMany(mappedBy = "gym", cascade = CascadeType.ALL)
    private List<GymClass> gymClasses;

    public Gym (DataGymCreate data) {
        this.name = data.name();
        this.cnpj = data.cnpj();
        this.phoneNumber = data.phoneNumber();
        this.address = data.address();
        this.gymOwner = data.gymOwner();
    }
}
