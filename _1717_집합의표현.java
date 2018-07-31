import java.util.*;

public class _1717_집합의표현 {
	static int p[] = new int[1000002];
	static int N,M;
	
	static int find(int cur) {
		if(p[cur] == cur) return cur;
		return p[cur] = find(p[cur]);
	}
	
	static void union(int u, int v) {
		u = find(u);
		v = find(v);
		if(u == v) return;
		p[u] = v;
		return;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		for(int i = 1 ; i <= N ; i++) {
			p[i] = i;
		} 
		
		while(M-->0) {
			int a = sc.nextInt();
			int b= sc.nextInt();
			int c = sc.nextInt();
			if(a == 0) {
				union(b,c);
			}else {
				int u = find(b);
				int v = find(c);
				if(u==v) System.out.println("YES");
				else System.out.println("NO");
			}
		}
	}


}
