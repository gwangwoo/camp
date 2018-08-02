import java.io.*;
import java.util.*;

public class _2960_�����佺�׳׽���ü {
	static int N,K;
	static ArrayList<Integer> primes = new ArrayList<>(); //  �Ҽ�����.

	static boolean isPrime(int num) {
		return primes.contains(num);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// 1. �Ҽ� ���ձ��ϱ�
		boolean minor[] = new boolean[1001];
		minor[0] = minor[1] = true;
		for(int i = 2; i*i <= 1000 ; i++) {
			if(!minor[i]) {
				for(int j = i+i ; j <= 1000 ; j+=i) {
					minor[j] = true;
				}
			}
		}
		for(int i = 1 ; i <= 1000 ; i++) {
			if(!minor[i]) primes.add(i);
		}
		// 1. 2���� N���� ��� ������ ���´�.
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i = 2 ; i <= N ; i++) {
			arr.add(i);
		}
		int count = 0;
		// 2. ���� ������ ���� ���� �� ����~~~
		while(true) {
			int min = Integer.MAX_VALUE;
			int index = 0;
			for(int i = 0 ; i < arr.size() ; i++) {
				if(arr.get(i) < min) {
					min = arr.get(i);
					index = i;
				}
			}
			if(isPrime(min)) {
				int tmp = arr.remove(index);
				count++;
				if(count == K) {
					System.out.println(tmp);
					return;
				}
				for(int i = 2; i <= N ; i++) {
					if(tmp * i > N) break;
					if(arr.contains(tmp*i)) {
						int col = arr.indexOf(tmp*i);
						int find = arr.remove(col);
						count++;
						if(count == K) {
							System.out.println(find);
							return;
						}
					}
				}
			}
		}
	}

}
