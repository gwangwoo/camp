import java.util.*;

public class _에라토스테네스체로써보기 {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		boolean[] minor = new boolean[N+1];
		minor[0] = minor[1] = true;

		for(int i = 2; i*i <= N ; i++) {
			if(!minor[i]) {
				for(int j = i+i; j <= N ; j+=i) {
					minor[j] = true;

				}
			}
		}
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i = 2 ; i <= N ; i++) {
			if(!minor[i]) arr.add(i);
		}
		System.out.println(arr);

	}
}