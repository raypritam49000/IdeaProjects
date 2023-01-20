package com.mongo.rest.api.service;

import com.mongo.rest.api.dto.ComponentDTO;

import java.util.List;

public interface ComponentService {

    public List<ComponentDTO> getAllComponentByProduct();

    public List<ComponentDTO> findAllComponentByProduct();

    public List<ComponentDTO> findAllComponentByWarehouse(String warehouse);

    public List<String> findAllWarehouse(String warehouse);

    public List<String> findAllWarehouses(String warehouse);

    public List<String> findAllWarehousesProject(String warehouse);

    public List<ComponentDTO> findAllComponentByWarehouseWithSorting(String warehouse);

    public List<ComponentDTO> findAllComponentList();

    public List<ComponentDTO> getAllComponents();

    public List<ComponentDTO> getComponentById(String id);


}
