package arbrebinaire;

/**
 * Interface Visiteur hauteur
 * @author GERLAND - LETOURNEUR
 */
public class VisiteurHauteur implements Visiteur {

	/**
	 * courante permet de retenir la hauteur au noeud courant
	 */
	private int courante = 0;
	public int getCourante() { return courante; }
	
	/**
	 * max permet de retenir la hauteur max dans l'arbre
	 */
	private int max = 0;
	public int getMax() { return max; }
	
	@Override
	public void visiterConstante(Constante c) {
		courante += 1;
		if(courante > max)
			max = courante;
	}

	@Override
	public void visiterOperateurNegation(Negation n) {
		courante += 1;
		n.getOpG().accept(this);
	}

	@Override
	public void visiterOperateurAddition(Addition a) {
		courante += 1;
		int temp = courante;
		a.getOpG().accept(this);
		courante = temp;
		a.getOpD().accept(this);
	}

	@Override
	public void visiterOperateurMultiplication(Multiplication m) {
		courante += 1;
		int temp = courante;
		m.getOpG().accept(this);
		courante = temp;
		m.getOpD().accept(this);
	}
}
