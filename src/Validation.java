public class Validation {
	
	private String num;
	private Code code;
	private Calculate calc;
	
	public Validation(String num){
		this.num = num;
		firstVal();
	}
	
	private void firstVal(){
		
		String val_num = this.num;
		
		String a = "";
		Character b;
		
		for(int i = 0; i < val_num.length(); i++){
			if(Character.isDigit(val_num.charAt(i)) || val_num.charAt(i) == '+'){
				a = a + val_num.charAt(i);
			}else{
				System.out.println("Помилковий символ - " + val_num.charAt(i));
				return;
			}
		}
				
		System.out.println("" + num);
		
		if(a.length() == 10){
			secondValForMobile(a);
		}else if (a.length() == 13) {
			secondValForCountries();
		}else{
			System.out.println("Не вірний формат номеру");
		}
	}
		
	private void secondValForMobile(String num){
		
		if(num.startsWith("067") || num.startsWith("068") || num.startsWith("096") || num.startsWith("097") || num.startsWith("098")){
			System.out.println("Дзвінок на мобільний номер " + "Київстар");
			calc = new Calculate(num);
		}else if(num.startsWith("050") || num.startsWith("066") || num.startsWith("095") || num.startsWith("099")){
			System.out.println("Дзвінок на мобільний номер " + "МТС");
			calc = new Calculate(num);
		}else if (num.startsWith("063") || num.startsWith("093")) {
			System.out.println("Дзвінок на мобільний номер " + "Life:) ");
			calc = new Calculate(num);
		}else if(num.startsWith("094")){
			System.out.println("Дзвінок на мобільний номер " + "Інтертелеком");
			calc = new Calculate(num);
		}else{
			System.out.println("Помилковий номер");
		}
	}
	
	private void secondValForCountries(){
		
		code = new Code();
		
		for(String s: code.getCountries().keySet()){
			if(code.getCountries().get(s).equals(num.substring(0, code.getCountries().get(s).length()))){
				System.out.println("Дзвінок можлививй: "+ s);
				calc = new Calculate(num);
				return;
			}
		}
		System.out.println("Невідома країна, дзвінок не можливий");
	}
}