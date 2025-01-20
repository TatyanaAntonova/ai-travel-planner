CREATE TABLE user_roles
(
    id        UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    role_name VARCHAR(50),
    user_id   UUID REFERENCES users (id)
);
