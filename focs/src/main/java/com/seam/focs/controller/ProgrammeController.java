package com.seam.focs.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.seam.focs.common.Result;
import com.seam.focs.entity.Programme;
import com.seam.focs.service.ProgrammeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/programme")
public class ProgrammeController {
    @Autowired
    private ProgrammeService programmeService;

    /**
     * Create a new Programme.
     *
     * @param programme
     * @return
     */
    @PostMapping("/add")
    public Result<String> addProgramme(@RequestBody Programme programme) {
        log.info("New Programme Details: {}", programme.toString());

        programmeService.save(programme);

        return Result.success("New Programme Added Successfully");
    }

    /**
     * Update an existing Programme.
     *
     * @param httpServletRequest
     * @param programme
     * @return
     */
    @PutMapping("/update")
    public Result<String> update(HttpServletRequest httpServletRequest,@RequestBody Programme programme) {
        log.info("Update Programme Details: {}", programme.toString());

        programmeService.updateById(programme);

        return Result.success("Programme Updated Successfully");
    }

    /**
     * Get Programme details by ID.
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<Programme> getProgrammeById(@PathVariable Long id) {
        log.info("Get Programme Details by ID, ID = {}", id);

        Programme programme = programmeService.getById(id);

        if (programme != null) {
            return Result.success(programme);
        } else {
            return Result.error("Programme not found");
        }
    }

    /**
     * Get a list of all Programmes.
     *
     * @return
     */
    @GetMapping("/list")
    public Result<List<Programme>> getAllProgrammes() {
        log.info("Get all Programmes");

        List<Programme> programmes = programmeService.list();

        if (programmes != null && !programmes.isEmpty()) {
            return Result.success(programmes);
        } else {
            return Result.error("No Programmes found");
        }
    }

    /**
     * Delete a Programme by ID.
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result<String> deleteProgrammeById(@PathVariable Long id) {
        log.info("Delete Programme by ID, ID = {}", id);

        boolean deleted = programmeService.removeById(id);

        if (deleted) {
            return Result.success("Programme Deleted Successfully");
        } else {
            return Result.error("Programme not found");
        }
    }
}
