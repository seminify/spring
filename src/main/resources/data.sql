-- mysqldump -uroot -pMYSQL_ROOT_PASSWORD --no-create-info --complete-insert MYSQL_DATABASE > data.sql
INSERT INTO
  `authority` (`id`, `authority`, `order`)
VALUES
  (1, 'ROLE_ADMIN', 3),
  (2, 'ROLE_USER', 2),
  (3, 'ROLE_ANONYMOUS', 1);

INSERT INTO
  `nav` (
    `id`,
    `nav_id`,
    `authority_id`,
    `title`,
    `src`,
    `order`
  )
VALUES
  (1, NULL, 2, 'user', '/user', 7),
  (2, 1, 2, 'user/todo', '/user/todo', 6),
  (3, NULL, 1, 'admin', '/admin', 5),
  (4, 3, 1, 'admin/authority', '/admin/authority', 4),
  (5, 3, 1, 'admin/nav', '/admin/nav', 3),
  (6, 3, 1, 'admin/user', '/admin/user', 2),
  (
    7,
    6,
    1,
    'admin/user/authority',
    '/admin/user/authority',
    1
  );

INSERT INTO
  `user` (`id`, `username`, `password`)
VALUES
  (
    1,
    'admin',
    '$2a$10$TQvSjapCjxnufCPLndExNuBCnbxUMcSfMQyOqLhUDagtPHxXz1Qd2'
  ),
  (
    2,
    'user',
    '$2a$10$TQvSjapCjxnufCPLndExNuBCnbxUMcSfMQyOqLhUDagtPHxXz1Qd2'
  );

INSERT INTO
  `user_authority` (`id`, `user_id`, `authority_id`)
VALUES
  (1, 1, 1),
  (2, 2, 2);
