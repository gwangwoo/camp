import java.util.*;

public class _1516_게임개발 {
	static int tt[];
	static int val[];
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		tt = new int[N+1];
		val = new int[N+1];
		for(int i = 1 ; i <= N ; i++) {
			int value = sc.nextInt();
			val[i] = value;
			tt[i] = value;
			while(true) {
				int tmp = sc.nextInt();
				if(tmp == -1) break;
				tt[i] += tt[tmp];
			}
		}
		
		for(int i = 1;  i<= N ; i++) {
			System.out.println(tt[i]);
		}

	}

}
