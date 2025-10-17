package com.tadinhos.fitclass.domain.gymrat;

import com.tadinhos.fitclass.domain.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity(name = "GymRat")
@Table(name = "gym_rats")
public class GymRat extends User {
}
