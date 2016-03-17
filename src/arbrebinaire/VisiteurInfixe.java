package arbrebinaire;

public class VisiteurInfixe implements Visiteur {

	private boolean parenthese = false;
	
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
		if(parenthese)
			System.out.print("(");
		a.getOpG().accept(this);
		System.out.print(a.getOp());
		a.getOpD().accept(this);
		if(parenthese)
			System.out.print(")");
		
	}

	@Override
	public void visiterOperateurMultiplication(Multiplication m) {
		parenthese = true;
		m.getOpG().accept(this);
		System.out.print(m.getOp());
		m.getOpD().accept(this);
		parenthese = false;
	}
}
