package maniv.billcalcuclator;

public class CalculateBill
{	
	static float billAmount;
	public static float billDomestic(String load,long units) {
		int range1 = 20; float pay1=0; float md1 = 0;//minimum demand amount
		int range2 = 30; float pay2=0; float md2 = 0;
		int range3 = 50; float pay3=0; float md3 = 0;
		int range4 = 150; float pay4=0; float md4 = 0;
		int range5 = 250; float pay5=0; float md5 = 0;
		int range6 = 400; float pay6 = 0; float md6 = 0;
											float md7 = 0;
						  
		float rate1 = 0;
		float rate2 = 7;
		float rate3 = 8.5f;
		float rate4 = 10;
		float rate5 = 11;
		float rate6 = 12;
		float rate7 = 13;	
		if (load.equals("5 Amp.")){
			md1 = 30;//minimum demand amount
			md2 = 50;
			md3 = 75;
			md4 = 100;
			md5 = 125;
			md6 = 150;
			md7 = 175;
			
			rate1 = 3;
			
		}else if (load.equals("15 Amp.")) {
			md1 = 50;
			md2 = 75;
			md3 = 100;
			md4 = 125;
			md5 = 150;
			md6 = 175;
			md7 = 200;
			
			rate1 = 4;
		}else if (load.equals("30 Amp.")) {
			md1 = 75;//minimum demand amount
			md2 = 100;
			md3 = 125;
			md4 = 150;
			md5 = 175;
			md6 = 200;
			md7 = 225;
			
			rate1 = 5;
		}
			
			pay1=range1*rate1;
			pay2=(range2-range1)*rate2+pay1;
			pay3= (range3-range2)*rate3+pay2;
			pay4 = (range4-range3)*rate4+pay3;
			pay5 = (range5-range4)*rate5+pay4;
			pay6 = (range6-range5)*rate6+pay5;
			
			
			if(units<=range1) {//<20
				billAmount=units * rate1 + md1;
				
			}else if(units<=range2) {//<30
				billAmount=(units-range1)* rate2 + pay1+md2;
				
			}else if(units<=range3) {//<50
				billAmount=(units-range2)* rate3 + pay2 +md3;

			}else if(units<=range4) {//<150
				billAmount=(units-range3)* rate4 + pay3+md4;
				
			}else if(units<=range5) {//<250
				billAmount=(units-range4)* rate5 + pay4+md5;
				
			}else if(units<=range6) {//<400
				billAmount=(units-range5)* rate6 + pay5+md6;
				
			}else if(units>range6) {//>400
				billAmount=(units-range6)* rate7 + pay6+md7;
			}
			return billAmount;
		
	} 
	public static float billNonDomestic(float rate, float minDemand,long units) {
		
			return billAmount = rate * units + minDemand;
	}
}
