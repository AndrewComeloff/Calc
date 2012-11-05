package gs.calc;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	final int MENU_RESET_ID = 1;
	final int MENU_QUIT_ID = 2;
	final int MENU_WHITE_ID = 3;
	final int MENU_BLACK_ID = 4;

	SharedPreferences sPref;
	final String SAVED_TEXT = "saved_text";
	final String CAUNT_BRACKET_L = "caunt_bracket_l";
	final String CAUNT_BRACKET_R = "caunt_bracket_r";
	final String RESULT_BAK = "bak_result";
	
	public static String num, numLast;
	String bak = "";
	
	boolean dot = false;
	
//	int style = R.layout.main;

	
	int bracketL, bracketR = 0;

	ImageButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9,
			btnDot, btnPlus, btnMake, btnSubtraction, btnMultiply, btnDivide,
			btnBackspace, btnBracketL, btnBracketR, btnCancle;

	static TextView tvResult;

	ScrollView vScroll;
//	HorizontalScrollView hScroll;
	
//	Vibrator vibr = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
	final long vibrMS = 15; // продолжительность вибро




	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		btn0 = (ImageButton) findViewById(R.id.btn0);
		btn0.setOnClickListener(this);
		btn1 = (ImageButton) findViewById(R.id.btn1);
		btn1.setOnClickListener(this);
		btn2 = (ImageButton) findViewById(R.id.btn2);
		btn2.setOnClickListener(this);
		btn3 = (ImageButton) findViewById(R.id.btn3);
		btn3.setOnClickListener(this);
		btn4 = (ImageButton) findViewById(R.id.btn4);
		btn4.setOnClickListener(this);
		btn5 = (ImageButton) findViewById(R.id.btn5);
		btn5.setOnClickListener(this);
		btn6 = (ImageButton) findViewById(R.id.btn6);
		btn6.setOnClickListener(this);
		btn7 = (ImageButton) findViewById(R.id.btn7);
		btn7.setOnClickListener(this);
		btn8 = (ImageButton) findViewById(R.id.btn8);
		btn8.setOnClickListener(this);
		btn9 = (ImageButton) findViewById(R.id.btn9);
		btn9.setOnClickListener(this);
		btnCancle = (ImageButton) findViewById(R.id.btnCancle);
		btnCancle.setOnClickListener(this);
		btnDivide = (ImageButton) findViewById(R.id.btnDivide);
		btnDivide.setOnClickListener(this);
		btnDot = (ImageButton) findViewById(R.id.btnDot);
		btnDot.setOnClickListener(this);
		btnMake = (ImageButton) findViewById(R.id.btnMake);
		btnMake.setOnClickListener(this);
		btnMultiply = (ImageButton) findViewById(R.id.btnMultiply);
		btnMultiply.setOnClickListener(this);
		btnPlus = (ImageButton) findViewById(R.id.btnPlus);
		btnPlus.setOnClickListener(this);
		btnBracketL = (ImageButton) findViewById(R.id.btnBracketL);
		btnBracketL.setOnClickListener(this);
		btnBracketR = (ImageButton) findViewById(R.id.btnBracketR);
		btnBracketR.setOnClickListener(this);
		btnBackspace = (ImageButton) findViewById(R.id.btnBackspace);
		btnBackspace.setOnClickListener(this);
		btnSubtraction = (ImageButton) findViewById(R.id.btnSubtraction);
		btnSubtraction.setOnClickListener(this);
		
		
		// јнимаци€ 
		Animation anim; 
