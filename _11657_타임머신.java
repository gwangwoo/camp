import java.io.*;
import java.util.*;

public class _11657_타임머신 {
	static ArrayList<Node> adj[];
	static int V,E;
	static int dist[];
	
	static void bell(int s) {
		for(int i = 1 ; i <= V ; i++) dist[i] = (int)1e9;
		dist[s] = 0;
		int n = 0;
		while(n <= V) {
			for(int i = 1; i <= V ; i++) {
				for(Node y : adj[i]) {
					if(dist[y.vertex] > dist[i] + y.weight) {
					// 사이클이 발생하는지 묻는것.
						if(n == V) {
							System.out.println("-1");
							System.exit(0);
						}
						dist[y.vertex] = y.weight + dist[i];
					}
				}
			}
			n++;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		dist = new int[V+1];
		adj = new ArrayList[V+1];
		for(int i = 1 ; i <= V ; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for(int i = 0 ; i < E ; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			adj[u].add(new Node(w,v));
		}
		
		bell(1);
		for(int i = 2 ; i <= V ; i++) {
			if(dist[i] == (int)1e9) { // 방문되지 않은점.
				System.out.println("-1");
			}else {
				System.out.println(dist[i]);
			}
		}
		
	}
	static class Node implements Comparable<Node> {
		int weight;
		int vertex;
		Node(int weight, int vertex) {
			this.weight = weight;
			this.vertex = vertex;
		}
		@Override
		public int compareTo(Node target) {
			if(this.weight > target.weight) return 1;
			else if(this.weight == target.weight) return 0;
			else return -1;
		}
	}
}
