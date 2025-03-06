create table users
(
    id        serial primary key,
    name varchar(50) unique not null,
    email     varchar(100) unique not null,
    password  varchar(50)       not null,
    role      varchar(50)  not null
);

INSERT INTO users (name, email, password, role)
VALUES
    ('Alice Johnson', 'alice.johnson@example.com', 'password123', 'USER'),
    ('Bob Smith', 'bob.smith@example.com', 'password456', 'ADMIN'),
    ('Charlie Brown', 'charlie.brown@example.com', 'password789', 'USER'),
    ('Diana Lee', 'diana.lee@example.com', 'password101', 'USER'),
    ('Eve White', 'eve.white@example.com', 'password202', 'USER');
