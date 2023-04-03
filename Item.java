public class Item {

  private int x = 0;
  private int y = 0;

  public Item(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }

  public void moveY(boolean positive) {
    if (positive) {
      this.y += 1;
    } else {
      this.y -= 1;
    }
  }

  public void moveX(boolean positive) {
    if (positive) {
      this.x += 1;
    } else {
      this.x -= 1;
    }
  }

  public void addX(int stepX) {
    this.x += stepX;
  }

  public void addY(int stepY) {
    this.y += stepY;
  }

}
