package file2;

public class Ex2 {
	public static void main(String[] args) {
		String [][] student = {{"aaa","����","1001"}, {"bbb","����","1002" },
				{"ccc" ,"��ġ", "1003"} , {"ddd" , "����","1004"}};
		String[][] score = {
				{"��ȣ" ,"����" , "����"},
				{"1001" ,"����","20"},
				{"1002" ,"����","50"},
				{"1003" ,"����","60"},
				{"1004" ,"����","17"},
				{"1001" ,"����","65"},
				{"1002" ,"����","15"},
				{"1003" ,"����","80"},
				{"1004" ,"����","70"},
				{"1001" ,"����","43"},
				{"1002" ,"����","90"},
				{"1003" ,"����","30"},
				{"1004" ,"����","70"}
		};
		
		//�л� ������ ������ ��� ������ �̴� 
				//student ==> 1.id 2.�ּ� 3.��ȣ
				//score ==> 1.��ȣ 2.���� 3.���� 4.���� ���� �̴� 
				//����1) ��ü ������ 1���� �л� �̸� ��� 

		
		int[] total = new int[4];
		for (int i = 0; i < score.length; i++) {
			if(score[i][0].equals("1001")) {
				total[0]+=Integer.parseInt(score[i][2]);
			}
			if(score[i][0].equals("1002")) {
				total[1]+=Integer.parseInt(score[i][2]);
			}
			if(score[i][0].equals("1003")) {
				total[2]+=Integer.parseInt(score[i][2]);
			}
			if(score[i][0].equals("1004")) {
				total[3]+=Integer.parseInt(score[i][2]);
			}
		}
		int max =0;
		int temp =0;
		for(int i =0;i< total.length;++i) {
			if(max<total[i]) {
				max=total[i];
				temp = i;
			}
		}
		System.out.println(student[temp][0]);
	
	for(

	int e:total)
	{
		System.out.println(e);
	}
}}
