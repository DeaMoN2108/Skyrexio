package user;

import utils.PropertyReader;

public class UserFactory {
    public static User withAdminPermission() {
        return new User(
                PropertyReader.getProperty("saucedemoo.user"),
                PropertyReader.getProperty("saucedemoo.password"),
                PropertyReader.getProperty("saucedemmo.first_name"),
                PropertyReader.getProperty("saucedemmo.last_name"),
                Integer.parseInt(PropertyReader.getProperty("saucedemmo.postal_code")));
    }

    public static User withLockedPermission() {
        return new User(
                PropertyReader.getProperty("saucedemoo.locked_user"),
                PropertyReader.getProperty("saucedemoo.password"),
                PropertyReader.getProperty("saucedemmo.first_name"),
                PropertyReader.getProperty("saucedemmo.last_name"),
                Integer.parseInt(PropertyReader.getProperty("saucedemmo.postal_code")));
    }

    public static User withIncorrectPermission() {
        return new User(
                PropertyReader.getProperty("saucedemoo.incorrect_user"),
                PropertyReader.getProperty("saucedemoo.password"),
                PropertyReader.getProperty("saucedemmo.first_name"),
                PropertyReader.getProperty("saucedemmo.last_name"),
                Integer.parseInt(PropertyReader.getProperty("saucedemmo.postal_code")));
    }

    public static User withEmptyPassPermission() {
        return new User(
                PropertyReader.getProperty("saucedemoo.user"),
                "",
                PropertyReader.getProperty("saucedemmo.first_name"),
                PropertyReader.getProperty("saucedemmo.last_name"),
                Integer.parseInt(PropertyReader.getProperty("saucedemmo.postal_code")));
    }

    public static User withEmptyLogPermission() {
        return new User(
                "",
                PropertyReader.getProperty("saucedemoo.password"),
                PropertyReader.getProperty("saucedemmo.first_name"),
                PropertyReader.getProperty("saucedemmo.last_name"),
                Integer.parseInt(PropertyReader.getProperty("saucedemmo.postal_code")));
    }
}
