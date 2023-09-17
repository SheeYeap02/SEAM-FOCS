package com.seam.focs.controller;

import com.seam.focs.service.StaffService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    private StaffService staffService;


//    public Result<Staff> page(int page, int pageSize, String name) {
//        log.info("page = {}, pageSize = {}, name = {}", page, pageSize, name);
//
//        //Construct pagination constitution
//        Page pageInfo = new Page(page, pageSize);
//
//        //Construct condition constitution
//        LambdaQueryWrapper<Staff> queryWrapper = new LambdaQueryWrapper();
//        //Add filter condition
//        queryWrapper.like(!StringUtils.isEmpty(name), Staff::getName, name);
//        //Add order condition
//        queryWrapper.orderByDesc(Staff::getUpdateTime);
//
//        //Execute query
//        staffService.page(pageInfo, queryWrapper);
//        return Result.success(pageInfo);
//    }


}
