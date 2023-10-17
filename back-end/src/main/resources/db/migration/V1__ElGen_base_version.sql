-- CREATE DATABASE ElGen;

CREATE TABLE Group_table
    (
        group_id VARCHAR(255) PRIMARY KEY,
        group_name VARCHAR(255) NOT NULL,
        group_description VARCHAR(255),
        group_logo BLOB

    );

CREATE TABLE Group_role
    (
        group_role_id integer PRIMARY KEY,
        group_role_name VARCHAR(255)
    );

create table chat
(
    chat_id         integer
        primary key,
    chat_name        varchar(35) not null,
    chat_descriptiom varchar(255),
    chat_logo        blob
);
create table chat_role
(
    chat_role_id   integer
        primary key,
    chat_role_name varchar(35)
);

create table user_role
(
    user_role_id  integer
        primary key,
    user_role_name varchar(35)
);

create table user_accounts_status
(
    user_accounts_status_id   varchar(35)
        primary key,
    user_accounts_status_name varchar(255)
);

CREATE TABLE user
(
    user_id                INT(20)      NOT NULL,
    name                   VARCHAR(35)  NULL,
    last_name              VARCHAR(35)  NULL,
    phone                  VARCHAR(9)   NULL,
    bio                    VARCHAR(255) NULL,
    last_login             DATE         NULL,
    password               VARCHAR(35)  NULL,
    email                  VARCHAR(255) NULL,
    user_account_status_id VARCHAR(35) NULL,
    user_role              INT(20)      NULL,
    CONSTRAINT user_account_status_id_fk
        FOREIGN KEY (user_account_status_id) REFERENCES user_accounts_status (user_accounts_status_id), -- Ось тут
    CONSTRAINT user_role_fk
        FOREIGN KEY (user_role) REFERENCES user_role (user_role_id),
    PRIMARY KEY (user_id)
);

create table follower
    (
        id               int(20) not null
        primary key,
        follow_user_id   int(20) null,
        follower_user_id int(20) null,
        constraint follow_user_id_fk
        foreign key (follow_user_id) references user (user_id),
        constraint follower_user_id_fk
        foreign key (follower_user_id) references user (user_id)
    );

ALTER TABLE user
    ADD INDEX email_index (email);

CREATE TABLE User_Group (
                            user_id VARCHAR(255),
                            group_id VARCHAR(255),
                            PRIMARY KEY (user_id, group_id),
                            FOREIGN KEY (user_id) REFERENCES user(email),
                            FOREIGN KEY (group_id) REFERENCES `Group_table`(group_id)
);

create table reaction_type
(
    reaction_type_id   int(20)     not null
        primary key,
    reaction_type_name varchar(20) null,
    icon               blob        null,
    color              varchar(7)  null
);


CREATE TABLE Message
(
    message_id INTEGER PRIMARY KEY,
    message_text VARCHAR(3000) NULL,
    message_from VARCHAR(100) NULL,
    message_date DATE NULL,
    is_pinned TINYINT(1) NULL,
    reply_to INTEGER NULL,
    comment_id INTEGER NULL,
    is_post TINYINT(1) NULL,
    chat_id INTEGER NULL
);

CREATE TABLE Comment
(
    comment_id INTEGER PRIMARY KEY,
    parent_comment_id INTEGER
);

ALTER TABLE Message
    ADD CONSTRAINT comment_id_fk FOREIGN KEY (comment_id) REFERENCES Comment(comment_id);


create table reaction
(
    react_name       varchar(20) null,
    reaction_type_id int(20)     null,
    message_id       int(20)     null,
    reaction_id      int(20)     not null
        primary key,
    constraint message_id_fk
        foreign key (message_id) references Message (message_id),
    constraint reaction_type_id_fk
        foreign key (reaction_type_id) references reaction_type (reaction_type_id)
);

create table user_reaction
    (
        ID          int(20) not null
        primary key,
        user_id     int(20) null,
        reaction_id int(20) null,
        constraint reaction_id_fk
        foreign key (reaction_id) references reaction (reaction_id),
        constraint user_id_fk
        foreign key (user_id) references user (user_id)
    );

create table attachment
    (
        attachment_id   int(20)      not null
        primary key,
        attachment_name varchar(255) null,
        attachment_data blob         null,
        message_id      int(20)      null,
        constraint attachment_message_id_fk
        foreign key (message_id) references Message (message_id)
    );

CREATE TABLE Group_Message
(
    group_id VARCHAR(255),
    message_id INTEGER,
    PRIMARY KEY (group_id, message_id),
    FOREIGN KEY (group_id) REFERENCES `Group_table`(group_id),
    FOREIGN KEY (message_id) REFERENCES Message(message_id)
);



ALTER TABLE Message
    ADD COLUMN user_id VARCHAR(100);


CREATE INDEX user_id_index ON Message (user_id);
CREATE INDEX chat_id_index ON Message (chat_id);

CREATE TABLE user_chat
(
    user_id VARCHAR(100),
    chat_id INTEGER,
    PRIMARY KEY (user_id),
    CONSTRAINT user_chat_user_id_fk FOREIGN KEY (user_id) REFERENCES Message (user_id),
    CONSTRAINT chat_id_fk FOREIGN KEY (chat_id) REFERENCES Message (chat_id)
);




