package com.tadinhos.fitclass.domain.gymowner;

import com.tadinhos.fitclass.domain.gym.Gym;
import com.tadinhos.fitclass.domain.gymowner.dto.DataGymOwnerCreate;
import com.tadinhos.fitclass.domain.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Entity(name = "GymOwner")
@Table(name = "gym_owners")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class GymOwner extends User {
    @OneToMany(mappedBy = "gymOwner")
    private List<Gym> gyms;

    public GymOwner(DataGymOwnerCreate data) {
        super(
                data.name(),
                data.email(),
                data.password(),
                data.phoneNumber(),
                data.cpf(),
                data.gender(),
                data.birthDate(),
                data.address()
        );
    }
}
