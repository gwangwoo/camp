import java.util.*;

public class _2042_�����ձ��ϱ� {
	static final int MAX = 1000001;
	static long arr[] = new long[MAX];
	static long seg[] = new long[4*MAX];
	static int N,M,K;
	
	static long query(int low, int hi , int node , int x,int y) {
		if(low > y || hi < x) return 0;
		if(low <= x && y <= hi) return seg[node];
		int mid = (x+y) / 2;
		long l = query(low, hi , node*2, x , mid);
		long r = query(low, hi, node*2+1, mid+1, y);
		return l+r;
		
	}
	
	static void update(int pos , int val, int node, int x,int y) {
		if(pos > y || pos < x) return;
		if(x == y) {
			seg[node] = val;
			return;
		}
		int mid = (x + y) / 2;
		update(pos, val , node * 2 , x , mid);
		update(pos, val , node * 2+1, mid+1, y);
		seg[node] = seg[node*2] + seg[node*2+1];
	}
	
	static void init(int node, int x,int y) {
		if(x == y) {
			seg[node] = arr[x];
			return;
		}
		int mid = (x + y) / 2;
		init(node * 2 , x, mid);
		init(node * 2 + 1 , mid + 1 , y);
		seg[node] = seg[node*2] + seg[node*2+1];
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		for(int i = 1 ; i < N + 1; i++) {
			arr[i] = sc.nextLong();
		}
		init(1,1,N);
		for(int i = 1 ; i <= 20 ; i++) {
			System.out.print(seg[i]+ " ");
			
		}
		System.out.println();
		int turn = M + K;
		while(turn -->0) {
			int a,b,c;
			a = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();
			if(a == 1) {
				update(b,c,1,1,N);
			}else {
				System.out.println(query(b,c,1,1,N));
			}
		}
		
	}

}
