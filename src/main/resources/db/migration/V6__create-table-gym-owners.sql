create table gym_owners(
   id bigint not null,

   primary key(id),

   constraint fk_gym_owners_user_id foreign key(id) references users(id)
       on delete cascade
)