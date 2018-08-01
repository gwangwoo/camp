import java.io.*;
import java.util.*;

public class _2623_음악프로그램 {
	static int in[];
	static ArrayList<Integer> adj[];
	static int N,M;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		in = new int[N+1];
		adj = new ArrayList[N+1];
		for(int i = 1 ; i <= N ; i++) {
			adj[i] = new ArrayList<>();
		}

		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int O = Integer.parseInt(st.nextToken());
			int u,v;
			u = Integer.parseInt(st.nextToken());
			for(int j = 0 ; j < O-1 ; j++) {
				v = Integer.parseInt(st.nextToken());
				adj[u].add(v);
				in[v]++;
				u = v;
			}
		}
		Queue<Integer> q = new LinkedList<>();
		for(int i =1 ; i <= N ; i++) {
			if(in[i] == 0) q.add(i);
		}

		ArrayList<Integer> ans = new ArrayList<>();
		while(!q.isEmpty()) {
			int now = q.poll();
			ans.add(now);
			for(int y : adj[now]) {
				in[y]--;
				if(in[y] == 0) q.add(y);
			}
		}
		
		if(ans.size() != N) {
			System.out.println("0");
			return;
		}
		for(int i = 0 ; i < N ; i++) {
			System.out.println(ans.get(i));
		}

	}

}
