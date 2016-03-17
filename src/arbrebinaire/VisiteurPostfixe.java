package arbrebinaire;

/**
 * Interface Visiteur postfixe
 * @author GERLAND - LETOURNEUR
 */
public class VisiteurPostfixe implements Visiteur {

	@Override
	public void visiterConstante(Constante c) {
		System.out.print(c.getValeur());
	}

	@Override
	public void visiterOperateurNegation(Negation n) {
		n.getOpG().accept(this);
		System.out.print(n.getOp());
	}

	@Override
	public void visiterOperateurAddition(Addition a) {
		a.getOpG().accept(this);
		a.getOpD().accept(this);
		System.out.print(a.getOp());
	}

	@Override
	public void visiterOperateurMultiplication(Multiplication m) {
		m.getOpG().accept(this);
		m.getOpD().accept(this);
		System.out.print(m.getOp());
	}

}
