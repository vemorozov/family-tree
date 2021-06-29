create table person(
    id integer primary key auto_increment,
    name varchar not null,
    gender char not null,
    is_alive boolean default true,
    dad integer,
    mom integer,
    foreign key (dad) references person(id),
    foreign key (mom) references person(id)
);

create table parent_child_jt(
    id integer primary key auto_increment,
    child_id integer references person(id),
    parent_id integer references person(id)
);