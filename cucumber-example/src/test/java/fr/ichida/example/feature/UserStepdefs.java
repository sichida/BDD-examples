package fr.ichida.example.feature;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.fr.Etantdonné;
import cucumber.api.java8.En;
import fr.ichida.example.CucumberExampleApplication;
import fr.ichida.example.entity.User;
import org.springframework.boot.test.SpringApplicationConfiguration;

/**
 * Created by shoun on 18/05/16.
 */
@SpringApplicationConfiguration(CucumberExampleApplication.class)
public class UserStepdefs {

    private User user;

    @Given("^user \"([^\"]*)\" exists$")
    public void userExists(String username) {
        user = new User();
        user.setUsername(username);
    }

    @And("^his firstname is \"([^\"]*)\"$")
    public void hisFirstnameIs(String firstname) throws Throwable {
        user.setFirstname(firstname);
    }

    @And("^his lastname is \"([^\"]*)\"$")
    public void hisLastnameIs(String lastname) throws Throwable {
        user.setLastname(lastname);
    }

    @And("^his email address is \"([^\"]*)\"$")
    public void hisEmailAddressIs(String email) throws Throwable {
        user.setEmail(email);
    }

    @And("^his company is \"([^\"]*)\"$")
    public void hisCompanyIs(String company) throws Throwable {
        user.setCompany(company);
    }

    @Given("^\"([^\"]*)\" is authenticated$")
    public void isAuthenticated(String arg0) throws Throwable {
        // Nothing but should login the user described by given username
    }

    @Etantdonné("^que \"([^\"]*)\" est authentifié$")
    public void queEstAuthentifié(String username) throws Throwable {
        // Nothing but should login the user described by given username
    }

    /*
    public UserStepdefs() {
        Given("^user \"([^\"]*)\" exists$", (String username) -> {
            user = new User();
            user.setUsername(username);
        });
        And("^his firstname is \"([^\"]*)\"$", (String firstname) -> {
            user.setFirstname(firstname);
        });
        And("^his lastname is \"([^\"]*)\"$", (String lastname) -> {
            user.setLastname(lastname);
        });
        And("^his email address is \"([^\"]*)\"$", (String email) -> {
            user.setEmail(email);
        });
        And("^his company is \"([^\"]*)\"$", (String company) -> {
            user.setCompany(company);
        });
        Given("^\"([^\"]*)\" is authenticated$", (String username) -> {
            // Nothing but should login the user described by given username
        });
    }
    */
}
