package fr.ichida.example.feature;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * This class is configured to run all cucumber features describe by <i>features</i> option in {@link CucumberOptions}.
 *
 * @author shoun
 * @since 12/12/2015
 */
@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber"}, features = {"classpath:features/"})
public class RunCukesTest {
}
