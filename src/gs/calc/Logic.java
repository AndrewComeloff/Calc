package gs.calc;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;

public class Logic {
	
	/**
	 *  Производит вычисления и отдает результат
	 */

	protected static ArrayList<BigDecimal> listNumber = new ArrayList<BigDecimal>();
	protected static ArrayList<String> listArifmetical = new ArrayList<String>();

	static MathContext mc = new MathContext(10);
	static BigDecimal result = new BigDecimal(0, mc);

	public static void addListNumber(String v) { // добавление чисел в список
//		if (v == null) {
//			return;
//		}
		BigDecimal bd = new BigDecimal(v, mc);
		listNumber.add(bd);
		MainActivity.num = null;
		MainActivity.numLast = null;
	}

	public static void addListArifmetical(String v) { // добавление мат знаков в список
		listArifmetical.add(v);
	}

//	public static void readList() { // читаем массив чисел и выводим вспомогательный TextView
//		MainActivity.tvListNumber.setText("");
//		for (int i = 0; i < listNumber.size(); i++) {			
//			MainActivity.tvListNumber.setText(MainActivity.tvListNumber.getText().toString() + listNumber.get(i) + ", ");
//		}
//		MainActivity.tvListArifmetical.setText("");
//		for (int i = 0; i < listArifmetical.size(); i++) {			
//			MainActivity.tvListArifmetical.setText(MainActivity.tvListArifmetical.getText() + listArifmetical.get(i) + ", ");
//		}
//		
//	}

	public static Integer search(String v) { // test
		listArifmetical.add("x");
		listArifmetical.add("/");
		listArifmetical.add("-");
		listArifmetical.add("+");
		int pos = listArifmetical.indexOf(v);
		// int pos = Collections.binarySearch(listArifmetical, v);
		return pos;
	}

	public static String make() {
		if (listArifmetical.isEmpty() == true){
			result = listNumber.get(listNumber.size()-1);
			listNumber.clear();
			listArifmetical.clear();
			return result.toString();
		}
		if (listArifmetical.size() > 0 && listNumber.size() > 1){
//			MainActivity.unnecessary = false;
//			MainActivity.make = true;
			if (listArifmetical.contains("x") == true || listArifmetical.contains("/") == true) {  
				for (int i = 0; i < listArifmetical.size(); i++) {
					
					if (listArifmetical.get(i).equals("x")){
						result = listNumber.get(i).multiply(listNumber.get(i + 1), mc);
//						result = listNumber.get(i) * listNumber.get(i + 1);
						listNumber.set(i + 1, result);
						listNumber.remove(i);
						listArifmetical.remove(i);					
						i = i-1;
					}
					else if (listArifmetical.get(i).equals("/")){
						result = listNumber.get(i).divide(listNumber.get(i + 1), mc);
						listNumber.set(i + 1, result);
						listNumber.remove(i);
						listArifmetical.remove(i);
						i = i-1;
					}
				}
			}
			if (listArifmetical.contains("+") == true || listArifmetical.contains("-") == true) {
				for (int i = 0; i < listArifmetical.size(); i++) {
					
					if (listArifmetical.get(i).equals("+")){
						result = listNumber.get(i).add(listNumber.get(i + 1), mc);
						listNumber.set(i + 1, result);
						listNumber.remove(i);
						listArifmetical.remove(i);
						i = i-1;
					}
					else if (listArifmetical.get(i).equals("-")){
						result = listNumber.get(i).subtract(listNumber.get(i + 1), mc);
						listNumber.set(i + 1, result);
						listNumber.remove(i);
						listArifmetical.remove(i);		
						i = i-1;
					}
				}			
			}
			listNumber.clear();
			listArifmetical.clear();			
		}
		return result.toString();

	}

	

	public static void listDel() {
		listNumber.clear();
		listArifmetical.clear();
		result = null;
	}
	
	

}
