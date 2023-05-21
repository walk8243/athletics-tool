.PHONY: up down reload

up:
	@$(MAKE) -C entity docker --no-print-directory
	docker-compose up --build -d

down:
	docker-compose down

reload:
	@$(MAKE) -C entity reload --no-print-directory
	@$(MAKE) -C tool-api eclipse --no-print-directory
	@$(MAKE) -C repository-api eclipse --no-print-directory
	@$(MAKE) -C web-api eclipse --no-print-directory
	@$(MAKE) -C tool-exporter eclipse --no-print-directory
