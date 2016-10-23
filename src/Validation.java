import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Validation {
	
	private String num;
	
	private List<Character> list_num;
	private List<Character> validation_symbols;
	private List<String> validation_symbols_for_mobile;
	
	private List<String> list_num_for_eq;
	
	private Code code;
	private Calculate calc;
	
	public Validation(String num){
		this.num = num;
		firstVal();
	}
	
	private void firstVal(){
		
		String val_num = this.num;
		list_num = new ArrayList<Character>();

		validation_symbols = new ArrayList<Character>();
		validation_symbols.add('0');
		validation_symbols.add('1');
		validation_symbols.add('2');
		validation_symbols.add('3');
		validation_symbols.add('4');
		validation_symbols.add('5');
		validation_symbols.add('6');
		validation_symbols.add('7');
		validation_symbols.add('8');
		validation_symbols.add('9');
		validation_symbols.add('+');
		
		for(int i = 0; i < val_num.length(); i++){

			if(validation_symbols.contains(val_num.charAt(i))){
				list_num.add(i, val_num.charAt(i));
			}else{
				System.out.println("Помилковий символ - " + val_num.charAt(i));
				return;
			}			
		}
		
		System.out.println("" + num);
		
		if(list_num.size() == 10){
			secondValForMobile(list_num);
		}else if (list_num.size() == 13) {
			secondValForCountries();
		}else{
			System.out.println("Не вірний формат номеру");
		}
	}
		
	private void secondValForMobile(List<Character> list_num){
		
		validation_symbols_for_mobile = new ArrayList<>();

		validation_symbols_for_mobile.add("067");
		validation_symbols_for_mobile.add("068");
		validation_symbols_for_mobile.add("096");
		validation_symbols_for_mobile.add("097");
		validation_symbols_for_mobile.add("098");

		validation_symbols_for_mobile.add("050");
		validation_symbols_for_mobile.add("066");
		validation_symbols_for_mobile.add("095");
		validation_symbols_for_mobile.add("099");
		
		validation_symbols_for_mobile.add("063");
		validation_symbols_for_mobile.add("093");
		
		validation_symbols_for_mobile.add("094");
			
		char a = num.charAt(0);
		char b = num.charAt(1);
		char c = num.charAt(2);
		
		String abc = (String)(""+a+b+c);
		
		for(int i = 0; i < validation_symbols_for_mobile.size(); i++){
			if(validation_symbols_for_mobile.get(i).equals(abc)){
				
				if(abc.equals("067") || abc.equals("068") || abc.equals("096") || abc.equals("068") || abc.equals("096") || abc.equals("097") || abc.equals("098")){
					System.out.println("Дзвінок на мобільний номер " + "Київстар");
				}else if(abc.equals("050") || abc.equals("066") || abc.equals("095")|| abc.equals("099")){
					System.out.println("Дзвінок на мобільний номер " + "МТС");
				}else if(abc.equals("063") || abc.equals("093")){
					System.out.println("Дзвінок на мобільний номер " + "Life:) ");
				}else if(abc.equals("094"))
					System.out.println("Дзвінок на мобільний номер " + "Інтертелеком");
				calc = new Calculate(num);
				return;
			}
		}
		
		System.out.println("Код номеру не зареєстровано в Україні");
	}
	
	private void secondValForCountries(){
		
		code = new Code();
		
		list_num_for_eq = new ArrayList<String>();
		list_num_for_eq.add(num);

		Set set = code.getCountries().entrySet();
		Iterator iter = set.iterator();
				
		while(iter.hasNext()){
			Map.Entry me = (Map.Entry)iter.next();
			if(list_num_for_eq.get(0).contains((CharSequence) me.getValue())){
				System.out.println("Код країни "+me.getValue()+", дзвінок можливий: "+ me.getKey());
				calc = new Calculate(num);
				return;
			}
		}
		System.out.println("Невідома країна, дзвінок не можливий");
		
	}
}
