import java.util.*;

public class _2805_�����ڸ��� {
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
			// ������ �Ǵ� ���.
			// ������ ������ mid���� ������ ���ٸ� �� ���� �������� �߸��Ƿ� res �ϴ� �� ���� �����ش�.
			
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
