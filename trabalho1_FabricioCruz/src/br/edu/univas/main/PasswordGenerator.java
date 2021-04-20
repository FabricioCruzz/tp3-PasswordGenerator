package br.edu.univas.main;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

import br.edu.univas.view.PasswordView;
import br.edu.univas.vo.PasswordCharacteristics;

public class PasswordGenerator {
	
	private static Scanner scanner = new Scanner(System.in);
	private static PasswordView view = new PasswordView();
	
	public static void main(String[] args) throws IOException {
		
		PasswordCharacteristics passwordCharacteristics = new PasswordCharacteristics();
		Random random = new Random();

		
		String path;
		
		captureDataAboutPasswordSize(passwordCharacteristics);
			
		capturePasswordData(passwordCharacteristics);
		
		
//		 PROGRAMA SOLICITA O LOCAL DE SALVAMENTO DO ARQUIVO TXT:::
		view.printQuestionPathToSavePassword();
		path = scanner.nextLine();
		
//		DEFINE UM TAMANHO ALEATÓRIO PARA A SENHA COM BASE NO MÍNIMO E MÁXIMO DECLARADOS PELO USUÁRIO:::
		int passwordLenght = random.nextInt((passwordCharacteristics.getMax() - passwordCharacteristics.getMin()) + 1) + passwordCharacteristics.getMin();

		StringBuilder password = constructsStringBuilderSenha(random, passwordCharacteristics, passwordLenght);
		
//		SENHA CONSTRUÍDA COM SUCESSO:::
		view.printSuccesMessagePassword();
		System.out.println(password.toString());
		
		StringBuilder constructsPath = constructsFilePath(path);
		
		generatesFilePassword(constructsPath, password);
		
		scanner.close();
	}
	
	/**
	 * ESTE MÉTODO REALIZA O TRATAMENTO PARA O ENTER NÃO CONSUMIDO AO LER UM DADO NUMÉRICO DO TECLADO E RETORNA O VALOR LIDO
	 */
	public static int readInteger() {
		int value = scanner.nextInt();
		scanner.nextLine();
		return value;
	}
	
	/**
	 * ESTE MÉTODO REALIZA A VERIFICAÇÃO DO TIPO DE INFORMAÇÃO FORNECIDO PELO USUÁRIO E RETORNA UM VALOR BOOLEANO
	 */
	public static boolean isYes(String answer) {
		if(answer.equalsIgnoreCase("S")) {
			return true;
		}
		return false;
	}
	
	/**
	 * ESTE MÉTODO REALIZA A VALIDAÇÃO DOS DADOS FORNECIDOS PELO USUÁRIO ATRAVÉS DO TECLADO
	 */
	public static String validatesAnswer(String answer) {
		
		if(answer.equalsIgnoreCase("S") || answer.equalsIgnoreCase("N")) {		
			return answer;
		}
		else {
			boolean swap = false;
			while(!swap) {
				view.printWrongAnswer();
				answer = scanner.nextLine();
				if(answer.equalsIgnoreCase("S") || answer.equalsIgnoreCase("N")) {
					swap = true;
				}
			}
			return answer;
		}
	}
	
	/**
	 * ESTE MÉTODO REALIZA A CAPTURA DOS DADOS DE TAMANHO DA SENHA FORNECIDOS PELO USUÁRIO ATRAVÉS DO TECLADO
	 */
	public static void captureDataAboutPasswordSize(PasswordCharacteristics characteristics) {
		
		view.printMinimumSize();
		int min = readInteger();
		characteristics.setMin(min);
		
		view.printMaximumSize();
		int max= readInteger();
		characteristics.setMax(max);
		
		if(characteristics.getMin() <= 0 || characteristics.getMax() <= 0) {
			view.printErrorMessageNumbers();
			captureDataAboutPasswordSize(characteristics);
		}
		
	}

	/**
	 * ESTE MÉTODO REALIZA A CAPTURA DOS DADOS DE CARACTERÍSTICAS DA SENHA DO USUÁRIO ATRAVÉS DO TECLADO
	 */
	
