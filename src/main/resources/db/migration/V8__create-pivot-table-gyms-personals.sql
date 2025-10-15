create table gyms_personals(
     gym_id bigint not null,
     personal_id bigint not null,

     primary key(gym_id, personal_id),

     constraint fk_gyms_personals_gym_id foreign key(gym_id) references gyms(id)
         on delete cascade,
     constraint fk_gyms_personals_personal_id foreign key(personal_id) references personals(id)
         on delete cascade
)