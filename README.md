# springboot-template-web

![](https://github.com/h1romas4/springboot-template-web/workflows/Java%20CI/badge.svg)

## Try with Gitpod

[![Open in Gitpod](https://gitpod.io/button/open-in-gitpod.svg)](https://gitpod.io#https://github.com/h1romas4/springboot-template-web)

## Build and Boot

### Require

* Setup JDK 11 and `JAVA_HOME` setting
* Setup Node.js 16 (optional)
* Install VSCode (optional)

### Initialize

```
git clone https://github.com/h1romas4/springboot-template-web.git
cd springboot-template-web
./gradlew build
./gradlew eclipse
# start vscode in source code directory
code .
```

### Develop

Backend and Frondend Develop (with automatic reload)

```
# start Spring Boot
./gradlew bootRun
# and start webpack watch (another terminal)
./gradlew --no-daemon watch
```

```
http://localhost:8080/
```

Only Frondend Develop (with automaic reload)

```
# use internal Node.js
./gradlew --no-daemon server
# or external Node.js
npm run server
```

```
http://localhost:9080/
```

Enjoy!
