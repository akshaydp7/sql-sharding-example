# MySQL Sharding (SpringBoot JPA) POC

_This repository is just a POC_
_Not ready for PRODUCTION._

## Running application

Clone this project in your local machine
### Setup
Execute init sql script in your sql server using mysql client like below or any other way
```
mysql -u {username} -p{password} < sql-sharding-example/src/main/resources/init.sql
``` 

### Configure
Update .properties file with correct mysql username and password 

### Execute
```
sh build.sh
```