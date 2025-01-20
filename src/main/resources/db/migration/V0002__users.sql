CREATE TABLE users
(
    id               UUID PRIMARY KEY      DEFAULT uuid_generate_v4(),
    first_name       VARCHAR(100) NOT NULL,
    last_name        VARCHAR(100) NOT NULL,
    email            VARCHAR(50) UNIQUE,
    password_hash    TEXT         NOT NULL DEFAULT ''
);
