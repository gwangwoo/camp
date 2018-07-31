import java.io.*;
import java.util.*;

public class _1766_巩力笼 {
	static int V,E;
	static ArrayList<Integer> adj[];
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	static int in[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		adj = new ArrayList[V+1];
		in = new int[V+1];
		for(int i = 1 ; i <= V ; i++) {
			adj[i] = new ArrayList<>();
		}

		while(E-->0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			adj[u].add(v);
			in[v]++;
		}
		// indegree 贸府秦林绰 内靛.
		for(int i = 1; i <= V ; i++) {
			if(in[i] == 0) {
				pq.add(i);
			}
		}
		while(pq.size() > 0) {
			int p = pq.poll();
			System.out.print(p + " ");
			for(int y : adj[p]) {
				in[y]--;
				if(in[y] == 0) pq.add(y);
			}
		}


	}

}
