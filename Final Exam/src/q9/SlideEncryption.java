package q9;

public class SlideEncryption implements EncryptionStrategy {

  private int operation;

  public SlideEncryption(int slide) {
    if (slide < 0) {
      operation = -1;
    } else if (slide == 0) {
      operation = 0;
    } else {
      operation = 1;
    }
  }

  @Override
  public String encode(String msg) {
    switch (this.operation) {
      case 1:
        return msg.substring(msg.length()-1) + msg.substring(0, msg.length()-1);
      case 0:
        return msg;
      case -1:
        return msg.substring(1) + msg.charAt(0);
    }
    return null;
  }
}
