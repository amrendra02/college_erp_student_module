package com.server.controller.student;

import com.server.constant.API;
import com.server.dto.ApiResponse;
import com.server.dto.student.StudentStatusDTO;
import com.server.service.student.StatusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(API.student)
public class StudentStatusController {

    @Autowired
    private StatusService statusService;

    private static  final Logger log = LoggerFactory.getLogger(StudentStatusController.class);

    @PostMapping(API.status)
    public ResponseEntity<StudentStatusDTO> create(@RequestBody StudentStatusDTO req){
        log.info("Request to create the Status of student: {} ",req);
        StudentStatusDTO res = this.statusService.create(req);
        log.info("Successfully created status: {}",res.getId());
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }
    @GetMapping(API.status+"/{rollNo}")
    public ResponseEntity<?> getAllStatus(@PathVariable String rollNo){
        log.info("Request to get all the Status of student: {} ",rollNo);
        List<StudentStatusDTO> res = this.statusService.getAllStatus(rollNo);

        log.info("Process Completed.");

        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }
    @PutMapping(API.status)
    public ResponseEntity<StudentStatusDTO> update(@RequestBody StudentStatusDTO req){
        log.info("Request to update the Status of student: {} ",req);
        StudentStatusDTO res = this.statusService.update(req);
        log.info("Successfully updated status: {}",res.getId());
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }
    @DeleteMapping(API.status)
    public ResponseEntity<ApiResponse> delete(@RequestBody StudentStatusDTO req){
        log.info("Request to delete the Status of student: {} ",req);
        ApiResponse res = this.statusService.delete(req);
        log.info("Successfully deleted status: {}",res.isSuccess());
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

}
