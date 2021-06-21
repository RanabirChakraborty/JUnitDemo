package testsuite;

import main.HelloWorld;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HelloWorldTest {

    @Test
    void printer() {

        int e = 10;
        HelloWorld m = new HelloWorld();
        String result = m.printer(e);
        assertEquals("I got 10", result);
        System.out.println("Success");
    }
}