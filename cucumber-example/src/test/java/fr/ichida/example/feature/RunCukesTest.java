package fr.ichida.example.feature;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * This class is configured to run all cucumber feature describe by <i>feature</i> option in {@link CucumberOptions}.
 *
 * @author shoun
 * @since 12/12/2015
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber"},
        features = {"classpath:features/"},
        glue = {"cucumber.api.spring", "fr.ichida.example.feature"},
        format = {"html:target/cucumber", "json:target/cucumber.json"}
)
public class RunCukesTest {
}
