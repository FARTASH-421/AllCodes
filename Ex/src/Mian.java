class Tree {
    String name;
    int height;

    public Tree(String n, int h) {
        this.name = n;
        this.height = h;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

class Kaj extends Tree {
    String typeLeaf;
    boolean allTimeGreen;

    public Kaj(String n, int h, String l) {
        super(n, h);
        this.typeLeaf = l;
        this.allTimeGreen = true;
    }

    @Override
    public int getHeight() {
        return super.getHeight();
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    public void setAllTimeGreen(boolean allTimeGreen) {
        this.allTimeGreen = allTimeGreen;
    }

    public String getTypeLeaf() {
        return typeLeaf;
    }

    public void setTypeLeaf(String typeLeaf) {
        this.typeLeaf = typeLeaf;
    }

    public boolean isAllTimeGreen() {
        return allTimeGreen;
    }
}