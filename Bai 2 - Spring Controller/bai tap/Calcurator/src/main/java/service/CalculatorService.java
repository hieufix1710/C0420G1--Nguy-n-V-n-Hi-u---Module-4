package service;


public class CalculatorService {

    public int calculator (int num1,int num2,String operator){
         int result =0;

        if (operator.equals("+")){
            result=num1+num2;
        }
        if (operator.equals("-")){
            result=num1-num2;
        }
        if (operator.equals("*") || operator.equals("x")){
            result=num1*num2;
        }
        if (operator.equals("/")){
            if (num2==0){
                result=0;
                return result;
            }
            if (num1==0){
                result=-1;
                return result;
            }
            result=num1/num2;
        }
       return result;
    }
}
