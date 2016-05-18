package handler.event.type;

/**
 * Created by tatiana.biliaieva on 5/6/2016.
 */
public enum EventType {
  FIRST("FIRST"),
  SECOND("SECOND");

  private final String value;

  private EventType(final String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return this.value;
  }
}
