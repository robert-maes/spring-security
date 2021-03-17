INSERT into users (username, password, enabled)
values('user', '$2a$10$1GvDNviK2wYho51TrXXrQe4AwVaRtlDxunXCE7xfem6gNRsfFv9HS',true);

INSERT into users (username, password, enabled)
values('admin', '$2a$10$1GvDNviK2wYho51TrXXrQe4AwVaRtlDxunXCE7xfem6gNRsfFv9HS',true);

insert into authorities (username, authority)
values('user', 'ROLE_USER');

insert into authorities (username, authority)
values('admin', 'ROLE_ADMIN');