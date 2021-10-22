package pl.przemek;

import org.junit.jupiter.api.Test;
import static  org.junit.jupiter.api.Assertions.*;

public class GreeterTest {
    @Test
    public void itGretsByName() {
        // Arrange / Given
        String name = "Jakub";
        Greeter greeter = new Greeter();
        // Act / When
        String greetingText = greeter.hello(name);
        // Assert / Then
        assertEquals("Hello Jakub", greetingText);
    }
}
