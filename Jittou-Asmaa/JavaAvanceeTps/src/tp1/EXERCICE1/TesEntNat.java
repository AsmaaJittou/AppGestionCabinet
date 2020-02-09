package tp1.EXERCICE1;

public class TesEntNat {
	public TesEntNat() {
		super();
	}
	public static void main (String args[])
	{
	try
	{
	EntNat V1 = new EntNat (7);
	System.out.println("PREMIERE VALEUR = " + V1.getN( )) ;
	EntNat V2 = new EntNat (-14);
	System.out.println("DEUXIEME VALEUR = " + V2.getN( )) ;
	}
	catch (ErrConst e)
	{
	System.out.println( e.getValeur( ) );
	}
	}

}
