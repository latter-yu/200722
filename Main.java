import java.util.*;
public class Main {
    public static void main1(String[] args) {

        //从 C/C++ 转到 Java 的程序员，一开始最不习惯的就是变量命名方式的改变。
        // C 语言风格使用下划线分隔多个单词，例如 “hello_world”；
        // 而 Java 则采用一种叫骆驼命名法的规则：
        // 除首个单词以外，所有单词的首字母大写，例如 “helloWorld”。
        //请你帮可怜的程序员们自动转换变量名。

        // 输入描述:
        // 输入包含多组数据。
        // 每组数据一行，包含一个 C 语言风格的变量名。
        // 每个变量名长度不超过 100。
        // 输出描述:
        // 对应每一组数据，输出变量名相应的骆驼命名法。

        // 示例:
        // 输入
        // hello_world
        // nice_to_meet_you
        // 输出
        // helloWorld
        // niceToMeetYou

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String strs = in.next();
            char[] chars = strs.toCharArray();
            List<Character> list = new ArrayList<>();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '_') {
                    // char 类型字母小写转大写是 char - 32;
                    // 大写转小写是 char + 32;
                    // String 类型可使用
                    // String.toUpperCase() 实现小写转大写
                    // String.toLowerCase() 实现大写转小写

                    chars[i + 1] = (char) (chars[i + 1] - 32);
                } else {
                    list.add(chars[i]);
                }
            }
            for (char l : list) {
                System.out.print(l);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        //对字符串中的所有单词进行倒排。
        // 说明：
        // 1、构成单词的字符只有 26 个大写或小写英文字母
        // 2、非构成单词的字符均视为单词间隔符
        // 3、要求倒排后的单词间隔符以一个空格表示
        // 如果原字符串中相邻单词间有多个间隔符时，倒排转换后也只允许出现一个空格间隔符
        // 4、每个单词最长 20 个字母；

        // 输入描述:
        // 输入一行以空格来分隔的句子
        // 输出描述:
        // 输出句子的逆序

        // 示例:
        // 输入
        // I am a student
        // 输出
        // student a am I

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String strs = in.nextLine();
            // 正则表达式：
            // ^[a-zA-Z]是去匹配目标字符串中以中括号中的a—z或者A—Z开头的字符
            // [^a-zA-Z]是去匹配目标字符串中非a—z也非A—Z的字符
            String[] str = strs.split("[^a-zA-Z]");
            StringBuffer sb = new StringBuffer();
            for (int i = str.length - 1; i >= 0; i--) {
                if (str[i] != " ") {
                    sb.append(str[i] + " ");
                }
            }
            System.out.println(sb.toString().trim());
            // trim(): 去掉首尾多余空格
        }
    }
}