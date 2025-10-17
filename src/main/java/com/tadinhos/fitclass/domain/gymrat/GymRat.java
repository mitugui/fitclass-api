package com.tadinhos.fitclass.domain.gymrat;

import com.tadinhos.fitclass.domain.gymclass.GymClass;
import com.tadinhos.fitclass.domain.user.User;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "GymRat")
@Table(name = "gym_rats")
public class GymRat extends User {
    @ManyToMany
    @JoinTable(
            name = "gym_rat_classes",
            joinColumns = @JoinColumn(name = "gym_rat_id"),
            inverseJoinColumns = @JoinColumn(name = "class_id")
    )
    private List<GymClass> gymClasses;
}
