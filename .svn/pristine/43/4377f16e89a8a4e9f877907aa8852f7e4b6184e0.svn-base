package com.hgicreate.rno.web.rest;

import com.hgicreate.rno.model.JobType;
import com.hgicreate.rno.service.TaskService;
import com.hgicreate.rno.service.dto.AbstractTaskDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author chen.c10
 */
@Slf4j
@CrossOrigin
@RestController
public class TaskResource {

    private final TaskService taskService;

    public TaskResource(TaskService taskService) {
        this.taskService = taskService;
    }

    /**
     * 获取相应状态下的任务ID
     */
    @GetMapping("/tasks/find-by-type/{type}")
    public ResponseEntity<? extends AbstractTaskDTO> findByType(@PathVariable("type") JobType type) {
        log.debug("进入方法：findByType。type={}", type);
        Optional<? extends AbstractTaskDTO> taskDTO = taskService.findByType(type);
        log.debug("退出方法：findByType。task={}", taskDTO);
        return ResponseEntity.ok(taskDTO.orElse(null));
    }
}
