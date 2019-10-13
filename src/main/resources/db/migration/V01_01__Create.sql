CREATE TABLE m_user (
    user_id     SERIAL,
    email       VARCHAR(512)    NOT NULL,
    name        VARCHAR(512)    NOT NULL,
    role        VARCHAR(20)     NOT NULL,
    password    VARCHAR(60)     NOT NULL,
    PRIMARY KEY (user_id),
    UNIQUE (email)
)