	public static void capturePasswordData(PasswordCharacteristics characteristics) {
		
		String answer;
		
		boolean answerBoolean = false;
		
		//PERGUNTA SOBRE LETRAS MAIUSCULAS NA SENHA:::
		view.printQuestionUppercase();
		answer = scanner.nextLine();		
		validatesAnswer(answer);
		answerBoolean = isYes(answer);
		characteristics.setUppercase(answerBoolean);
					
		//PERGUNTA SOBRE LETRAS MINUSCULAS NA SENHA:::
		view.printQuestionLowercase();
		answer = scanner.nextLine();
		validatesAnswer(answer);
		answerBoolean = isYes(answer);
		characteristics.setLowercase(answerBoolean);
				
		//PERGUNTA SOBRE NUMEROS NA SENHA NA SENHA:::		
		view.printQuestionNumbers();
		answer = scanner.nextLine();
		validatesAnswer(answer);
		answerBoolean = isYes(answer);
		characteristics.setNumbers(answerBoolean);
		
		//PERGUNTA SOBRE CARACTERES ESPECIAIS NA SENHA:::
		view.printQuestionSpecialCharacters();
		answer = scanner.nextLine();
		validatesAnswer(answer);
		answerBoolean = isYes(answer);
		characteristics.setSpecialCharacters(answerBoolean);
			
		if(!characteristics.isUppercase() && !characteristics.isLowercase() && !characteristics.isNumbers() && !characteristics.isSpecialCharacters()) {
			view.printErrorMessageParameters();
			capturePasswordData(characteristics);
		}		
	}
	
	/**
	 * ESTE MÉTODO UTILIZA UM STRING BUILDER PARA CRIAR A SENHA DO USUÁRIO
	 */
	public static StringBuilder constructsStringBuilderSenha(Random random, PasswordCharacteristics characteristics, int passwordLength) {
		
		StringBuilder password = new StringBuilder();
		
		int idx;
		
		for (int i = 0; i < passwordLength; i++) {
			
			if(characteristics.isUppercase()) {
				
				idx = random.nextInt(characteristics.getUppercaseArray().length);
				password.append(characteristics.getUppercaseArray()[idx]);
				
				if(password.length() == passwordLength) {
					break;
				}
			}
			
			if(characteristics.isLowercase()) {
				
				idx = random.nextInt(characteristics.getLowercaseArray().length);
				password.append(characteristics.getLowercaseArray()[idx]);
				
				if(password.length() == passwordLength) {
					break;
				}
			}
			
			if(characteristics.isNumbers()) {
				
				idx = random.nextInt(characteristics.getNumbersArray().length);
				password.append(characteristics.getNumbersArray()[idx]);
				
				if(password.length() == passwordLength) {
					break;
				}
			}
			if(characteristics.isSpecialCharacters()) {
				
				idx = random.nextInt(characteristics.getSpecialCharactersArray().length);
				password.append(characteristics.getSpecialCharactersArray()[idx]);
				
				if(password.length() == passwordLength) {
					break;
				}
			}
			
			
		}
		return password;
	}
	
	/**
	 * ESTE MÉTODO CONSTRÓI O "CAMINHO" QUE O USUÁRIO INFORMOU PARA SALVAR O ARQUIVO TXT DA SENHA
	 */
	public static StringBuilder constructsFilePath(String path) {
		
		StringBuilder constructsPath = new StringBuilder();
		
		constructsPath.append(path);
		constructsPath.append("\\secret_password.txt");
		
		return constructsPath;
	}
	
	/**
	 * ESTE MÉTODO REALIZA A CRIAÇÃO DO ARQUIVO TXT COM A SENHA
	 */
	public static void generatesFilePassword(StringBuilder constructsPath, StringBuilder password) throws IOException {
		
		String filePath = constructsPath.toString();
		
		FileWriter file = new FileWriter(filePath);
		PrintWriter saveFile = new PrintWriter(file);
		
		saveFile.printf("%s", password.toString());
		
		file.close();
		
	}

	
}
