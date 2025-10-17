package com.tadinhos.fitclass.domain.personal;

import com.tadinhos.fitclass.domain.category.Category;
import com.tadinhos.fitclass.domain.gym.Gym;
import com.tadinhos.fitclass.domain.user.User;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "Personal")
@Table(name = "personals")
public class Personal extends User {
    @ManyToMany
    @JoinTable(
            name = "personal_categories",
            joinColumns = @JoinColumn(name = "personal_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;

    @ManyToMany
    @JoinTable(
            name = "gyms_personals",
            joinColumns = @JoinColumn(name = "personal_id"),
            inverseJoinColumns = @JoinColumn(name = "gym_id")
    )
    private List<Gym> gyms;
}
