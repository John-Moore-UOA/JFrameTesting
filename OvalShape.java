class OvalShape {

  private int x = 0;
  private int y = 0;
  // private Color colour;

  public OvalShape(int x, int y) {
    this.x = x;
    this.y = y;
    // this.colour = colour;
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }

  public void moveX() {
    this.x += 1;
  }

  public void moveY() {
    this.y += 1;
  }

  // public Color getColour() {
  // return this.colour;
  // }

}