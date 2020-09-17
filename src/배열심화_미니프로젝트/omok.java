package 배열심화_미니프로젝트;

import java.util.Scanner;

public class omok {
   public static void main(String[] args) {
      int[][] omok = new int[10][10];
      Scanner sc = new Scanner(System.in);
      int p1x, p2x, p1y, p2y;
      int turn = 0;
      int winner = 0;
      while (true) {
         //오목판보여주기
         for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; ++j) {
               System.out.print(omok[i][j] + " ");
            }
            System.out.println();
         }
         
         //승자 보여주기
         if(winner == 1) {
            System.out.println("p1의 승리!");
            break;
         }
         if(winner == 2) {
            System.out.println("p2의 승리!");
            break;
         }
         
         
         //x,y 입력
         if (turn % 2 == 0) {
            System.out.print("1번 플레이어 x좌표 입력 :");
            p1x = sc.nextInt();
            System.out.print("1번 플레이어 y좌표 입력 :");
            p1y = sc.nextInt();

            if (omok[p1y][p1x] == 0) {
               omok[p1y][p1x] = 1;
               turn += 1;
            }

         }
         else if (turn % 2 == 1) {
            System.out.print("2번 플레이어 x좌표 입력 :");
            p2x = sc.nextInt();
            System.out.print("2번 플레이어 y좌표 입력 :");
            p2y = sc.nextInt();

            if (omok[p2y][p2x] == 0) {
               omok[p2y][p2x] = 2;
               turn += 1;
            }
         }
         
      
         
         // 가로검사
         for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 6; ++j) {
               if (omok[i][j] == 1 && omok[i][j + 1] == 1 && omok[i][j + 2] == 1 && omok[i][j + 3] == 1
                     && omok[i][j + 4] == 1) {
                  winner = 1;
               }
               if (omok[i][j] == 2 && omok[i][j + 1] == 2 && omok[i][j + 2] == 2 && omok[i][j + 3] == 2
                     && omok[i][j + 4] == 2) {
                  winner = 2;
               }
            }
         }
         // 세로검사
         for (int i = 0; i < 6; ++i) {
            for (int j = 0; j < 10; ++j) {
               if (omok[i][j] == 1 && omok[i + 1][j] == 1 && omok[i + 2][j] == 1 && omok[i + 3][j] == 1 && omok[i + 4][j] == 1)winner = 1;
               if (omok[i][j] == 2 && omok[i + 1][j] == 2 && omok[i + 2][j] == 2 && omok[i + 3][j] == 2 && omok[i + 4][j] == 2)winner = 2;
            }
         }
         // 대각선검사
//         우상 y: 4~9 x: 0~5
         for(int i=4; i<10;++i) {
            for(int j=0;j<6;++j) {
               if(omok[i][j]==1 &&omok[i-1][j+1]==1 &&omok[i-2][j+2]==1 &&omok[i-3][j+3]==1 &&omok[i-4][j+4]==1 )winner =1;
               if(omok[i][j]==2 &&omok[i-1][j+1]==2 &&omok[i-2][j+2]==2 &&omok[i-3][j+3]==2 &&omok[i-4][j+4]==2 )winner =2;
            }
         }
//         우하 y: 0~5 x: 0~5
         for(int i=0; i<6;++i) {
            for(int j=0;j<6;++j) {
               if(omok[i][j]==1 &&omok[i+1][j+1]==1 &&omok[i+2][j+2]==1 &&omok[i+3][j+3]==1 &&omok[i+4][j+4]==1 )winner =1;
               if(omok[i][j]==2 &&omok[i+1][j+1]==2 &&omok[i+2][j+2]==2 &&omok[i+3][j+3]==2 &&omok[i+4][j+4]==2 )winner =2;
            }
         }
//         좌상 y: 4~9 x: 4~9              
         for(int i =4 ; i<10;++i) {
            for(int j=4;j<10;++j) {
               if(omok[i][j]==1 &&omok[i-1][j-1]==1 &&omok[i-2][j-2]==1 &&omok[i-3][j-3]==1 &&omok[i-4][j-4]==1 )winner =1;
               if(omok[i][j]==2 &&omok[i-1][j-1]==2 &&omok[i-2][j-2]==2 &&omok[i-3][j-3]==2 &&omok[i-4][j-4]==2 )winner =2;
            }
         }
//         좌하 y: 0~5 x: 4~9
         for(int i =0 ; i<6;++i) {
            for(int j=4;j<10;++j) {
               if(omok[i][j]==1 &&omok[i+1][j-1]==1 &&omok[i+2][j-2]==1 &&omok[i+3][j-3]==1 &&omok[i+4][j-4]==1 )winner =1;
               if(omok[i][j]==2 &&omok[i+1][j-1]==2 &&omok[i+2][j-2]==2 &&omok[i+3][j-3]==2 &&omok[i+4][j-4]==2 )winner =2;
            }
         }
      }

   }
}
