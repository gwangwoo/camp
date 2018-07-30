import java.util.*;

public class _2014_¼Ò¼öÀÇ°ö {
	static int K,N;
	static int arr[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<val> pq = new PriorityQueue<>();
		K = sc.nextInt();
		N = sc.nextInt();
		arr = new int[K];
		for(int i = 0 ; i < K ; i++) {
			arr[i] = sc.nextInt();
			pq.add(new val(arr[i]));
		}
		for(int i = 0 ; i < K ; i++) {
			for(int j = 0 ; j < K ; j++) {
				int tmp = arr[i]*arr[j];
				pq.add(new val(tmp));
			}
		}
		HashSet<Integer> hs = new HashSet<>();
		int size = pq.size();
		for(int i = 0 ; i < size ; i++) {
			hs.add(pq.poll().value);
		}
		ArrayList<Integer> arr = new ArrayList<>(hs);
		Collections.sort(arr);
		for(int i = 0 ; i < arr.size() ; i++) {
			System.out.print(arr.get(i)+ " " );
		}
		System.out.println(arr.get(N));
	}
	static class val implements Comparable<val> {
		int value;
		val(int value) {
			this.value = value;
		}
		@Override
		public int compareTo(val target) {
			if(this.value > target.value) return 1;
			else return -1;
		}
		
	}
}
