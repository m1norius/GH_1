
public class Calculate {
		
	public Calculate(String num){
		firstCalc(num);
	}
	
	private void firstCalc(String num){
		
		if(num.contains("+")){
			String a = num.replace("+", "");
			secondCalc(a);
		}else{
			secondCalc(num);
		}
	}
	
	private void secondCalc(String a){
		
		int sum = 0;
		for(int i = 0; i < a.length(); i++){
			Integer integer = new Integer(""+a.charAt(i));
			sum = sum + integer;
		}
		System.out.println("1st round: "+sum);
		if((""+sum).length() == 1){
			thirdCalc(sum);
		}
		
		String b = ""+sum;
		int sum_2 = 0;
		if(b.length() > 1){
			for(int i = 0; i < b.length(); i++){
				Integer integer_1 = new Integer(""+b.charAt(i));
				sum_2 = sum_2 + integer_1;
			}
		System.out.println("2st round: "+sum_2);
		thirdCalc(sum_2);
		}
		
		String c = ""+sum_2;
		int sum_3 = 0;
		if(c.length() > 1){
			for(int i = 0; i < c.length(); i++){
				Integer integer_2 = new Integer(""+c.charAt(i));
				sum_3 = sum_3 + integer_2;
			}
		System.out.println("3st round: "+sum_3);
		thirdCalc(sum_3);
		}		
	}
	
	private void thirdCalc(int a){
		switch (a) {
		case 1:
			System.out.println("One");
			break;
		case 2:
			System.out.println("Two");
			break;
		case 3:
			System.out.println("Three");
			break;
		case 4:
			System.out.println("Four");
			break;
		case 5:
			System.out.println("5");
			break;
		case 6:
			System.out.println("6");
			break;
		case 7:
			System.out.println("7");
			break;
		case 8:
			System.out.println("8");
			break;
		case 9:
			System.out.println("9");
			break;
		default:
			break;
		}
	}
}
