import java.util.Scanner;

public class _14581_�ҵ鿡�Եѷ�����ȫ�� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = ":";
		str += sc.next();
		str+= ":";
		
		for(int i = 0 ; i < 3 ; i++) {
			for(int j = 0 ; j < 3 ; j++) {
				if(i == 1 && j == 1) {
					System.out.print(str);
					continue;
				}
				System.out.print(":fan:");
			}
			System.out.println();
		}
	}
}