//		Animation animCombo;
		
		anim = AnimationUtils.loadAnimation(this, R.anim.anim_1);
		btn0.startAnimation(anim);
		anim = AnimationUtils.loadAnimation(this, R.anim.anim_2);
		btnDot.startAnimation(anim);
		anim = AnimationUtils.loadAnimation(this, R.anim.anim_3);
		btnPlus.startAnimation(anim);
		anim = AnimationUtils.loadAnimation(this, R.anim.anim_4);
		btnMake.startAnimation(anim);
		anim = AnimationUtils.loadAnimation(this, R.anim.anim_5);
		btnSubtraction.startAnimation(anim);
		anim = AnimationUtils.loadAnimation(this, R.anim.anim_6);
		btn3.startAnimation(anim);
		anim = AnimationUtils.loadAnimation(this, R.anim.anim_7);
		btn2.startAnimation(anim);
		anim = AnimationUtils.loadAnimation(this, R.anim.anim_8);
		btn1.startAnimation(anim);
		anim = AnimationUtils.loadAnimation(this, R.anim.anim_9);
		btn4.startAnimation(anim);
		anim = AnimationUtils.loadAnimation(this, R.anim.anim_10);
		btn5.startAnimation(anim);
		anim = AnimationUtils.loadAnimation(this, R.anim.anim_11);
		btn6.startAnimation(anim);
		anim = AnimationUtils.loadAnimation(this, R.anim.anim_12);
		btnMultiply.startAnimation(anim);
		anim = AnimationUtils.loadAnimation(this, R.anim.anim_13);
		btnDivide.startAnimation(anim);
		anim = AnimationUtils.loadAnimation(this, R.anim.anim_14);
		btn9.startAnimation(anim);
		anim = AnimationUtils.loadAnimation(this, R.anim.anim_15);
		btn8.startAnimation(anim);
		anim = AnimationUtils.loadAnimation(this, R.anim.anim_16);
		btn7.startAnimation(anim);
		anim = AnimationUtils.loadAnimation(this, R.anim.anim_17);
		btnBracketL.startAnimation(anim);
		anim = AnimationUtils.loadAnimation(this, R.anim.anim_18);
		btnBracketR.startAnimation(anim);
		anim = AnimationUtils.loadAnimation(this, R.anim.anim_19);
		btnCancle.startAnimation(anim);
		anim = AnimationUtils.loadAnimation(this, R.anim.anim_20);
		btnBackspace.startAnimation(anim);
		
//		animCombo = AnimationUtils.loadAnimation(this, R.anim.anim_combo);
		

		tvResult = (TextView) findViewById(R.id.tvResult);
//		tvListNumber = (TextView)findViewById(R.id.tvListNumber);
//		tvListArifmetical = (TextView)findViewById(R.id.tvListArifmetical);

		vScroll = (ScrollView) findViewById(R.id.vScroll);
		
		loadText();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn0:
			((Vibrator)getSystemService(VIBRATOR_SERVICE)).vibrate(vibrMS);
			String tvRes = " "+tvResult.getText().toString();
			if (tvRes.endsWith(" 0") || tvRes.endsWith("x0") || tvRes.endsWith("/0") ||
					tvRes.endsWith("+0") || tvRes.endsWith("-0") || tvRes.endsWith("(0") == true){
				return;
			}				
			viewNumber("0");
			anim = AnimationUtils.loadAnimation(this, R.anim.anim_combo);
			btn0.startAnimation(anim);
			
