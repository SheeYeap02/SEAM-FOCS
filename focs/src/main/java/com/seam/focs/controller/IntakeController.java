package com.seam.focs.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.seam.focs.DTO.ProfileEmergencyDTO;
import com.seam.focs.common.Result;
import com.seam.focs.entity.*;
import com.seam.focs.service.ApplicationService;
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

    @Autowired
    private ApplicationService applicationService;

    /**
     *
     * @param intakes
     * @return
     */
    @PostMapping("/add")
    public Result<String> save(@RequestBody List<Intake> intakes) {
        log.info("New Intake, Details: {}", intakes.toString());
        intakeService.saveBatch(intakes);

        //To get back the intake
        LambdaQueryWrapper<Intake> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Intake::getApplicantId, intakes.get(0).getApplicantId());
        queryWrapper.orderByAsc(Intake::getPriority);

        List<Intake> list = intakeService.list(queryWrapper);

        //After completed automatically set into the application
        LambdaQueryWrapper<Application> queryWrapper2 = new LambdaQueryWrapper<>();
        queryWrapper2.eq(Application::getApplicantId, intakes.get(0).getApplicantId());
        Application application = applicationService.getOne(queryWrapper2);
        application.setIntakeId(list.get(0).getIntakeId());
        applicationService.updateById(application);
        return Result.success("New Intake Details Added Successfully");
    }

    /**
     *
     * @param httpServletRequest
     * @param intakes
     * @return
     */
    @PutMapping("update")
    public Result<String> update(HttpServletRequest httpServletRequest, @RequestBody List<Intake> intakes) {
        log.info("This is update {}", intakes.toString());
        intakeService.updateBatchById(intakes);
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
        queryWrapper.orderByAsc(Intake::getPriority);

        List<Intake> list = intakeService.list(queryWrapper);
//        if(list.size() > 0) {
            return Result.success(list);
//        }
//        return Result.error("There is no result");
    }

}
