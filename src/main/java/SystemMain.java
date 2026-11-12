import java.util.Scanner;

public class SystemMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=====校园资源预约系统V1.0=====");
        System.out.print("请输入账号：");
        String username = scanner.nextLine();
        System.out.print("请输入密码：");
        String password = scanner.nextLine();

        //硬编码内置账号
        if("admin".equals(username) && "123456".equals(password)){
            System.out.println("欢迎管理员，登录成功！");
        }else if("student".equals(username) && "123456".equals(password)){
            System.out.println("欢迎学生用户，登录成功！");
        }else{
            System.out.println("账号或密码错误，登录失败！");
        }
        scanner.close();
    }
}
