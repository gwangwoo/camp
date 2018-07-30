import java.util.*;

public class _1644_소수의연속합 {
	static ArrayList<Integer> arr = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// 에라토스테네스의체를 통해 소수 구하기.
		boolean[] minor = new boolean[N+1];
		minor[0] = minor[1] = true;

		for(int i = 2 ; i*i <= N; i++) {
			if(!minor[i]) {
				for(int j = i+i ; j <= N ; j+=i) {
					minor[j] = true;
				}
			}
		}
		for(int i = 2 ; i <= N ; i++) {
			if(!minor[i]) arr.add(i);
		}

		int sum = 0, res = 0;
		int l = 0, r = 0;

		while(true) {
			if(sum >= N) sum -= arr.get(l++);
			else if(r == arr.size()) break;
			else sum += arr.get(r++);
			if(sum == N) res++;
		}
		System.out.println(res);


	}
}