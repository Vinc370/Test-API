package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Region;
import com.example.demo.Handler.Response;
import com.example.demo.Services.RegionService;

@RestController
@RequestMapping("api")
public class RegionRestController {
    @Autowired
    private RegionService<Region> regionService;

    @GetMapping("region")
    public ResponseEntity<Object> getAll(){
        //return regionService.getAll();
        return Response.generate(HttpStatus.OK, "data retrieved", regionService.getAll());
    }

    @GetMapping("region/{id}")
    public ResponseEntity<Object> get(@PathVariable(required = true) Integer id){
        //return regionService.Get(id);
        return Response.generate(HttpStatus.OK, "data retrieved", regionService.Get(id));
    }

    @PostMapping("region")
    public ResponseEntity<Object> post(@RequestBody Region region){
        regionService.Insert(region);
        return Response.generate(HttpStatus.OK, "data saved");
    }

    @DeleteMapping("region/{id}")
    public ResponseEntity<Object> delete(@PathVariable(required = true) Integer id){
        regionService.Delete(id);
        return Response.generate(HttpStatus.OK, "data deleted");
    }
}