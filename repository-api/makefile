.PHONY: build reload jooq check fix

build:
	@$(MAKE) -C ../entity build --no-print-directory
	@docker build -t walk8243/athletics-tool-repository-api .

reload:
	@$(MAKE) -C ../entity reload --no-print-directory
	@$(MAKE) eclipse --no-print-directory

jooq:
	@java -cp "./script/jooq/jar/*" org.jooq.codegen.GenerationTool ./script/jooq/config.xml

check:
	@gradlew check

fix:
	@gradlew spotlessApply

eclipse:
	@gradlew cleanEclipse eclipse --quiet
