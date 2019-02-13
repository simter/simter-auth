## Rest Interface

| Sn | Method | Url     | Description
|----|--------|---------|-------------
| 1  | POST   | /login  | Login
| 2  | POST   | /logout | Logout

## 1. Login

### 1.1. Request

```
POST /login
Content-Type : application/json;charset=utf-8

[$appId, $loginType, $username, $password]
```

Body must be a standard json array string :

| Name       | ValueType | Require | Description
|------------|-----------|---------|-------------
| $appId     | String    | true    | App ID
| $loginType | Integer   | true    | login type : 1-by username and password
| $username  | String    | true    | login account
| $password  | String    | true    | login password

> Now only support login type `1`.

### 1.2. Response

| StatusCode    | Content-Type             | Body   | Description
|---------------|--------------------------|--------|-------------
| 201 Created   | text/plain;charset=utf-8 | $token | success
| 403 Forbidden | text/plain;charset=utf-8 | $msg   | failed

- $token ：a JWT format token generated on server.
- $msg ：failed message.

JWT structure (`$header.$payload.$signature`) :

**$header = {typ: "...", alg: "..."} ：**

| Key | ValueType | Require | Description
|-----|-----------|---------|-------------
| typ | String    | true    | "JWT"
| alg | String    | true    | "HS256"

**$payload = {iss: "...", sub: "...", aud: "...", exp: 1483200000, nbf: 1464710400, iat: 1451577600, jti: "..."} ：**

| Key | ValueType | Require | Description
|-----|-----------|---------|-------------
| **Registered claims ：**
| iss | String    | true    | issuer
| sub | String    | false   | subject
| aud | String    | false   | audience
| exp | Long      | false   | expire after seconds between 1970-01-01T00:00:00Z 
| nbf | Long      | false   | invalid before seconds between 1970-01-01T00:00:00Z 
| iat | Long      | true    | issued time seconds between 1970-01-01T00:00:00Z 
| jti | String    | false   | jwt unique id
| **Public claims ：**
| user.id      | String  | true  | user string id
| user.code    | String  | true  | 
| user.name    | String  | true  | 
| branch.id    | String  | true  | directly branch string id
| branch.type  | integer | true  | branch type : 1-Company, 2-Department
| branch.code  | String  | true  | 
| branch.name  | String  | true  | 
| company.id   | String  | true  | belong company string id
| company.code | String  | true  | 
| company.name | String  | true  | 
| roles        | String  | false | role codes bellow the belong company. string join with symbol ','

## 2. Logout

TODO