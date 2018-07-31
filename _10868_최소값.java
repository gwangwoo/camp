import java.util.*;

public class _10868_ÃÖ¼Ò°ª {
	static final int MAX = 100001;
	static long arr[] = new long[MAX];
	static long seg[] = new long[4*MAX];
	static int N,M;
	
	static long query(int low, int hi , int node, int x, int y) {
		if(low > y || hi < x) return 0;
		if(low <= x && y <= hi) return seg[node];
		
		int mid = (x + y) / 2;
		long l = query(low, hi , node*2 , x , mid);
		long r = query(low, hi , node*2+1 , mid+1 , y);
		if(l != 0 && r != 0) return l>r ? r : l;
		else if(l == 0) return r;
		else return l;
	}
	
	static void init(int node, int x,int y) {
		if(x == y) {
			seg[node] = arr[x];
			return;
		}
		int mid = (x + y) / 2;
		init(node * 2 , x, mid);
		init(node * 2 + 1 , mid + 1 , y);
		seg[node] = Math.min(seg[node*2], seg[node*2+1]);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		for(int i = 1 ; i <= N ; i++) {
			arr[i] = sc.nextLong();
		}
		init(1,1,N);
		while(M-->0) {
			int a,b;
			a = sc.nextInt();
			b = sc.nextInt();
			System.out.println(query(a,b,1,1,N));
		}
		
	}

}
