-- mysqldump -uroot -pMYSQL_ROOT_PASSWORD --no-create-info --complete-insert MYSQL_DATABASE > data.sql
INSERT INTO `authority` (`id`, `authority`)
VALUES (1, 'ADMIN'),
    (2, 'USER');
INSERT INTO `header` (`id`, `header`, `src`, `authority_id`)
VALUES (1, 'user', 'user', 2);
INSERT INTO `user` (`id`, `password`, `username`)
VALUES (
        1,
        '$2a$10$TQvSjapCjxnufCPLndExNuBCnbxUMcSfMQyOqLhUDagtPHxXz1Qd2',
        'admin'
    );
INSERT INTO `user_authority` (`id`, `user_id`, `authority_id`)
VALUES (1, 1, 1);