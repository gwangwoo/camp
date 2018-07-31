import java.io.*;
import java.util.*;

public class _3강_3번_최소비용신장트리 {
	static ArrayList<Node> adj;
	static int p[];
	static int V,E;

	static int find(int cur) {
		if(cur == p[cur]) return cur;
		else return p[cur] = find(p[cur]);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());

		adj = new ArrayList<>();
		p = new int[V+1];
		for(int i = 1; i <= V ; i++) {
			p[i] = i;
		}
		for(int i = 0 ; i < E ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			adj.add(new Node(u,v,w));
		}
		Collections.sort(adj);
		int min = 0;
		for(int i = 0 ; i < E ; i++) {
			int rootX = find(adj.get(i).u);
			int rootY = find(adj.get(i).v);
			
			if(rootX == rootY) continue;
			
			p[rootX] = rootY;
			min += adj.get(i).weight;
		}
		bw.write(String.valueOf(min));
		bw.flush();
		
	}
	static class Node implements Comparable<Node> {
		int u,v,weight;
		Node(int u,int v,int weight) {
			this.u = u;
			this.v = v;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node target) {
			if(this.weight > target.weight) return 1;
			else return -1;
		}

	}
}
