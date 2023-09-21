package com.seam.focs.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.seam.focs.DTO.ProfileEmergencyDTO;
import com.seam.focs.common.Result;
import com.seam.focs.entity.EmergencyInfo;
import com.seam.focs.entity.Intake;
import com.seam.focs.entity.ProfileInfo;
import com.seam.focs.service.DetailedInfoService;
import com.seam.focs.service.IntakeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/intake")
public class IntakeController {
    @Autowired
    private IntakeService intakeService;

    /**
     *
     * @param intakes
     * @return
     */
    @PostMapping("/add")
    public Result<String> save(@RequestBody List<Intake> intakes) {
        log.info("New Intake, Details: {}", intakes.toString());
        intakeService.saveBatch(intakes);
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

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<List<Intake>> getIntake(@PathVariable Long id) {
        log.info("Initialize intake details");
        log.info("Applicant id = {}", id);

        //Construct query condition
        LambdaQueryWrapper<Intake> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Intake::getApplicantId, id);
        //Add order condition
        queryWrapper.orderByDesc(Intake::getPriority);

        List<Intake> list = intakeService.list(queryWrapper);

        return Result.success(list);
    }

}
