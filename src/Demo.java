import java.util.List;

public class Demo {
	public static void main(String[] args) {
		Constraint one = new OrConstraint( new AtomicConstraint(false, "C = 4"),
				new AtomicConstraint(false, "D = 7"));
		Constraint two = new OrConstraint( new AtomicConstraint(true, "E = A"),
				new AtomicConstraint(false, "D = M"));
		Constraint three = new AndConstraint( one, two);
		Constraint four = new OrConstraint( new AtomicConstraint(false, "A = 3"), three);
		Constraint nine = new OrConstraint( new AtomicConstraint( true, "C = K "),
				new AtomicConstraint(false, "K = 17"));
        Constraint ten = new AndConstraint( new AtomicConstraint( false, "A = 4"),
        		nine);
        Constraint eleven = new AndConstraint( new AtomicConstraint( true, "L = 1"), 
        		ten);
        Constraint twelve = new AndConstraint (four, eleven);
        Constraint thirteen = new NotConstraint( new AtomicConstraint(false, "G = 7"));
        Constraint fourteen = new OrConstraint( thirteen, new AtomicConstraint( true, "H = 4"));
        Constraint fifteen = new AndConstraint( fourteen, new AtomicConstraint( false, "L = 4"));
        Constraint sixteen = new OrConstraint( new AtomicConstraint(false, "M = 1"),
        		new AtomicConstraint(false, "N = 42"));
        Constraint seventeen = new AndConstraint( new AtomicConstraint( false, "M = A"), sixteen); 
		Constraint eighteen = new OrConstraint( new AtomicConstraint(false, "M = N"), seventeen);
		Constraint nineteen = new OrConstraint(fifteen, eighteen);
		Constraint twenty = new OrConstraint(new AtomicConstraint(false, "G = 4"), nineteen);
		Constraint twenty1 = new OrConstraint(new AtomicConstraint(false, "F = 1"), twenty);
		Constraint twenty2 = new AndConstraint(new AtomicConstraint(false, "J = 11"),
				new AtomicConstraint(true, "J = C"));
		Constraint twenty3 = new AndConstraint( twenty2, twenty1);
		Constraint twenty4 = new OrConstraint(twelve, twenty3);
		Constraint twenty5 = new AndConstraint( new AtomicConstraint(false, "O = 1"), 
				new AtomicConstraint(false, "A = B"));
		Constraint twenty6 = new OrConstraint( new AtomicConstraint(false, "G = I"), 
				new AtomicConstraint(false, "H = 1"));
		Constraint twenty7 = new AndConstraint( twenty5, twenty6);
		Constraint twenty8 = new NotConstraint(new OrConstraint( new AtomicConstraint( false, "L = B"), new AtomicConstraint( false, "O = H")));
		Constraint twenty9 = new AndConstraint(new AtomicConstraint(false, "K = D"), new AtomicConstraint( false, "O = A"));
		Constraint thirty = new AndConstraint( twenty8, twenty9);
		Constraint thirty1= new OrConstraint(new AtomicConstraint(false, " D = F"), new AtomicConstraint(false, "I = G"));
		Constraint thirty2= new OrConstraint(thirty1, thirty);
		Constraint thirty3 = new OrConstraint(twenty7, thirty2);
		Constraint thirty4 = new AndConstraint( twenty4, thirty3);
		
		Constraint root = thirty4;
		
        List<List<AtomicConstraint>> demo = root.flatten();
        
        System.out.println("Unflattened: " + root.toString());
        System.out.println("Flattened: " + demo.toString());
	}
}
