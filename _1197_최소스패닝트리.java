import java.io.*;
import java.util.*;

public class _1197_최소스패닝트리 {
	static int p[];
	static ArrayList<Edge> adj;
	static int V,E;
	
	static int find(int cur) {
		if(cur == p[cur]) return cur;
		else return p[cur] = find(p[cur]);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		p = new int[V+1];
		for(int i = 1 ; i <= V ; i++) {
			p[i] = i;
		}
		adj = new ArrayList<>();
		
		for(int i = 0 ; i < E ; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			adj.add(new Edge(u,v,w));
		}
		
		Collections.sort(adj);
		int min = 0;
		for(int i = 0 ; i < E ; i++) {
			int rootX = find(adj.get(i).u);
			int rootY = find(adj.get(i).v);
			
			if(rootX == rootY) continue; // 사이클이 생김
			
			p[rootX] = rootY;
			min += adj.get(i).weight;
		}
		System.out.println(min);
		
	}
	static class Edge implements Comparable<Edge> {
		int u,v,weight;
		Edge(int u,int v,int weight) {
			this.u = u;
			this.v = v;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge target) {
			if(this.weight > target.weight) return 1;
			else return -1;
		}
		
	}
}
