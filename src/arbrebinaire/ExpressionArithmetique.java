package arbrebinaire;

public class ExpressionArithmetique {
	private Noeud racine;
	
	public ExpressionArithmetique(Noeud racine){
		this.racine = racine;
	}

	public Noeud getRacine() {
		return racine;
	}

	public void afficherPostFixe() {
		VisiteurPostfixe pf = new VisiteurPostfixe();
		System.out.print("\n postfixe: "); 
		this.racine.accept(pf);
	}

	public int calculerValeur() {
		VisiteurValeur v = new VisiteurValeur();
		this.racine.accept(v);
		return v.getValue();
	}

	public int calculerHauteur() {
		VisiteurHauteur h = new VisiteurHauteur();
		this.racine.accept(h);
		return h.getMax();
	}
	
	public void afficherInFixe() {
		VisiteurInfixe vi = new VisiteurInfixe();
		System.out.print("\n infixe: ");
		this.racine.accept(vi);
	}
	
}
