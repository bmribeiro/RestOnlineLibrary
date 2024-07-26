-- Script 1 - User
INSERT INTO users (username, email, profile, created, active)
VALUES ('John Doe', 'john.doe@example.com', 'ADMIN', DATEADD('DAY', FLOOR(RAND() * 365), '2022-01-01'), true);

-- Script 2 - User
INSERT INTO users (username, email, profile, created, active)
VALUES ('Jane Smith', 'jane.smith@example.com', 'USER', DATEADD('DAY', FLOOR(RAND() * 365), '2022-01-01'), true);

-- Script 3 - User
INSERT INTO users (username, email, profile, created, active)
VALUES ('Michael Johnson', 'michael.johnson@example.com', 'GUEST', DATEADD('DAY', FLOOR(RAND() * 365), '2022-01-01'), true);

-- Script 4 - User
INSERT INTO users (username, email, profile, created, active)
VALUES ('Emily Davis', 'emily.davis@example.com', 'ADMIN', DATEADD('DAY', FLOOR(RAND() * 365), '2022-01-01'), false);

-- Script 5 - User
INSERT INTO users (username, email, profile, created, active)
VALUES ('Daniel Wilson', 'daniel.wilson@example.com', 'USER', DATEADD('DAY', FLOOR(RAND() * 365), '2022-01-01'), true);

-- Script 6 - User
INSERT INTO users (username, email, profile, created, active)
VALUES ('Sophia Clark', 'sophia.clark@example.com', 'GUEST', DATEADD('DAY', FLOOR(RAND() * 365), '2022-01-01'), false);

-- Script 7 - User
INSERT INTO users (username, email, profile, created, active)
VALUES ('Matthew Anderson', 'matthew.anderson@example.com', 'ADMIN', DATEADD('DAY', FLOOR(RAND() * 365), '2022-01-01'), false);

-- Script 8 - User
INSERT INTO users (username, email, profile, created, active)
VALUES ('Olivia Garcia', 'olivia.garcia@example.com', 'USER', DATEADD('DAY', FLOOR(RAND() * 365), '2022-01-01'), true);

-- Script 9 - User
INSERT INTO users (username, email, profile, created, active)
VALUES ('David Martinez', 'david.martinez@example.com', 'GUEST', DATEADD('DAY', FLOOR(RAND() * 365), '2022-01-01'), true);

-- Script 10 - User
INSERT INTO users (username, email, profile, created, active)
VALUES ('Emma Hernandez', 'emma.hernandez@example.com', 'ADMIN', DATEADD('DAY', FLOOR(RAND() * 365), '2022-01-01'), true);

-- Script 1 - Book
INSERT INTO books (title, category, copies, available)
VALUES ('Introduction to Algorithms', 'Informática', 5, true);

-- Script 2 - Book
INSERT INTO books (title, category, copies, available)
VALUES ('Artificial Intelligence: A Modern Approach', 'Informática', 3, true);

-- Script 3 - Book
INSERT INTO books (title, category, copies, available)
VALUES ('Computer Networks', 'Informática', 4, true);

-- Script 4 - Book
INSERT INTO books (title, category, copies, available)
VALUES ('Operating System Concepts', 'Informática', 2, false);

-- Script 5 - Book
INSERT INTO books (title, category, copies, available)
VALUES ('Data Science from Scratch', 'Informática', 6, true);

-- Script 6 - Book
INSERT INTO books (title, category, copies, available)
VALUES ('The Selfish Gene', 'Ciências', 7, true);

-- Script 7 - Book
INSERT INTO books (title, category, copies, available)
VALUES ('A Brief History of Time', 'Ciências', 5, true);

-- Script 8 - Book
INSERT INTO books (title, category, copies, available)
VALUES ('The Gene: An Intimate History', 'Ciências', 3, false);

-- Script 9 - Book
INSERT INTO books (title, category, copies, available)
VALUES ('The Origin of Species', 'Ciências', 4, true);

-- Script 10 - Book
INSERT INTO books (title, category, copies, available)
VALUES ('Cosmos', 'Ciências', 6, true);


