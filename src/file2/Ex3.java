package file2;

public class Ex3 {
	public static void main(String[] args) {
		String nameData = "";
		nameData+=	"100001/�̸���";nameData += "\n";		
		nameData += "100002/�̿���";nameData += "\n";
		nameData += "100003/���缮";nameData += "\n";
		nameData += "100004/�ڸ��";nameData += "\n";
		nameData += "100005/�ֿ���";nameData += "\n";
		nameData += "100006/�ں���";
		String  moneyData = "";
		moneyData += "100001/600";moneyData += "\n";	
		moneyData += "100003/7000";moneyData += "\n";		
		moneyData += "100001/100";moneyData += "\n";		
		moneyData += "100002/400";moneyData += "\n";		
		moneyData += "100001/600";moneyData += "\n";		
		moneyData += "100004/900";moneyData += "\n";		
		moneyData += "100001/130";moneyData += "\n";		
		moneyData += "100003/200";moneyData += "\n";		
		moneyData += "100002/700";moneyData += "\n";	
		moneyData += "100002/900";moneyData += "\n";
		moneyData += "100004/800";
		
		// ����) moneyData �� nameData �� �����ؼ� �Ʒ��Ͱ��� ��������
		String[] nametemp;
		String[] moneytemp;
		
		

		String userData = "";
		
		nametemp = nameData.split("\n");
		String[][] name = new String[nametemp.length][2];
		for(int i=0;i<nametemp.length;++i) {
			String[] temp=new String[2];
			temp = nametemp[i].split("/");
			name[i][0]=temp[0];
			name[i][1]=temp[1];
		}
		
		
		moneytemp = moneyData.split("\n");
		String[][] money = new String[moneytemp.length][2];
		for(int i=0;i<moneytemp.length;++i) {
			String[] temp = new String[2];
			temp = moneytemp[i].split("/");
			money[i][0]=temp[0];
			money[i][1]=temp[1];
		}
		for(int i =0;i<money.length;++i) {
			for(int j=0;j<name.length;++j) {
				if(money[i][0].equals(name[j][0])) {
					userData+= money[i][0]+"/"+name[j][1]+"/"+money[i][1]+"\n";
				}
			}
		}
		System.out.println(userData);
				/*
				 * 100001/�̸���/600
				 * 100003/���缮/7000
				 * 100001/�̸���/100
				 * 100002/�̿���/400
				 * 100001/�̸���/600
				 * 100004/�ڸ��/900
				 * 100001/�̸���/130
				 * 100003/���缮/200
				 * 100002/�̿���/700
				 * 100002/�̿���/900
				 * 100004/�ڸ��/800
				 */
			


	}
}
