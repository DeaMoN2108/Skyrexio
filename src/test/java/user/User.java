package user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class User {
    private final String login;
    private final String password;
    private final String first_name;
    private final String last_name;
    private final Integer postal_code;
}
