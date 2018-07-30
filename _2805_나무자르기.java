import java.util.*;

public class _2805_나무자르기 {
	static long arr[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long M = sc.nextLong();
		arr = new long[N];
		
		for(int i = 0 ; i < N ; i++) {
			arr[i] = sc.nextLong();
		}
		
		Arrays.sort(arr);
		
		long l = 1;
		long r = (long)2e9;
		long ans = 0;
		
		while(l <= r) {
			long mid = (l + r) / 2;
			long res = 0;
			// 조건이 되는 경우.
			// 벌목을 했을때 mid보다 나무가 높다면 그 위에 나무들은 잘리므로 res 싹다 뺀 값을 더해준다.
			
			for(int i = 0 ; i < N ; i++) {
				if(mid < arr[i]) res += (arr[i] - mid);
			}
			if(res >= M) {
				ans = mid;
				System.out.println("L "+l);
				l = mid + 1;
			}else {
				System.out.println("R "+r);
				r = mid-1;
			}
		}
		System.out.println(ans);
	}

}
