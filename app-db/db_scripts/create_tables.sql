CREATE TABLE IF NOT EXISTS skillhub.profiles
(
    id           serial PRIMARY KEY,
    first_name   VARCHAR NOT NULL,
    last_name    VARCHAR NOT NULL,
    title        VARCHAR,
    team         VARCHAR,
    about        TEXT,
    skills       JSONB,
    certificates JSONB
);