package java_test;

import java.util.Scanner;

public class ��ٱ��� {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		String[] ids = {"qwer", "javaking", "abcd"};
		String[] pws = {"1111",   "2222", "3333"};
		String[] items = {"���", "�ٳ���", "����"};
		
		final int MAX_SIZE = 100;
		int[][] jang = new int[2][MAX_SIZE];

		String fileName = "jang.txt";
		
		int count = 0;
		int log = -1;
		
		while(true) {
			
			System.out.println("[MEGA SHOP]");
			System.out.println("[1]�α���");
			System.out.println("[2]�α׾ƿ�");
			System.out.println("[3]����");
			System.out.println("[4]��ٱ���");
			System.out.println("[5]����");
			System.out.println("[6]�ε�");
			System.out.println("[0]����");
			
			System.out.print("�޴� ���� : ");
			int sel = sc.nextInt();
			
			if(sel == 1) {
				//[1]�α���
				if(log == 1) {
					System.out.println("�α׾ƿ��� ���� �Ͻÿ�");
					continue;
				}
				System.out.println("�α����� ID�Է� :");
				String NowId = sc.next();
				int c=1;
				for(int i =0;i<ids.length;++i ) {
					if(NowId.equals(ids[i])) {
						count =i;
						c=0;
						log=1;
						System.out.println(NowId+"�� �α��� �Ϸ�!");
					}
				}
				if(c==1) {
					System.out.println("�������� �ʴ� ���̵� �Դϴ�");
					continue;
				}
				
				
			}
			else if(sel == 2) {
				//[2]�α׾ƿ�
				if(log==-1) {
					System.out.println("�̹� �α׾ƿ� �����Դϴ�");
					continue;
				}
				log=-1;
				System.out.println("�α׾ƿ� �Ϸ�!");
			}
			else if(sel == 3) {
				//[3]����
				System.out.println("�����ϰ� ���� ��ǰ ����");
				System.out.println("1.���\n2.�ٳ���\n3.����");
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
				//[4]��ٱ���
				
			}
			else if(sel == 5) {
				//[5]����
				
			}
			else if(sel == 6) {
				//[6]�ε�
			}
			else if(sel == 0) {
				System.out.println("���α׷� ����");
				break;
			}
			
		}
		
	}
}
