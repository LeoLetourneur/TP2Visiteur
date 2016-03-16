package arbrebinaire;

public interface Visiteur {
	
	public void visiterConstante(Constante c);
	
	public void visiterOperateurNegation(Negation n);
	
	public void visiterOperateurAddition(Addition a);

	public void visiterOperateurMultiplication(Multiplication m);
}
