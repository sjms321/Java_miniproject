package 배열심화_미니프로젝트;

import java.util.Random;
import java.util.Scanner;

public class 소코반{
   public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);
      System.out.println("생성할 벽의 개수를 입력하세오 :");
      int wallnum = sc.nextInt();
      if (wallnum > 40) {
         System.out.println("벽이 너무 많습니다. 재시작 하세요.");
         return;
      }
      int[][] game = new int[7][7];
      Random rd = new Random();

      while (wallnum != 0) {
         int x = rd.nextInt(7);
         int y = rd.nextInt(7);
         if (game[y][x] == 0) {
            game[y][x] = 9;
            wallnum--;
         }
      }
      while (true) {
         int x = rd.nextInt(7);
         int y = rd.nextInt(7);
         if (game[y][x] == 0) {
            game[y][x] = 1;
            break;
         }
      }
      while (true) {
         int x = rd.nextInt(5) + 1;
         int y = rd.nextInt(5) + 1;
         if (game[y][x] == 0) {
            game[y][x] = 2;
            break;
         }
      }
      for (int i = 0; i < 7; ++i) {
         for (int j = 0; j < 7; ++j) {
            if (game[i][j] == 9)
               System.out.print("벽 ");
            else if (game[i][j] == 1)
               System.out.print("골 ");
            else if (game[i][j] == 2)
               System.out.print("공 ");
            else
               System.out.print(game[i][j] + " ");
         }
         System.out.println();
      }

      while (true) {
         System.out.println("본인의 캐릭터 자리를 골라주세요");
         System.out.print("x축");
         int Cx = sc.nextInt();
         System.out.print("y축");
         int Cy = sc.nextInt();
         if (game[Cy][Cx] == 0) {
            game[Cy][Cx] = 10;
            break;
         }
      }
      while (true) {
         for (int i = 0; i < 7; ++i) {
            for (int j = 0; j < 7; ++j) {
               if (game[i][j] == 9)
                  System.out.print("벽 ");
               else if (game[i][j] == 1)
                  System.out.print("골 ");
               else if (game[i][j] == 2)
                  System.out.print("공 ");
               else if (game[i][j] == 10)
                  System.out.print("옷 ");
               else
                  System.out.print(game[i][j] + " ");
            }
            System.out.println();
         }
         System.out.println("8상 2하 4좌 6우");
         int num = sc.nextInt();
         if (num == 8) {
            int x = 0, y = 0;
            for (int i = 0; i < 7; ++i) {
               for (int j = 0; j < 7; ++j) {
                  if (game[i][j] == 10) {
                     y = i;
                     x = j;
                  }
               }
            }
            if (y == 0)
               continue;
            if (game[y - 1][x] == 0) {
               game[y - 1][x] = 10;
               game[y][x] = 0;
            } else if (game[y - 1][x] == 9 || game[y - 1][x] == 1)
               continue;
            else if (game[y - 1][x] == 2) {
               if ((y - 1) == 0 || game[y - 2][x] == 9)
                  continue;
               else if (game[y - 2][x] == 1)
                  break;
               else {
                  game[y - 2][x] = 2;
                  game[y - 1][x] = 10;
                  game[y][x] = 0;
               }
            }
         }

         else if (num == 2) {
            int x = 0, y = 0;
            for (int i = 0; i < 7; ++i) {
               for (int j = 0; j < 7; ++j) {
                  if (game[i][j] == 10) {
                     y = i;
                     x = j;
                  }
               }
            }
            if (y == 6)
               continue;
            if (game[y + 1][x] == 0) {
               game[y + 1][x] = 10;
               game[y][x] = 0;
            } else if (game[y + 1][x] == 9 || game[y + 1][x] == 1)
               continue;
            else if (game[y + 1][x] == 2) {
               if ((y + 1) == 6 || game[y + 2][x] == 9)
                  continue;
               else if (game[y + 2][x] == 1)
                  break;
               else {
                  game[y + 2][x] = 2;
                  game[y + 1][x] = 10;
                  game[y][x] = 0;
               }
            }
         }

         else if (num == 4) {
            int x = 0, y = 0;
            for (int i = 0; i < 7; ++i) {
               for (int j = 0; j < 7; ++j) {
                  if (game[i][j] == 10) {
                     y = i;
                     x = j;
                  }
               }
            }
            if (x == 0)
               continue;// 맨 왼쪽일때
            if (game[y][x - 1] == 0) {
               game[y][x - 1] = 10;
               game[y][x] = 0;
            } else if (game[y][x - 1] == 9 || game[y][x - 1] == 1)
               continue;// 왼쪽에 벽이나 골이 있을때
            else if (game[y][x - 1] == 2) {// 왼쪽에 공이 있는데
               if ((x - 1) == 0 || game[y][x - 2] == 9)
                  continue;// 왼쪽이 끝이거나 왼쪽의 왼쪽에 벽이 존재할 때
               else if (game[y][x - 2] == 1)
                  break;// 왼쪽의 왼쪽에 골이있을때
               else {
                  // 왼쪽에 공이있는데 그 왼쪽이 0일때
                  game[y][x - 2] = 2;
                  game[y][x - 1] = 10;
                  game[y][x] = 0;
               }
            }
         } else if (num == 6) {
            int x = 0, y = 0;
            for (int i = 0; i < 7; ++i) {
               for (int j = 0; j < 7; ++j) {
                  if (game[i][j] == 10) {
                     y = i;
                     x = j;
                  }
               }
            }
            if (x == 6)
               continue;// 맨 오른쪽일때
            if (game[y][x + 1] == 0) {
               game[y][x + 1] = 10;
               game[y][x] = 0;
            } else if (game[y][x + 1] == 9 || game[y][x + 1] == 1)
               continue;// 오른쪽에 벽이나 골이 있을때
            else if (game[y][x + 1] == 2) {// 오른쪽에 공이 있는데
               if ((x + 1) == 6 || game[y][x + 2] == 9)
                  continue;// 오른쪽이 끝이거나 오른쪽의 오른쪽에 벽이 존재할 때
               else if (game[y][x + 2] == 1)
                  break;// 오른쪽의 오른쪽에 골이있을때
               else {
                  game[y][x + 2] = 2;
                  game[y][x + 1] = 10;
                  game[y][x] = 0;
               }
            }
         }

      }
      System.out.println("게임 종료");
   }
}
