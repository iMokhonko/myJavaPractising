package com.imokhonko.Enums.MyEnumsSecond;

public enum Colors {

    RED("Red", "FF0000"),
    GREEN("Green", "008000"),
    BLUE("Blue","0000FF");

    private final String colorName;
    private final String RGB;

    Colors(final String colorName, final String RGB) {
        this.colorName = colorName;
        this.RGB = RGB;
    }

    public String getColorName() {
        return colorName;
    }

    public String getRGB() {
        return RGB;
    }

}
