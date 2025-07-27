class Type {
    public static void main(String[] args) {
        char ch1 = '>';
        if((ch1 >='A' && ch1<='Z') || (ch1>='a' && ch1<='z')){
            System.out.println("Alphabet");
        }
        else if(ch1>=0 && ch1<=9){
            System.out.println("Digit");;
        }
        else{
            System.out.println("Special Character");
        }
    }
}