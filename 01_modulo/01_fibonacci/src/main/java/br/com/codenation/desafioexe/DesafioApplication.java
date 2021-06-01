package br.com.codenation.desafioexe;

import java.util.List;
import java.util.ArrayList;

public class DesafioApplication {
	/* Gera uma sequencia Fibonacci até o número 350 */
	public static List<Integer> fibonacci() {
		List<Integer> fibonaccis = new ArrayList();
		fibonaccis.add(0);
		fibonaccis.add(1);
		for (int index = 0; fibonaccis.get(index + 1) <= 350; index++) {
			fibonaccis.add(fibonaccis.get(index) + fibonaccis.get(index + 1));
		}
		return fibonaccis;
	}

	/* Verifica se um número pertence a sequencia de Fibonacci */
	public static Boolean isFibonacci(Integer a) {
		List<Integer> number = fibonacci();
		if (number.contains(a)) {
			return true;
		}
		return false;
	}

}
