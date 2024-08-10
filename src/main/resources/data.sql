-- Computing
INSERT INTO books (title, category, copies, available) VALUES ('Introduction to Algorithms', 'Informática', 5, true);
INSERT INTO books (title, category, copies, available) VALUES ('Computer Networking', 'Informática', 3, true);
INSERT INTO books (title, category, copies, available) VALUES ('Data Structures and Algorithms', 'Informática', 4, false);
INSERT INTO books (title, category, copies, available) VALUES ('The Art of Computer Programming', 'Informática', 4, true);

-- Literature
INSERT INTO books (title, category, copies, available) VALUES ('To Kill a Mockingbird', 'Literatura', 2, true);
INSERT INTO books (title, category, copies, available) VALUES ('1984', 'Literatura', 6, true);
INSERT INTO books (title, category, copies, available) VALUES ('Pride and Prejudice', 'Literatura', 3, false);
INSERT INTO books (title, category, copies, available) VALUES ('The Catcher in the Rye', 'Literatura', 5, false);

-- Science
INSERT INTO books (title, category, copies, available) VALUES ('A Brief History of Time', 'Ciência', 4, true);
INSERT INTO books (title, category, copies, available) VALUES ('The Selfish Gene', 'Ciência', 5, true);
INSERT INTO books (title, category, copies, available) VALUES ('The Origin of Species', 'Ciência', 2, false);
INSERT INTO books (title, category, copies, available) VALUES ('The Gene: An Intimate History', 'Ciência', 3, true);

-- History
INSERT INTO books (title, category, copies, available) VALUES ('Sapiens: A Brief History of Humankind', 'História', 4, true);
INSERT INTO books (title, category, copies, available) VALUES ('Guns, Germs, and Steel', 'História', 3, true);
INSERT INTO books (title, category, copies, available) VALUES ('The History of the Ancient World', 'História', 6, false);
INSERT INTO books (title, category, copies, available) VALUES ('The Silk Roads', 'História', 6, true);

-- Philosophy
INSERT INTO books (title, category, copies, available) VALUES ('Meditations', 'Filosofia', 5, true);
INSERT INTO books (title, category, copies, available) VALUES ('The Republic', 'Filosofia', 3, true);
INSERT INTO books (title, category, copies, available) VALUES ('Nicomachean Ethics', 'Filosofia', 2, false);
INSERT INTO books (title, category, copies, available) VALUES ('Beyond Good and Evil', 'Filosofia', 3, true);

-- Biography
INSERT INTO books (title, category, copies, available) VALUES ('The Diary of a Young Girl', 'Biografia', 4, true);
INSERT INTO books (title, category, copies, available) VALUES ('Long Walk to Freedom', 'Biografia', 3, true);
INSERT INTO books (title, category, copies, available) VALUES ('Steve Jobs', 'Biografia', 5, false);
INSERT INTO books (title, category, copies, available) VALUES ('Becoming', 'Biografia', 2, true);

