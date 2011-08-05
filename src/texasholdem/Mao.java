package texasholdem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Mao implements Comparable<Mao>{

	private List<Carta> cartas = new ArrayList<Carta>();
	private ClassificacaoMao classificacao;
	
	@Override
	public int compareTo(Mao o) {
		return this.classificacao.getValor().compareTo(
				o.classificacao.getValor());
	}
	
	public void avalia(){
		classificacao = ClassificacaoMao.NADA;
		
		boolean flush = isFlush();
		boolean straight = isStraight();
		
		if (flush && straight) {
			classificacao = ClassificacaoMao.STRAIGHT_FLUSH;
		} else if (flush) {
			classificacao = ClassificacaoMao.FLUSH;
		} else if (straight) {
			classificacao = ClassificacaoMao.STRAIGHT;
		} else {
			
			int[] valores = new int[15];
			for (Carta carta : cartas) {
				valores[carta.getValor()] ++;
			}
			int maiorValor = 0;
			int segundoMaiorValor = 0;
			
			for (int i = 2; i < valores.length; i++) {
				if (valores[i] >= maiorValor) {
					segundoMaiorValor = maiorValor;
					maiorValor = valores[i];
				} else if (valores[i] > segundoMaiorValor) {
					segundoMaiorValor = valores[i];
				}
			}
			
			if (maiorValor == 2 && segundoMaiorValor == 2) {
				classificacao = ClassificacaoMao.DOIS_PARES;
			}
			else if (maiorValor == 3 && segundoMaiorValor == 2) {
				classificacao = ClassificacaoMao.FULL_HOUSE;
			}else if(maiorValor == 2) {
				classificacao = ClassificacaoMao.PAR;
			}else if(maiorValor == 3) {
				classificacao = ClassificacaoMao.TRINCA;
			}else if(maiorValor == 4) {
				classificacao = ClassificacaoMao.QUADRA;
			}
		}
		
	}
	
	private boolean isStraight(){
		
		Integer valor = cartas.get(cartas.size() - 1).getValor();
		
		boolean as = (valor == 14);
		boolean temDois = (cartas.get(0).getValor() == 2);
		
		for (int i = 0; i < cartas.size() - (as && temDois ? 2 : 1); i++) {
			if (cartas.get(i).getValor() !=
					cartas.get(i + 1).getValor() - 1) {
				return false;
			}
		}
		
		
		
		return true;
	}
	
	private boolean isFlush() {
		Carta primeiraCarta = cartas.get(0);
		
		for (int i = 1; i < cartas.size(); i++) {
			if (!cartas.get(i).getNaipe().equals(primeiraCarta.getNaipe())) {
				return false;
			}
		}
		
		return true;
	}
	
	private void addCarta(Carta carta) {
		cartas.add(carta);
	}
	
	@Override
	public String toString() {
		StringBuilder mao = new StringBuilder();
		for (Carta carta: cartas) {
			mao.append(carta.toString());
			mao.append(" ");
		}
		return mao.toString().trim();
	}

	public static Mao parse(String cartas){
		String[] cartasStr = cartas.split(" ");
		Mao mao = new Mao();
		for (String s : cartasStr) {
			Carta carta = Carta.parse(s);
			mao.addCarta(carta);
		}
		
		Collections.sort(mao.getCartas());
		return mao;
	}

	public List<Carta> getCartas() {
		return cartas;
	}
	
	public String getNome() {
		return classificacao.getNome();
	}
	
	public Integer getValor() {
		return classificacao.getValor();
	}
	
}
