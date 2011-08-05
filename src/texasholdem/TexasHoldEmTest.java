package texasholdem;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;


public class TexasHoldEmTest {
	
	@Test
	public void testAvalia(){
		
		List<Mao> listMaos = new ArrayList<Mao>();
		
		Mao mao1 = Mao.parse("Qh Js Th Ad Kh");
		mao1.avalia();
		Assert.assertEquals("Straight", mao1.getNome());
		
		Mao mao2 = Mao.parse("4h 8h 9h Qh Kh");
		mao2.avalia();
		Assert.assertEquals("Flush", mao2.getNome());
		
		Mao mao3 = Mao.parse("2h 3h 4h 5h 6h");
		mao3.avalia();
		Assert.assertEquals("Straight Flush", mao3.getNome());
		
		Mao mao4 = Mao.parse("Ah Ac 3h 4h 5h");
		mao4.avalia();
		Assert.assertEquals("Par", mao4.getNome());
		
		Mao mao5 = Mao.parse("Ah As Ac 4h 5h");
		mao5.avalia();
		Assert.assertEquals("Trinca", mao5.getNome());
		
		Mao mao6 = Mao.parse("Ah As Ac Ad 5h");
		mao6.avalia();
		Assert.assertEquals("Quadra", mao6.getNome());
		
		Mao mao7 = Mao.parse("Ah Ad Ac 4h 4c");
		mao7.avalia();
		Assert.assertEquals("Full House", mao7.getNome());
		
		listMaos.add(mao1);
		listMaos.add(mao2);
		listMaos.add(mao3);
		listMaos.add(mao4);
		listMaos.add(mao5);
		listMaos.add(mao6);
		listMaos.add(mao7);
		
		Collections.sort(listMaos);
		Assert.assertEquals(mao3, listMaos.get(6));
		
	}
	
}
