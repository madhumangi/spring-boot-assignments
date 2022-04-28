package com.cameraapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Camera {
    @Id
    @GeneratedValue(generator="camera_gen",strategy=GenerationType.AUTO)
    @SequenceGenerator(name="camera_gen",sequenceName="camera_sequence",initialValue=101,allocationSize=1)
    private Integer cameraId;
    private String model;
    @Column(length = 20)
    private String cameraType;
    @Column(length = 20)
    private String lensType;
    private double price;
    @Column(length = 20)
    private String brand;

    @Override
    public String toString() {
        return "Camera{" +
                "model='" + model + '\'' +
                ", cameraType=" + cameraType +
                ", lensType=" + lensType +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                '}';
    }
}
