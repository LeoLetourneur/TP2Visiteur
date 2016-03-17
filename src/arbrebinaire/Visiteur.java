package arbrebinaire;

/**
 * Interface Visiteur
 * @author GERLAND - LETOURNEUR
 */
public interface Visiteur {
	
	/**
	 * Affichage de la constance
	 */
	public void visiterConstante(Constante c);
	
	/**
	 * Affichage de la négation
	 */
	public void visiterOperateurNegation(Negation n);
	
	/**
	 * Affichage de l'addition
	 */
	public void visiterOperateurAddition(Addition a);

	/**
	 * Affichage de la multiplication
	 */
	public void visiterOperateurMultiplication(Multiplication m);
}
