create table addresses(
    id bigint not null auto_increment,
    address varchar(510) not null,
    cep varchar(8) not null,
    number varchar(45),

    primary key(id)
)