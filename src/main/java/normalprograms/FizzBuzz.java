package normalprograms;

public class FizzBuzz {
	
	public static void main(String[] args) {
		String fizz = "Fizz";
		String Buzz = "Buzz";
		String FizzBuzz = "FizzBuzz";
		for (int i = 1; i <= 100; i++) {
			System.out.println(i%15==0?FizzBuzz:i%5==0?Buzz:i%3==0?fizz:i);
		}
		
	}

}
