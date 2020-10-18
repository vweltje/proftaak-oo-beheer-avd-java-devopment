package nl.avd.javadev.proftaak.shapes;

import nl.avd.javadev.proftaak.Shape;
import nl.avd.javadev.proftaak.ShapeType;
import nl.avd.javadev.proftaak.Calculable;

import java.util.Map;

public class Sphere  extends Shape implements Calculable {

    public Sphere(Integer id) {
        super();
        this.type = ShapeType.SPHERE;
        this.fields = new String[]{"radius"};
        this.id = id;
        if (id != null) {
            this.setProperties();
        } else {
            this.showStage();
        }
    }

    @Override
    public double getVolume() {
        return 0.0;
    }

    @Override
    public void calculateVolume() {

    }
}
