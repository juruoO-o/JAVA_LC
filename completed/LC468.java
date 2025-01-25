import java.util.*;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
public class Main {
    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 2, 4, 3};
        int[] nums2 = {1, 2, 3};
        String s = "-2+ 1";
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
        new Solution().validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:");
        String string = new Codec().serialize(root);
        TreeNode newRoot = new Codec().deserialize(string);
    }
}

class Solution {
    public String validIPAddress(String queryIP) {
        if (queryIP.contains(".")) {
            return judgeIpv4(queryIP);
        } else if(queryIP.contains(":")){
            return judgeIpv6(queryIP);
        }else{
            return "Neither";
        }
    }

    private String judgeIpv6(String queryIP) {
        boolean ok = true;
        String[] strs = queryIP.split(":");
        if(queryIP.charAt(0)==':' || queryIP.charAt(queryIP.length()-1)==':'){
            return "Neither";
        }
        if (strs.length!=8)
            return "Neither";
        for (String str : strs) {
            if(str.length()<1 || str.length()>4){
                ok=false;
                break;
            }
            for(int i=0;i<str.length();i++){
                char c=str.charAt(i);
                if(!Character.isDigit(c) && (c<'a' || c>'f') && (c<'A' || c>'F')){
                    ok=false;
                    break;
                }
            }
        }
        return ok?"IPv6":"Neither";
    }

    private String judgeIpv4(String queryIP) {
        if (queryIP.charAt(0)=='.' || queryIP.charAt(queryIP.length()-1)=='.')
            return "Neither";
        boolean ok = true;
        String[] strs = queryIP.split("\\.");
        if (strs.length!=4)
            return "Neither";
        for (String str : strs) {
            if("".equals(str)||str.charAt(0)=='0' && str.length()>1){
                ok=false;
                break;
            }
            int num = 0;
            try {
                num = Integer.parseInt(str);
            } catch (NumberFormatException e) {
                return "Neither";
            }
            if (num > 255) {
                ok = false;
                break;
            }
        }
        return ok ? "IPv4" : "Neither";
    }
}