class PowerThree{
    public static void main(String[] args) {
        int n = 21;
        boolean flag = true;
        while(n > 0){
            if(n % 3 == 2){
                flag = false;
                break; 
            }
            n /= 3;
        }
        System.out.println(flag);
    }
}