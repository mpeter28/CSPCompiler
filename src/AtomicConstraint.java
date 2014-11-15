import java.util.ArrayList;
import java.util.List;

public class AtomicConstraint implements Constraint {

    private boolean negated;
    private String clause;

    public AtomicConstraint(boolean negated, String clause) {
        this.negated = negated;
        this.clause = clause;
    }

    public boolean isNegated() {
        return negated;
    }

    public String getClause() {
        return clause;
    }

    @Override
    public List<List<AtomicConstraint>> flatten() {
        List<List<AtomicConstraint>> baseOr = new ArrayList<List<AtomicConstraint>>();

        ArrayList<AtomicConstraint> baseAnd = new ArrayList<AtomicConstraint>();
        baseAnd.add(this);

        baseOr.add(baseAnd);

        return baseOr;
    }

}
