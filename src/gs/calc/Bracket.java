package gs.calc;

public class Bracket {
	
	/**
	* разбивает полученную строку с уравнением, в котором есть скобки,
	* на блоки с математической очередностью
	*/	
	
	public static String bracket(String equation){
		
		if (equation.indexOf('=') != -1){ // Если это не первое уравнение, то предыдущие вычисления отбрасываются
			equation = equation.substring(equation.lastIndexOf('=')+2, equation.length());
		}
		
		equation = "(" + equation + ")";
		
		int lengthBracket = 0; // колличество мат уравнений
		for (int i = 0; i < equation.length(); i++){
			if (equation.charAt(i) == '('){
				  lengthBracket++;				  
			  }	
		}
		
		String result = null;
		String parse = null;		
		
		
		for (int i = 0; i < lengthBracket; i++){
			String equationFirst = equation.substring(0, equation.indexOf(')')+1);
			result = equationFirst.substring(equationFirst.lastIndexOf('('));
			parse = Parse.parse(result.substring(1, result.length()-1));
			equation = equation.replace(result, parse);
		}
		
		
		return equation;
	}
}
