INSERT INTO auth_user
(username, password, algorithm)
VALUES
('vasyuk.maksim', '$2y$10$JTCOd8FDUEg6EwuVzFCb3O53RXCVIlr0g32J62JtD1NwOtl5vWXCO', 'BCRYPT');

INSERT INTO authority
(name, auth_user)
VALUES
('READ', '1');

INSERT INTO Box
(name)
VALUES
('Входящие'),
('Сегодня'),
('На неделе'),
('Позже');

INSERT INTO task
(subject)
VALUES
('Заменить принтер'),
('Установить телефон'),
('Посмотреть СБИС');

INSERT INTO job
(task, box)
VALUES
(1, 2),
(2, 3),
(3, 4);
