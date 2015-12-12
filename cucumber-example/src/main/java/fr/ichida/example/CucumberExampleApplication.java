package fr.ichida.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This is the main class of the Spring boot application.
 * You may want to run this entry point using your IDE.
 * <p>
 * On few IDE (like IntelliJ) there is a glitch with maven dependencies declared as <i>provided</i>: There are not
 * included in the classpath on run. In our case, the tomcat server won't start due to this lack.
 * A solution has been made on stackoverflow within
 * <a href="http://stackoverflow.com/questions/30237768/run-spring-boots-main-using-ide">this post</a>.
 * So, in your project structure, just add the maven dependency <i>spring-boot-starter-tomcat</i> to your classpath.
 * <p>
 * You also can configure the debug options with the following JVM arguments:
 * -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8000,suspend=n
 *
 * @author shoun
 * @since 10/12/2015
 */
@SpringBootApplication
public class CucumberExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(CucumberExampleApplication.class, args);
    }
}
