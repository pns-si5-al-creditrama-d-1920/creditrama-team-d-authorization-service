CREATE TABLE IF NOT EXISTS oauth_client_details (
  client_id VARCHAR(256) PRIMARY KEY,
  resource_ids VARCHAR(256),
  client_secret VARCHAR(256),
  scope VARCHAR(256),
  authorized_grant_types VARCHAR(256),
  web_server_redirect_uri VARCHAR(256),
  authorities VARCHAR(256),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additional_information VARCHAR(4096),
  autoapprove VARCHAR(256)
);
/*
-- PERMISSION AND USER
CREATE SEQUENCE IF NOT EXISTS  permission_seq;

create table if not exists  permission (
  id int not null default nextval ('permission_seq'),
  permission_name varchar(512) default null,
  primary key (id),
  constraint permission_name unique (permission_name)
)  ;

CREATE SEQUENCE IF NOT EXISTS  role_seq;

create table if not exists role (
  id int not null default nextval ('role_seq'),
  role_name varchar(255) default null,
  primary key (id),
  constraint role_name unique (role_name)
)  ;

CREATE SEQUENCE IF NOT EXISTS  user_seq;
create table if not exists user_creditrama (
  id int not null default nextval ('user_seq'),
  username varchar(100) not null,
  password varchar(1024) not null,
  email varchar(1024) not null,
  enabled smallint not null,
  accountNonExpired smallint not null,
  credentialsNonExpired smallint not null,
  accountNonLocked smallint not null,
  primary key (id),
  constraint username unique (username)
);


create table  if not exists permission_role (
  permission_id int default null,
  role_id int default null
 ,
  constraint permission_role_ibfk_1 foreign key (permission_id) references permission (id),
  constraint permission_role_ibfk_2 foreign key (role_id) references role (id)
)  ;

CREATE INDEX IF NOT EXISTS permission_id on permission_role (permission_id);
CREATE INDEX IF NOT EXISTS role_id on permission_role (role_id);



create table if not exists role_user (
  role_id int default null,
  user_id int default null
 ,
  constraint role_user_ibfk_1 foreign key (role_id) references role (id),
  constraint role_user_ibfk_2 foreign key (user_id) references user_creditrama (id)
)  ;

CREATE INDEX IF NOT EXISTS role_id on role_user (role_id);
CREATE INDEX IF NOT EXISTS user_id on role_user (user_id);

-- END OF IT
*/


CREATE TABLE IF NOT EXISTS oauth_client_token (
  token_id VARCHAR(256),
  token bytea,
  authentication_id VARCHAR(256) PRIMARY KEY,
  user_name VARCHAR(256),
  client_id VARCHAR(256)
);

CREATE TABLE IF NOT EXISTS oauth_access_token (
  token_id VARCHAR(256),
  token bytea,
  authentication_id VARCHAR(256) PRIMARY KEY,
  user_name VARCHAR(256),
  client_id VARCHAR(256),
  authentication bytea,
  refresh_token VARCHAR(256)
);

CREATE TABLE IF NOT EXISTS oauth_refresh_token (
  token_id VARCHAR(256),
  token bytea,
  authentication bytea
);

CREATE TABLE IF NOT EXISTS oauth_code (
  code VARCHAR(256), authentication bytea
);

CREATE TABLE IF NOT EXISTS oauth_approvals (
  userId VARCHAR(256),
  clientId VARCHAR(256),
  scope VARCHAR(256),
  status VARCHAR(10),
  expiresAt TIMESTAMP,
  lastModifiedAt TIMESTAMP
);
