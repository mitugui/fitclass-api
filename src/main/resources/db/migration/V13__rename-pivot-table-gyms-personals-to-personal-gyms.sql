alter table gyms_personals rename to personal_gyms;

alter table personal_gyms drop foreign key fk_gyms_personals_gym_id;
alter table personal_gyms drop foreign key fk_gyms_personals_personal_id;

alter table personal_gyms
    add constraint fk_personal_gyms_personal_id foreign key(personal_id) references personals(id)
        on delete cascade;

alter table personal_gyms
    add constraint fk_personal_gyms_gym_id foreign key(gym_id) references gyms(id)
        on delete cascade;

