create table gyms(
    id bigint not null auto_increment,

    address_id bigint not null,
    gym_owner_id bigint not null,

    name varchar(100) not null,
    cnpj varchar(16),
    phone_number varchar(45) not null unique,

    primary key(id),

    constraint fk_gyms_address_id foreign key(address_id) references addresses(id),
    constraint fk_gyms_gym_owner_id foreign key(gym_owner_id) references gym_owners(id)
)