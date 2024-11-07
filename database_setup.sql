create database if not exists like_hero_to_zero;
use like_hero_to_zero;
create table if not exists users
(
    id       int auto_increment
    primary key,
    username varchar(255)                 null,
    password varchar(255)                 null comment 'should be stored as hash',
    roles    longtext collate utf8mb4_bin null comment 'defined by an ENUM'
    check (json_valid(`roles`)),
    constraint username
    unique (username)
    );

create table if not exists dataset_entry
(
    id          int auto_increment
    primary key,
    owner       int          null,
    country     varchar(255) null,
    emissions   int          null,
    created_at  datetime     null,
    last_update datetime     null,
    constraint dataset_entry_ibfk_1
    foreign key (owner) references users (id)
    );

create index if not exists owner
    on dataset_entry (owner);

create table if not exists dataset_entry_change
(
    id            int auto_increment
    primary key,
    author        int          null,
    dataset_entry int          null,
    comment       varchar(255) null,
    country       varchar(255) null,
    emissions     int          null,
    created_at    datetime     null,
    approved      tinyint(1)   null,
    constraint dataset_entry_change_ibfk_1
    foreign key (author) references users (id),
    constraint dataset_entry_change_ibfk_2
    foreign key (dataset_entry) references dataset_entry (id)
    );

create index if not exists author
    on dataset_entry_change (author);

create index if not exists dataset_entry
    on dataset_entry_change (dataset_entry);