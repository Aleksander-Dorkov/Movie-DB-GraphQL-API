insert into authorities (authority_id, authority)
values (nextval('authority_seq'), 'ROLE_USER_FREE'),
       (nextval('authority_seq'), 'ROLE_USER_PAID'),
       (nextval('authority_seq'), 'ROLE_ADMIN');

insert into users(user_id, username, password, registration_date, account_non_locked)
values (nextval('user_seq'), 'demo_free_account', '$2a$10$SiRr.soEFLATu6/d.6Tyzu6U20S0DaItwzPyyWRpsmAt/gqTgLXhe', now(),
        true),
       (nextval('user_seq'), 'user2', '$2a$10$SiRr.soEFLATu6/d.6Tyzu6U20S0DaItwzPyyWRpsmAt/gqTgLXhe', now(), true),
       (nextval('user_seq'), 'user3', '$2a$10$SiRr.soEFLATu6/d.6Tyzu6U20S0DaItwzPyyWRpsmAt/gqTgLXhe', now(), true),
       (nextval('user_seq'), 'user4', '$2a$10$SiRr.soEFLATu6/d.6Tyzu6U20S0DaItwzPyyWRpsmAt/gqTgLXhe', now(), true),
       (nextval('user_seq'), 'user5', '$2a$10$SiRr.soEFLATu6/d.6Tyzu6U20S0DaItwzPyyWRpsmAt/gqTgLXhe', now(), true),
       (nextval('user_seq'), 'user6', '$2a$10$SiRr.soEFLATu6/d.6Tyzu6U20S0DaItwzPyyWRpsmAt/gqTgLXhe', now(), true),
       (nextval('user_seq'), 'user7', '$2a$10$SiRr.soEFLATu6/d.6Tyzu6U20S0DaItwzPyyWRpsmAt/gqTgLXhe', now(), true),
       (nextval('user_seq'), 'user8', '$2a$10$SiRr.soEFLATu6/d.6Tyzu6U20S0DaItwzPyyWRpsmAt/gqTgLXhe', now(), true),
       (nextval('user_seq'), 'user9', '$2a$10$SiRr.soEFLATu6/d.6Tyzu6U20S0DaItwzPyyWRpsmAt/gqTgLXhe', now(), true),
       (nextval('user_seq'), 'user10', '$2a$10$SiRr.soEFLATu6/d.6Tyzu6U20S0DaItwzPyyWRpsmAt/gqTgLXhe', now(), true),
       (nextval('user_seq'), 'user11', '$2a$10$SiRr.soEFLATu6/d.6Tyzu6U20S0DaItwzPyyWRpsmAt/gqTgLXhe', now(), true),
       (nextval('user_seq'), 'user12', '$2a$10$SiRr.soEFLATu6/d.6Tyzu6U20S0DaItwzPyyWRpsmAt/gqTgLXhe', now(), true),
       (nextval('user_seq'), 'user13', '$2a$10$SiRr.soEFLATu6/d.6Tyzu6U20S0DaItwzPyyWRpsmAt/gqTgLXhe', now(), true),
       (nextval('user_seq'), 'demo_paid_account', '$2a$10$SiRr.soEFLATu6/d.6Tyzu6U20S0DaItwzPyyWRpsmAt/gqTgLXhe', now(),
        true),
       (nextval('user_seq'), 'demo_admin', '$2a$10$SiRr.soEFLATu6/d.6Tyzu6U20S0DaItwzPyyWRpsmAt/gqTgLXhe', now(), true);

insert into users_authorities(user_id, authority_id)
VALUES (1, 1),
       (2, 1),
       (3, 1),
       (4, 1),
       (5, 1),
       (6, 1),
       (7, 1),
       (8, 1),
       (9, 1),
       (10, 1),
       (11, 1),
       (12, 1),
       (13, 1),
       (14, 2),
       (15, 3);


