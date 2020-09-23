package java_test;

import java.util.Scanner;

public class 장바구니 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		String[] ids = {"qwer", "javaking", "abcd"};
		String[] pws = {"1111",   "2222", "3333"};
		String[] items = {"사과", "바나나", "딸기"};
		
		final int MAX_SIZE = 100;
		int[][] jang = new int[2][MAX_SIZE];

		String fileName = "jang.txt";
		
		int count = 0;
		int log = -1;
		
		while(true) {
			
			System.out.println("[MEGA SHOP]");
			System.out.println("[1]로그인");
			System.out.println("[2]로그아웃");
			System.out.println("[3]쇼핑");
			System.out.println("[4]장바구니");
			System.out.println("[5]저장");
			System.out.println("[6]로드");
			System.out.println("[0]종료");
			
			System.out.print("메뉴 선택 : ");
			int sel = sc.nextInt();
			
			if(sel == 1) {
				//[1]로그인
				if(log == 1) {
					System.out.println("로그아웃을 먼저 하시오");
					continue;
				}
				System.out.println("로그인할 ID입력 :");
				String NowId = sc.next();
				int c=1;
				for(int i =0;i<ids.length;++i ) {
					if(NowId.equals(ids[i])) {
						count =i;
						c=0;
						log=1;
						System.out.println(NowId+"로 로그인 완료!");
					}
				}
				if(c==1) {
					System.out.println("존재하지 않는 아이디 입니다");
					continue;
				}
				
				
			}
			else if(sel == 2) {
				//[2]로그아웃
				if(log==-1) {
					System.out.println("이미 로그아웃 상태입니다");
					continue;
				}
				log=-1;
				System.out.println("로그아웃 완료!");
			}
			else if(sel == 3) {
				//[3]쇼핑
				System.out.println("쇼핑하고 싶은 상품 선택");
				System.out.println("1.사과\n2.바나나\n3.딸기");
				int num = sc.nextInt();
				int c=0;
		loop:   for(int i=0;i<jang[count].length;i++) {
					if(jang[count][i]==0) {
						c=i;
						break loop;
					}
				}
				if(num == 1) {
					jang[count][c]=1;
				}
				else if(num == 2) {
					jang[count][c]=2;
				}
				else if(num == 3) {
					jang[count][c]=3;
				}
			}
			else if(sel == 4) {
				//[4]장바구니
				
			}
			else if(sel == 5) {
				//[5]저장
				
			}
			else if(sel == 6) {
				//[6]로드
			}
			else if(sel == 0) {
				System.out.println("프로그램 종료");
				break;
			}
			
		}
		
	}
}
