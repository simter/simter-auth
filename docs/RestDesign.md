## Rest Interface

| Sn | Method | Url     | Description
|----|--------|---------|-------------
| 1  | POST   | /login  | Login by username and password
| 2  | POST   | /logout | Logout
| 3  | GET    | /verify | Verify the logined state

### 1. `POST /login` Login by username and password

**Request：**

```
POST /login
Content-Type : application/json;charset=utf-8

{BODY}
```

{BODY} must be a standard json object structure :

| Name     | Require | Description
|----------|---------|-------------
| username | true    | The login user's account name
| password | true    | The sha3 hash of the login password
| for      | false   | Which system or app want to do the login. <br>It's optional if login to the same domain, otherwise it's required.

**Response：**

```
200 OK
Content-Type : text/plain;charset=utf-8

{BODY}
```

{BODY} is a jwt token text.