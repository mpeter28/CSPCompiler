import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;


public class AndConstraintTest {

	@Test
	public void flattenTest() {
		TestConstraint c = new TestConstraint();
		AndConstraint and = new AndConstraint( c, c );
		
		List<AtomicConstraint> 
				x = new ArrayList<AtomicConstraint>(),
				y = new ArrayList<AtomicConstraint>(),
				z = new ArrayList<AtomicConstraint>(),
				w = new ArrayList<AtomicConstraint>();
		
		List<List<AtomicConstraint>> canon = new ArrayList<List<AtomicConstraint>>();
		x.add( new AtomicConstraint(true, "A=1") );
		x.add( new AtomicConstraint(false, "A=2") );
		x.add( new AtomicConstraint(true, "B=1") );
		x.add( new AtomicConstraint(false, "B=2") );
		x.add( new AtomicConstraint(true, "A=1") );
		x.add( new AtomicConstraint(false, "A=2") );
		x.add( new AtomicConstraint(true, "B=1") );
		x.add( new AtomicConstraint(false, "B=2") );
		
		y.add( new AtomicConstraint(true, "A=1") );
		y.add( new AtomicConstraint(false, "A=2") );
		y.add( new AtomicConstraint(true, "B=1") );
		y.add( new AtomicConstraint(false, "B=2") );
		y.add( new AtomicConstraint(true, "C=1") );
		y.add( new AtomicConstraint(false, "C=2") );
		y.add( new AtomicConstraint(true, "D=1") );
		y.add( new AtomicConstraint(false, "D=2") );
		
		z.add( new AtomicConstraint(true, "C=1") );
		z.add( new AtomicConstraint(false, "C=2") );
		z.add( new AtomicConstraint(true, "D=1") );
		z.add( new AtomicConstraint(false, "D=2") );
		z.add( new AtomicConstraint(true, "A=1") );
		z.add( new AtomicConstraint(false, "A=2") );
		z.add( new AtomicConstraint(true, "B=1") );
		z.add( new AtomicConstraint(false, "B=2") );

		w.add( new AtomicConstraint(true, "C=1") );
		w.add( new AtomicConstraint(false, "C=2") );
		w.add( new AtomicConstraint(true, "D=1") );
		w.add( new AtomicConstraint(false, "D=2") );
		w.add( new AtomicConstraint(true, "C=1") );
		w.add( new AtomicConstraint(false, "C=2") );
		w.add( new AtomicConstraint(true, "D=1") );
		w.add( new AtomicConstraint(false, "D=2") );
		
		canon.add( x );
		canon.add( y );
		canon.add( z );
		canon.add( w );

		boolean pass = true;
		List<List<AtomicConstraint>> flattened = and.flatten();
		
		for( int i = 0; i < canon.size() && pass; i++ ) {
			for( int j = 0; j < canon.size() && pass; j++ ) {
				if( !canon.get(i).get(j).equals(flattened.get(i).get(j)))
					pass = false;
			}
		}
		Assert.assertTrue( pass );
	}
}
