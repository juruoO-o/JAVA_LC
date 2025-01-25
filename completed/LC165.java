//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 2}, nums2 = {2, 7};
        new Solution().compareVersion("1","1.1");
    }
}

class Solution {
    public int compareVersion(String version1, String version2) {
        int i1 = 0, j1 = 0, i2 = 0, j2 = 0;
        int len1 = version1.length(), len2 = version2.length();
        char[] str1 = version1.toCharArray(), str2 = version2.toCharArray();
        while (j1 < len1 && j2 < len2) {
            while (j1 < len1 && str1[j1] != '.') ++j1;
            while (j2 < len2 && str2[j2] != '.') ++j2;
            int v1 = Integer.parseInt(version1.substring(i1, j1));
            int v2 = Integer.parseInt(version2.substring(i2, j2));
            if (v1 < v2)
                return -1;
            else if (v1 > v2)
                return 1;
            j1++;
            i1 = j1;
            j2++;
            i2 = j2;
        }
        int sig = 1;
        if (j2 < len2) {
            i1 = i2;
            j1 = j2;
            len1=len2;
            version1 = version2;
            str1 = str2;
            sig = -1;
        }
        if (j1 < len1) {
            while (j1 < len1) {
                while (j1 < len1 && str1[j1] != '.') j1++;
                int v1 = Integer.parseInt(version1.substring(i1,j1));
                if(v1>0)
                    return sig;
                j1++;
                i1=j1;
            }
        }
        return 0;
    }
}