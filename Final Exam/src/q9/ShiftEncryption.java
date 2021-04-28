package q9;

public class ShiftEncryption implements EncryptionStrategy{

  private int shift;

  public ShiftEncryption(int shift) {
    if (shift < -10 || shift > 10) {
      throw new IllegalArgumentException("Shift must be between -10 and 10.");
    }
    this.shift = shift;
  }

  @Override
  public String encode(String msg) {
    StringBuilder newMsg = new StringBuilder();
    for (char c : msg.toCharArray()) {
      char newC = (char) (c + shift);
      newMsg.append(newC);
    }
    return newMsg.toString();
  }
}
