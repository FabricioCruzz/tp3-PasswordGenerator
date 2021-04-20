package br.edu.univas.view;

public class PasswordView {
	
	public void printMinimumSize() {
		System.out.println("Defina um tamanho m�nimo para a sua senha:");
	}
	
	public void printMaximumSize() {
		System.out.println("Defina um tamanho m�ximo para a sua senha:");
	}
	
	public void printQuestionUppercase() {
		System.out.println("Sua senha possuir� letras mai�sculas? (Responda: S/N)");
	}
	
	public void printQuestionLowercase() {
		System.out.println("Sua senha possuir� letras min�sculas? (Responda: S/N)");
	}
	
	public void printWrongAnswer() {
		System.out.println("ERRO: Voc� digitou um valor inv�lido para este campo, por favor, insira um valor v�lido!\n");
	}
	
	public void printQuestionNumbers() {
		System.out.println("Sua senha possuir� n�meros? (Responda: S/N)");
	}
	
	public void printQuestionSpecialCharacters() {
		System.out.println("Sua senha possuir� caracteres especiais? (Responda: S/N)");
	}
	
	public void printQuestionPathToSavePassword() {
		System.out.println("Por favor, informe o local que ser� salvo:");
	}
	
	public void printErrorMessageNumbers() {
		System.out.println("ERRO: Voc� n�o pode definir um MIN/MAX menor ou igual a zero!\n");
	}
	
	public void printErrorMessageParameters() {
		System.out.println("ERRO: Voc� deve definir ao menos um tipo de par�metro para sua senha!\n");
	}
	
	public void printSuccesMessagePassword() {
		System.out.println("SENHA CRIADA COM SUCESSO!");
	}
}
