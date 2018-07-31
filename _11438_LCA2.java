import java.util.*;
import java.io.*;

public class _11438_LCA2 {
	static int MAX = 100001;
	static int N,M;
	static boolean visited[];
	static int d[];
	static int par[][] = new int [18][MAX];
	static ArrayList<Integer> adj[];
	
	static void bfs(int s) {
		visited[s] = true;
		d[s] = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		while(!q.isEmpty()) {
			int p = q.poll();
			for(int y : adj[p]) {
				if(!visited[y]) {
					q.add(y);
					par[0][y] = p;
					visited[y] = true;
					d[y] = d[p]+1;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		visited = new boolean[N+1];
		d = new int[N+1];
		adj = new ArrayList[N+1];
		for(int i = 1 ; i <= N ; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for(int i = 1; i <= N-1 ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			adj[u].add(v);
			adj[v].add(u);
		}
		d[1] = 0;
		par[0][1] = 1;
		bfs(1);
		
		for(int k = 1;  k <= 17 ; k++) {
			for(int n = 1 ; n <= N ;n++)  {
				par[k][n] = par[k-1][par[k-1][n]];
			}
		}
		
		M = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < M ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			//a 와 높이를 b와 맞춘다.
			if(d[a] < d[b]) {
				for(int k = 17 ; k >= 0 ; k--) {
					if(a!=b && d[par[k][b]] >= d[a]) b = par[k][b];
				}
			}else if(d[a] > d[b]) {
				for(int k = 17; k >= 0 ; k--) {
					if(a!=b && d[par[k][a]] >= d[b]) a = par[k][a];
				}
			}
			int ans;
			
			for(int k = 17; k >= 0 && a!=b ; k--) {
				if(a!=b && par[k][a] != par[k][b]) {
					a = par[k][a];
					b = par[k][b];
				}
			}
			
			if(a == b) ans = a;
			else ans = par[0][a];
			System.out.println(ans);
		}
	}

}
