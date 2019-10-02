# springboot-template-web

![](https://github.com/h1romas4/springboot-template-web/workflows/Java%20CI/badge.svg)

## Build and Boot

### Require

* Setup JDK 11
* Install VSCode (optional recommend)

### Windows

Open cmd.exe or PowerShell

```
git clone https://github.com/h1romas4/springboot-template-web.git
cd springboot-template-web
.\gradlew.bat build
.\gradlew.bat eclipse
.\gradlew.bat webpack
code .
```

In VS Code internal terminal (Spring Boot development)

```
.\gradlew.bat bootRun
```

In VS Code another internal terminal (JavaScript Webpack development)

```
.\gradlew.bat watch
```

Enjoy! (Support for automatic application restarts)

```
http://localhost:8080/
```

### macOS / Linux

```
git clone https://github.com/h1romas4/springboot-template-web.git
cd springboot-template-web
./gradlew build
./gradlew eclipse
./gradlew webpack
code .
```

In VS Code internal terminal (Spring Boot development)

```
./gradlew bootRun
```

In VS Code another internal terminal (JavaScript Webpack development)

```
./gradlew watch
```

Enjoy! (Support for automatic application restarts)

```
http://localhost:8080/
```
