package com.cameraresponseexception.service;


import com.cameraresponseexception.exceptions.CameraNotFoundException;
import com.cameraresponseexception.exceptions.IdNotFoundException;
import com.cameraresponseexception.model.Camera;
import com.cameraresponseexception.repository.ICameraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CameraServiceImpl implements ICameraService{

    @Autowired
    private ICameraRepository cameraRepository;

    @Override
    public void addCamera(Camera camera) {
        cameraRepository.save(camera);
    }

    @Override
    public void updateCamera(Camera camera) {
        cameraRepository.save(camera);
    }

    @Override
    public void deleteById(int cameraId){
        cameraRepository.deleteById(cameraId);
    }

    @Override
    public List<Camera> getAll() {
        return cameraRepository.findAll();
    }

    @Override
    public Camera getById(int cameraId) throws IdNotFoundException {
        Camera camera=cameraRepository.findById(cameraId).get();
        if(camera!=null)
            return camera;
        else
            throw new IdNotFoundException("Id not found");
    }

    @Override
    public List<Camera> getByBrandAndPriceLessThan(String brand, double price) throws CameraNotFoundException {
        List<Camera> cameras=cameraRepository.findByBrandAndPriceLessThan(brand, price);
        if(cameras.isEmpty())
            throw new CameraNotFoundException("Lens type not found");
        else
            return cameras;
    }

    @Override
    public List<Camera> getByLensType(String lensType) throws CameraNotFoundException {
        List<Camera> cameras=cameraRepository.findByLensType(lensType);
        if(cameras.isEmpty())
            throw new CameraNotFoundException("Lens type not found");
        else
            return cameras;
    }

    @Override
    public List<Camera> getByCameraType(String cameraType) throws CameraNotFoundException {
        List<Camera> cameras=cameraRepository.findByCameraType(cameraType);
        if(cameras.isEmpty())
            throw new CameraNotFoundException("Lens type not found");
        else
            return cameras;
    }

    @Override
    public List<Camera> getByPriceLessThan(double price) throws CameraNotFoundException {
        List<Camera> cameras=cameraRepository.findByPriceLessThan(price);
        if(cameras.isEmpty())
            throw new CameraNotFoundException("Lens type not found");
        else
            return cameras;
    }
}
