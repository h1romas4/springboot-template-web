# springboot-template-web

## VS Code setting

```
{
    "java.jdt.ls.vmargs": "-noverify -Xmx1G -XX:+UseG1GC -XX:+UseStringDeduplication -Dfile.encoding=UTF-8"
}
```

### Extentions

* Language Support for Java(TM) by Red Hat
* ESLint
* EditorConfig for Visual Studio Code

## Windows

Open cmd.exe or PowerShell

```
git clone https://github.com/h1romas4/springboot-template-web.git
cd springboot-template-web
.\gradle.bat eclipse
.\gradle.bat webpack
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

## macOS / Linux

```
git clone https://github.com/h1romas4/springboot-template-web.git
cd springboot-template-web
.\gradle eclipse
.\gradle webpack
code .
```

In VS Code internal terminal (Spring Boot development)

```
.\gradlew bootRun
```

In VS Code another internal terminal (JavaScript Webpack development)

```
.\gradlew watch
```

Enjoy! (Support for automatic application restarts)

```
http://localhost:8080/
```
