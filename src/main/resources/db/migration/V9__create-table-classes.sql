create table classes(
    id bigint not null auto_increment,

    gym_id bigint not null,
    personal_id bigint not null,
    category_id bigint not null,

    start_time datetime not null,
    end_time datetime not null,
    people_limit int,
    count_people int,

    primary key(id),

    constraint fk_classes_gym_id foreign key(gym_id) references gyms(id)
        on delete cascade
        on update no action,
    constraint fk_classes_personal_id foreign key(personal_id) references personals(id)
        on delete cascade
        on update no action,
    constraint fk_classes_category_id foreign key(category_id) references categories(id)
        on delete cascade
        on update no action
)