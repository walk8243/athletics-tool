# athletics-tool

陸上競技の登録ツール

## 使い方

### ローカル起動

```sh
$ docker-compose up --build
```

### アプリケーションへアクセス

- tool-frontend
	- http://localhost:3000
- tool-api
	- http://localhost:8080/actuator/health
- repository-api
	- http://localhost:8082/actuator/health
- web-frontend
	- http://localhost:3001
- web-api
	- http://localhost:8081/actuator/health
- tool-exporter
	- http://localhost:8083/actuator/health

## ドキュメント

ドキュメントは [こちら](./docs/README.md) 
