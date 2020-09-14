build/test:
	./gradlew build -xtest

test:
	./gradlew test

.PHONY: build

build:
	./gradlew build

clean:
	./gradlew clean

run:
	./gradlew bootRun

dev:
	./gradlew build --continuous -xtest

db/up:
	docker-compose up -d db

db/bash:
	docker exec -ti blog_db bash

mysql:
	docker exec -ti blog_db mysql -u root -p blog