package com.tadinhos.fitclass.domain.gymclass;

import com.tadinhos.fitclass.domain.category.Category;
import com.tadinhos.fitclass.domain.gym.Gym;
import com.tadinhos.fitclass.domain.gymrat.GymRat;
import com.tadinhos.fitclass.domain.personal.Personal;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "Class")
@Table(name = "classes")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GymClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Integer peopleLimit;
    private Integer countPeople;

    @ManyToOne
    @JoinColumn(name = "gym_id")
    private Gym gym;

    @ManyToOne
    @JoinColumn(name = "personal_id")
    private Personal personal;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany(mappedBy = "gymClasses")
    private List<GymRat> gymRats;
}
