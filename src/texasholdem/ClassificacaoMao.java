package texasholdem;

public enum ClassificacaoMao {

	NADA(0, "Nada"), PAR(1, "Par"), DOIS_PARES(2, "Dois Pares"), 
	TRINCA(3, "Trinca"), STRAIGHT(4, "Straight"), FLUSH(5, "Flush"), 
	FULL_HOUSE(6, "Full House"), QUADRA(7, "Quadra"), STRAIGHT_FLUSH(8, "Straight Flush");
	
	Integer valor;
	String nome;
	
	private ClassificacaoMao(int valor, String nome) {
		this.valor = valor;
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Integer getValor() {
		return valor;
	}
}
