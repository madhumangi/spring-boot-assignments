package com.cameraresponseexception.controller;

import com.cameraresponseexception.model.Camera;
import com.cameraresponseexception.service.ICameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cameraresponseexceptions-api")
public class CameraController {

    @Autowired
    private ICameraService cameraService;

    @PostMapping("/cameras")
    public ResponseEntity<Void> addCamera(@RequestBody Camera camera){

        cameraService.addCamera(camera);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping("/cameras")
    public ResponseEntity<Void> updateCamera(@RequestBody Camera camera){
        cameraService.updateCamera(camera);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @DeleteMapping("/cameras/id/{cameraId}")
    public ResponseEntity<Void> deleteCamera(@PathVariable("cameraId") int cameraId){
        cameraService.deleteById(cameraId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }



    // http://localhost:8080/cameras
    @GetMapping("/cameras")
    public ResponseEntity<List<Camera>> showCameras(){
        List<Camera> cameras=cameraService.getAll();
        HttpHeaders httpheaders=new HttpHeaders();
        httpheaders.add("desc","Get all");
        return ResponseEntity.status(HttpStatus.OK).headers(httpheaders).body(cameras);
    }

    // http://8080/localhost:8080/cameras/brand/price
    @GetMapping("/cameras/brand/{brand}/price/{price}")
    public ResponseEntity<List<Camera>> showByBrandAndPrice(@PathVariable("brand")String brand,@PathVariable("price")double price){
        List<Camera> cameras=cameraService.getByBrandAndPriceLessThan(brand,price);
        HttpHeaders httpheaders=new HttpHeaders();
        httpheaders.add("desc","Get by brand"+brand+" price less than "+price);
        return ResponseEntity.status(HttpStatus.OK).headers(httpheaders).body(cameras);
    }

    // http://8080/localhost:8080/cameras/lenstype/STANDARD
    @GetMapping("/cameras/lens/{lensType}")
    public ResponseEntity<List<Camera>> showByLensType(@PathVariable("lensType")String lensType){
        List<Camera> cameras=cameraService.getByLensType(lensType);
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("desc","Get by lenstype "+lensType);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(cameras);
    }

    // http://8080/localhost:8080/cameras/cameratype/DSLR
    @GetMapping("/cameras/cameraType/{cameraType}")
    public ResponseEntity<List<Camera>> showByCameraType(@PathVariable("cameraType")String cameraType){
        List<Camera> cameras=cameraService.getByCameraType(cameraType);
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("desc","Get by cameratype "+cameraType);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(cameras);
    }

    //  http://localhost:8080/cameras/price/
    @GetMapping("/cameras/price/{price}")
    public ResponseEntity<List<Camera>> showByLessPrice(@PathVariable("price") double price){
        List<Camera> cameras=cameraService.getByPriceLessThan(price);
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("desc","Get by price less than "+price);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(cameras);
    }

    //  http://localhost:8080/cameras/id/101
    @GetMapping("/cameras/id/{cameraId}")
    public ResponseEntity<Camera> showByCameraID(@PathVariable("cameraId") int cameraId){
        Camera cameras=cameraService.getById(cameraId);
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("desc","Get by camera id"+cameraId);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(cameras);

    }

}
