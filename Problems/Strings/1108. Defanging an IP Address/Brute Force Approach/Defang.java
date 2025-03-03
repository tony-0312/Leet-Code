/*
 * Given a valid (IPv4) IP address, return a defanged version of that IP address.

A defanged IP address replaces every period "." with "[.]".

Example 1:

Input: address = "1.1.1.1"
Output: "1[.]1[.]1[.]1"

Example 2:

Input: address = "255.100.50.0"
Output: "255[.]100[.]50[.]0"
 */
class Defang{
    public static void main(String[] args) {
        String address = "227.222.40.237";
        String ans = "";
        int start = 0;
        for(int i = 0; i < address.length(); i++){
            if('.' == address.charAt(i)){
                ans += address.substring(start, i) + "[.]";
                start = i+1;
            }
        }
        ans += address.substring(start, address.length());
        System.out.println(ans);
    }
}