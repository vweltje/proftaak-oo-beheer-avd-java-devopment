package nl.avd.javadev.proftaak.shapes;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CylinderTest {
    private static Map<String, String> properties;
    private static Cylinder sut;

    @BeforeAll
    static void beforeAll(){
        properties = new HashMap<>();
        sut = new Cylinder(null);
    }

    @Test
    @DisplayName("Return 3141.59 when values are 10 and 10")
    void getVolume_for10and10_expect1000() {
        // Arrange
        properties.put("radius" , "10");
        properties.put("height" , "10");
        sut.setProperties(properties);

        // Act
        double actual = sut.getVolume();

        // Assert
        assertEquals(3141.59, actual, 0.01);
    }

    @Test
    @DisplayName("Return NumberFormatException when values are garbage")
    void getVolume_forGarbage_returnGarbage() {
        // Arrange
        properties.put("radius" , "pannekoek");
        properties.put("height" , "pannekoek");
        sut.setProperties(properties);

        // Act

        // Assert
        assertThrows(NumberFormatException.class, () -> {
            sut.getVolume();
        });
    }

    @Test
    @DisplayName("Don't allow negative values")
    void getVolume_forNegativeValues_returnException(){
        // Arrange
        properties.put("radius" , "-10");
        properties.put("height" , "-10");
        sut.setProperties(properties);

        // Act

        // Assert
        assertThrows(InputMismatchException.class, () -> {
            sut.getVolume();
        });

    }
}