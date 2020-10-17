package nl.avd.javadev.proftaak.shapes;

import nl.avd.javadev.proftaak.Shape;
import nl.avd.javadev.proftaak.ShapeType;
import nl.avd.javadev.proftaak.Calculable;

import java.util.Map;

public class Cube extends Shape implements Calculable {

    public Cube(Map<String, String> properties) {
        super();
        this.type = ShapeType.CUBE;
        this.fields = new String[]{"length", "width", "height"};
        this.setProperties(properties);
    }

    @Override
    public void getVolume() {

    }

    public double calculateVolume() {
        int edgeLength = 1;
        double volume = (edgeLength*edgeLength*edgeLength);
//        return volume;
        throw new UnsupportedOperationException();
    }
}
