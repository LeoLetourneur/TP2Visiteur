package arbrebinaire;

public class VisiteurInfixe implements Visiteur {

	private int parenthese = 0;
	
	@Override
	public void visiterConstante(Constante c) {
		System.out.print(c.getValeur());
	}

	@Override
	public void visiterOperateurNegation(Negation n) {
		System.out.print("("+n.getOp());
		n.getOpG().accept(this);
		System.out.print(")");
	}

	@Override
	public void visiterOperateurAddition(Addition a) {
		if(parenthese > 0)
			System.out.print("(");
		a.getOpG().accept(this);
		System.out.print(a.getOp());
		a.getOpD().accept(this);
		if(parenthese > 0)
			System.out.print(")");
		
	}

	@Override
	public void visiterOperateurMultiplication(Multiplication m) {
		parenthese++;
		m.getOpG().accept(this);
		System.out.print(m.getOp());
		m.getOpD().accept(this);
		parenthese--;
	}
}
