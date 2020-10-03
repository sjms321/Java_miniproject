package file2;

public class Ex2 {
	public static void main(String[] args) {
		String [][] student = {{"aaa","신촌","1001"}, {"bbb","강남","1002" },
				{"ccc" ,"대치", "1003"} , {"ddd" , "강동","1004"}};
		String[][] score = {
				{"번호" ,"과목" , "점수"},
				{"1001" ,"국어","20"},
				{"1002" ,"국어","50"},
				{"1003" ,"국어","60"},
				{"1004" ,"국어","17"},
				{"1001" ,"수학","65"},
				{"1002" ,"수학","15"},
				{"1003" ,"수학","80"},
				{"1004" ,"수학","70"},
				{"1001" ,"영어","43"},
				{"1002" ,"영어","90"},
				{"1003" ,"영어","30"},
				{"1004" ,"영어","70"}
		};
		
		//학생 정보와 성적이 담긴 데이터 이다 
				//student ==> 1.id 2.주소 3.번호
				//score ==> 1.번호 2.국어 3.수학 4.영어 점수 이다 
				//문제1) 전체 성적이 1등인 학생 이름 출력 

		
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
