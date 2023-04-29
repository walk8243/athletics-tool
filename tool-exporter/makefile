.PHONY: reload

reload:
	@$(MAKE) -C ../entity reload --no-print-directory
	@$(MAKE) eclipse --no-print-directory

eclipse:
	@gradlew cleanEclipse eclipse --quiet
