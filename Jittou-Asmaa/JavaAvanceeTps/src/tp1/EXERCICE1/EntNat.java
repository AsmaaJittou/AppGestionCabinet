package tp1.EXERCICE1;

public class EntNat {

	private int n;
	public EntNat (int n) throws ErrConst
	{
	if (n<0) { throw new ErrConst() ;}
	this.n = n;
	}
	public int getN() {return n;}
  
	public static void somme(EntNat a , EntNat b ) throws ErrConst, ErrSom {
		if (a.getN()<0 || b.getN()<0) { throw new ErrConst() ;}
		else {
			if((a.getN() + b.getN())> Integer.MAX_VALUE ) {
				throw new ErrSom() ;
			}
		}
	}
	public static void diff(EntNat a , EntNat b ) throws ErrConst, ErrDiff {
		if (a.getN()<0 || b.getN()<0) { throw new ErrConst() ;}
		else {
			if((a.getN() - b.getN())> Integer.MAX_VALUE ) {
				throw new ErrDiff() ;
			}
		}
	}
	public static void produit(EntNat a , EntNat b ) throws ErrConst, ErrPro {
		if (a.getN()<0 || b.getN()<0) { throw new ErrConst() ;}
		else {
			if((a.getN() * b.getN())> Integer.MAX_VALUE ) {
				throw new ErrPro() ;
			}
		}
	}
}
