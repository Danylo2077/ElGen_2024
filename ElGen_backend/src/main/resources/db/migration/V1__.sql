CREATE TABLE attachment
(
    attachment_id   BIGINT AUTO_INCREMENT NOT NULL,
    message_id      BIGINT NULL,
    attachment_name VARCHAR(255) NULL,
    icon            BLOB NULL,
    CONSTRAINT pk_attachment PRIMARY KEY (attachment_id)
);

CREATE TABLE chat
(
    chat_id          BIGINT AUTO_INCREMENT NOT NULL,
    icon             BLOB NULL,
    chat_name        VARCHAR(255) NULL,
    chat_description VARCHAR(255) NULL,
    CONSTRAINT pk_chat PRIMARY KEY (chat_id)
);

CREATE TABLE chat_role
(
    chat_role_id   BIGINT AUTO_INCREMENT NOT NULL,
    chat_role_name VARCHAR(255) NULL,
    CONSTRAINT pk_chat_role PRIMARY KEY (chat_role_id)
);

CREATE TABLE comment
(
    comment_id        BIGINT AUTO_INCREMENT NOT NULL,
    parent_comment_id BIGINT NULL,
    CONSTRAINT pk_comment PRIMARY KEY (comment_id)
);

CREATE TABLE follower
(
    user_id          BIGINT AUTO_INCREMENT NOT NULL,
    follower_user_id BIGINT NULL,
    follow_user_id   BIGINT NULL,
    CONSTRAINT pk_follower PRIMARY KEY (user_id)
);

CREATE TABLE `group`
(
    group_id          BIGINT AUTO_INCREMENT NOT NULL,
    icon              BLOB NULL,
    group_name        VARCHAR(255) NULL,
    group_description VARCHAR(255) NULL,
    CONSTRAINT pk_group PRIMARY KEY (group_id)
);

CREATE TABLE group_message
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    group_id   BIGINT NULL,
    message_id BIGINT NULL,
    CONSTRAINT pk_group_message PRIMARY KEY (id)
);

CREATE TABLE group_role
(
    group_role_id   BIGINT AUTO_INCREMENT NOT NULL,
    group_role_name VARCHAR(255) NULL,
    CONSTRAINT pk_group_role PRIMARY KEY (group_role_id)
);

CREATE TABLE message
(
    message_id     BIGINT AUTO_INCREMENT NOT NULL,
    message_text   VARCHAR(255) NULL,
    message_from   VARCHAR(255) NULL,
    message_date   datetime NULL,
    is_pinned      BIT(1) NULL,
    reply_to       BIGINT NULL,
    is_post        BIT(1) NULL,
    chat_id        VARCHAR(255) NULL,
    message_tag_id BIGINT NULL,
    comment_id     BIGINT NULL,
    CONSTRAINT pk_message PRIMARY KEY (message_id)
);

CREATE TABLE message_tag
(
    message_tag_id   BIGINT AUTO_INCREMENT NOT NULL,
    message_tag_name VARCHAR(255) NULL,
    CONSTRAINT pk_message_tag PRIMARY KEY (message_tag_id)
);

CREATE TABLE reaction
(
    reaction_id      BIGINT AUTO_INCREMENT NOT NULL,
    reaction_name    VARCHAR(255) NULL,
    message_id       BIGINT NULL,
    reaction_type_id BIGINT NULL,
    CONSTRAINT pk_reaction PRIMARY KEY (reaction_id)
);

CREATE TABLE reaction_type
(
    reaction_type_id   BIGINT AUTO_INCREMENT NOT NULL,
    reaction_type_name VARCHAR(255) NULL,
    color              VARCHAR(255) NULL,
    CONSTRAINT pk_reaction_type PRIMARY KEY (reaction_type_id)
);

CREATE TABLE user
(
    user_id                BIGINT AUTO_INCREMENT NOT NULL,
    name                   VARCHAR(255) NULL,
    last_name              VARCHAR(255) NULL,
    email                  VARCHAR(255) NULL,
    password               VARCHAR(255) NULL,
    phone                  VARCHAR(255) NULL,
    bio                    VARCHAR(255) NULL,
    user_role              VARCHAR(255) NULL,
    last_login             date NULL,
    user_account_status_id BIGINT NULL,
    user_role_id           BIGINT NULL,
    user_tag_id            BIGINT NULL,
    user_name              VARCHAR(255) NULL,
    CONSTRAINT pk_user PRIMARY KEY (user_id)
);

CREATE TABLE user_account_status
(
    user_account_status_id   BIGINT AUTO_INCREMENT NOT NULL,
    user_account_status_name VARCHAR(255) NULL,
    CONSTRAINT pk_user_account_status PRIMARY KEY (user_account_status_id)
);

