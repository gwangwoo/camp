import java.util.*;

public class _1427_소트인사이드 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		ArrayList<Integer> arr= new ArrayList<>();
		for(int i = 0 ; i < str.length() ; i++) {
			int tmp = str.charAt(i)-'0';
			arr.add(tmp);
		}
		Collections.sort(arr);
		Collections.reverse(arr);
		for(int i = 0 ; i < arr.size() ; i++) System.out.print(arr.get(i));
	}
}
