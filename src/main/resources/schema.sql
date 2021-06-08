--CREATE USER todo;

--CREATE DATABASE todo
--    WITH OWNER = todo
--    ENCODING = 'UTF8'
--    LC_COLLATE = 'ru_RU.UTF-8'
--    LC_CTYPE = 'ru_RU.UTF-8'
--    TEMPLATE = template0;

DROP TABLE IF EXISTS auth_user;
DROP TABLE IF EXISTS authority;
DROP TABLE IF EXISTS task;
DROP TABLE IF EXISTS boxType;
DROP TABLE IF EXISTS box;


CREATE TABLE IF NOT EXISTS auth_user
(
    id serial PRIMARY KEY,
    username text NOT NULL,
    password text NOT NULL,
    algorithm text NOT NULL
);

CREATE TABLE IF NOT EXISTS authority
(
    id serial PRIMARY KEY,
    name text NOT NULL,
    auth_user int NOT NULL
);

CREATE TABLE IF NOT EXISTS Task
(
    id serial primary key,
    subject text not null
);

CREATE TABLE IF NOT EXISTS Job
(
    id serial primary key,
    task int not null,
    box int not null
);


CREATE TABLE IF NOT EXISTS Box
(
    id serial primary key,
    name text not null
);
