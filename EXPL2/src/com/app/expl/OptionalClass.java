package com.app.expl;
import java.util.Optional;

public class OptionalClass {

    public static void main(String[] args) {

        Optional<String> name = Optional.ofNullable(getUserName());

        System.out.println("Is value present? " + name.isPresent());

        String finalName = name.orElse("Guest User");
        System.out.println("User Name: " + finalName);

        name.ifPresent(n -> System.out.println("Welcome, " + n));

        Optional<String> email = Optional.ofNullable(null);

        String finalEmail = email.orElseGet(() -> "No Email Provided");
        System.out.println(finalEmail);
    }

    public static String getUserName() {
        return null;
    }
}
