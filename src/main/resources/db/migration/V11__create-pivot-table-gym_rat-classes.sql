create table gym_rat_classes(
    gym_rat_id bigint not null,
    class_id bigint not null,

    primary key(gym_rat_id, class_id),

    constraint fk_gym_rat_classes_gym_rat_id foreign key(gym_rat_id) references gym_rats(id)
        on delete cascade,
    constraint fk_gym_rat_classes_class_id foreign key(class_id) references classes(id)
        on delete cascade
)