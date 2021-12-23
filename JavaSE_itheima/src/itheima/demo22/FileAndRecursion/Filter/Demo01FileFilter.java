package itheima.demo22.FileAndRecursion.Filter;

import java.io.File;

/**
 * @ClassName Demo01ListFilter
 * @Description TODO
 * @Author 100749
 * @Date 2020-12-29 8:34
 * @Version 1.0
 *
 * 需求:
 *         遍历c:\\abc文件夹,及abc文件夹的子文件夹
 *         只要.java结尾的文件
 *
 *         File[] listFiles(FileFilter filter)
 *     java.io.FileFilter接口:用于抽象路径名(File对象)的过滤器。
 *         作用:用来过滤文件(File对象)
 *         抽象方法:用来过滤文件的方法
 *             boolean accept(File pathname) 测试指定抽象路径名是否应该包含在某个路径名列表中。
 *             参数:
 *                 File pathname:使用ListFiles方法遍历目录,得到的每一个文件对象
 *     File[] listFiles(FilenameFilter filter)
 *     java.io.FilenameFilter接口:实现此接口的类实例可用于过滤器文件名。
 *         作用:用于过滤文件名称
 *         抽象方法:用来过滤文件的方法
 *             boolean accept(File dir, String name) 测试指定文件是否应该包含在某一文件列表中。
 *             参数:
 *                 File dir:构造方法中传递的被遍历的目录
 *                 String name:使用ListFiles方法遍历目录,获取的每一个文件/文件夹的名称
 *     注意:
 *         两个过滤器接口是没有实现类的,需要我们自己写实现类,重写过滤的方法accept,在方法中自己定义过滤的规则
 **/
public class Demo01FileFilter {

  public static void main(String[] args) {
    //重写accept方法，实现过滤.java文件结尾的需求
    File file = new File("G:\\安装包");
    getAllFile(file);
  }

  private static void getAllFile(File dir) {
    // System.out.println(dir);

/*   // 匿名内部类写法
    // 先对传过来的目录进行过滤，放在封装好的File类数组中
    File[] files = dir.listFiles(new FileFilter() {
      @Override
      public boolean accept(File pathname) {
        if (pathname.isDirectory()){
          // 如果返回true，会把从accept方法中的File对象传递到File数组中，然后进行下一步遍历文件夹，在遍历文件夹的时候进行递归遍历
          return true;
        }
        // 不是文件夹，就先判断return后面是true还是false,若是false就不会保存到File数组中，就被过滤掉了
        return pathname.getName().toLowerCase().endsWith(".java");
      }
    });*/

    // Lambda表达式的简洁写法
    // 先对传过来的目录进行过滤，放在封装好的File类数组中
    File[] files = dir.listFiles((pathname)-> pathname.isDirectory() || pathname.getName().toLowerCase().endsWith(".java"));
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
