package prog2.dnd.shapes;

import java.io.Serializable;

public class ShapeCommand implements Command, Serializable {

    private static final long serialVersionUID = 9014281940881665265L;
    private ShapeType type;

    public ShapeCommand(ShapeType type) {
        this.type = type;
    }

    @Override
    public void updateDescription(ShapeDescription description) {
        description.setType(type);
    }
}
