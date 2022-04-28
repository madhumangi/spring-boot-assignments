package com.cameraapp.controller;

import com.cameraapp.model.Camera;
import com.cameraapp.service.ICameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("camera-api")
public class CameraController {

    @Autowired
    private ICameraService cameraService;

    @PostMapping("/cameras")
    public void addCamera(@RequestBody Camera camera){
        cameraService.addCamera(camera);
    }
    @PutMapping("/cameras")
    public void updateCamera(@RequestBody Camera camera){
        cameraService.updateCamera(camera);
    }

    @DeleteMapping("/cameras/id/{cameraId}")
    public void deleteCamera(@PathVariable("cameraId") int cameraId){
        cameraService.deleteById(cameraId);
    }



    // http://localhost:8080/cameras
    @GetMapping("/cameras")
    public List<Camera> showCameras(){
        return cameraService.getAll();
    }

    // http://8080/localhost:8080/cameras/brand/price
    @GetMapping("/cameras/brand/{brand}/price/{price}")
    public List<Camera> showByBrandAndPrice(@PathVariable("brand")String brand,@PathVariable("price")double price){
        return cameraService.getByBrandAndPriceLessThan(brand,price);
    }

    // http://8080/localhost:8080/cameras/lenstype/STANDARD
    @GetMapping("/cameras/lens/{lensType}")
    public List<Camera> showByLensType(@PathVariable("lensType")String lensType){
        return cameraService.getByLensType(lensType);
    }

    // http://8080/localhost:8080/cameras/cameratype/DSLR
    @GetMapping("/cameras/cameraType/{cameraType}")
    public List<Camera> showByCameraType(@PathVariable("cameraType")String cameraType){
        return cameraService.getByCameraType(cameraType);
    }

    //  http://localhost:8080/cameras/price/
    @GetMapping("/cameras/price/{price}")
    public List<Camera> showByLessPrice(@PathVariable("price") double price){
        return cameraService.getByPriceLessThan(price);
    }

    //  http://localhost:8080/cameras/id/101
    @GetMapping("/cameras/id/{cameraId}")
    public Camera showByBookID(@PathVariable("cameraId") int cameraId){
        return cameraService.getById(cameraId);
    }

}
