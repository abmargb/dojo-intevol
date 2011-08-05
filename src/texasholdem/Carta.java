package texasholdem;

public class Carta implements Comparable<Carta> {
	private Character naipe;
	private Integer valor;

	private Carta(int valor, Character naipe) {
		this.valor = valor;
		this.naipe = naipe;
	}

	public Character getNaipe() {
		return naipe;
	}

	public void setNaipe(Character naipe) {
		this.naipe = naipe;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	@Override
	public int compareTo(Carta o) {
		return this.getValor().compareTo(o.getValor());
	}

	@Override
	public String toString(){
		StringBuilder cartaString = new StringBuilder();
		
		int valor = this.getValor();
		if (valor < 10) {
			cartaString.append(this.getValor());
		} else {
			switch (valor) {
			case 10:
				cartaString.append("T");
				break;
			
			case 11:
				cartaString.append("J");
				break;
				
			case 12:
				cartaString.append("Q");
				break;
			
			case 13:
				cartaString.append("K");
				break;
				
			case 14:
				cartaString.append("A");
			default:
				break;
			}	
		}

		cartaString.append(this.getNaipe());
		return cartaString.toString();
	}

	public static Carta parse(String carta) {
		char[] caracteres = carta.toCharArray();
		int valor = valorCarta(caracteres[0]);
		Character naipe = caracteres[1];
		return new Carta(valor, naipe);
	}

	private static int valorCarta(char valorChar) {

		if (Character.isDigit(valorChar)) {
			return Character.getNumericValue(valorChar);
		} else {
			
			switch (valorChar) {
			case 'T':
				return 10;
			case 'J':
				return 11;
			case 'Q':
				return 12;
			case 'K':
				return 13;
			case 'A':
				return 14;
			default:
				return 0;
			}
		}
		
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Carta)) {
			return false;
		}
		Carta carta = (Carta) obj;
		return (carta.getNaipe().equals(this.naipe) && carta.getValor().equals(
				this.getValor()));
	}
}
