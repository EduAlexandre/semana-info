
CREATE TABLE `groups` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `groups`(`nome`) VALUES  ('Admin');
INSERT INTO `groups`(`nome`) VALUES  ('Manager');
INSERT INTO `groups`(`nome`) VALUES  ('Speaker');
INSERT INTO `groups`(`nome`) VALUES  ('Participants');


CREATE TABLE `permissions` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;


INSERT INTO `permissions`(`nome`) VALUES ('CADASTRAR_GESTOR');
INSERT INTO `permissions`(`nome`) VALUES ('LISTAR_GESTOR');
INSERT INTO `permissions`(`nome`) VALUES ('CADASTRAR_PALESTRANTE');
INSERT INTO `permissions`(`nome`) VALUES ('LISTAR_PALESTRANTE');
INSERT INTO `permissions`(`nome`) VALUES ('CADASTRAR_USUARIO');
INSERT INTO `permissions`(`nome`) VALUES ('LISTAR_USUARIO');
INSERT INTO `permissions`(`nome`) VALUES ('CADASTRAR_PALESTRA');
INSERT INTO `permissions`(`nome`) VALUES ('LISTAR_PALESTRA');
INSERT INTO `permissions`(`nome`) VALUES ('CANCELAR_PART');
INSERT INTO `permissions`(`nome`) VALUES ('ATUALIZAR_STATUS');
INSERT INTO `permissions`(`nome`) VALUES ('AREA_ADMIN');
INSERT INTO `permissions`(`nome`) VALUES ('AREA_GESTOR');
INSERT INTO `permissions`(`nome`) VALUES ('AREA_PALESTRANTE');
INSERT INTO `permissions`(`nome`) VALUES ('AREA_USUARIO');

CREATE TABLE `groups_permissions` (
  `id_group` bigint(20) NOT NULL,
  `id_permissions` bigint(20) NOT NULL,
  PRIMARY KEY (`id_group`,`id_permissions`),
  KEY `FKm71l9ko0sgn2sx6cwkf8kh5j9` (`id_permissions`),
  CONSTRAINT `FKaj2j3yor1sn7us49np3cyo5wl` FOREIGN KEY (`id_group`) REFERENCES `groups` (`id`),
  CONSTRAINT `FKm71l9ko0sgn2sx6cwkf8kh5j9` FOREIGN KEY (`id_permissions`) REFERENCES `permissions` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `groups_permissions` VALUES (1,1);
INSERT INTO `groups_permissions` VALUES (3,1);
INSERT INTO `groups_permissions` VALUES (1,2);
INSERT INTO `groups_permissions` VALUES (3,2);
INSERT INTO `groups_permissions` VALUES (1,3);
INSERT INTO `groups_permissions` VALUES (2,3);
INSERT INTO `groups_permissions` VALUES (1,4);
INSERT INTO `groups_permissions` VALUES (2,4);
INSERT INTO `groups_permissions` VALUES (1,5);
INSERT INTO `groups_permissions` VALUES (1,6);
INSERT INTO `groups_permissions` VALUES (1,7);
INSERT INTO `groups_permissions` VALUES (2,7);
INSERT INTO `groups_permissions` VALUES (1,8);
INSERT INTO `groups_permissions` VALUES (2,8);
INSERT INTO `groups_permissions` VALUES (4,8);
INSERT INTO `groups_permissions` VALUES (1,9);
INSERT INTO `groups_permissions` VALUES (1,10);
INSERT INTO `groups_permissions` VALUES (2,10);
INSERT INTO `groups_permissions` VALUES (1,11);
INSERT INTO `groups_permissions` VALUES (1,12);
INSERT INTO `groups_permissions` VALUES (2,12);
INSERT INTO `groups_permissions` VALUES (1,13);
INSERT INTO `groups_permissions` VALUES (3,13);
INSERT INTO `groups_permissions` VALUES (1,14);
INSERT INTO `groups_permissions` VALUES (4,14);


CREATE TABLE `room` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

INSERT INTO `room`(`nome`) VALUES ('Sala 01');
INSERT INTO `room`(`nome`) VALUES ('Sala 02');
INSERT INTO `room`(`nome`) VALUES ('Sala 03');
INSERT INTO `room`(`nome`) VALUES ('Sala 04');
INSERT INTO `room`(`nome`) VALUES ('Sala 05');
INSERT INTO `room`(`nome`) VALUES ('Sala 06');
INSERT INTO `room`(`nome`) VALUES ('Sala 07');
INSERT INTO `room`(`nome`) VALUES ('Sala 08');
INSERT INTO `room`(`nome`) VALUES ('Auditório');


CREATE TABLE `user_model` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `cod_grup` int(11) NOT NULL,
  `cpf` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_la8xty622mpbfdhq2iixt9lhu` (`email`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;


INSERT INTO `user_model`(`active`,`email`, `name`, `password`, `cod_grup`, `cpf`) VALUES (1,'ifpe@gmail.com', 'Admin', '$2a$10$TcHINGZJbi64wSjFdJYIo.lPlI1KSyHLpP6eWb9AsmRPifwUKoUbG', '1', 'Não informado');

UPDATE `user_model` SET `active` = true WHERE (`id` = '1');





CREATE TABLE `activity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount_vacancies` int(11) NOT NULL,
  `name_event` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `data` varchar(255) DEFAULT NULL,
  `room` varchar(255) DEFAULT NULL,
  `speaker` varchar(255) DEFAULT NULL,
  `time_fim` varchar(255) DEFAULT NULL,
  `time_ini` varchar(255) DEFAULT NULL,
  `duracao`  varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;


CREATE TABLE `registrations` (
  `id_registration` int(11) NOT NULL AUTO_INCREMENT,
  `time_ini_activy` varchar(255) DEFAULT NULL,
  `activity_id` int(11) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `presenca` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id_registration`),
  KEY `FKedlyh8d29976nq7j2gyhjecbo` (`activity_id`),
  KEY `FKrn1ikib33h9pyku93jyusdioy` (`user_id`),
  CONSTRAINT `FKedlyh8d29976nq7j2gyhjecbo` FOREIGN KEY (`activity_id`) REFERENCES `activity` (`id`),
  CONSTRAINT `FKrn1ikib33h9pyku93jyusdioy` FOREIGN KEY (`user_id`) REFERENCES `user_model` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;


CREATE TABLE `user_groups` (
 `id` bigint(20) NOT NULL AUTO_INCREMENT,
 `id_group` bigint(20) NOT NULL, 
 `id_user` bigint(20) NOT NULL,  
  PRIMARY KEY (`id`),
  KEY `FKjphvwvn8nahsmtrq1166birpv` (`id_group`),
  KEY `FKpapfixqqro3n8ln7bd2n8uvya` (`id_user`),
  CONSTRAINT `FKjphvwvn8nahsmtrq1166birpv` FOREIGN KEY (`id_group`) REFERENCES `groups` (`id`),
  CONSTRAINT `FKpapfixqqro3n8ln7bd2n8uvya` FOREIGN KEY (`id_user`) REFERENCES `user_model` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;


INSERT INTO `user_groups`(`id_user`,`id_group`) VALUES(1, 1);



















