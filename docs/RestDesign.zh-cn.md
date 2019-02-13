## Rest Interface

| Sn | Method | Url     | Description
|----|--------|---------|-------------
| 1  | POST   | /login  | 登录系统
| 2  | POST   | /logout | 退出登录

## 1. 登录系统

### 1.1. Request

```
POST /login
Content-Type : application/json;charset=utf-8

[$appId, $loginType, $username, $password]
```

Body 为 json 数组的字符串表示，数组中各元素说明如下：

| Name       | ValueType | Require | Description
|------------|-----------|---------|-------------
| $appId     | String    | true    | 应用 ID
| $loginType | Integer   | true    | 登录方式：1-账号密码登录
| $username  | String    | true    | 登录账号
| $password  | String    | true    | 登录密码

> 登录方式现时仅支持 1，代表基于账号密码登录，其它登录方式待扩展。

### 1.2. Response

| StatusCode    | Content-Type             | Body   | Description
|---------------|--------------------------|--------|-------------
| 201 Created   | text/plain;charset=utf-8 | $token | 登录成功，返回 JWT 令牌
| 403 Forbidden | text/plain;charset=utf-8 | $msg   | 登录失败

- $token ：服务端生成的 JWT 令牌。
- $msg ：登录失败的异常信息。

$token 的 JWT 结构（`$header.$payload.$signature`）说明如下：

**$header = {typ: "...", alg: "..."} ：**

| Key | ValueType | Require | Description
|-----|-----------|---------|-------------
| typ | String    | true    | Header 类型，默认为 "JWT"
| alg | String    | true    | Header 算法，默认为 "HS256"

**$payload = {iss: "...", sub: "...", aud: "...", exp: 1483200000, nbf: 1464710400, iat: 1451577600, jti: "..."} ：**

| Key | ValueType | Require | Description
|-----|-----------|---------|-------------
| **Registered claims ：**
| iss | String    | true    | issuer 发行人
| sub | String    | false   | subject 主题
| aud | String    | false   | audience 认证账号
| exp | Long      | false   | expires 在此时点或之后无效，值为距 1970-01-01T00:00:00Z 之间的秒数
| nbf | Long      | false   | notBefore 在此时点之前无效，值为距 1970-01-01T00:00:00Z 之间的秒数
| iat | Long      | true    | issuedAt 分发时间，值为距 1970-01-01T00:00:00Z 之间的秒数
| jti | String    | false   | jwtId 此 token 的唯一标识符
| **Public claims ：**
| user.id      | String  | true  | 用户 ID 的字符串表示
| user.code    | String  | true  | 用户编号
| user.name    | String  | true  | 用户姓名
| branch.id    | String  | true  | 直属机构（单位或部门） ID 的字符串表示
| branch.type  | integer | true  | 直属机构类型，1-单位、2-部门
| branch.code  | String  | true  | 直属机构编号
| branch.name  | String  | true  | 直属机构名称
| company.id   | String  | true  | 所属单位 ID 的字符串表示
| company.code | String  | true  | 所属单位编号
| company.name | String  | true  | 所属单位名称
| roles        | String  | false | 用户在所属单位所拥有角色的编码用逗号 "," 连接而成的字符串

[LoginNotifier4Jwt.java]: (https://gitee.com/bctaxi/bc-system/blob/master/src/main/java/cn/bc/login/LoginNotifier4Jwt.java)

## 2. 退出登录

TODO