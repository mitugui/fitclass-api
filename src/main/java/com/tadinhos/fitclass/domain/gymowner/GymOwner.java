package com.tadinhos.fitclass.domain.gymowner;

import com.tadinhos.fitclass.domain.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity(name = "GymOwner")
@Table(name = "gym_owners")
public class GymOwner extends User {
}
