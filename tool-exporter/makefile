.PHONY: reload check fix

GRADLE = ./gradlew
ifeq ($(OS),Windows_NT)
	GRADLE = gradlew.bat
endif

reload:
	@$(MAKE) -C ../entity reload --no-print-directory
	@$(MAKE) eclipse --no-print-directory

check:
	@$(GRADLE) check

fix:
	@$(GRADLE) spotlessApply

eclipse:
	@$(GRADLE) cleanEclipse eclipse --quiet
