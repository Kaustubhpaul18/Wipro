public class SumOfDigits{
    public static void main(String[] args) {
        int sum = 0;
        int num=15487;
        for(int i = num; i > 0; i--){
            sum = sum + (i%10);
            i = i/ 10;
        }
        System.out.println("The sum of the digits is: " + sum);
    }
}