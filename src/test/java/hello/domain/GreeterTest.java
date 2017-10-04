package hello.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GreeterTest {

    Greeter greeter = new Greeter();

    @Test
    public void testSayHelloToJohan() {
        assertEquals("Hello, Johan", greeter.sayHello("Johan"));
    }

    @Test
    public void testSayHelloToName() {
        assertEquals("Hello, Name", greeter.sayHello("Name"));
    }

    @Test
    public void testSayHelloEmpty() {
        assertEquals("Hello, World", greeter.sayHello(""));
    }

    @Test
    public void testSayHelloNull() {
        assertEquals("Hello, World", greeter.sayHello(null));
    }
}