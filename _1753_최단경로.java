import java.io.*;
import java.util.*;

public class _1753_최단경로 {
	static int dist[];
	static ArrayList<Node> adj[];
	static int V,E,S;
	
	static void dijk(int s) {
		for(int i = 1 ; i <= V ; i++) dist[i] = (int)1e9;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[s] = 0;
		pq.add(new Node(s,dist[s]));
		while(!pq.isEmpty()) {
			Node p = pq.poll();
			for(Node y : adj[p.index]) {
				if(dist[y.index] > dist[p.index] + y.weight) {
					dist[y.index] = dist[p.index] + y.weight;
					pq.add(new Node(y.index, dist[y.index]));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(br.readLine());
		
		adj = new ArrayList[V+1];
		dist = new int[V+1];
		for(int i =1 ;  i <= V ; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for(int i = 0 ; i < E ; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			adj[u].add(new Node(v,w));
		}
		
		dijk(S);
		for(int i = 1 ; i <= V ; i++) {
			if(dist[i] != (int)1e9) {
				System.out.println(dist[i]);
			}else {
				System.out.println("INF");
			}
		}
		
	}
	static class Node implements Comparable<Node> {
		int index,weight;
		Node(int index, int weight) {
			this.index = index;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node target) {
			if(this.weight > target.weight) return 1;
			else return -1;
		}
		
	}
}
