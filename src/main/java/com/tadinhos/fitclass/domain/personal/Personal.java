package com.tadinhos.fitclass.domain.personal;

import com.tadinhos.fitclass.domain.user.User;
import jakarta.persistence.*;

@Entity(name = "Personal")
@Table(name = "personals")
public class Personal extends User {
}
