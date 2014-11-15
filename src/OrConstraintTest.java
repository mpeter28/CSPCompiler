import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class OrConstraintTest {

    @Test
    public void OrConstraintFlattenTest() {
        OrConstraint orConstraint = new OrConstraint(new TestConstraint(), new TestConstraint());
        List<List<AtomicConstraint>> result = orConstraint.flatten();

        List<AtomicConstraint> andBlock = result.get(0);
        Assert.assertEquals(true, andBlock.get(0).isNegated());
        Assert.assertEquals(false, andBlock.get(1).isNegated());
        Assert.assertEquals(true, andBlock.get(2).isNegated());
        Assert.assertEquals(false, andBlock.get(3).isNegated());

        Assert.assertEquals("A=1", andBlock.get(0).getClause());
        Assert.assertEquals("A=2", andBlock.get(1).getClause());
        Assert.assertEquals("B=1", andBlock.get(2).getClause());
        Assert.assertEquals("B=2", andBlock.get(3).getClause());

        andBlock = result.get(1);
        Assert.assertEquals(true, andBlock.get(0).isNegated());
        Assert.assertEquals(false, andBlock.get(1).isNegated());
        Assert.assertEquals(true, andBlock.get(2).isNegated());
        Assert.assertEquals(false, andBlock.get(3).isNegated());

        Assert.assertEquals("C=1", andBlock.get(0).getClause());
        Assert.assertEquals("C=2", andBlock.get(1).getClause());
        Assert.assertEquals("D=1", andBlock.get(2).getClause());
        Assert.assertEquals("D=2", andBlock.get(3).getClause());

        andBlock = result.get(2);
        Assert.assertEquals(true, andBlock.get(0).isNegated());
        Assert.assertEquals(false, andBlock.get(1).isNegated());
        Assert.assertEquals(true, andBlock.get(2).isNegated());
        Assert.assertEquals(false, andBlock.get(3).isNegated());

        Assert.assertEquals("A=1", andBlock.get(0).getClause());
        Assert.assertEquals("A=2", andBlock.get(1).getClause());
        Assert.assertEquals("B=1", andBlock.get(2).getClause());
        Assert.assertEquals("B=2", andBlock.get(3).getClause());

        andBlock = result.get(3);
        Assert.assertEquals(true, andBlock.get(0).isNegated());
        Assert.assertEquals(false, andBlock.get(1).isNegated());
        Assert.assertEquals(true, andBlock.get(2).isNegated());
        Assert.assertEquals(false, andBlock.get(3).isNegated());

        Assert.assertEquals("C=1", andBlock.get(0).getClause());
        Assert.assertEquals("C=2", andBlock.get(1).getClause());
        Assert.assertEquals("D=1", andBlock.get(2).getClause());
        Assert.assertEquals("D=2", andBlock.get(3).getClause());
    }
}
