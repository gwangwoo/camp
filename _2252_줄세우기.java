import java.util.*;

public class _2252_줄세우기 {
	static ArrayList<Integer> adj[];
	static Stack<Integer> st = new Stack<>();
	static boolean visited[];
	static int V,E;
	
	static void dfs(int v) {
		visited[v] = true;
		for(int y : adj[v]) {
			if(!visited[y]) {
				dfs(y);
			}
		}
		st.push(v);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		
		adj = new ArrayList[V+1];
		visited = new boolean[V+1];
		for(int i = 1 ; i <= V ; i++) {
			adj[i] = new ArrayList<>();
		}
		
		while(E-->0) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			
			adj[u].add(v);
		}
		for(int i = 1 ; i <= V ; i++) {
			if(!visited[i]) {
				dfs(i);
			}
		}
		
		while(st.size() > 0) {
			System.out.print(st.pop() + " ");
		}
		
	}

}
