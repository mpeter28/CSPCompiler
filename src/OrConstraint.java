import java.util.List;

public class OrConstraint implements Constraint {

    private Constraint leftConstraint;
    private Constraint rightConstraint;

    public OrConstraint(Constraint leftConstraint, Constraint rightConstraint) {
        this.leftConstraint = leftConstraint;
        this.rightConstraint = rightConstraint;
    }

    @Override
    public List<List<AtomicConstraint>> flatten() {
        List<List<AtomicConstraint>> flattenLeft = leftConstraint.flatten();
        List<List<AtomicConstraint>> flattenRight = rightConstraint.flatten();

        flattenLeft.addAll(flattenRight);
        return flattenLeft;
    }
}
