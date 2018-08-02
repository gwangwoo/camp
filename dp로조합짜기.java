
public class dp로조합짜기 {
	static long comb[][] = new long[101][101];
	public static void main(String[] args) {
		// nCr --> comb[n][r]
		for(int i = 1 ; i <= 100; i++) {
			comb[i][0] = comb[i][i] = 1;
			for(int j = 1 ; j < i ; j++) {
				comb[i][j] = comb[i-1][j-1] + comb[i-1][j];
			}
		}
		System.out.println(comb[29][13]);
	}
	
}
