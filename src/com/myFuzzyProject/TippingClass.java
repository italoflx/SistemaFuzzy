package com.myFuzzyProject;

import java.util.Scanner;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;

public class TippingClass {
	public static void main(String[] args) throws Exception {
		Scanner ler = new Scanner(System.in);
		float color, size;
		
		String filename = "tipper.fcl"; //arquivo FCL
		FIS fis = FIS.load(filename, true); //carregamento

		if (fis == null) { //erro durante o carregamento do arquivo
			System.err.println("Can't load file: '" + filename + "'");
			System.exit(1);
		}

		// Get default function block
		FunctionBlock fb = fis.getFunctionBlock(null);
	
		
		// Defini��es de vari�veis de entrada FIS
		System.out.println("Digite o grau de vermelho - Numero real entre 1 e 10");
		color = ler.nextFloat();
		System.out.println("Digite a area danificada - Numero real entre 1 e 100");
		size = ler.nextFloat();
		fb.setVariable("color", color);
		fb.setVariable("size", size);

		// Execu��o do sistema
		fb.evaluate();

		// Show output variable's chart
		fb.getVariable("tip").defuzzify();

		float resultado = (float) fb.getVariable("tip").getValue();
		System.out.println(resultado);
		
		if(resultado >= 0 && resultado <= 2.9) {
			System.out.println("Camarao saudavel");
		}else if(resultado >= 3 && resultado <= 7) {
			System.out.println("Camarao pouco doente");
		}else if(resultado >= 6 && resultado <= 10) {
			System.out.println("Camarao doente");
		}
	}
}
