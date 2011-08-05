package texasholdem;
import org.junit.Assert;
import org.junit.Test;


public class MaoTeste {

	@Test
	public void testParse() {
		Mao mao1 = Mao.parse("9c Ah Ks Kd 9d");
		Assert.assertEquals(5, mao1.getCartas().size());
		Assert.assertTrue(mao1.getCartas().contains(Carta.parse("9c")));
	}
	
}
