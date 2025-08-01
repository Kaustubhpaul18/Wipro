class OddEven{
    public static void main(String[] args){
        if(args.length < 1){
            System.out.println("Enter the number");
            return;
        }
        int num=Integer.parseInt(args[0]);
        if(num%2 == 0)
            System.out.println(num + " is even");
        else
            System.out.println(num + " is odd");
    }
}