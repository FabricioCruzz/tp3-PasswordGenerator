package br.edu.univas.vo;

public class PasswordCharacteristics {	
	
	private int min = 0;
	private int max = 0;
	
	
	private boolean uppercase = false;
	private boolean lowercase = false;
	
	private boolean numbers = false;
	
	private boolean specialCharacters = false;
	
	private String[] uppercaseArray = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
	private String[] lowercaseArray = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
	private String[] numbersArray = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
	private String[] specialCharactersArray = {"!", "@", "#", "$", "%", "&", "*"};
	
//	ESTA CLASSE NÃO POSSUI OS "SETS" PARA OS ARRAYS PARA QUE O USUÁRIO NÃO ALTERE A ESTRUTURA PADRÃO
	
	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public boolean isUppercase() {
		return uppercase;
	}

	public void setUppercase(boolean uppercase) {
		this.uppercase = uppercase;
	}

	public boolean isLowercase() {
		return lowercase;
	}

	public void setLowercase(boolean lowercase) {
		this.lowercase = lowercase;
	}

	public boolean isNumbers() {
		return numbers;
	}

	public void setNumbers(boolean numbers) {
		this.numbers = numbers;
	}

	public boolean isSpecialCharacters() {
		return specialCharacters;
	}
	
	public void setSpecialCharacters(boolean specialCharacters) {
		this.specialCharacters = specialCharacters;
	}
	
	
	
	public String[] getUppercaseArray() {
		return uppercaseArray;
	}

	public String[] getLowercaseArray() {
		return lowercaseArray;
	}

	public String[] getNumbersArray() {
		return numbersArray;
	}

	public String[] getSpecialCharactersArray() {
		return specialCharactersArray;
	}

		
}
