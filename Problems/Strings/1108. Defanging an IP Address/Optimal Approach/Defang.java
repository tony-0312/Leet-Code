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
        System.out.println(address.replace(".", "[.]"));
    }
}