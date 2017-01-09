package threads.arrayprogram;

public class MissingNumberFromGivenArray {
	
	public static void main(String[] args) {
		int arr[] = {7,8,10};
        gettMissingNumber(arr);
	}

	public static void gettMissingNumber(int[] arr){
		
		int x1 = arr[0];
		int x2 = 1;
		
		for (int i = 1; i < arr.length; i++) {
			x1^=arr[i];
		}
		System.out.println(x1);

		for (int i = 2; i <= arr.length+1; i++) {
			x2^=i;
		}
		System.out.println(x1^x2);
	}
}
