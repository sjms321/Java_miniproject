package java_test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class ATM {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int size = 5;
		int count = 0;
		int log = -1;
		
		String[] accs = new String[size];
		for(int i =0;i<size;++i) {
			accs[i]="";
		}
		String[]  pws = new String[size];
		for(int i =0;i<size;++i) {
			pws[i]="";
		}
		int[]  moneys = new int[size];
		
		String fileName = "atm.txt";
		
		while(true) {
			
			System.out.println("[MEGA ATM]");
			System.out.println("[1]ȸ������");
			System.out.println("[2]ȸ��Ż��");
			System.out.println("[3]�α���");
			System.out.println("[4]�α׾ƿ�");
			System.out.println("[5]�Ա�");
			System.out.println("[6]���");
			System.out.println("[7]��ü");
			System.out.println("[8]�ܾ���ȸ");
			System.out.println("[9]����");
			System.out.println("[10]�ε�");
			System.out.println("[0]����");
			
			System.out.print("�޴� ���� : ");
			int sel = sc.nextInt();
			
			if(sel == 1) {
				System.out.println("ȸ�������� ACCS�Է� : ");
				String Accs= sc.next();
				int c =0;
				for(int i =0;i<size;++i) {
					if(accs[i].equals(Accs)) {
						System.out.println("�ߺ��� ACCS����");
						c=1;
					}
				}
				if(c==1)continue;
				int a =0;
		loop	:for(int i=0;i<size;i++) {
					if(accs[i].equals("")) {
						count = i;
						a=1;
						break loop;
					}
				}
				if(a==1) {
				accs[count]=Accs;
				System.out.println("���� �� ��й�ȣ �Է�: ");
				String Pw = sc.next();
				pws[count]=Pw;
				moneys[count]=1000;}
				else {
					System.out.println("ȸ���� �� á���ϴ�");
					continue;
				}
			}
			else if(sel == 2) {
				//ȸ��Ż��
				if(log==-1) {
					System.out.println("�α����� ���� �Ͻÿ�");
					continue;
				}
				accs[count]="";
				pws[count]="";
				moneys[count]=0;
				log=-1;
				
			}
			else if(sel == 3) {
				//�α���
				
				System.out.println("�α����� Acc�Է�: ");
				String NowId = sc.next();
				int c=1;
				for(int i=0;i<size;++i) {
					if(NowId.equals(accs[i])) {
						count=i;
						c=0;
					}
				}
				if(c==1) {
					System.out.println("�������� �ʴ� ACC�Դϴ�");
					continue;
				}

				System.out.print("�н������Է� :");
				String Pw = sc.next();
				if(Pw.equals(pws[count])) {
					log=1;
					System.out.println("�α��� ����");
				}
				else {
					System.out.println("�߸��� ��й�ȣ �Դϴ�.");
					continue;
				}
				
			}
			else if(sel == 4) {
				//�α׾ƿ�
				if(log==-1) {
					System.out.println("�̹� �α׾ƿ� �����Դϴ�");
					continue;
				}
				log =-1;
				System.out.println("�α׾ƿ� �Ϸ�");
			}
			else if(sel == 5) {
				//�Ա�
				if(log == -1) {
					System.out.println("�α����� �����Ͻÿ�");
					continue;
				}
				System.out.print("�Ա� �� �ݾ��� �Է� :");
				int money = sc.nextInt();
				moneys[count]+= money;
				
			}
			else if(sel == 6) {
				//���
				if(log == -1) {
					System.out.println("�α����� �����Ͻÿ�");
					continue;
				}
				System.out.print("��� �� �ݾ��� �Է� :");
				int money = sc.nextInt();
				if((moneys[count]-money)<0) {
					System.out.println("��� �ܾ� ����");
					continue;
				}
				moneys[count]-= money;
			}
			else if(sel == 7) {
				//��ü
				if(log == -1) {
					System.out.println("�α����� �����Ͻÿ�");
					continue;
				}
				System.out.print("��ü �� �ݾ��� �Է� :");
				int money = sc.nextInt();
				System.out.println("��ü ���� ���� �Է�");
				String Acc = sc.next();
				int c =1,moneyR=0;
				for(int i=0;i<size;i++) {
					if(accs[i].equals(Acc)) {
						c=0;
						moneyR =i;
					}
				}
				if(c==1) {
					System.out.println("���� �����Դϴ�");
					continue;
				}
				if((moneys[count]-money)<0) {
					System.out.println("��� �ܾ� ����");
					continue;
				}
				moneys[moneyR]+=money;
				moneys[count]-=money;
			}
			else if(sel == 8) {
				//�ܾ���ȸ
				if(log == -1) {
					System.out.println("�α����� �����Ͻÿ�");
					continue;
				}
				System.out.println(accs[count]+"���� �ܾ��� "+moneys[count]+"�� �Դϴ�");
			}
			else if(sel == 9) {
				//����
				//�� �ٿ� ACC/pw/�ܾ� ����
				FileWriter fw = null;
				String data = "";
				for(int i=0;i<size;++i) {
					data += accs[i]+"/"+pws[i]+"/"+moneys[i]+"\n";
				}
				try {
					fw = new FileWriter(fileName);
					fw.write(data);
					fw.close();
				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
			}
			else if(sel == 10) {
				String data = "";
				File file = new File(fileName);
				if(file.exists()) {
					FileReader fr = null;
					BufferedReader br = null;
					try {
						fr = new FileReader(file);
						br = new BufferedReader(fr);
						while(true) {
							String line = br.readLine();
							if(line == null)break;
							data += line + "\n";
						}
						String[] datas= data.split("\n");
						for(int i=0;i<size;++i) {
							String temp = datas[i];
							String[] temps = temp.split("/");
							accs[i]=temps[0];
							pws[i]=temps[1];
							moneys[i]=Integer.parseInt(temps[2]);
						}
						
					} catch (Exception e) {
						e.printStackTrace();
						// TODO: handle exception
					}
				}
				else System.out.println("�ε��� ���� ����");
				//�ε�
			}
			else if(sel == 0) {
				break;
			}
			
		}
		
	}

}
