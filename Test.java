import java.util.*;

public class Test {
    public static void main1(String[] args) {
        // 乒乓球筐
        // nowcoder 有两盒（A、B）乒乓球，有红双喜的、有亚力亚的……
        // 现在他需要判别 A 盒是否包含了 B 盒中所有的种类，并且每种球的数量不少于 B 盒中的数量
        // 该怎么办呢？

        // 输入描述:
        // 输入有多组数据。
        // 每组数据包含两个字符串 A、B，代表 A 盒与 B 盒中的乒乓球，每个乒乓球用一个大写字母表示
        // 即相同类型的乒乓球为相同的大写字母。
        // 字符串长度不大于 10000。
        // 输出描述:
        // 每一组输入对应一行输出：如果B盒中所有球的类型在 A 中都有
        // 并且每种球的数量都不大于 A，则输出 “Yes”；否则输出 “No”。

        // 示例：
        // 输入
        // ABCDFYE CDE
        // ABCDGEAS CDECDE
        // 输出
        // Yes
        // No

        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            Map<Character,Integer>map=new HashMap<>();
            String[] str = new String[2];
            str=sc.nextLine().split(" ");
            String searh = searh(str, map);
            System.out.println(searh);
        }

    }

    private static String searh(String[] str,Map<Character,Integer> map) {
        for (int i = 0; i <str[0].length() ; i++) {
            if (map.containsKey(str[0].charAt(i))){
                map.put(str[0].charAt(i),map.get(str[0].charAt(i))+1);
            }else {
                map.put(str[0].charAt(i),1);
            }
        }
        for (int i = 0; i <str[1].length() ; i++) {
            if (map.containsKey(str[1].charAt(i))){
                map.put(str[1].charAt(i),map.get(str[1].charAt(i))-1);
            }else {
                return "No";
            }
        }
        for (int i = 0; i <str[0].length() ; i++) {

            if (map.get(str[0].charAt(i))<0){
                return "No";
            }
        }
        return "Yes";
    }

    public static void main(String[] args) {
        // 查找兄弟单词

        // 输入描述:
        // 先输入字典中单词的个数，再输入 n 个单词作为字典单词。
        // 输入一个单词，查找其在字典中兄弟单词的个数
        // 再输入数字 n
        // 输出描述:
        // 根据输入，输出查找到的兄弟单词的个数

        // 示例：
        // 输入
        // 3 abc bca cab abc 1
        // 输出
        // 2
        // bca

        // 题目解析：
        // 输入描述:
        // 先输入字典中单词的个数 n，再输入 n 个单词作为字典单词。
        // 再输入一个单词，查找其在字典中兄弟单词的个数 m
        // 再输入数字 k
        // 输出描述:
        // 根据输入，输出查找到的兄弟单词的个数 m
        // 然后输出查找到的兄弟单词的第 k 个单词。

        // ps: 数字和字符串各自占一行，还要判断边界条件
        // 当没有指定序号的兄弟时，不输出字符串

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int wordsNum = scanner.nextInt();
            String[] dict = new String[wordsNum];
            for (int i = 0; i < wordsNum; i++) {
                dict[i] = scanner.next();
            }
            String target = scanner.next();
            int brotherIndex = scanner.nextInt();
            process(dict, target, brotherIndex);
            scanner.nextLine();
            // 使光标到下一行
        }
    }

    public static void process(String[] dict, String target, int brotherIndex) {
        List<String> list = new ArrayList<>();
        Arrays.sort(dict);
        for (String cur : dict) {
            if (isBrother(target, cur)) {
                list.add(cur);
            }
        }
        System.out.println(list.size());
        if (brotherIndex <= list.size() && list.size() > 0) {
            System.out.println(list.get(brotherIndex - 1));
        }
    }

    public static boolean isBrother(String target, String cur) {
        // 长度不一，则不可能
        if (target.equals(cur)) {
            return false;
        }
        // 单词一致，则不可能
        if (target.length() != cur.length()) {
            return false;
        }
        char[] targetArray = target.toCharArray();
        char[] curArray = cur.toCharArray();
        // 将两数组分别排字母序
        // 再次比较，如果相同，说明为兄弟单词
        Arrays.sort(targetArray);
        Arrays.sort(curArray);
        for (int i = 0; i < curArray.length; i++) {
            if (targetArray[i] != curArray[i]) {
                return false;
            }
        }
        return true;
    }
}
