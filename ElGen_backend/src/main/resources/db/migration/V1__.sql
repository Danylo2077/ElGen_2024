CREATE TABLE file_data
(
    id        BIGINT AUTO_INCREMENT NOT NULL,
    name      VARCHAR(255) NULL,
    type      VARCHAR(255) NULL,
    file_path VARCHAR(255) NULL,
    post_id   BIGINT NULL,
    CONSTRAINT pk_file_data PRIMARY KEY (id)
);

CREATE TABLE message_tag
(
    message_tag_id   BIGINT AUTO_INCREMENT NOT NULL,
    message_tag_name VARCHAR(255) NULL,
    CONSTRAINT pk_message_tag PRIMARY KEY (message_tag_id)
);

CREATE TABLE message_tag_mapping
(
    post_id BIGINT NOT NULL,
    tag_id  BIGINT NOT NULL
);

CREATE TABLE post
(
    post_id BIGINT AUTO_INCREMENT NOT NULL,
    text    VARCHAR(255) NULL,
    user_id BIGINT NULL,
    CONSTRAINT pk_post PRIMARY KEY (post_id)
);

CREATE TABLE roles
(
    id   INT AUTO_INCREMENT NOT NULL,
    name VARCHAR(20) NULL,
    CONSTRAINT pk_roles PRIMARY KEY (id)
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
    last_login             datetime NULL,
    user_account_status_id BIGINT NULL,
    user_tag_id            BIGINT NULL,
    user_name              VARCHAR(255) NULL,
    CONSTRAINT pk_user PRIMARY KEY (user_id)
);

CREATE TABLE user_roles
(
    role_id INT    NOT NULL,
    user_id BIGINT NOT NULL,
    CONSTRAINT pk_user_roles PRIMARY KEY (role_id, user_id)
);

ALTER TABLE file_data
    ADD CONSTRAINT FK_FILE_DATA_ON_POST FOREIGN KEY (post_id) REFERENCES post (post_id);

ALTER TABLE post
    ADD CONSTRAINT FK_POST_ON_USER FOREIGN KEY (user_id) REFERENCES user (user_id);

ALTER TABLE message_tag_mapping
    ADD CONSTRAINT fk_mestagmap_on_message_tag FOREIGN KEY (tag_id) REFERENCES message_tag (message_tag_id);

ALTER TABLE message_tag_mapping
    ADD CONSTRAINT fk_mestagmap_on_post FOREIGN KEY (post_id) REFERENCES post (post_id);

ALTER TABLE user_roles
    ADD CONSTRAINT fk_userol_on_role FOREIGN KEY (role_id) REFERENCES roles (id);

ALTER TABLE user_roles
    ADD CONSTRAINT fk_userol_on_user FOREIGN KEY (user_id) REFERENCES user (user_id);