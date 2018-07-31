import java.io.*;
import java.util.*;

public class _1922_네트워크연결 {
	static ArrayList<Edge> adj;
	static int V,E;
	static int p[];
	
	static int find(int cur) {
		if(p[cur] == cur) return cur;
		else return p[cur] = find(p[cur]);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		
		adj = new ArrayList<>();
		p = new int[V+1];
		for(int i = 1 ; i <= V ; i++) {
			p[i] = i;
		}
		for(int i = 0; i < E ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			adj.add(new Edge(u,v,w));
		}
		
		int min = 0;
		Collections.sort(adj);
		for(int i = 0 ; i < E ; i++) {
			int rootX = find(adj.get(i).u);
			int rootY = find(adj.get(i).v);
			
			if(rootX == rootY) continue; //  사이클이 생김.
			
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
