# otp_bank
#### Test for Advanced Search Page: https://www.otpbank.ru/ 
#### Технологии и инструменты:
<p align="center">
<a href="https://www.jetbrains.com/idea/"><img src="/icons/Intelij_IDEA.png" width="50" height="50"  alt="IDEA"/></a>
<a href="https://www.java.com/"><img src="/icons/Java.png" width="50" height="50"  alt="Java"/></a>
<a href="https://github.com/"><img src="/icons/GitHub-Mark.png" width="50" height="50"  alt="Github"/></a>
<a href="https://junit.org/junit5/"><img src="/icons/JUnit5.png" width="50" height="50"  alt="JUnit 5"/></a>
<a href="https://gradle.org/"><img src="/icons/Gradle.png" width="50" height="50"  alt="Gradle"/></a>
<a href="https://selenide.org/"><img src="/icons/Selenide.png" width="50" height="50"  alt="Selenide"/></a>
<a href="https://aerokube.com/selenoid/"><img src="/icons/Selenoid.png" width="50" height="50"  alt="Selenoid"/></a>
<a href="https://github.com/allure-framework/allure2"><img src="/icons/Allure_Report.png" width="50" height="50"  alt="Allure"/></a>
<a href="https://www.jenkins.io/"><img src="/icons/Jenkins.png" width="50" height="50"  alt="Jenkins"/></a>
</p>

#### Gradle dependencies:
```
testImplementation 'org.junit.jupiter:junit-jupiter:5.8.1',
            'com.codeborne:selenide:6.10.3',
            'io.qameta.allure:allure-selenide:2.20.1',
            "org.slf4j:slf4j-simple:1.7.32",
            'com.codeborne:pdf-test:1.5.0',
            'org.assertj:assertj-core:3.23.1'
    testRuntimeOnly 'org.junit.jupiter:junit-jupiter-engine:5.8.1'
```
## Подключение Allure
#### build.gradle:
```
plugins {
    id "io.qameta.allure" version "2.11.2"
}
allure {
    report {
        version.set ("2.19.0")
    }
    adapter {
        aspectjWeaver.set(true)
        frameworks {
            junit5 {
                adapterVersion.set("2.19.0")
            }
        }
    }
}
```
#### jenkins:
- Для подключения визуальной составляющей Allure указываем Path: build/allure-results. После выполнения сборки нам доступен следующего формата отчет:
