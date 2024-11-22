CREATE TABLE teacher
(
    teacher_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(), -- Separate ID for teachers
    user_id    UUID         NOT NULL,
    hire_date  DATE         NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE ON UPDATE CASCADE
);