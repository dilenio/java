package br.com.codenation.calculadora;


public class CalculadoraSalario {

	public long calcularSalarioLiquido(double salarioBase) {
		//Use o Math.round apenas no final do método para arredondar o valor final.
		//Documentação do método: https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#round-double-
		double valorInss = calcularInss(salarioBase);
		double valorIrff = calcularIrff(salarioBase - valorInss);
		double salarioLiquido = salarioBase - (valorInss + valorIrff);
		if (salarioBase < 1039.00) {
			salarioLiquido = 0;
		}
		
		return Math.round(salarioLiquido);
	}
	
	
	//Exemplo de método que pode ser criado para separar melhor as responsábilidades de seu algorítmo
	private double calcularInss(double salarioBase) {
		double valorInss = 0;
		if (salarioBase <= 1500.00) {
			valorInss = salarioBase * 0.08;
		} else if (salarioBase > 1500.00 && salarioBase <= 4000.00) {
			valorInss = salarioBase * 0.09;
		} else {
			valorInss = salarioBase * 0.11;
		}
		return valorInss;
	}
	
	private double calcularIrff(double salarioBase) {
		double valorIrff = 0;
		if (salarioBase < 3000.00) {
			valorIrff = 0;
		} else if (salarioBase > 3000.00 && salarioBase <= 6000.00) {
			valorIrff = salarioBase * 0.075;
		} else {
			valorIrff = salarioBase * 0.15;
		}
		return valorIrff;
	}

}
/*Dúvidas ou Problemas?
Manda e-mail para o meajuda@codenation.dev que iremos te ajudar! 
*/