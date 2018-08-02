import java.util.*;

public class _1181_단어정렬 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int T = N;
		ArrayList<Text> arr = new ArrayList<>();
		NEXT:
		while(T-->0) {
			String tmp = sc.next();
			Text text = new Text(tmp,tmp.length());
			for(int i = 0 ; i < arr.size() ; i++) {
				if(arr.get(i).str.equals(text.str)) continue NEXT;
			}
			arr.add(text);
		}
		Collections.sort(arr);
		for(int i = 0 ; i < arr.size() ; i++) {
			System.out.println(arr.get(i).str);
		}
	}
	static class Text implements Comparable<Text> {
		String str;
		int size;
		Text(String str, int size) {
			this.str = str;
			this.size = size;
		}
		@Override
		public int compareTo(Text target) {
			if(this.size > target.size) return 1;
			else if(this.size < target.size) return -1;
			else {
				if(this.str.compareTo(target.str) > 0) return 1;
				else if(this.str.compareTo(target.str) < 0) return -1;
				else return 0;
			}
		}
	}
}
