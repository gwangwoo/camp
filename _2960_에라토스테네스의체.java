import java.util.*;

public class _2960_에라토스테네스의체 {
	static int N,M;
	static boolean primes[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		primes = new boolean[N+1];
		
		Queue<Integer> q= new LinkedList<>();
		for(int i = 2; i <= N ; i++) {
			q.add(i);
		}
		
		while(!q.isEmpty()) {
			int now = q.poll();
			if(!primes[now]) {
				primes[now] = true;
				for(int i = now ; i <= N ; i++) {
					for(int j = i*i ; j <= N ; j+=i) {
						primes[j] = true;
					}
				}
			}
		}
	}

}
