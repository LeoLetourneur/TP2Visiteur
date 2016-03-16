package arbrebinaire;

public class VisiteurHauteur implements Visiteur {

	private int courante;
	private int max;
	
	public int getCourante() {
		return courante;
	}
	public void setCourante(int courante) {
		this.courante = courante;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}

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
