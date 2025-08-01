class Welcome{
    public static void main(String[] args){
        if (args.length < 1) {
            System.out.println("Please provide a name as a command line argument.");
            return;
        }
        String a= args[0];
        System.out.println("Welcome " + a);    
    }
}