.PHONY: up down reload

up:
	docker-compose up --build

down:
	docker-compose down

reload:
	@$(MAKE) -C tool-api --no-print-directory
	@$(MAKE) -C repository-api --no-print-directory
	@$(MAKE) -C web-api --no-print-directory
	@$(MAKE) -C tool-exporter --no-print-directory