//			vibr.vibrate(50);
			break;
		case R.id.btn1:	
			((Vibrator)getSystemService(VIBRATOR_SERVICE)).vibrate(vibrMS);
			viewNumber("1");
			anim = AnimationUtils.loadAnimation(this, R.anim.anim_combo);
			btn1.startAnimation(anim);	
			break;
		case R.id.btn2:
			((Vibrator)getSystemService(VIBRATOR_SERVICE)).vibrate(vibrMS);
			viewNumber("2");
			anim = AnimationUtils.loadAnimation(this, R.anim.anim_combo);
			btn2.startAnimation(anim);	
			break;
		case R.id.btn3:
			((Vibrator)getSystemService(VIBRATOR_SERVICE)).vibrate(vibrMS);
			viewNumber("3");
			anim = AnimationUtils.loadAnimation(this, R.anim.anim_combo);
			btn3.startAnimation(anim);	
			break;
		case R.id.btn4:
			((Vibrator)getSystemService(VIBRATOR_SERVICE)).vibrate(vibrMS);
			viewNumber("4");
			anim = AnimationUtils.loadAnimation(this, R.anim.anim_combo);
			btn4.startAnimation(anim);	
			break;
		case R.id.btn5:
			((Vibrator)getSystemService(VIBRATOR_SERVICE)).vibrate(vibrMS);
			viewNumber("5");			
			anim = AnimationUtils.loadAnimation(this, R.anim.anim_combo);
			btn5.startAnimation(anim);			
			break;
		case R.id.btn6:
			((Vibrator)getSystemService(VIBRATOR_SERVICE)).vibrate(vibrMS);
			viewNumber("6");
			anim = AnimationUtils.loadAnimation(this, R.anim.anim_combo);
			btn6.startAnimation(anim);	
			break;
		case R.id.btn7:
			((Vibrator)getSystemService(VIBRATOR_SERVICE)).vibrate(vibrMS);
			viewNumber("7");
			anim = AnimationUtils.loadAnimation(this, R.anim.anim_combo);
			btn7.startAnimation(anim);	
			break;
		case R.id.btn8:
			((Vibrator)getSystemService(VIBRATOR_SERVICE)).vibrate(vibrMS);
			viewNumber("8");
			anim = AnimationUtils.loadAnimation(this, R.anim.anim_combo);
			btn8.startAnimation(anim);	
			break;
		case R.id.btn9:
			((Vibrator)getSystemService(VIBRATOR_SERVICE)).vibrate(vibrMS);
			viewNumber("9");
			anim = AnimationUtils.loadAnimation(this, R.anim.anim_combo);
			btn9.startAnimation(anim);	
			break;
		case R.id.btnCancle:
			((Vibrator)getSystemService(VIBRATOR_SERVICE)).vibrate(vibrMS);
			reset();
			tvResult.setText("");
			Logic.listDel();
			anim = AnimationUtils.loadAnimation(this, R.anim.anim_combo);
			btnCancle.startAnimation(anim);
			break;
		case R.id.btnDot:
			((Vibrator)getSystemService(VIBRATOR_SERVICE)).vibrate(vibrMS);
			String res = tvResult.getText().toString();
			if (res.endsWith("+") || res.endsWith("-")|| res.endsWith("x")|| res.endsWith("/")|| res.endsWith("(") || res.length() == 0) {
				viewNumber("0");
			}
			if (!dot){
				viewNumber(".");
				dot = true;
			}			
							
			anim = AnimationUtils.loadAnimation(this, R.anim.anim_combo);
			btnDot.startAnimation(anim);
			break;
		case R.id.btnMake:
			((Vibrator)getSystemService(VIBRATOR_SERVICE)).vibrate(vibrMS);
			dot();
			tvRes = tvResult.getText().toString();
			if (tvRes.endsWith("+") || tvRes.endsWith("-") || tvRes.endsWith("(") || 
					tvRes.endsWith("x") || tvRes.endsWith("/") == true){
				break;
			}
			while (bracketL > bracketR) {
				tvResult.setText(tvResult.getText() + ")");
				bracketR++;
			}
			tvResult.append(Html.fromHtml("=" + "<font color='grey'><b><br>" + 
			Bracket.bracket(tvResult.getText().toString()) + "</br></b></font>", null, null));
			bak = tvResult.getText().toString();
			scrollDown();
			anim = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);
			tvResult.startAnimation(anim);	
			
			btnMake.startAnimation(anim_combo);	
			dot = false;
			if (tvResult.getText().toString().endsWith("ноль")){
				tvResult.startAnimation(anim);
			}
			break;
		case R.id.btnMultiply:
			((Vibrator)getSystemService(VIBRATOR_SERVICE)).vibrate(vibrMS);
//			tvResult.setText(tvResult.getText() + "x");
			viewArfmetical("x");
			anim = AnimationUtils.loadAnimation(this, R.anim.anim_combo);
			btnMultiply.startAnimation(anim);
			break;
		case R.id.btnDivide:
			((Vibrator)getSystemService(VIBRATOR_SERVICE)).vibrate(vibrMS);
//			tvResult.setText(tvResult.getText() + "/");
			viewArfmetical("/");
			anim = AnimationUtils.loadAnimation(this, R.anim.anim_combo);
			btnDivide.startAnimation(anim);
			break;
		case R.id.btnPlus:
			((Vibrator)getSystemService(VIBRATOR_SERVICE)).vibrate(vibrMS);
