package desafioControleFluxo;

import java.util.Scanner;

public class Contador {

	static Contador exec = new Contador();

	public static void main(String[] args) {
		exec.executar();
	}

	public void executar() {
		try (Scanner scan = new Scanner(System.in)) {
			try {
				System.out.print("Digite o primeiro número: ");
				int parametroUm = scan.nextInt();

				System.out.print("Digite o segundo número: ");
				int parametroDois = scan.nextInt();

				contar(parametroUm, parametroDois);
			} catch (NumberFormatException e) {
				System.out.println("Os parâmetros devem ser números inteiros.");
				executar();
			} catch (ParametrosInvalidosException e) {
				System.out.println(e.getMessage());
				System.out.println("Por favor, tente novamente.");
				executar();
			}
		}
	}

	static void contar(int parametroUm, int parametroDois) throws ParametrosInvalidosException {
		if (parametroUm >= parametroDois) {
			throw new ParametrosInvalidosException("O segundo parâmetro deve ser maior que o primeiro");
		}

		for (int i = 1; i <= (parametroDois - parametroUm); i++) {
			System.out.println("Imprimindo o número " + i);
		}
	}
}
