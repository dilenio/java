package br.com.codenation;

import java.util.Arrays;

public class StatisticUtil {

	public static int average(int[] elements)
	{
		int somaDosElementos = 0;

		for (int index = 0; index < elements.length; index++) {
			somaDosElementos += elements[index];
		}
		int media = somaDosElementos/elements.length;
		return media;
	}

	public static int mode(int[] elements) {
		int comparar = 0;
		int moda = 0;
		for (int index = 0; index < elements.length; index++) {
			int ocorre = 0;

			for (int index2 = 0; index2 < elements.length; index2++) {
				if (elements[index] == elements[index2]) {
					ocorre++;
				}
			}
			if (ocorre > comparar) {
				moda = elements[index];
				comparar = ocorre;
			}
		}

		return moda;
	}

	public static int median(int[] elements) {
		Arrays.sort(elements);

		if (elements.length %2 == 1) {
			int calculaImpar = elements.length / 2;
			return elements[calculaImpar];
		}
		int calculaPar1 = (elements.length / 2) - 1;
		int calculaPar2 = elements.length / 2;
		int mediana = (elements[calculaPar1] + elements[calculaPar2]) / 2;
		return mediana;
	}
}