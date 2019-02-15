/**
 * Create table script.
 * @author RJ
 */

create table st_organization (
  id         bigint primary key,
  type       smallint                 not null,
  status     smallint                 not null,
  code       varchar(100)             not null,
  name       varchar(100)             not null,
  branch_id  bigint references st_organization,
  company_id bigint references st_organization,
  create_on  timestamp with time zone not null,
  unique (company_id, code)
);

create table st_user (
  id         bigint primary key,
  status     smallint                 not null,
  code       varchar(100)             not null,
  name       varchar(100)             not null,
  branch_id  bigint references st_organization,
  company_id bigint references st_organization,
  create_on  timestamp with time zone not null,
  unique (company_id, code)
);

create table st_account (
  id        bigint primary key references st_user,
  status    smallint                 not null,
  username  varchar(100) unique      not null,
  password  varchar(100)             not null,
  create_on timestamp with time zone not null
);

create table st_relation (
  type        smallint                 not null,
  master_id   bigint                   not null,
  follower_id bigint                   not null,
  sn          smallint                 not null default 0,
  create_on   timestamp with time zone not null,
  primary key (type, master_id, follower_id)
);

create table st_role (
  id         bigint primary key,
  status     smallint                 not null,
  code       varchar(100)             not null,
  name       varchar(100)             not null,
  company_id bigint references st_organization,
  create_on  timestamp with time zone not null,
  unique (company_id, code)
);
