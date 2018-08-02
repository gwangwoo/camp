import java.util.*;

public class _11051_이항계수2 {
	static long[][] comb = new long[1002][1002];
	
	static void calComb(int n, int k) {
		for(int i = 1 ; i <= 30 ; i++) {
			comb[i][0] = comb[i][i] = 1;
			for(int j = 1 ; j < 30 ; j++) {
				comb[i][j] = (comb[i-1][j-1] + comb[i-1][j]);
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		calComb(N,K);
		long res = comb[N][K];
		System.out.println(res);
	}

}
