import java.io.*;
import java.util.Scanner;

public class Testing {
    public static String add_bd(){    //加标点
        System.out.println("请输入古诗");
        Scanner in = new Scanner(System.in);
        String poetry = in.nextLine(); //分词前
        String poem = "";   //分词后
        int j=0;
        for(int i =0;i<poetry.length();i+=7){
            String a = poetry.substring(i,i+7);
            boolean b = j % 2 == 0;//判断奇偶，第几次分词
            //System.out.println(b);
            if(b == true){
                poem = poem + a+"，";
                //System.out.println(poem);
            }
            else{
                poem = poem + a+"。\n";
                //System.out.println(poem);
            }
            j++;
        }
        System.out.println(poem);
        return poem;
    }

    public static void find_word(){   //查词
        Scanner in = new Scanner(System.in);
        System.out.println("是否需要分词（请输入“是”或者“否”）");
        String a = in.next();
        String needFind = "";
        if(a.equals("是")){
            needFind = Testing.add_bd();
        }
        else{
            System.out.println("请输入古诗");
            needFind = in.next();
        }
        System.out.println("请输入想要检测的单词");
        String word = in.next();
        int i = 0;
        while (needFind.indexOf(word) != -1 ){
            i++;
            System.out.println(word+"出现第"+i+"次,位置在" + needFind.indexOf(word));
            needFind = needFind.substring(needFind.indexOf(word)+word.length());
            System.out.println("剩余的文字：" + needFind);
        }
        System.out.println(word+"一共出现了"+i+"次");
    }

    public static void In()throws Exception{
        // 第1步：使用File类找到一个文件
        File f = new File("d:" + File.separator + "Java\\Experiment05\\TXT\\a.txt");// 声明File 对象
        // 第2步：通过子类实例化父类对象
        Writer out = null;
        // 准备好一个输出的对象
        out = new FileWriter(f);
        // 通过对象多态性进行实例化
        // 第3步：进行写操作
        System.out.println("请输入古诗");
        Scanner in = new Scanner(System.in);
        String poetry = in.nextLine(); //分词前
        // 准备一个字符串,写入
        out.write(poetry);
        // 第4步：关闭输出流
        out.close();
    }

    public static void Out()throws Exception{
        try{
            File read = new File("d:" + File.separator + "Java\\Experiment05\\TXT\\a.txt");
            File write = new File("d:" + File.separator + "Java\\Experiment05\\TXT\\2.txt");

            BufferedReader br = new BufferedReader(new FileReader(read));
            BufferedWriter bw = new BufferedWriter(new FileWriter(write));
            String temp = br.readLine();
            System.out.println(temp);
            while(temp != null){
                int j=0;
                for(int i =0;i<temp.length();i+=7){
                    String a = temp.substring(i, i + 7);
                    boolean b = j % 2 == 0;//判断奇偶，第几次分词
                    //System.out.println(b);
                    if(b == true){
                        bw.write(a+"，");
                        //System.out.println(poem);
                    }
                    else{
                        bw.write(a+"。\n");
                        //System.out.println(poem);
                    }
                    j++;
                }
                temp = br.readLine();
            }
            bw.close();
            br.close();
        }catch(FileNotFoundException e){ //文件未找到
            System.out.println (e);
        }catch(IOException e){
            System.out.println (e);
        }

    }



    public static void main(String[] args){
//        try {
//            In();
//            Out();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        //add_bd();
        find_word();
    }
}