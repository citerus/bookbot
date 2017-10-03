package hello;

public class Greeter {
    public String sayHelloToJohan() {
        return "Hello, Johan";
    }
    public String sayHello(String name) {
        if (name == null) name = "World";
        return "Hello, " + name;
    }

}
