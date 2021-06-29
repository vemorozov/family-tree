insert into person(id, name, gender, is_alive, dad, mom) values (1, 'Cynthia Maria Hawes', 'F', false , null, null);
insert into person(id, name, gender, is_alive, dad, mom) values (2, 'Daniel B. Wesson', 'M', true, null, null);
insert into person(id, name, gender, is_alive, dad, mom) values (3, 'Horace Smith', 'M', false , null, null);
insert into person(id, name, gender, is_alive, dad, mom) values (4, 'Eliza Foster', 'F', true, null, null);
insert into person(id, name, gender, is_alive, dad, mom) values (5, 'Mr Smith', 'M', true, 3, 4);
insert into person(id, name, gender, is_alive, dad, mom) values (6, 'Mrs Smith', 'F', true, 1, 2);
insert into person(id, name, gender, is_alive, dad, mom) values (7, 'Smith Jr', 'M', true, 5, 6);
insert into person(id, name, gender, is_alive, dad, mom) values (8, 'Mowgli', 'M', true, null, 6);

insert into parent_child_jt (parent_id, child_id) values (1, 6);
insert into parent_child_jt (parent_id, child_id) values (2, 6);
insert into parent_child_jt (parent_id, child_id) values (3, 5);
insert into parent_child_jt (parent_id, child_id) values (4, 5);
insert into parent_child_jt (parent_id, child_id) values (5, 7);
insert into parent_child_jt (parent_id, child_id) values (6, 7);
insert into parent_child_jt (parent_id, child_id) values (6, 8);
