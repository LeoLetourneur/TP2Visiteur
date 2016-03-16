package arbrebinaire;

public interface Visiteur {
	
	public void visiterConstante(Constante c);
	
	public void visiterOperateurUnaire(OperateurUnaire u);
	
	public void visiterOperateurBinaire(OperateurBinaire b);

}
