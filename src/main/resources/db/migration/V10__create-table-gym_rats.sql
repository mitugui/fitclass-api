create table gym_rats (
      id bigint not null,

      primary key(id),

      constraint fk_gym_rats_user_id foreign key(id) references users(id)
          on delete cascade
)