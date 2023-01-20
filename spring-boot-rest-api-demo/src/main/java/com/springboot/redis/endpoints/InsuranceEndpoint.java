package com.springboot.redis.endpoints;

import com.springboot.redis.domains.Insurance;
import com.springboot.redis.services.InsuranceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/insurance")
public class InsuranceEndpoint {

    private final InsuranceService insuranceService;

    public InsuranceEndpoint(InsuranceService insuranceService) {
        this.insuranceService = insuranceService;
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Insurance>> getInsurancesByCounty(@RequestParam String county) {
        List<Insurance> insuranceList = insuranceService.findAllInsurancesByCounty(county);
        return Optional.ofNullable(insuranceList)
                .map(insurances -> new ResponseEntity<>(insurances, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Insurance> getInsuranceById(@PathVariable(value = "id") Integer id) {
        Insurance insuranceData = insuranceService.findOneById(id);
        return Optional.ofNullable(insuranceData)
                .map(insurance -> new ResponseEntity<>(insurance, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Insurance> storeInsurance(@Valid @RequestBody Insurance insurancePayload) {
        Insurance insurance = insuranceService.store(insurancePayload);
        return new ResponseEntity<>(insurance, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteInsurance(@PathVariable(value = "id") Integer id) {
        insuranceService.destroy(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
