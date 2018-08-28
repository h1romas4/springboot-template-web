CREATE TABLE m_user (
    id      SERIAL,
    name    varchar(40)     default NULL,
    attr    varchar(100)    default NULL,
    created timestamp       default current_timestamp,
    updated timestamp       default current_timestamp,
    PRIMARY KEY (id)
)
