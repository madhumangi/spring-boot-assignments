package com.cameraresponseexception.model;

public enum LensType {
    FISHEYE("Fisheye"),
    WIDEANGLE("Wide angle"),
    STANDARD("Standard"),
    SHORTTELEPHOTO("Short Telephoto"),
    MEDIUMTELEPHOTO("Medium Telephoto"),
    SUPERTELEPHOTO("Super Telephoto"),
    MACRO("Macro"),
    ZOOM("Zoom lens"),
    PRIME("Prime lens");

    public String type;

    LensType(String type) {
        this.type = type;
    }
}