CREATE TABLE user_chat
(
    id      BIGINT AUTO_INCREMENT NOT NULL,
    user_id BIGINT NULL,
    chat_id BIGINT NULL,
    CONSTRAINT pk_user_chat PRIMARY KEY (id)
);

CREATE TABLE user_group
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    user_id  BIGINT NULL,
    group_id BIGINT NULL,
    CONSTRAINT pk_user_group PRIMARY KEY (id)
);

CREATE TABLE user_reaction
(
    user_reaction_id BIGINT AUTO_INCREMENT NOT NULL,
    reaction_id      BIGINT NULL,
    user_id          BIGINT NULL,
    CONSTRAINT pk_user_reaction PRIMARY KEY (user_reaction_id)
);

CREATE TABLE user_role
(
    user_role_id   BIGINT AUTO_INCREMENT NOT NULL,
    user_role_name VARCHAR(255) NULL,
    CONSTRAINT pk_user_role PRIMARY KEY (user_role_id)
);

CREATE TABLE user_tag
(
    user_tag_id   BIGINT AUTO_INCREMENT NOT NULL,
    user_tag_name VARCHAR(255) NULL,
    CONSTRAINT pk_user_tag PRIMARY KEY (user_tag_id)
);

ALTER TABLE attachment
    ADD CONSTRAINT FK_ATTACHMENT_ON_MESSAGE FOREIGN KEY (message_id) REFERENCES message (message_id);

ALTER TABLE follower
    ADD CONSTRAINT FK_FOLLOWER_ON_FOLLOWER_USER FOREIGN KEY (follower_user_id) REFERENCES user (user_id);

ALTER TABLE follower
    ADD CONSTRAINT FK_FOLLOWER_ON_FOLLOW_USER FOREIGN KEY (follow_user_id) REFERENCES user (user_id);

ALTER TABLE follower
    ADD CONSTRAINT FK_FOLLOWER_ON_USER FOREIGN KEY (user_id) REFERENCES user (user_id);

ALTER TABLE group_message
    ADD CONSTRAINT FK_GROUP_MESSAGE_ON_GROUP FOREIGN KEY (group_id) REFERENCES `group` (group_id);

ALTER TABLE group_message
    ADD CONSTRAINT FK_GROUP_MESSAGE_ON_MESSAGE FOREIGN KEY (message_id) REFERENCES message (message_id);

ALTER TABLE message
    ADD CONSTRAINT FK_MESSAGE_ON_COMMENT FOREIGN KEY (comment_id) REFERENCES comment (comment_id);

ALTER TABLE message
    ADD CONSTRAINT FK_MESSAGE_ON_MESSAGE_TAG FOREIGN KEY (message_tag_id) REFERENCES message_tag (message_tag_id);

ALTER TABLE message
    ADD CONSTRAINT FK_MESSAGE_ON_REPLY_TO FOREIGN KEY (reply_to) REFERENCES message (message_id);

ALTER TABLE reaction
    ADD CONSTRAINT FK_REACTION_ON_MESSAGE FOREIGN KEY (message_id) REFERENCES message (message_id);

ALTER TABLE reaction
    ADD CONSTRAINT FK_REACTION_ON_REACTION_TYPE FOREIGN KEY (reaction_type_id) REFERENCES reaction_type (reaction_type_id);

ALTER TABLE user_chat
    ADD CONSTRAINT FK_USER_CHAT_ON_CHAT FOREIGN KEY (chat_id) REFERENCES chat (chat_id);

ALTER TABLE user_chat
    ADD CONSTRAINT FK_USER_CHAT_ON_USER FOREIGN KEY (user_id) REFERENCES user (user_id);

ALTER TABLE user_group
    ADD CONSTRAINT FK_USER_GROUP_ON_GROUP FOREIGN KEY (group_id) REFERENCES `group` (group_id);

ALTER TABLE user_group
    ADD CONSTRAINT FK_USER_GROUP_ON_USER FOREIGN KEY (user_id) REFERENCES user (user_id);

ALTER TABLE user
    ADD CONSTRAINT FK_USER_ON_USER_ACCOUNT_STATUS FOREIGN KEY (user_account_status_id) REFERENCES user_account_status (user_account_status_id);

ALTER TABLE user
    ADD CONSTRAINT FK_USER_ON_USER_ROLE FOREIGN KEY (user_role_id) REFERENCES user_role (user_role_id);

ALTER TABLE user
    ADD CONSTRAINT FK_USER_ON_USER_TAG FOREIGN KEY (user_tag_id) REFERENCES user_tag (user_tag_id);

ALTER TABLE user_reaction
    ADD CONSTRAINT FK_USER_REACTION_ON_REACTION FOREIGN KEY (reaction_id) REFERENCES reaction (reaction_id);

ALTER TABLE user_reaction
    ADD CONSTRAINT FK_USER_REACTION_ON_USER FOREIGN KEY (user_id) REFERENCES user (user_id);