import java.io.*;
import java.util.*;

public class _1717_집합의표현2 {
	static int N,M;
	static int p[] = new int[1000001];
	
	static int find(int cur) {
		if(cur == p[cur]) return cur;
		return p[cur] = find(p[cur]);
	}
	
	static void union(int u,int v) {
		u = find(u);
		v = find(v);
		if(u == v) return;
		p[u] = v;
		return;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i = 1 ; i <= N ; i++) {
			p[i]= i;
		}
		
		while(M-->0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c= Integer.parseInt(st.nextToken());
			
			if(a == 0) {
				union(b,c);
			}else {
				int u = find(b);
				int v = find(c);
				if(u == v) System.out.println("YES");
				else System.out.println("NO");
			}
		
		}
		
	}

}
