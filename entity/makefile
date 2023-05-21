.PHONY: build reload jar check fix docker

GRADLE = ./gradlew
ifeq ($(OS),Windows_NT)
	GRADLE = gradlew.bat
endif

build: fix jar

reload:
	@$(MAKE) jar --no-print-directory
	@$(GRADLE) cleanEclipse eclipse --quiet

jar:
	@$(GRADLE) build -xtest

check:
	@$(GRADLE) check

fix:
	@$(GRADLE) spotlessApply

docker:
	@docker build -t walk8243/athletics-tool-entity .
