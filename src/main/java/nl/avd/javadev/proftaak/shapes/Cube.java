package nl.avd.javadev.proftaak.shapes;

import nl.avd.javadev.proftaak.Shape;
import nl.avd.javadev.proftaak.ShapeType;
import nl.avd.javadev.proftaak.Calculable;

public class Cube extends Shape implements Calculable {

    public Cube(Integer id) {
        super();
        this.type = ShapeType.CUBE;
        this.fields = new String[]{"length", "width", "height"};
        this.id = id;
        if (id != null) {
            this.getDataFromDatabase();
        }
    }

    @Override
    public double getVolume() throws NumberFormatException {
        return this.getProperty("length") * this.getProperty("width") * this.getProperty("height");
    }

    @Override
    public void calculateVolume() {

    }

}
