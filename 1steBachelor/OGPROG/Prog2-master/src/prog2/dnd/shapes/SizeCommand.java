package prog2.dnd.shapes;

import java.io.Serializable;

public class SizeCommand implements Command, Serializable {

    private static final long serialVersionUID = 3271685275157309236L;
    private double size;

    public SizeCommand(double size) {
        this.size = size;
    }

    @Override
    public void updateDescription(ShapeDescription description) {
        description.setSize(size);
    }

}