-- Users
INSERT INTO auth_user (username, email, password, role, created_at, user_status, user_status_changed_at)
VALUES
('john.doe', 'john.doe@example.com', 'teste', 'ROLE_USER', CURRENT_TIMESTAMP - INTERVAL '1' DAY, TRUE, CURRENT_TIMESTAMP - INTERVAL '1' DAY),
('jane.smith', 'jane.smith@example.com', 'teste', 'ROLE_ADMIN', CURRENT_TIMESTAMP - INTERVAL '2' DAY, FALSE, CURRENT_TIMESTAMP - INTERVAL '2' DAY),
('michael.johnson', 'michael.johnson@example.com', 'teste', 'ROLE_USER', CURRENT_TIMESTAMP - INTERVAL '3' DAY, TRUE, CURRENT_TIMESTAMP - INTERVAL '3' DAY),
('emily.davis', 'emily.davis@example.com', 'teste', 'ROLE_USER', CURRENT_TIMESTAMP - INTERVAL '4' DAY, FALSE, CURRENT_TIMESTAMP - INTERVAL '4' DAY),
('william.brown', 'william.brown@example.com', 'teste', 'ROLE_ADMIN', CURRENT_TIMESTAMP - INTERVAL '5' DAY, TRUE, CURRENT_TIMESTAMP - INTERVAL '5' DAY),
('olivia.martin', 'olivia.martin@example.com', 'teste', 'ROLE_USER', CURRENT_TIMESTAMP - INTERVAL '6' DAY, FALSE, CURRENT_TIMESTAMP - INTERVAL '6' DAY),
('james.miller', 'james.miller@example.com', 'teste', 'ROLE_ADMIN', CURRENT_TIMESTAMP - INTERVAL '7' DAY, TRUE, CURRENT_TIMESTAMP - INTERVAL '7' DAY),
('sophia.wilson', 'sophia.wilson@example.com', 'teste', 'ROLE_USER', CURRENT_TIMESTAMP - INTERVAL '8' DAY, FALSE, CURRENT_TIMESTAMP - INTERVAL '8' DAY),
('benjamin.moore', 'benjamin.moore@example.com', 'teste', 'ROLE_USER', CURRENT_TIMESTAMP - INTERVAL '9' DAY, TRUE, CURRENT_TIMESTAMP - INTERVAL '9' DAY),
('ava.taylor', 'ava.taylor@example.com', 'teste', 'ROLE_ADMIN', CURRENT_TIMESTAMP - INTERVAL '10' DAY, FALSE, CURRENT_TIMESTAMP - INTERVAL '10' DAY),
('lucas.anderson', 'lucas.anderson@example.com', 'teste', 'ROLE_USER', CURRENT_TIMESTAMP - INTERVAL '11' DAY, TRUE, CURRENT_TIMESTAMP - INTERVAL '11' DAY),
('mia.jackson', 'mia.jackson@example.com', 'teste', 'ROLE_ADMIN', CURRENT_TIMESTAMP - INTERVAL '12' DAY, FALSE, CURRENT_TIMESTAMP - INTERVAL '12' DAY),
('noah.white', 'noah.white@example.com', 'teste', 'ROLE_USER', CURRENT_TIMESTAMP - INTERVAL '13' DAY, TRUE, CURRENT_TIMESTAMP - INTERVAL '13' DAY),
('isabella.harris', 'isabella.harris@example.com', 'teste', 'ROLE_ADMIN', CURRENT_TIMESTAMP - INTERVAL '14' DAY, FALSE, CURRENT_TIMESTAMP - INTERVAL '14' DAY),
('ethan.clark', 'ethan.clark@example.com', 'teste', 'ROLE_USER', CURRENT_TIMESTAMP - INTERVAL '15' DAY, TRUE, CURRENT_TIMESTAMP - INTERVAL '15' DAY),
('charlotte.lewis', 'charlotte.lewis@example.com', 'teste', 'ROLE_ADMIN', CURRENT_TIMESTAMP - INTERVAL '16' DAY, FALSE, CURRENT_TIMESTAMP - INTERVAL '16' DAY),
('aiden.walker', 'aiden.walker@example.com', 'teste', 'ROLE_USER', CURRENT_TIMESTAMP - INTERVAL '17' DAY, TRUE, CURRENT_TIMESTAMP - INTERVAL '17' DAY),
('abigail.rodriguez', 'abigail.rodriguez@example.com', 'teste', 'ROLE_ADMIN', CURRENT_TIMESTAMP - INTERVAL '18' DAY, FALSE, CURRENT_TIMESTAMP - INTERVAL '18' DAY),
('jack.young', 'jack.young@example.com', 'teste', 'ROLE_USER', CURRENT_TIMESTAMP - INTERVAL '19' DAY, TRUE, CURRENT_TIMESTAMP - INTERVAL '19' DAY),
('emily.allen', 'emily.allen@example.com', 'teste', 'ROLE_ADMIN', CURRENT_TIMESTAMP - INTERVAL '20' DAY, FALSE, CURRENT_TIMESTAMP - INTERVAL '20' DAY),
('daniel.scott', 'daniel.scott@example.com', 'teste', 'ROLE_USER', CURRENT_TIMESTAMP - INTERVAL '21' DAY, TRUE, CURRENT_TIMESTAMP - INTERVAL '21' DAY),
('harper.james', 'harper.james@example.com', 'teste', 'ROLE_ADMIN', CURRENT_TIMESTAMP - INTERVAL '22' DAY, FALSE, CURRENT_TIMESTAMP - INTERVAL '22' DAY),
('matthew.hernandez', 'matthew.hernandez@example.com', 'teste', 'ROLE_USER', CURRENT_TIMESTAMP - INTERVAL '23' DAY, TRUE, CURRENT_TIMESTAMP - INTERVAL '23' DAY),
('ava.martinez', 'ava.martinez@example.com', 'teste', 'ROLE_ADMIN', CURRENT_TIMESTAMP - INTERVAL '24' DAY, FALSE, CURRENT_TIMESTAMP - INTERVAL '24' DAY),
('joseph.king', 'joseph.king@example.com', 'teste', 'ROLE_USER', CURRENT_TIMESTAMP - INTERVAL '25' DAY, TRUE, CURRENT_TIMESTAMP - INTERVAL '25' DAY),
('lucy.garcia', 'lucy.garcia@example.com', 'teste', 'ROLE_ADMIN', CURRENT_TIMESTAMP - INTERVAL '26' DAY, FALSE, CURRENT_TIMESTAMP - INTERVAL '26' DAY),
('sebastian.taylor', 'sebastian.taylor@example.com', 'teste', 'ROLE_USER', CURRENT_TIMESTAMP - INTERVAL '27' DAY, TRUE, CURRENT_TIMESTAMP - INTERVAL '27' DAY),
('ella.carter', 'ella.carter@example.com', 'teste', 'ROLE_ADMIN', CURRENT_TIMESTAMP - INTERVAL '28' DAY, FALSE, CURRENT_TIMESTAMP - INTERVAL '28' DAY),
('alexander.martin', 'alexander.martin@example.com', 'teste', 'ROLE_USER', CURRENT_TIMESTAMP - INTERVAL '29' DAY, TRUE, CURRENT_TIMESTAMP - INTERVAL '29' DAY),
('avery.perez', 'avery.perez@example.com', 'teste', 'ROLE_ADMIN', CURRENT_TIMESTAMP - INTERVAL '30' DAY, FALSE, CURRENT_TIMESTAMP - INTERVAL '30' DAY);


