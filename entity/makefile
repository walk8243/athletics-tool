.PHONY: build reload jar check fix docker

build: fix jar

reload:
	@$(MAKE) jar --no-print-directory
	@gradlew cleanEclipse eclipse --quiet

jar:
	@gradlew build -xtest

check:
	@gradlew check

fix:
	@gradlew spotlessApply

docker:
	@docker build -t walk8243/athletics-tool-entity .
