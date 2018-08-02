import java.util.*;

public class _1010_다리놓기 {
	static int comb[][] = new int[31][31];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// dp로 조합 만들어 놓기.
		for(int i = 1 ; i < 31 ; i++) {
			comb[i][0] = comb[i][i] = 1;
			for(int j = 1; j < i ; j++) {
				comb[i][j] = comb[i-1][j-1] + comb[i-1][j];
			}
		}
		
		int T = sc.nextInt();;
		while(T-->0) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			System.out.println(comb[M][N]);
		}
		
	}

}
