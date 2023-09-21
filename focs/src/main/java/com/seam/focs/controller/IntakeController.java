package com.seam.focs.controller;

import com.seam.focs.DTO.ProfileEmergencyDTO;
import com.seam.focs.common.Result;
import com.seam.focs.entity.Intake;
import com.seam.focs.service.DetailedInfoService;
import com.seam.focs.service.IntakeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/intake")
public class IntakeController {
    @Autowired
    private IntakeService intakeService;

    /**
     *
     * @param intake
     * @return
     */
    @PostMapping("/add")
    public Result<String> save(@RequestBody Intake intake) {
        log.info("New Intake, Details: {}", intake.toString());

        intakeService.save(intake);

        return Result.success("New Intake Details Added Successfully");
    }

    /**
     *
     * @param httpServletRequest
     * @param intake
     * @return
     */
    @PutMapping("update")
    public Result<String> update(HttpServletRequest httpServletRequest, @RequestBody Intake intake) {
        log.info("This is update {}", intake.toString());
        intakeService.updateById(intake);
        return Result.success("Intake Details Edited Successfully");
    }

}
