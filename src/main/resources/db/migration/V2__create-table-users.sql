create table users(
   id bigint not null auto_increment,

   address_id bigint not null,

   name varchar(255) not null,
   email varchar(255) not null unique,
   password varchar(255) not null,
   phone_number varchar(45) not null unique,
   cpf varchar(9) not null unique,
   gender char(1) not null,
   birthdate date not null,

   primary key(id),

   constraint fk_users_address_id foreign key(address_id) references addresses(id)
)