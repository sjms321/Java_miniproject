package �迭��ȭ_�̴�������Ʈ;

import java.util.Random;
import java.util.Scanner;

public class ���ڹ�{
   public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);
      System.out.println("������ ���� ������ �Է��ϼ��� :");
      int wallnum = sc.nextInt();
      if (wallnum > 40) {
         System.out.println("���� �ʹ� �����ϴ�. ����� �ϼ���.");
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
               System.out.print("�� ");
            else if (game[i][j] == 1)
               System.out.print("�� ");
            else if (game[i][j] == 2)
               System.out.print("�� ");
            else
               System.out.print(game[i][j] + " ");
         }
         System.out.println();
      }

      while (true) {
         System.out.println("������ ĳ���� �ڸ��� ����ּ���");
         System.out.print("x��");
         int Cx = sc.nextInt();
         System.out.print("y��");
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
                  System.out.print("�� ");
               else if (game[i][j] == 1)
                  System.out.print("�� ");
               else if (game[i][j] == 2)
                  System.out.print("�� ");
               else if (game[i][j] == 10)
                  System.out.print("�� ");
               else
                  System.out.print(game[i][j] + " ");
            }
            System.out.println();
         }
         System.out.println("8�� 2�� 4�� 6��");
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
               continue;// �� �����϶�
            if (game[y][x - 1] == 0) {
               game[y][x - 1] = 10;
               game[y][x] = 0;
            } else if (game[y][x - 1] == 9 || game[y][x - 1] == 1)
               continue;// ���ʿ� ���̳� ���� ������
            else if (game[y][x - 1] == 2) {// ���ʿ� ���� �ִµ�
               if ((x - 1) == 0 || game[y][x - 2] == 9)
                  continue;// ������ ���̰ų� ������ ���ʿ� ���� ������ ��
               else if (game[y][x - 2] == 1)
                  break;// ������ ���ʿ� ����������
               else {
                  // ���ʿ� �����ִµ� �� ������ 0�϶�
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
               continue;// �� �������϶�
            if (game[y][x + 1] == 0) {
               game[y][x + 1] = 10;
               game[y][x] = 0;
            } else if (game[y][x + 1] == 9 || game[y][x + 1] == 1)
               continue;// �����ʿ� ���̳� ���� ������
            else if (game[y][x + 1] == 2) {// �����ʿ� ���� �ִµ�
               if ((x + 1) == 6 || game[y][x + 2] == 9)
                  continue;// �������� ���̰ų� �������� �����ʿ� ���� ������ ��
               else if (game[y][x + 2] == 1)
                  break;// �������� �����ʿ� ����������
               else {
                  game[y][x + 2] = 2;
                  game[y][x + 1] = 10;
                  game[y][x] = 0;
               }
            }
         }

      }
      System.out.println("���� ����");
   }
}
