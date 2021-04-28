package q9;

class SpyKid {
  private String name;
  private String message;
  private EncryptionStrategy encryptionStrategy;

  public SpyKid(String name, String message, EncryptionStrategy encryptionStrategy) {
    this.name = name;
    this.message = message;
    this.encryptionStrategy = encryptionStrategy;
  }

  public void changeEncryptionStrategy(EncryptionStrategy newStrategy ) {
    this.encryptionStrategy = newStrategy;
  }

  @Override
  public String toString() {
    return name + "'s message is: " + encryptionStrategy.encode(this.message);
  }
}