//			tvResult.setText(tvResult.getText() + "+");
			viewArfmetical("+");
			anim = AnimationUtils.loadAnimation(this, R.anim.anim_combo);
			btnPlus.startAnimation(anim);
			break;
		case R.id.btnSubtraction:
			((Vibrator)getSystemService(VIBRATOR_SERVICE)).vibrate(vibrMS);
//			tvResult.setText(tvResult.getText() + "-");
			viewArfmetical("-");
			anim = AnimationUtils.loadAnimation(this, R.anim.anim_combo);
			btnSubtraction.startAnimation(anim);
			break;
		case R.id.btnBracketL:
			((Vibrator)getSystemService(VIBRATOR_SERVICE)).vibrate(vibrMS);
			scrollDown();
			tvRes = tvResult.getText().toString();
			if (tvRes.length() == 1 && tvRes.endsWith("-") == true){
				return;
			}
			if (tvRes.length()>1){
				if (tvRes.charAt(tvRes.length()-2) == 'x' || tvRes.charAt(tvRes.length()-2) == '/'
						|| tvRes.charAt(tvRes.length()-2) == '+'|| tvRes.charAt(tvRes.length()-2) == '-'){
					return;
				}
			}
			if(tvRes.endsWith("+") || tvRes.endsWith("-") || tvRes.endsWith("(") || 
					tvRes.endsWith("x") || tvRes.endsWith("/") == true || tvRes.length() == 0){
				tvResult.setText(tvResult.getText() + "(");
				bracketL++;				
			}
			anim = AnimationUtils.loadAnimation(this, R.anim.anim_combo);
			btnBracketL.startAnimation(anim);
			break;			
		case R.id.btnBracketR:
			((Vibrator)getSystemService(VIBRATOR_SERVICE)).vibrate(vibrMS);
			if (bracketL > bracketR){
				scrollDown();
				tvRes = tvResult.getText().toString();				
				if (tvRes.endsWith("+") || tvRes.endsWith("-") || tvRes.endsWith("(") || 
						tvRes.endsWith("x") || tvRes.endsWith("/") || tvRes.endsWith("(") == true){
					break;
				}
				tvResult.setText(tvResult.getText() + ")");
				bracketR++;					
								
			}
			anim = AnimationUtils.loadAnimation(this, R.anim.anim_combo);
			btnBracketR.startAnimation(anim);
				break;
		case R.id.btnBackspace:
			((Vibrator)getSystemService(VIBRATOR_SERVICE)).vibrate(vibrMS);
			scrollDown();
			backspace();
			anim = AnimationUtils.loadAnimation(this, R.anim.anim_combo);
			btnBackspace.startAnimation(anim);
			break;
