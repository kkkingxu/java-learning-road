package itheima.demo22.FileAndRecursion.Filter;

import java.io.File;

/**
 * @ClassName Demo02FilenameFilter
 * @Description TODO
 * @Author 100749
 * @Date 2020-12-29 9:29
 * @Version 1.0
 **/
public class Demo02FilenameFilter {
  public static void main(String[] args) {
    //重写accept方法，实现过滤.java文件结尾的需求
    File file = new File("G:\\安装包");
    getAllFile(file);
  }

  private static void getAllFile(File dir) {
    // System.out.println(dir);

/*   // 匿名内部类写法
    // 先对传过来的目录进行过滤，放在封装好的File类数组中
        File[] files = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                //过滤规则,pathname是文件夹或者是.java结尾的文件返回true
                return new File(dir,name).isDirectory() || name.toLowerCase().endsWith(".java");
            }
        });*/

    // Lambda表达式的简洁写法
    // 先对传过来的目录进行过滤，放在封装好的File类数组中
    File[] files = dir.listFiles((d,name)->new File(d,name).isDirectory() || name.toLowerCase().endsWith(".java"));

    // 然后遍历File数组
    for (File f : files) {
      if (f.isDirectory()){
        //System.out.println(f); //f是一个文件夹，先打印
        getAllFile(f); // 继续向下遍历
      }else{
        System.out.println(f); // f是一个文件直接打印
      }
    }
  }
}
