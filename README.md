# athletics-tool

陸上競技の登録ツール

## 使い方

### ローカル起動

```sh
$ docker-compose up --build
```

### アプリケーションへのアクセス

- tool-frontend
	- http://localhost:8000
- tool-api
	- http://localhost:8081/actuator/health
- repository-api
	- http://localhost:8082/actuator/health
- web-frontend
	- http://localhost:8001
- web-api
	- http://localhost:8090/actuator/health
- tool-exporter
	- http://localhost:8083/actuator/health

### DBへのアクセス

- host
	- localhost
- port
	- 3307
- database
	- athletics-tool
- user
	- user
- password
	- f85kt4HR

## ドキュメント

ドキュメントは [こちら](./docs/README.md) 
