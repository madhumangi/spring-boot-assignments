package com.cameraapp.model;

public enum CameraType {
    DSLR("DSLR Camera"),
    COMPACT("Compact Camera"),
    POINTANDSHOOT("Point And Shoot"),
    MIRRORLESS("Mirrorless Camera"),
    ACTION("Action(Adventure) Camera"),
    DEGREE360("360 Camera"),
    MEDIUMFORMAT("Medium Format Camera"),
    TRADITIONAL("Traditional Film Camera");

    public String type;

    CameraType(String type) {
        this.type = type;
    }
}
