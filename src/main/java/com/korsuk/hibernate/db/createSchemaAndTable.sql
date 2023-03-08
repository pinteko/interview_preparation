create schema students_db;

SET search_path TO students_db;

create table if not exists students (
     id bigserial primary key, name varchar(255),
     mark integer);