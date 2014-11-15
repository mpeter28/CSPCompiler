import java.util.ArrayList;
import java.util.List;

public class TestConstraint implements Constraint {

    public List<List<AtomicConstraint>> flatten() {
        List<List<AtomicConstraint>> preBuiltList = new ArrayList<List<AtomicConstraint>>();

        List<AtomicConstraint> andBlock = new ArrayList<AtomicConstraint>();
        andBlock.add(new AtomicConstraint(true, "A=1"));
        andBlock.add(new AtomicConstraint(false, "A=2"));
        andBlock.add(new AtomicConstraint(true, "B=1"));
        andBlock.add(new AtomicConstraint(false, "B=2"));

        preBuiltList.add(andBlock);

        List<AtomicConstraint> andBlockTwo = new ArrayList<AtomicConstraint>();
        andBlockTwo.add(new AtomicConstraint(true, "C=1"));
        andBlockTwo.add(new AtomicConstraint(false, "C=2"));
        andBlockTwo.add(new AtomicConstraint(true, "D=1"));
        andBlockTwo.add(new AtomicConstraint(false, "D=2"));

        preBuiltList.add(andBlockTwo);

        return preBuiltList;
    }

}