package arbrebinaire;

/**
 * Interface Visiteur valeur
 * @author GERLAND - LETOURNEUR
 */
public class VisiteurValeur implements Visiteur {

	/**
	 * Value permet de retenir la résultat courent
	 */
	private int value;
	public int getValue() { return value; }

	@Override
	public void visiterConstante(Constante c) {
		value = c.getValeur();
	}

	@Override
	public void visiterOperateurNegation(Negation n) {
		n.getOpG().accept(this);
		value = -value;
	}

	@Override
	public void visiterOperateurAddition(Addition a) {
		int temp;
		a.getOpG().accept(this);
		temp = value;
		a.getOpD().accept(this);
		value = temp + value;
	}

	@Override
	public void visiterOperateurMultiplication(Multiplication m) {
		int temp;
		m.getOpG().accept(this);
		temp = value;
		m.getOpD().accept(this);
		value = temp * value;
	}
}
