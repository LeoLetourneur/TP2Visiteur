package arbrebinaire;

public class VisiteurInfixe implements Visiteur {

	private boolean parenthese = false;
	
	@Override
	public void visiterConstante(Constante c) {
		System.out.print(c.getValeur());
		if(parenthese) {
			parenthese = false;
			System.out.print(")");
		}
	}

	@Override
	public void visiterOperateurNegation(Negation n) {
		System.out.print("("+n.getOp());
		parenthese = true;
		n.getOpG().accept(this);
	}

	@Override
	public void visiterOperateurAddition(Addition a) {
		System.out.print("(");
		a.getOpG().accept(this);
		System.out.print(a.getOp());
		a.getOpD().accept(this);
		System.out.print(")");
		
	}

	@Override
	public void visiterOperateurMultiplication(Multiplication m) {
		m.getOpG().accept(this);
		System.out.print(m.getOp());
		m.getOpD().accept(this);
	}
}
