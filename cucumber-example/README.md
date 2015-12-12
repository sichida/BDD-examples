# Cucumber example

This project offers an example of cucumber-jvm use.

To develop this application, I've written features specifications using Gerking language.

This language is required by Cucumber in order to be read by the test runner.

## Project structure

I've begun the project with a [Spring boot](http://projects.spring.io/spring-boot/) application using web dependency
(Full-stack web development with Tomcat and Spring MVC).
Then, I just added the following dependencies:
* _info.cukes:cucumber-java8_ for Cucumber java
* _info.cukes:cucumber-junit_ for Cucumber integration with JUnit
* _info.cukes:cucumber-spring_ for Cucumber integration with Spring
* _org.assertj:assertj-core_ for convenience test methods

Bellow, the project structure:

    |- src
        |- main
            |- java
                |- fr.ichida.example
                    |- entity           // POJO representing project entities
                    |- features         // REST services implementation
                    |- service          // Business services
            |- resources                // Application static files (configuration)
        |- test
            |- java
                |- fr.ichida.example
                    |- features         // Implementation of cucumber tests
            |- resources
                |- features             // Gerking feature files

## How to run the application

If you want to run the application (starting an embeded tomcat server) you can use maven spring-boot runner :
_mvn spring-boot:run_.

You also may want to run this entry point using your IDE. On few IDE (like IntelliJ) there is a glitch with maven
dependencies declared as _provided_: there are not included in the classpath on run.
In our case, the tomcat server won't start due to this lack.

A solution has been made on Stack Overflow within
[this post](http://stackoverflow.com/questions/30237768/run-spring-boots-main-using-ide).
So, in your project structure, just add the maven dependency _spring-boot-starter-tomcat_ to your classpath.
