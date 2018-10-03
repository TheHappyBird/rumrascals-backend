package com.rumrascals.rumrascalsbackend.controllers;

import com.rumrascals.rumrascalsbackend.domain.dto.RumDTO;
import com.rumrascals.rumrascalsbackend.domain.dto.RumReturnDTO;
import com.rumrascals.rumrascalsbackend.services.RumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class RumController {

    private final RumService rumService;

    @Autowired
    public RumController(RumService rumService) {
        this.rumService = rumService;
    }

    @RequestMapping(value = "rums", method = RequestMethod.POST)
    public long create(@RequestBody RumDTO rum) {
        return rumService.createRum(rum);

    }

    @RequestMapping(value = "rums", method = RequestMethod.GET)
    public List<RumReturnDTO> list() {
        return rumService.getAllRum();
    }

    @RequestMapping(value = "rums/{id}", method = RequestMethod.GET)
    public RumReturnDTO get(@PathVariable Long id) {
        return rumService.getRum(id);
    }

    @RequestMapping(value = "rums/{id}", method = RequestMethod.PUT)
    public long update(@PathVariable Long id, @RequestBody RumDTO rum) {
        return rumService.updateRum(id, rum);
    }

    @RequestMapping(value = "rums/{id}", method = RequestMethod.DELETE)
    public RumReturnDTO delete(@PathVariable Long id) {
        return rumService.deleteRum(id);
    }
}
