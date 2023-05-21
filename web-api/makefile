.PHONY: reload check fix

reload:
	@$(MAKE) -C ../entity reload --no-print-directory
	@$(MAKE) eclipse --no-print-directory

check:
	@gradlew check

fix:
	@gradlew spotlessApply

eclipse:
	@gradlew cleanEclipse eclipse --quiet
