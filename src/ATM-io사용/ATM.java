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
			System.out.println("[1]회원가입");
			System.out.println("[2]회원탈퇴");
			System.out.println("[3]로그인");
			System.out.println("[4]로그아웃");
			System.out.println("[5]입금");
			System.out.println("[6]출금");
			System.out.println("[7]이체");
			System.out.println("[8]잔액조회");
			System.out.println("[9]저장");
			System.out.println("[10]로드");
			System.out.println("[0]종료");
			
			System.out.print("메뉴 선택 : ");
			int sel = sc.nextInt();
			
			if(sel == 1) {
				System.out.println("회원가입할 ACCS입력 : ");
				String Accs= sc.next();
				int c =0;
				for(int i =0;i<size;++i) {
					if(accs[i].equals(Accs)) {
						System.out.println("중복된 ACCS존재");
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
				System.out.println("설정 할 비밀번호 입력: ");
				String Pw = sc.next();
				pws[count]=Pw;
				moneys[count]=1000;}
				else {
					System.out.println("회원이 꽉 찼습니다");
					continue;
				}
			}
			else if(sel == 2) {
				//회원탈퇴
				if(log==-1) {
					System.out.println("로그인을 먼저 하시오");
					continue;
				}
				accs[count]="";
				pws[count]="";
				moneys[count]=0;
				log=-1;
				
			}
			else if(sel == 3) {
				//로그인
				
				System.out.println("로그인할 Acc입력: ");
				String NowId = sc.next();
				int c=1;
				for(int i=0;i<size;++i) {
					if(NowId.equals(accs[i])) {
						count=i;
						c=0;
					}
				}
				if(c==1) {
					System.out.println("존재하지 않는 ACC입니다");
					continue;
				}

				System.out.print("패스워드입력 :");
				String Pw = sc.next();
				if(Pw.equals(pws[count])) {
					log=1;
					System.out.println("로그인 성공");
				}
				else {
					System.out.println("잘못된 비밀번호 입니다.");
					continue;
				}
				
			}
			else if(sel == 4) {
				//로그아웃
				if(log==-1) {
					System.out.println("이미 로그아웃 상태입니다");
					continue;
				}
				log =-1;
				System.out.println("로그아웃 완료");
			}
			else if(sel == 5) {
				//입금
				if(log == -1) {
					System.out.println("로그인을 먼저하시오");
					continue;
				}
				System.out.print("입금 할 금액을 입력 :");
				int money = sc.nextInt();
				moneys[count]+= money;
				
			}
			else if(sel == 6) {
				//출금
				if(log == -1) {
					System.out.println("로그인을 먼저하시오");
					continue;
				}
				System.out.print("출금 할 금액을 입력 :");
				int money = sc.nextInt();
				if((moneys[count]-money)<0) {
					System.out.println("출금 잔액 부족");
					continue;
				}
				moneys[count]-= money;
			}
			else if(sel == 7) {
				//이체
				if(log == -1) {
					System.out.println("로그인을 먼저하시오");
					continue;
				}
				System.out.print("이체 할 금액을 입력 :");
				int money = sc.nextInt();
				System.out.println("이체 받을 계좌 입력");
				String Acc = sc.next();
				int c =1,moneyR=0;
				for(int i=0;i<size;i++) {
					if(accs[i].equals(Acc)) {
						c=0;
						moneyR =i;
					}
				}
				if(c==1) {
					System.out.println("없는 계좌입니다");
					continue;
				}
				if((moneys[count]-money)<0) {
					System.out.println("출금 잔액 부족");
					continue;
				}
				moneys[moneyR]+=money;
				moneys[count]-=money;
			}
			else if(sel == 8) {
				//잔액조회
				if(log == -1) {
					System.out.println("로그인을 먼저하시오");
					continue;
				}
				System.out.println(accs[count]+"님의 잔액은 "+moneys[count]+"원 입니다");
			}
			else if(sel == 9) {
				//저장
				//한 줄에 ACC/pw/잔액 저장
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
				else System.out.println("로드할 파일 없음");
				//로드
			}
			else if(sel == 0) {
				break;
			}
			
		}
		
	}

}
