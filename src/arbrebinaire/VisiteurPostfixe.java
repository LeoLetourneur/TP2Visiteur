package arbrebinaire;

public class VisiteurPostfixe implements Visiteur {

	@Override
	public void visiterConstante(Constante c) {
		System.out.print(c.getValeur());
	}

	@Override
	public void visiterOperateurUnaire(OperateurUnaire u) {
		if(u.getOpG() != null) {
			u.getOpG().accept(this);
		}
		System.out.print(u.getOp());
	}

	@Override
	public void visiterOperateurBinaire(OperateurBinaire b) {
		if(b.getOpG() != null) {
			b.getOpG().accept(this);
		}
		if (b.getOpD() != null) {
			b.getOpD().accept(this);
		}
		
		System.out.print(b.getOp());
	}

}
