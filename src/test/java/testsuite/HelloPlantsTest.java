package testsuite;

import main.HelloPlants;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HelloPlantsTest {

    // @Ignore("if we want to ignore the testcase")
    @Test
    void green() {

        String stat = "plant";
        HelloPlants m = new HelloPlants();
        String result = m.green(stat);
        assertEquals("I have a plant", result);
        System.out.println("Success");

    }
}