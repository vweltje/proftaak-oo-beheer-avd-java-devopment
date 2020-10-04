package nl.avd.javadev.proftaak.shapes;

import nl.avd.javadev.proftaak.Shape;
import nl.avd.javadev.proftaak.ShapeType;
import nl.avd.javadev.proftaak.iShape;

import java.util.Map;

public class Cube extends Shape implements iShape {

    public Cube(Map<String, String> properties) {
        super();
        this.type = ShapeType.CUBE;
        this.fields = new String[]{"length", "width", "height"};
        this.setProperties(properties);
    }

    @Override
    public void getVolume() {

    }

    @Override
    public void calculateVolume() {

    }
}