
## Build runnable Spring Boot JAR
```bash
mvn clean package
```

## Build Docker compose 
```bash
docker-compose build
```

## Running Docker compose
```bash
docker-compose run -d
```

## Test with Newman
```bash
newman run src/test/resources/newman/key-vault.postman_collection.json -e src/test/resources/newman/Local.postman_environment.json
```