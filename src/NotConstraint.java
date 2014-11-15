import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class NotConstraint implements Constraint {

    private Constraint toBeNegated;

    public NotConstraint(Constraint toBeNegated) {
        this.toBeNegated = toBeNegated;
    }

    @Override
    public List<List<AtomicConstraint>> flatten() {
        List<List<AtomicConstraint>> negated = new ArrayList<List<AtomicConstraint>>();
        List<HashSet<AtomicConstraint>> combinations = new ArrayList<HashSet<AtomicConstraint>>();
        combinations.add(new HashSet<AtomicConstraint>());

        for (List<AtomicConstraint> andBlock : toBeNegated.flatten()) {
            List<HashSet<AtomicConstraint>> newCombinations = new ArrayList<HashSet<AtomicConstraint>>();

            for (AtomicConstraint atomic : andBlock) {
                atomic.toggleNegated();

                for (HashSet<AtomicConstraint> partialCombination : combinations) {
                    HashSet<AtomicConstraint> combo = new HashSet<AtomicConstraint>(partialCombination);
                    combo.add(atomic);
                    newCombinations.add(combo);
                }
            }

            combinations = newCombinations;
        }

        for (HashSet<AtomicConstraint> combination : combinations) {
            negated.add(new ArrayList<AtomicConstraint>(combination));
        }

        return negated;
    }
}
