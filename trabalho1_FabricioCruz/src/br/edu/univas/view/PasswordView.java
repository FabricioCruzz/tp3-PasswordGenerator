package br.edu.univas.view;

public class PasswordView {
	
	public void printMinimumSize() {
		System.out.println("Defina um tamanho mínimo para a sua senha:");
	}
	
	public void printMaximumSize() {
		System.out.println("Defina um tamanho máximo para a sua senha:");
	}
	
	public void printQuestionUppercase() {
		System.out.println("Sua senha possuirá letras maiúsculas? (Responda: S/N)");
	}
	
	public void printQuestionLowercase() {
		System.out.println("Sua senha possuirá letras minúsculas? (Responda: S/N)");
	}
	
	public void printWrongAnswer() {
		System.out.println("ERRO: Você digitou um valor inválido para este campo, por favor, insira um valor válido!\n");
	}
	
	public void printQuestionNumbers() {
		System.out.println("Sua senha possuirá números? (Responda: S/N)");
	}
	
	public void printQuestionSpecialCharacters() {
		System.out.println("Sua senha possuirá caracteres especiais? (Responda: S/N)");
	}
	
	public void printQuestionPathToSavePassword() {
		System.out.println("Por favor, informe o local que será salvo:");
	}
	
	public void printErrorMessageNumbers() {
		System.out.println("ERRO: Você não pode definir um MIN/MAX menor ou igual a zero!\n");
	}
	
	public void printErrorMessageParameters() {
		System.out.println("ERRO: Você deve definir ao menos um tipo de parâmetro para sua senha!\n");
	}
	
	public void printSuccesMessagePassword() {
		System.out.println("SENHA CRIADA COM SUCESSO!");
	}
}
