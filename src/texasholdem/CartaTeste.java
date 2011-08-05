package texasholdem;
import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class CartaTeste {

	@Test
	public void testParse(){
		Carta carta1 = Carta.parse("Kc");
		assertEquals(new Character('c'), carta1.getNaipe());
		assertEquals(new Integer(13), carta1.getValor());
		
		Carta carta2 = Carta.parse("2d");
		assertEquals(new Character('d'), carta2.getNaipe());
		assertEquals(new Integer(2), carta2.getValor());
		
		Carta carta3 = Carta.parse("Ah");
		assertEquals(new Character('h'), carta3.getNaipe());
		assertEquals(new Integer(14), carta3.getValor());
		
		Carta carta4 = Carta.parse("Ts");
		assertEquals(new Character('s'), carta4.getNaipe());
		assertEquals(new Integer(10), carta4.getValor());
		
		Carta carta5 = Carta.parse("Qh");
		assertEquals(new Character('h'), carta5.getNaipe());
		assertEquals(new Integer(12), carta5.getValor());
		
		Carta carta6 = Carta.parse("Jh");
		assertEquals(new Character('h'), carta6.getNaipe());
		assertEquals(new Integer(11), carta6.getValor());
	}
	
}
