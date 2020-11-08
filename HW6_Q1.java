package HW;
//請設計三個類別Calculator.java，CalException.java與CalTest.java，
//        在Calculator.java裡有個自訂方法為powerXY(int x, int y)，
//        功能是會計算x的y次方並回傳結果。
//        CalTest.java執行後，使用者可以輸入x與y的值，請加入例外處理機制，讓程式能解決以下狀況：
//        1. x與y同時為0，(產生自訂的CalException例外物件)
//        2. y為負值，而導致x的y次方結果不為整數
//        3. x與y皆正確情況下，會顯示運算後結果

import java.util.Scanner;

//計算x的y次方
class Calculator{
    int pow_cal;
    Calculator(int x, int y){
        pow_cal = (int)Math.pow(x,y);
    }
    int getCal(){
        return pow_cal;
    }
}

//例外機制-底數指數為零
class CalExceptionA extends ArithmeticException{
    public CalExceptionA(){
    }
    public CalExceptionA(String message){
        super(message);
    }
}

//例外機制-指數為負數
class CalExceptionB extends ArithmeticException{
    public CalExceptionB(){
    }
    public CalExceptionB(String message){
        super(message);
    }
}

public class HW6_Q1 {
    //輸入檢查
    public static int keyin(){
        int keyin = 0;
        Scanner sc = new Scanner(System.in);
        while(true){
            if (sc.hasNextInt()) {
                keyin = sc.nextInt();
                break;
            }
            else {
                System.out.println("輸入錯誤，請輸入整數");
                sc.next();

            }
        }
        return keyin;
    }

    public static void method(int val,int pow){
        if(val == 0 || pow == 0){
            throw new CalExceptionA("底數、指數不得同時為零");
        }
        else if(pow < 0){
            throw new CalExceptionB("指數不得為負數");
        }
    }

    public static void main(String[] args) throws Exception {
        //輸入底數、指數
        System.out.println("請輸入底數");
        int val = keyin();
        System.out.println("請輸入指數");
        int pow = keyin();

        Calculator cal = new Calculator(val,pow);
        int result = 0;
        result = cal.getCal();

        try{
            method(val,pow);
        }catch (CalExceptionA e1) {
            e1.printStackTrace();
            throw new Exception();
        }catch (CalExceptionB e2) {
            e2.printStackTrace();
            throw new Exception();
        }
        //沒出錯的話，顯示結果
        System.out.println(val+"的"+pow+"次方 = "+result);
    }
}
