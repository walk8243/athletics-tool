.PHONY: build reload jooq check fix

GRADLE = ./gradlew
ifeq ($(OS),Windows_NT)
	GRADLE = gradlew.bat
endif

build:
	@$(MAKE) -C ../entity build --no-print-directory
	@docker build -t walk8243/athletics-tool-repository-api .

reload:
	@$(MAKE) -C ../entity reload --no-print-directory
	@$(MAKE) eclipse --no-print-directory

jooq:
	@java -cp "./script/jooq/jar/*" org.jooq.codegen.GenerationTool ./script/jooq/config.xml

check:
	@$(GRADLE) check

fix:
	@$(GRADLE) spotlessApply

eclipse:
	@$(GRADLE) cleanEclipse eclipse --quiet
