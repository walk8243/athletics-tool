.PHONY: reload jooq

reload:
	@gradlew cleanEclipse eclipse --quiet

jooq:
	@java -cp "./script/jooq/jar/*" org.jooq.codegen.GenerationTool ./script/jooq/config.xml