//			}
		}

	}

	void viewNumber(String num1) { // составление числа из цифр

		scrollDown();
		
		if (tvResult.getText().length() != 0){
			if (bak.equals(tvResult.getText().toString()) == true){
				return;
			}			
		}
		
		
		numLast = num1;

		tvResult.setText(tvResult.getText() + num1);

		if (num == null) {
			num = num1;
			return;
		}
		if (num != null) {
			num = num + num1;
			return;
		}

	}

	void viewArfmetical(String v) { // замена арифметического знака
		String tvRes = tvResult.getText().toString();		
		if (v != "-" && tvRes.length() < 1 || tvRes.endsWith("\n") == true){
			return;
		}
		dot();
		
		if (v != "-" && tvRes.endsWith("(") || tvRes.endsWith("(-") == true) {
			if (v == "+" && tvRes.endsWith("(-") == true){
				backspace();
			}
			return;
		}
		if (tvRes.endsWith("+") || tvRes.endsWith("-") || 
			tvRes.endsWith("x") || tvRes.endsWith("/") == true) { // смотрит наличие арифметического знака			
			if (v == "+" && tvRes.charAt(0) == '-' && tvRes.length() < 2) { // в самом начале, если стоит знак -, то при нажатии +, - уберетс€
				backspace();
				return;
			}
			if (tvRes.charAt(0) == '-' && tvRes.length() < 2){ 
				return;
			}
			if (v != "-"){ // если нажали +,х или /, то знак заменитс€
				backspace();
				if (tvRes.charAt(tvRes.length()-2) == '-'){ // ≈сли последний знак был "-" и перед ним сто€л 
					backspace();                            // ещЄ один знак, то удал€тс€ оба знака и станет новый
				}
			}

			if (v == "-" && tvRes.charAt(tvRes.length()-2) == '-' || tvRes.charAt(tvRes.length()-2) == '+'
					|| tvRes.charAt(tvRes.length()-2) == 'x' || tvRes.charAt(tvRes.length()-2) == '/'){ // дает возможность поставить - после */+-
				if (tvRes.charAt(tvRes.length()-1) == '-' && v == "-"){
					backspace();
					backspace();
					tvResult.setText(tvResult.getText() + v+v);
				}
				backspace();  			    
			}
		}
		tvResult.setText(tvResult.getText() + v);
		dot = false;
		scrollDown();
		num = null;
//		make = false;
		return;
	}
	
	void dot(){ // добавл€ет ноль после дроби, если не поставлено значение после зап€той
		String res = tvResult.getText().toString();
		if (res.endsWith(".")){
			tvResult.setText(tvResult.getText() + "0");			
		}
	}
	
	void backspace(){		
		String val = tvResult.getText().toString().substring(bak.length());	
		if (val.endsWith(")") == true){
			bracketR--;
		}	
		if (val.endsWith("(") == true){
			bracketL--;
		}
		if (val.endsWith(".") == true){
			dot = false;
		}
		
		if(val.length() < 1){
			return;
		}
		String tvRes = val.subSequence(0, val.length()-1).toString();
			tvResult.setText(bak + tvRes);
//		}
	}

	void reset() {
		num = null; 
		numLast = null;		
//		make = false;
		bracketL = 0; 
		bracketR = 0;
		bak = "";
		dot = false;
	}

	void scrollDown() {
		
		vScroll.post(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				vScroll.fullScroll(View.FOCUS_DOWN);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		menu.add(0, MENU_RESET_ID, 0, "Reset");
		menu.add(0, MENU_QUIT_ID, 0, "Quit");
		menu.add(0, MENU_WHITE_ID, 0, "White");
		menu.add(0, MENU_BLACK_ID, 0, "Black");
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case MENU_RESET_ID:
			// очищаем пол€
			tvResult.setText("");
			break;
		case MENU_QUIT_ID:
			// выход из приложени€
			saveText();
			finish();
			break;
		case MENU_WHITE_ID:
//			style = R.layout.main;
			onCreate(null);	
			break;
		case MENU_BLACK_ID:
			setContentView(R.layout.main2);
					
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	 void saveText(){
	 sPref = getPreferences(MODE_PRIVATE);
	 Editor ed = sPref.edit();
	 ed.putString(SAVED_TEXT, tvResult.getText().toString());
	 ed.putInt(CAUNT_BRACKET_L, bracketL);
	 ed.putInt(CAUNT_BRACKET_R, bracketR);
	 ed.putString(RESULT_BAK, bak);
	 ed.commit();
//	 Toast.makeText(this, "Text saved", 1000).show();
	 }
	
	 void loadText(){
	 sPref = getPreferences(MODE_PRIVATE);
	 String savedText = sPref.getString(SAVED_TEXT, "");
	 Integer cauntBracketL = sPref.getInt(CAUNT_BRACKET_L, 0);
	 Integer cauntBracketR = sPref.getInt(CAUNT_BRACKET_R, 0);
	 String resultBak = sPref.getString(RESULT_BAK, "");
	 tvResult.setText(savedText);
	 bracketL = cauntBracketL;
	 bracketR = cauntBracketR;
	 bak = resultBak;
	 
	 Toast.makeText(this, "Loaded", 1000).show();
	 scrollDown();
	 }
	 
	 @Override
	  protected void onDestroy() {
	    saveText();
	    super.onDestroy();
	  }

}
