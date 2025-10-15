create table personals(
    id bigint not null,

    primary key(id),

    constraint fk_personals_user_id foreign key(id) references users(id)
        on delete cascade
)