package com.tadinhos.fitclass.domain.category;

import com.tadinhos.fitclass.domain.gymclass.GymClass;
import com.tadinhos.fitclass.domain.personal.Personal;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "Category")
@Table(name = "categories")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String name;

    @ManyToMany(mappedBy = "categories")
    private List<Personal> personals;

    @OneToMany(mappedBy = "category")
    private List<GymClass> gymClasses;
}
