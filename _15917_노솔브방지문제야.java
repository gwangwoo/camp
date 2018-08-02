import java.util.*;

public class _15917_노솔브방지문제야 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		NEXT:
		while(T-->0) {
			int N  = sc.nextInt();
			if(N == 1) {
				System.out.println(1);
				continue NEXT;
			}
			for(int i = 0 ; i < 32 ; i++) {
				if((2<<i) == N) {
					System.out.println(1);
					continue NEXT;
				}
			}
			System.out.println(0);
		}
	}
	
}
