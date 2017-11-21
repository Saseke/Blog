package demo;

import java.util.Scanner;

/**
 * 控制主体
 */
public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float score = scanner.nextFloat();
        String out = "";
        switch ((int)score/10){
            case 1:
                out = "春季";
                break;
            case 2:
                out = "春季";
                break;

            case 3:
                out = "春季";
                break;

            case 4:
                out = "夏季";
                break;

            case 5:
                out = "夏季";
                break;

            case 6:
                out = "夏季";
                break;

            default:
                out = "不知道";
                System.out.println(out);

        }
    }
}
