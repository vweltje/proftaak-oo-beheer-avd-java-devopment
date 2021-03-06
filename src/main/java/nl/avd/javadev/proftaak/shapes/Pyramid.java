package nl.avd.javadev.proftaak.shapes;

import nl.avd.javadev.proftaak.Shape;
import nl.avd.javadev.proftaak.ShapeType;
import nl.avd.javadev.proftaak.CalculableShape;
import java.util.InputMismatchException;

public class Pyramid  extends Shape implements CalculableShape {

    public Pyramid(Integer id) {
        super();
        this.setType(ShapeType.PYRAMID);
        this.setFields(new String[]{"length", "width", "height"});
        this.setId(id);
        if (id != null) {
            this.getDataFromDatabase();
        }
    }

    @Override
    public Double getVolume() throws NumberFormatException, InputMismatchException {
        if (this.getProperty("length") < 0){
            throw new InputMismatchException("Length cannot be negative");
        }
        if (this.getProperty("width") < 0){
            throw new InputMismatchException("Width cannot be negative");
        }
        if (this.getProperty("height") < 0){
            throw new InputMismatchException("Height cannot be negative");
        }

        return (this.getProperty("length") * this.getProperty("width") * this.getProperty("height")) / 3.0;
    }

}
