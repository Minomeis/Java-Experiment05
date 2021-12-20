#大202 韩若梅
## 一、实验目的
1. 掌握字符串String及其常用方法的使用
2. 掌握输入输出流的使用

## 二、业务要求
&emsp;&emsp;有《长恨歌》古诗词，在经某程序处理后，被删去了非汉字部分，如标点符号、回车换行等。现请设计程序恢复。

## 三、实验要求
1. 每7个汉字加入一个标点符号，奇数时加“，”，偶数时加“。”；
2. 允许提供输入参数，统计古诗中某个字或词出现的次数。

## 四、实验过程
1. 首先思考如何实现分词（即添加标点以及换行），我通过循环整个字符串，每7个字节获取一次，然后将标点与其拼接后组成新的带标点换行的字符串。
2. 其次是查词功能，通过indexOf()函数，定位到第一次出现词语位置，然后通过substring()函数截取第一次出现后的字符串，继续循环查找，直至没有为止（indexOf()==-1）。

## 五、流程图
![](https://github.com/Minomeis/Java-Experiment05/blob/master/img/Java%E5%AE%9E%E9%AA%8C5.png)
## 六、关键代码
1. 循环实现分词
```java
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
```

2. 通过indexOf()函数，定位到第一次出现词语位置，然后通过substring()函数截取
```java
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
```
## 七、运行截图
1. 分词
![](https://github.com/Minomeis/Java-Experiment05/blob/master/img/001.jpg)
2. 查词
![](https://github.com/Minomeis/Java-Experiment05/blob/master/img/002.jpg)
![](https://github.com/Minomeis/Java-Experiment05/blob/master/img/003.jpg)
## 八、感想体悟
&emsp;&emsp;本次实验，因为有之前作业的基础，因此完成的比较快。而且与前几次实验相比，本次实验并不是需要系统化的去创建多个类和对象，
因此代码量相对较少，所以整体花费时间较少。能够帮助我理解部分字符串相关的函数，同时也发现还有大量我不清楚的函数存在，需要我去学习。
<br>&emsp;&emsp;对于IO流的有关内容，更能够深刻的了解IO流具体是一个什么意思，上课时说实话感觉上比较抽象，不能够很好的理解，
通过查看老师的实例，再自己试着写，帮助我更好的理解了IO流的应用。