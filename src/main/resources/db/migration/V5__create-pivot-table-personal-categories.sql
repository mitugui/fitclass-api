create table personal_categories(
    personal_id bigint not null,
    category_id bigint not null,

    primary key(personal_id, category_id),

    constraint fk_personal_categories_personal_id foreign key(personal_id) references personals(id)
        on delete cascade,
    constraint fk_personal_categories_category_id foreign key(category_id) references categories(id)
        on delete cascade
)