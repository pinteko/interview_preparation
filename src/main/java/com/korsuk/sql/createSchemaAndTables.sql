create schema cinema;

SET search_path TO cinema;

create table if not exists films (
    id bigserial primary key, title varchar(255),
    duration interval minute);

create table if not exists seance (
    id bigserial primary key,
    film_id integer references films(id),
    duration interval minute,
    start_show timestamp,
    end_show timestamp generated always as (start_show + duration + interval '30 minutes') stored,
    price numeric(10,2) default 2);


create table if not exists tickets (
    id bigserial primary key,
    seance_id integer references seance(id),
    count integer default 1,
    film_title varchar(255), film_price numeric(10,2));

/*Работу не доделал. В общем и целом хотел создать в некоторых столбцах таблицы
  автогенерируемые значения на основании предыдущих значений,
  но уперся в то, что нельзя делать подзапросы
  при создании таблицы, и нельзя обратиться к самому себе же...*/