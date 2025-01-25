import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode tmp = q.poll();
            sb.append(tmp == null ? "null" : tmp.val);
            sb.append(' ');
            if (tmp != null) {
                q.add(tmp.left);
                q.add(tmp.right);
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int idx = 0, tmp;
        int len = data.length();
        TreeNode ans = null;
        TreeNode curN = null;
        Queue<TreeNode> last = new LinkedList<>();
        Queue<TreeNode> cur = new LinkedList<>();
        boolean leftSon = true;
        while (idx < len) {
            tmp = idx;
            while (idx<len && data.charAt(idx) != ' ') {
                idx++;
            }
            String sub = data.substring(tmp, idx);
            if ("null".equals(sub)) {
                curN = null;
            } else {
                curN = new TreeNode(Integer.parseInt(sub));
            }
            cur.add(curN);
            if(last.peek()==null){
                if (ans==null){
                   ans = curN;
                   idx++;
                   last=cur;
                   cur = new LinkedList<>();
                   continue;
                }else{
                    last = cur;
                    cur = new LinkedList<>();
                }
            }
            if (leftSon){
                last.peek().left = curN;
                leftSon=false;
            }else{
                last.poll().right=curN;
                leftSon=true;
            }
            idx++;
        }
        return ans;
    }

}