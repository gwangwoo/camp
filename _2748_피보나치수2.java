import java.util.*;

public class _2748_피보나치수2 {
	static Long dp[] = new Long[100];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		dp[0] = (long) 0;
		dp[1] = (long) 1;
		for(int i = 2 ; i < 100 ; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		System.out.println(dp[N]);
	}

}
