CREATE TABLE course
(
    course_id          UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name        VARCHAR(100) NOT NULL,
    description TEXT,
    credits     INT          NOT NULL,
    course_url  VARCHAR(255) NOT NULL,
    duration    INT          NOT NULL
);