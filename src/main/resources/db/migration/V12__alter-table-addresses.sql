alter table addresses
    drop column address,
    add street varchar(255),
    add neighborhood varchar(255),
    add town varchar(255),
    add province varchar(255)
