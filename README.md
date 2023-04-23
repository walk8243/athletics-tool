# athletics-tool

陸上競技の登録ツール

## 使い方

### ローカル起動

```sh
$ make up
```

### アプリケーションへのアクセス

- tool-frontend
	- http://localhost:8000
- tool-api
	- http://localhost:8081/swagger-ui.html
- repository-api
	- http://localhost:8082/swagger-ui.html
- web-frontend
	- http://localhost:8001
- web-api
	- http://localhost:8090/swagger-ui.html
- tool-exporter
	- http://localhost:8083/swagger-ui.html

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

### 開発中のデバッグ

通常通りそれぞれのアプリケーションのディレクトリで起動。

フロントエンド（Next.js）は http://localhost:3000 で、
その他のアプリケーションは http://localhost:8080 でアクセス可能。

#### VSCodeでのデバッグ

VSCodeの場合は、それぞれのアプリケーション名からデバッガを起動が可能。

## ドキュメント

ドキュメントは [こちら](./docs/README.md) 
