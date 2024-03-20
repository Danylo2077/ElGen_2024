
CREATE TABLE chat
(
    chat_id          INT AUTO_INCREMENT PRIMARY KEY,
    icon             BLOB NULL,
    chat_name        VARCHAR(255) NULL,
    chat_description VARCHAR(255) NULL
);

CREATE TABLE chat_role
(
    chat_role_id   INT AUTO_INCREMENT PRIMARY KEY,
    chat_role_name VARCHAR(255) NULL
);

CREATE TABLE comment
(
    comment_id        INT AUTO_INCREMENT PRIMARY KEY,
    parent_comment_id INT
);

CREATE TABLE `group`
(
    group_id          INT AUTO_INCREMENT PRIMARY KEY,
    group_name        VARCHAR(255) NULL,
    group_description VARCHAR(255) NULL,
    icon              BLOB NULL
);


CREATE TABLE group_role
(
    group_role_id   INT AUTO_INCREMENT PRIMARY KEY,
    group_role_name VARCHAR(255) NULL
);

CREATE TABLE message_tag
(
    message_tag_id   INT AUTO_INCREMENT PRIMARY KEY,
    message_tag_name VARCHAR(255) NULL
);

CREATE TABLE message
(
    message_id     INT AUTO_INCREMENT PRIMARY KEY,
    message_text   VARCHAR(255) NULL,
    message_from   VARCHAR(255) NULL,
    message_date   datetime NULL,
    is_pinned      BIT NULL,
    reply_to       INT,
    is_post        BIT NULL,
    chat_id        VARCHAR(255),
    message_tag_id INT,
    comment_id     INT,
    CONSTRAINT FK_MESSAGE_ON_COMMENT FOREIGN KEY (comment_id) REFERENCES comment (comment_id),
    CONSTRAINT FK_MESSAGE_ON_MESSAGE_TAG FOREIGN KEY (message_tag_id) REFERENCES message_tag (message_tag_id),
    CONSTRAINT FK_MESSAGE_ON_REPLY_TO FOREIGN KEY (reply_to) REFERENCES message (message_id)
);

CREATE TABLE attachment
(
    attachment_id   INT AUTO_INCREMENT PRIMARY KEY,
    message_id      INT,
    attachment_name VARCHAR(255) NULL,
    icon            BLOB NULL,
    CONSTRAINT FK_ATTACHMENT_ON_MESSAGE FOREIGN KEY (message_id) REFERENCES message (message_id)
);


CREATE TABLE group_message
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    group_id   INT,
    message_id INT,
    CONSTRAINT FK_GROUP_MESSAGE_ON_GROUP FOREIGN KEY (group_id) REFERENCES `group` (group_id),
    CONSTRAINT FK_GROUP_MESSAGE_ON_MESSAGE FOREIGN KEY (message_id) REFERENCES message (message_id)
);

CREATE TABLE reaction
(
    reaction_id      INT AUTO_INCREMENT PRIMARY KEY,
    reaction_name    VARCHAR(255) NULL,
    message_id       INT,
    reaction_type_id BIGINT,
    CONSTRAINT FK_REACTION_ON_MESSAGE FOREIGN KEY (message_id) REFERENCES message (message_id)
);

CREATE TABLE reaction_type
(
    reaction_type_id   INT AUTO_INCREMENT PRIMARY KEY,
    reaction_type_name VARCHAR(255) NULL,
    color              VARCHAR(255) NULL
);

CREATE TABLE user_account_status
(
    user_account_status_id   INT AUTO_INCREMENT PRIMARY KEY,
    user_account_status_name VARCHAR(255) NULL
);

CREATE TABLE user_tag
(
    user_tag_id   INT AUTO_INCREMENT PRIMARY KEY,
    user_tag_name VARCHAR(255) NULL
);

CREATE TABLE user_role
(
    user_role_id   INT AUTO_INCREMENT PRIMARY KEY,
    user_role_name VARCHAR(255) NULL
);

CREATE TABLE user
(
    user_id                INT AUTO_INCREMENT PRIMARY KEY,
    name                   VARCHAR(255) NULL,
    last_name              VARCHAR(255) NULL,
    email                  VARCHAR(255) NULL,
    password               VARCHAR(255) NULL,
    phone                  VARCHAR(255) NULL,
    bio                    VARCHAR(255) NULL,
    user_role              VARCHAR(255) NULL,
    last_login             date NULL,
    user_account_status_id INT,
    user_role_id           INT,
    user_tag_id            INT,
    full_name              VARCHAR(255) NULL,
    CONSTRAINT FK_USER_ON_USER_ACCOUNT_STATUS FOREIGN KEY (user_account_status_id) REFERENCES user_account_status (user_account_status_id),
    CONSTRAINT FK_USER_ON_USER_ROLE FOREIGN KEY (user_role_id) REFERENCES user_role (user_role_id),
    CONSTRAINT FK_USER_ON_USER_TAG FOREIGN KEY (user_tag_id) REFERENCES user_tag (user_tag_id)
);

CREATE TABLE follower
(
    user_id          INT,
    follower_user_id INT,
    follow_user_id   INT,
    PRIMARY KEY (user_id, follower_user_id, follow_user_id),
    CONSTRAINT FK_FOLLOWER_ON_USER FOREIGN KEY (user_id) REFERENCES user (user_id),
    CONSTRAINT FK_FOLLOWER_ON_FOLLOWER_USER FOREIGN KEY (follower_user_id) REFERENCES user (user_id),
    CONSTRAINT FK_FOLLOWER_ON_FOLLOW_USER FOREIGN KEY (follow_user_id) REFERENCES user (user_id)
);

CREATE TABLE user_chat
(
    id      BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    chat_id INT,
    CONSTRAINT FK_USER_CHAT_ON_USER FOREIGN KEY (user_id) REFERENCES user (user_id),
    CONSTRAINT FK_USER_CHAT_ON_CHAT FOREIGN KEY (chat_id) REFERENCES chat (chat_id)
);

CREATE TABLE user_group
(
    id       BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id  INT,
    group_id INT,
    CONSTRAINT FK_USER_GROUP_ON_USER FOREIGN KEY (user_id) REFERENCES user (user_id),
    CONSTRAINT FK_USER_GROUP_ON_GROUP FOREIGN KEY (group_id) REFERENCES `group` (group_id)
);

CREATE TABLE user_reaction
(
    user_reaction_id INT AUTO_INCREMENT PRIMARY KEY,
    reaction_id      INT,
    user_id          INT,
    CONSTRAINT FK_USER_REACTION_ON_USER FOREIGN KEY (user_id) REFERENCES user (user_id),
    CONSTRAINT FK_USER_REACTION_ON_REACTION FOREIGN KEY (reaction_id) REFERENCES reaction (reaction_id)
);




