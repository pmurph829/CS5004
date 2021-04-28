package q9;

public class StrategyMain {
  public static void main(String [] args) {
    SpyKid kid = new SpyKid("Carmen", "Hello Shark Boy!",
            new SlideEncryption(1)); // slide right
    System.out.println(kid);
    kid.changeEncryptionStrategy(new ShiftEncryption(1)); // shift right
    System.out.println(kid);
    SpyKid otherKid = new SpyKid("Juni", "Ifmmp!Tibsl!Cpz\"",
            new ShiftEncryption(-1)); // shift left by 1
    System.out.println(otherKid);
  }
}