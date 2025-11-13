package com.app.work;

import java.util.Optional;

@FunctionalInterface
interface Greet {
    void sayHello(String name);
}

@FunctionalInterface
interface Calculation {
    int add(int a, int b);
}

public class LambdaDemo {

    private String email;  // ✅ new email field

    public static void main(String[] args) {

        Greet greet = (name) -> System.out.println("Hello " + name + "!");
        greet.sayHello("Joshika");

        Calculation cobj = (i, j) -> i + j;
        Calculation cobj1 = (i, j) -> i * j;

        LambdaDemo obj = new LambdaDemo();

        // ✅ Email assignment (you can change or test null)
        obj.email = null;        // try: obj.email = "user@example.com";

        obj.print(cobj1);
        obj.checkOption();
        obj.checkEmail();  // ✅ calling new method

        Optional<String> nameOpt = Optional.ofNullable(obj.getName());

        if (nameOpt.isPresent()) {
            System.out.println(nameOpt.get());
        } else {
            System.out.println("Name not found");
        }
    }

    public void print(Calculation cobj) {
        System.out.println("Result: " + cobj.add(3, 4));
    }

    public void checkOption() {

        Optional<String> name = Optional.ofNullable(null);
        System.out.println("Is Present: " + name.isPresent());

        String result = name.orElse("Default Name");
        System.out.println("Result: " + result);

        name.ifPresent(n -> System.out.println("Hello " + n));

        Optional<String> city = Optional.of("Mumbai");
        System.out.println(city.orElseGet(() -> "Unknown City"));
        System.out.println(city.orElse("No city found"));
    }

    // ✅ New method for email check
    public void checkEmail() {
        Optional<String> emailOpt = Optional.ofNullable(email);

        System.out.println("\nChecking email...");
        System.out.println(emailOpt.orElse("No Email Provided"));

        emailOpt.ifPresent(e -> System.out.println("Email found: " + e));
    }

    public String getName() {
        return null;
    }
}
