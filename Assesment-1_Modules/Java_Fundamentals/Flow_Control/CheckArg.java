class CheckArg{
    public static void main(String[] args){
        if(args.length < 1){
            System.out.println("No Values");
            return;
        }
        for(int i = 0; i < args.length; i++) {
            if(i > 0) {
            System.out.print(",");
            }
            System.out.print(args[i]);
        }
    }
}