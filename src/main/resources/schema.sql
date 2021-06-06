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

CREATE TABLE IF NOT EXISTS task
(
    id serial PRIMARY KEY,
    topic text NOT NULL,
    description text NOT NULL
);