-- Testing
INSERT INTO auth_user (username, email, password, role, created_at, user_status, user_status_changed_at)
VALUES ('bruno.ribeiro', 'bruno.miguel.rib@gmail.com', '$2a$10$VfBrtQ4QPc7wZuY6txhdpOO.jaeu.MFd1dlL2j99/zw5GzIBhIbem', 'admin', CURRENT_TIMESTAMP - INTERVAL '30' DAY, FALSE, CURRENT_TIMESTAMP - INTERVAL '31' DAY);


-- Livro 1
INSERT INTO reservations (user_id, book_id, reserved_at, status, status_changed_at)
VALUES (31, 1, '2024-07-01 10:00:00', 'rented', '2024-07-07 10:00:00');

-- Livro 2
INSERT INTO reservations (user_id, book_id, reserved_at, status, status_changed_at)
VALUES (31, 2, '2024-07-05 15:00:00', 'returned', '2024-07-10 15:00:00');

-- Livro 3
INSERT INTO reservations (user_id, book_id, reserved_at, status, status_changed_at)
VALUES (31, 3, '2024-07-10 09:00:00', 'rented', '2024-07-15 09:00:00');

-- Livro 4
INSERT INTO reservations (user_id, book_id, reserved_at, status, status_changed_at)
VALUES (31, 4, '2024-07-12 11:00:00', 'returned', '2024-07-20 11:00:00');

-- Livro 5
INSERT INTO reservations (user_id, book_id, reserved_at, status, status_changed_at)
VALUES (31, 5, '2024-07-15 14:00:00', 'rented', '2024-07-25 14:00:00');

-- Livro 6
INSERT INTO reservations (user_id, book_id, reserved_at, status, status_changed_at)
VALUES (31, 6, '2024-07-18 16:00:00', 'returned', '2024-07-30 16:00:00');

-- Livro 7
INSERT INTO reservations (user_id, book_id, reserved_at, status, status_changed_at)
VALUES (31, 7, '2024-07-20 10:00:00', 'rented', '2024-08-05 10:00:00');

-- Livro 8
INSERT INTO reservations (user_id, book_id, reserved_at, status, status_changed_at)
VALUES (31, 8, '2024-07-22 12:00:00', 'returned', '2024-08-10 12:00:00');

-- Livro 9
INSERT INTO reservations (user_id, book_id, reserved_at, status, status_changed_at)
VALUES (31, 9, '2024-07-25 08:00:00', 'rented', '2024-08-15 08:00:00');

-- Livro 10
INSERT INTO reservations (user_id, book_id, reserved_at, status, status_changed_at)
VALUES (31, 10, '2024-07-28 13:00:00', 'returned', '2024-08-20 13:00:00');
