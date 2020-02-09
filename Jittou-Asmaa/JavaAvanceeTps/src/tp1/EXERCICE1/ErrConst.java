package tp1.EXERCICE1;

public class ErrConst extends Exception {
	private int valeur;

	public ErrConst(int valeur) {
		this.valeur = valeur;
		}
	public ErrConst() {
		
		}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}
}
