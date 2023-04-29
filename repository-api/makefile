.PHONY: build reload jooq

build:
	@$(MAKE) -C ../entity build --no-print-directory
	@docker build -t walk8243/athletics-tool-repository-api .

reload:
	@$(MAKE) -C ../entity reload --no-print-directory
	@$(MAKE) eclipse --no-print-directory

jooq:
	@java -cp "./script/jooq/jar/*" org.jooq.codegen.GenerationTool ./script/jooq/config.xml

eclipse:
	@gradlew cleanEclipse eclipse --quiet
