package com.cameraresponseexception.service;
import com.cameraresponseexception.exceptions.CameraNotFoundException;
import com.cameraresponseexception.exceptions.IdNotFoundException;
import com.cameraresponseexception.model.Camera;

import java.util.List;

public interface ICameraService {

    void addCamera(Camera camera);
    void updateCamera(Camera camera);
    void deleteById(int cameraId);
    List<Camera> getAll();

    Camera getById(int cameraId) throws IdNotFoundException;

    List<Camera> getByBrandAndPriceLessThan(String brand,double price) throws CameraNotFoundException;
    List<Camera> getByLensType(String lensType) throws CameraNotFoundException;
    List<Camera> getByCameraType(String cameraType) throws CameraNotFoundException;
    List<Camera> getByPriceLessThan(double price) throws CameraNotFoundException;


}
