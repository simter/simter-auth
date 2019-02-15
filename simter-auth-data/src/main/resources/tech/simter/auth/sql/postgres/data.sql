/**
 * Data initialize script.
 * @author RJ
 */

-- admin
insert into st_user(id, status, code, name, create_on)
  values (1, 1, '001', 'Admin', date_trunc('second', current_timestamp));
insert into st_account(id, status, username, password, create_on)
  values (1, 1, 'admin', '21218cca77804d2ba1922c33e0151105', date_trunc('second', current_timestamp)); -- 888888