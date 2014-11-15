import java.util.ArrayList;
import java.util.List;

public class AndConstraint implements Constraint {
	
	private Constraint left;
	private Constraint right;
	
	public AndConstraint( Constraint l, Constraint r ) {
		this.left = l;
		this.right = r;
	}
    
	@Override
	public String toString() {
		return "( " + left.toString() + " AND " + right.toString() + " )";
	}
	
    @Override
    public List<List<AtomicConstraint>> flatten() {
       List<List<AtomicConstraint>> leftResult = left.flatten();
       List<List<AtomicConstraint>> rightResult = right.flatten();
       
       ArrayList<List<AtomicConstraint>> flattened = new ArrayList<List<AtomicConstraint>>();
       
       for( List<AtomicConstraint> list : leftResult ) {
    	   for( List<AtomicConstraint> list2 : rightResult ) {
    		   List<AtomicConstraint> r = new ArrayList<AtomicConstraint>();
    		   r.addAll( list );
    		   r.addAll( list2 );
    		   flattened.add( r );
    	   }
       }
       
       return flattened;
    }
}
