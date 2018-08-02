import java.util.Scanner;

public class _15921_수찬이는마린보이야 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		if(N == 0) {
			System.out.println("divide by zero");
			return;
		}
		int arr[] = new int[N];
		int sum = 0;
		for(int i = 0 ; i < N ; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		double avg = (double)sum / (double)N;
		
		double var = 0;
		for(int i = 0 ; i < N ; i++) {
			var += (double)arr[i] / (double)N;
		}
		double ans = avg / var;
		
		if(var == 0) {
			System.out.println("divide by zero");
			return;
		}
		
		System.out.printf("%.2f", ans);
		
	}
}
