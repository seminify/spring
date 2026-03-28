-- mysqldump -uroot -pMYSQL_ROOT_PASSWORD --no-create-info --complete-insert MYSQL_DATABASE > data.sql
INSERT INTO
  `authority` (`id`, `authority`, `order`)
VALUES
  (1, 'ROLE_ADMIN', 3),
  (2, 'ROLE_USER', 2),
  (3, 'ROLE_ANONYMOUS', 1);

INSERT INTO
  `header` (
    `id`,
    `header_id`,
    `authority_id`,
    `title`,
    `src`,
    `order`
  )
VALUES
  (1, NULL, 1, 'admin', '/admin', 5),
  (2, 1, 1, 'admin/authority', '/admin/authority', 4),
  (3, 1, 1, 'admin/header', '/admin/header', 3),
  (4, 1, 1, 'admin/user', '/admin/user', 2),
  (
    5,
    4,
    1,
    'admin/user/authority',
    '/admin/user/authority',
    1
  );

INSERT INTO
  `user` (`id`, `password`, `username`)
VALUES
  (
    1,
    '$2a$10$TQvSjapCjxnufCPLndExNuBCnbxUMcSfMQyOqLhUDagtPHxXz1Qd2',
    'admin'
  );

INSERT INTO
  `user_authority` (`id`, `user_id`, `authority_id`)
VALUES
  (1, 1, 1);
