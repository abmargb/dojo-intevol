package katabank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class KataBankOCR {

	static String[] NUMEROS = new String[]{" _ " +
			"| |" +
			"|_|",

			"   " +
					"  |" +
					"  |",

					" _ " +
							" _|" +
							"|_ ",

							" _ " +
									" _|" +
									" _|",

									"   " +
											"|_|" +
											"  |",

											" _ " +
													"|_ " +
													" _|",

													" _ " +
															"|_ " +
															"|_|",

															" _ " +
																	"  |" +
																	"  |",

																	" _ " +
																			"|_|" +
																			"|_|",

																			" _ " +
																					"|_|" +
	" _|"};
	//	(d1+2*d2+3*d3 +..+9*d9) mod 11 = 0
	static boolean checkSum(Integer[] toBeChecked){

		int soma = 0;
		for (int i = 0; i < toBeChecked.length; i++) {
			Integer number = toBeChecked[toBeChecked.length - i - 1];
			if (number == null) {
				return false;
			}
			soma += number * (i+1);
		}
		return soma % 11 == 0;	
	}

	static int diff(String numberA, String numberB) {

		int diffs = 0;
		for (int i = 0; i < numberA.length(); i++) {
			if (numberA.charAt(i) != numberB.charAt(i)) {
				diffs++;
			}
		}

		return diffs;
	}

	public static void tentaCorrecao(String[] aSerCorrigido, Map<String, Integer> strToNum){

		for (int i = 0; i < aSerCorrigido.length; i++) {
			for(int j = 0; j < 10; j++) {
				if (diff(aSerCorrigido[i], NUMEROS[j]) == 1) {
					String[] temp = Arrays.copyOf(aSerCorrigido, aSerCorrigido.length);
					temp[i] = NUMEROS[j];
					Integer[] numeroModificado = new Integer[9];
					for (int k=0; k<9; k++ ){
						Integer numero = strToNum.get(temp[k].toString());
						numeroModificado[k] = numero;
					}
					
					if(checkSum(numeroModificado)){
						System.out.println(Arrays.toString(numeroModificado));
					}
				}
			}
		}	
	}
	
	public static void main(String[] args) {

		Map<Integer, String> numToStr = new HashMap<Integer, String>();
		Map<String, Integer> strToNum = new HashMap<String, Integer>(); 
		for (int i = 0; i < NUMEROS.length; i++) {
			strToNum.put(NUMEROS[i], i);
			numToStr.put(i, NUMEROS[i]);
		}

		Scanner sc = new Scanner(System.in);
		String[] linhas = new String[3];
		for (int i = 0; i < 3; i++) {
			String linha = sc.nextLine();
			linhas[i] = linha;
		}

		Integer[] entradas = new Integer[9];

		String[] entradaString = new String[9];


		boolean ill = false;
		for (int i = 0; i < 9; i++) {

			StringBuilder entrada = new StringBuilder();

			for (int j = 0; j < 3; j++) {
				entrada.append(linhas[j].substring(i*3, (3*i)+3));
			}
			entradaString[i] = entrada.toString();

			Integer numero = strToNum.get(entrada.toString());
			if (numero == null) {
				ill = true;
			}

			entradas[i] = numero;
		}

		for (int i = 0; i < entradas.length; i++) {
			System.out.print(entradas[i]);
		}
		System.out.println();

		boolean err = !checkSum(entradas);

		if (ill) {
			System.out.println("ILL");
		} else if (err) {
			System.out.println("ERR");
		}

		if (ill || err) {
			tentaCorrecao(entradaString, strToNum);
		}
		
	}

}
