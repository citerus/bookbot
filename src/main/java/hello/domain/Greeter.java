package hello.domain;

public class Greeter {
    public String sayHello(String name) {
        if (name == null || name.isEmpty()) {
            name = "World";
        }
        return "Hello, " + name;
    }

}
