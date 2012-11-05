package gs.calc;

public class Parse {
	
	/**
	* принимает строку от Bracket с мат уравнением и раскидывает по спискам числа и мат. действия
	* и возвращает результат от Logic
	*/
	
	public static String parse(String equation) {
//		if (equation.indexOf('=') != -1){ // Если это не первое уравнение, то предыдущие вычисления отбрасываются
//			equation = equation.substring(equation.lastIndexOf('=')+2, equation.length());
//		}
		
		String number = equation;
		String arifmetical = equation;
		
		if (equation.endsWith("/0") == true){
			return equation = "Деление на ноль";
		}
		
		number = number.replace('x', 's');
		number = number.replace('/', 's');
		number = number.replace('+', 's');
		
//		char minus;
		char[] chars = number.toCharArray();
		for (int i = 1; i < chars.length; i++){
			if (chars[i] == '-' && chars[i-1] != 's'){
				chars[i] = 's';
			}
		}
		number = String.valueOf(chars);
		
		number = number + "s";
		
		int lengthArif = -2; // подсчет количества мат. действий
		for (int i = 0; i < number.length(); i++) {
			  if (number.charAt(i) == 's'){
				  lengthArif++;				  
			  }			     
			}
		
		for (int i = 1; i < arifmetical.length(); i++){
			if (number.charAt(i) == 's'){
				if (equation.charAt(i) == 'x'){
					Logic.addListArifmetical("x");
				}
				if (equation.charAt(i) == '/'){
					Logic.addListArifmetical("/");
				}
				if (equation.charAt(i) == '+'){
					Logic.addListArifmetical("+");
				}
				if (equation.charAt(i) == '-'){
					Logic.addListArifmetical("-");
				}
				
			}
		}
			
			
			for (int i = -2; i < lengthArif; i++){ // заполнение списка ListNumber
				if(number.contentEquals("") != true){
					Logic.addListNumber(number.substring(0, number.indexOf('s')).toString());				
					number = number.replaceFirst(number.substring(0, number.indexOf('s')+1), ""); // удаление чисел занесенных уже в список
				}
//				if (number.substring(0, number.indexOf('s')).contentEquals("") != true){						
					
//				}
				
			}	
			
			equation = Logic.make();
		
			while (equation.indexOf('.') != -1 && equation.endsWith("0")) {
				equation = equation.subSequence(0, equation.length()-1).toString();						
			}
			if (equation.endsWith(".")){
				equation = equation.subSequence(0, equation.length()-1).toString();
			}

			return equation;
	}
	
	void removeZero (){
		
	}

}
