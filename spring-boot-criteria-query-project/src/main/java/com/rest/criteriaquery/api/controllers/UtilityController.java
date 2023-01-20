package com.rest.criteriaquery.api.controllers;

import com.rest.criteriaquery.api.dto.EnumDTO;
import com.rest.criteriaquery.api.enumeration.Gender;
import com.rest.criteriaquery.api.properties.EnumClassPathScanningCandidateComponentProvider;
import com.rest.criteriaquery.api.utilities.ApiUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.*;
import java.util.stream.Stream;

import static io.jsonwebtoken.lang.Classes.forName;

@RestController
@RequestMapping("/utility")
public class UtilityController {

    private final Map<String, List<EnumDTO>> enumsList = new HashMap<>();

    @Autowired
    UtilityController(EnumClassPathScanningCandidateComponentProvider enumProvider) {
        enumProvider.findCandidateComponents("com.rest.criteriaquery.api")
                .forEach(component -> {
                    List<EnumDTO> enumDTO = new ArrayList<>();

                    Class<Enum<?>> componentClass = forName(component.getBeanClassName());

                    Stream.of(componentClass.getEnumConstants()).forEach(e -> {
                        EnumDTO enumDTO1 = new EnumDTO();
                        enumDTO1.setConstant(e.name());
                        enumDTO1.setValue(e.toString());
                        enumDTO.add(enumDTO1);
                    });

                    enumsList.put(componentClass.getSimpleName(), enumDTO);
                });
    }


    //FETCH all Enums
    @GetMapping("/enums")
    Map<String, List<EnumDTO>> getAllEnums() {
        return enumsList;
    }

}