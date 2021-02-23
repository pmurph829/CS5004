public abstract class AbstractNode implements Node{
  protected String data;
  protected NodeType type;

  @Override
  public String getData(){
    return this.data;
  }

  @Override
  public NodeType getType(){
    return this.type;
  }

  @Override
  public String toString(){
    return this.data;
  }
}
