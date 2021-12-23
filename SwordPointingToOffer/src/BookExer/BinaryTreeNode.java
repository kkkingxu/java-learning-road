package BookExer;

/**
 * 如下类型为CMyString类型的声明，请为该类型添加赋值运算符函数
 */
public class BinaryTreeNode {

private int data;
private BinaryTreeNode LChildNode;
private BinaryTreeNode RChildNode;

public BinaryTreeNode(int data){
  super();
  this.data = data;
}

  public int getData() {
    return data;
  }

  public void setData(int data) {
    this.data = data;
  }

  public BinaryTreeNode getLChildNode() {
    return LChildNode;
  }

  public void setLChildNode(BinaryTreeNode LChildNode) {
    this.LChildNode = LChildNode;
  }

  public BinaryTreeNode getRChildNode() {
    return RChildNode;
  }

  public void setRChildNode(BinaryTreeNode RChildNode) {
    this.RChildNode = RChildNode;
  }
}
