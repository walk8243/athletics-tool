.PHONY: build reload jar

build: 
	@docker build -t walk8243/athletics-tool-entity .

reload:
	@$(MAKE) jar --no-print-directory
	@./gradlew cleanEclipse eclipse --quiet

jar:
	@./gradlew build -xtest
