class FinalValue{
    static int findFinalValue(String[] ops){
        int ans = 0;
        for(String str : ops){
            char ch = str.charAt(1);
            switch (ch) {
                case '+':
                    ans++;
                    break;
                case '-':
                    ans--;
                    break;
                default:
                    break;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String[] ops = {"X++","++X","--X","X--"};
        System.out.println(findFinalValue(ops));
    }
}