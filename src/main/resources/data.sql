insert into authorities (authority)
values ('ROLE_USER'),
       ('ROLE_ADMIN');

insert into users(username, password, registration_date, account_non_locked)
values ('user1', '$2a$10$WrnhoySfhv8XQMdjMCf5T.1IWFtH15a.FX74tsN63pKyWXM5V1Bzu', now(), true),
       ('user2', '$2a$10$WrnhoySfhv8XQMdjMCf5T.1IWFtH15a.FX74tsN63pKyWXM5V1Bzu', now(), true),
       ('user3', '$2a$10$WrnhoySfhv8XQMdjMCf5T.1IWFtH15a.FX74tsN63pKyWXM5V1Bzu', now(), true),
       ('user4', '$2a$10$WrnhoySfhv8XQMdjMCf5T.1IWFtH15a.FX74tsN63pKyWXM5V1Bzu', now(), true),
       ('user5', '$2a$10$WrnhoySfhv8XQMdjMCf5T.1IWFtH15a.FX74tsN63pKyWXM5V1Bzu', now(), true),
       ('user6', '$2a$10$WrnhoySfhv8XQMdjMCf5T.1IWFtH15a.FX74tsN63pKyWXM5V1Bzu', now(), true),
       ('user7', '$2a$10$WrnhoySfhv8XQMdjMCf5T.1IWFtH15a.FX74tsN63pKyWXM5V1Bzu', now(), true),
       ('user8', '$2a$10$WrnhoySfhv8XQMdjMCf5T.1IWFtH15a.FX74tsN63pKyWXM5V1Bzu', now(), true),
       ('user9', '$2a$10$WrnhoySfhv8XQMdjMCf5T.1IWFtH15a.FX74tsN63pKyWXM5V1Bzu', now(), true),
       ('user10', '$2a$10$WrnhoySfhv8XQMdjMCf5T.1IWFtH15a.FX74tsN63pKyWXM5V1Bzu', now(), true),
       ('user11', '$2a$10$WrnhoySfhv8XQMdjMCf5T.1IWFtH15a.FX74tsN63pKyWXM5V1Bzu', now(), true),
       ('user12', '$2a$10$WrnhoySfhv8XQMdjMCf5T.1IWFtH15a.FX74tsN63pKyWXM5V1Bzu', now(), true),
       ('user13', '$2a$10$WrnhoySfhv8XQMdjMCf5T.1IWFtH15a.FX74tsN63pKyWXM5V1Bzu', now(), true);

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
       (13, 1);
