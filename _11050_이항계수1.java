import java.util.*;

public class _11050_이항계수1 {
	
	static int comb(int n,int k) {
		int res = 1;
		for(int i = 0 ; i < k ; i++) {
			res = res *(n-i) / (i+1);
		}
		return res;
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		System.out.println(comb(N,K));
	}
}
