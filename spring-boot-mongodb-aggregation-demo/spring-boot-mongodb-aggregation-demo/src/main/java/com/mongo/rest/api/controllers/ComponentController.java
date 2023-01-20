package com.mongo.rest.api.controllers;

import com.mongo.rest.api.dto.ComponentDTO;
import com.mongo.rest.api.service.ComponentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/components")
public class ComponentController {

    private final ComponentService componentService;

    public ComponentController(ComponentService componentService) {
        this.componentService = componentService;
    }

    @GetMapping("/getAllComponentByProduct")
    public List<ComponentDTO> getAllComponentByProduct() {
        return componentService.getAllComponentByProduct();
    }

    @GetMapping("/findAllComponentByProduct")
    public List<ComponentDTO> findAllComponentByProduct() {
        return componentService.findAllComponentByProduct();
    }

    @GetMapping("/findAllComponentByWarehouse/{warehouse}")
    public List<ComponentDTO> findAllComponentByWarehouse(@PathVariable("warehouse") String warehouse) {
        return componentService.findAllComponentByWarehouse(warehouse);
    }

    @GetMapping("/findAllByWarehouse/{warehouse}")
    public List<String> findAllWarehouse(@PathVariable("warehouse") String warehouse) {
        return componentService.findAllWarehouse(warehouse);
    }

    @GetMapping("/findAllWarehouses/{warehouse}")
    public List<String> findAllWarehouses(@PathVariable("warehouse") String warehouse) {
        return componentService.findAllWarehouses(warehouse);
    }

    @GetMapping("/findAllWarehousesProject/{warehouse}")
    public List<String> findAllWarehousesProject(@PathVariable("warehouse") String warehouse) {
        return componentService.findAllWarehousesProject(warehouse);
    }

    @GetMapping("/findAllComponentByWarehouseWithSorting/{warehouse}")
    public List<ComponentDTO> findAllComponentByWarehouseWithSorting(@PathVariable("warehouse") String warehouse) {
        return componentService.findAllComponentByWarehouseWithSorting(warehouse);
    }

    @GetMapping("/findAllComponentList")
    public List<ComponentDTO> findAllComponentList() {
        return componentService.findAllComponentList();
    }

    @GetMapping("/getAllComponents")
    public List<ComponentDTO> getAllComponents(){
        return componentService.getAllComponents();
    }

    @GetMapping("/getComponentById/{id}")
    public List<ComponentDTO> getComponentById(@PathVariable("id") String id){
        return componentService.getComponentById(id);
    }
}
