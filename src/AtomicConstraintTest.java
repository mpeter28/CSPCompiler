import org.junit.Test;
import org.junit.Assert;

import java.util.List;

public class AtomicConstraintTest {

    @Test
    public void GettersTest() {
        AtomicConstraint constraint = new AtomicConstraint(true, "A=1");
        Assert.assertEquals(true, constraint.isNegated());
        Assert.assertEquals("A=1", constraint.getClause());
    }

    @Test
    public void FlattenTest() {
        AtomicConstraint constraint = new AtomicConstraint(true, "A=1");

        List<List<AtomicConstraint>> result = constraint.flatten();
        Assert.assertEquals(1, result.size());
        Assert.assertEquals(1, result.get(0).size());
        Assert.assertEquals(true, result.get(0).get(0).isNegated());
        Assert.assertEquals("A=1", result.get(0).get(0).getClause());
    }
}
