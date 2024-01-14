package uz.pdp.test;

import java.util.ArrayList;
import java.util.List;

public interface DB {
    ArrayList<User> users = new ArrayList<>(List.of(
            new User("asdf"),
            new User("qwer"),
            new User("ertt"),
            new User("dfgg")
    ));
}
