CREATE TABLE student
(
    student_id              UUID PRIMARY KEY DEFAULT uuid_generate_v4(), -- Separate ID for students
    user_id         UUID         NOT NULL,
    major           VARCHAR(100) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);