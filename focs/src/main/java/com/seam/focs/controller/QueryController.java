package com.seam.focs.controller;

import com.seam.focs.common.Result;
import com.seam.focs.entity.Query;
import com.seam.focs.service.QueryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/queries")
public class QueryController {
    @Autowired
    private QueryService queryService;

    /**
     * Create a new Query.
     *
     * @param query
     * @return
     */
    @PostMapping("/add")
    public Result<String> addQuery(@RequestBody Query query) {
        log.info("New Query Details: {}", query.toString());

        queryService.save(query);

        return Result.success("New Query Added Successfully");
    }

    /**
     * Update an existing Query.
     *
     * @param httpServletRequest
     * @param query
     * @return
     */
    @PutMapping("/update")
    public Result<String> update(HttpServletRequest httpServletRequest, @RequestBody Query query) {
        log.info("Update Query Details: {}", query.toString());

        queryService.updateById(query);

        return Result.success("Query Updated Successfully");
    }

    /**
     * Get Query details by ID.
     *
     * @param queryId
     * @return
     */
    @GetMapping("/{queryId}")
    public Result<Query> getQueryById(@PathVariable Long queryId) {
        log.info("Get Query Details by ID, ID = {}", queryId);

        Query query = queryService.getById(queryId);

        if (query != null) {
            return Result.success(query);
        } else {
            return Result.error("Query not found");
        }
    }

    /**
     * Get a list of all Queries.
     *
     * @return
     */
    @GetMapping("/list")
    public Result<List<Query>> getAllQueries() {
        log.info("Get all Queries");

        List<Query> queries = queryService.list();

        if (queries != null && !queries.isEmpty()) {
            return Result.success(queries);
        } else {
            return Result.error("No Queries found");
        }
    }

    /**
     * Delete a Query by ID.
     *
     * @param queryId
     * @return
     */
    @DeleteMapping("/{queryId}")
    public Result<String> deleteQueryById(@PathVariable Long queryId) {
        log.info("Delete Query by ID, ID = {}", queryId);

        boolean deleted = queryService.removeById(queryId);

        if (deleted) {
            return Result.success("Query Deleted Successfully");
        } else {
            return Result.error("Query not found");
        }
    }
}
