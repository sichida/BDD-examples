package fr.ichida.example.feature;

import cucumber.api.PendingException;
import cucumber.api.java8.En;

/**
 * Created by shoun on 18/05/16.
 */
public class UserStepdefs implements En {
    public UserStepdefs() {
        Given("^user \"([^\"]*)\" exists$", (String arg0) -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });
    }
}
