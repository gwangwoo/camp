import java.io.*;
import java.util.*;
public class _AB6 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		while(N-->0) {
			String[] str = br.readLine().split(",");
			int res = Integer.parseInt(str[0]) + Integer.parseInt(str[1]);
			System.out.println(res);
		}
	}

}
