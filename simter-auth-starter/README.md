#  Simter Auth Server

## Requirement

- Maven 3.6+
- Kotlin 1.3+
- Java 8+
- Spring Framework 5.1+
- Spring Boot 2.1+
- Reactor 3.2+

## Maven Profiles

| Environment | Profile                 | Persistence        | Remark
|-------------|-------------------------|--------------------|--------
| Development | dev                     |                    | db.name=test_st_auth, db.username=test, db.password=password
| Production  | prod                    |                    | db.name=st_auth, db.username=test, db.password=password
| Database :
|             | reactive-h2             | [H2]               |
|             | reactive-postgres       | [PostgreSQL]       |
|             | reactive-mongo          | [MongoDB]          |
|             | reactive-mongo-embedded | [Embedded MongoDB] |

The default profile is `dev` and `reactive-h2`. Run bellow command to start:

```bash
mvn spring-boot:run -P {profile-name}
```

Default server-port is `8083`, use `'-D port=8083'` to change to another port.

## Maven Properties

Property Name | Default Value  | Remark
--------------|----------------|--------
port          | 8083           | Web server port
app.env       | dev            | Environment
db.host       | localhost      | Database host
db.platform   | mongo-embedded | `h2`, `postgres`, `mongo` or `mongo-embedded`
db.name       | test_st_auth   | Database name
db.username   | test           | Database connect username
db.password   | password       | Database connect password
db.init-mode  | always         | Init database by `spring.datasource.schema/data` config. `never` or `always`

Use `'-D {property-name}={property-value}'` to override default value. Such as:

```bash
mvn spring-boot:run -D port=8083
```

## Build Production

```bash
mvn clean package -P prod,reactive-postgres
```

## Run Production

```bash
java -jar {package-name}.jar

# or
nohup java -jar {package-name}.jar > /dev/null &
```

## Run Integration Test

Run test in the real server.

1. Start server. Such as `'mvn spring-boot:run'`
2. Run [IntegrationTest.kt]


[Embedded MongoDB]: https://github.com/flapdoodle-oss/de.flapdoodle.embed.mongo#embedded-mongodb
[MongoDB]: https://www.mongodb.com
[HyperSQL]: http://hsqldb.org
[H2]: http://h2database.com
[PostgreSQL]: https://www.postgresql.org
[IntegrationTest.kt]: https://github.com/simter/simter-auth/blob/master/simter-auth-starter/src/test/kotlin/tech/simter/auth/starter/IntegrationTest.kt