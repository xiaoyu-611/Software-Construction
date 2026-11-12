import java.util.HashMap;
import java.util.Scanner;

public class SystemMain {
    //内存存储用户 key:用户名 value:密码
    private static HashMap<String,String> userMap = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while(true){
            System.out.println("\n====V1.1系统首页====");
            System.out.println("1.登录");
            System.out.println("2.注册");
            System.out.println("0.退出");
            System.out.print("请选择操作：");
            int op = Integer.parseInt(scanner.nextLine());
            switch (op){
                case 1:
                    login();
                    break;
                case 2:
                    register();
                    break;
                case 0:
                    System.out.println("程序退出");
                    return;
                default:
                    System.out.println("输入选项非法");
            }
        }
    }

    //登录
    private static void login(){
        System.out.print("输入账号：");
        String username = scanner.nextLine();
        System.out.print("输入密码：");
        String pwd = scanner.nextLine();
        if(!checkUsernameNotEmpty(username)){
            System.out.println("账号不能为空");
            return;
        }
        if(!userMap.containsKey(username)){
            System.out.println("用户不存在");
            return;
        }
        String realPwd = userMap.get(username);
        if(realPwd.equals(pwd)){
            System.out.println("登录成功");
        }else {
            System.out.println("密码错误");
        }
    }

    //注册
    private static void register(){
        System.out.print("请输入用户名：");
        String username = scanner.nextLine();
        System.out.print("请输入密码：");
        String pwd = scanner.nextLine();

        //校验
        if(!checkUsernameNotEmpty(username)){
            System.out.println("账号不能为空");
            return;
        }
        if(!checkPasswordValid(pwd)){
            System.out.println("密码长度必须≥6位");
            return;
        }
        if(userMap.containsKey(username)){
            System.out.println("用户名已存在，注册失败");
            return;
        }
        userMap.put(username,pwd);
        System.out.println("注册成功，可以登录！");
    }

    //账号非空校验 抽离方法
    private static boolean checkUsernameNotEmpty(String username){
        return username != null && !username.trim().equals("");
    }
    //密码合法性校验
    private static boolean checkPasswordValid(String password){
        return password != null && password.length() >=6;
    }
}
