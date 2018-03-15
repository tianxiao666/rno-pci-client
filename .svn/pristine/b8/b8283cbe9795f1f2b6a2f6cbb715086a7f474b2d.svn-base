package com.hgicreate.rno.repo;

import com.hgicreate.rno.model.Job;
import com.hgicreate.rno.model.JobStatus;
import com.hgicreate.rno.model.JobType;
import com.hgicreate.rno.web.rest.vm.JobQueryVm;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import javax.persistence.criteria.Predicate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author chen.c10
 */
public interface JobRepository extends JpaRepository<Job, Long>, JpaSpecificationExecutor<Job> {
    String ALL = "ALL";
    String LAUNCHED_OR_RUNNING = "LaunchedOrRunning";

    /**
     * 通过任务运行状态和任务类型并按创建时间降序排列获取一个任务
     *
     * @param runningStatus 任务运行状态
     * @param type          任务类型
     * @return 任务对象
     */
    List<Job> findByRunningStatusAndTypeOrderByCreateTimeDesc(JobStatus runningStatus, JobType type);

    /**
     * 通过条件查询作业列表
     *
     * @param cond 查询条件
     * @return 作业列表
     */
    default List<Job> findAll(JobQueryVm cond) {
        return findAll((root, query, builder) -> {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Predicate predicate = builder.conjunction();
            if (null != cond.getJobType()) {
                predicate.getExpressions().add(
                        builder.equal(root.<JobType>get("type"), cond.getJobType())
                );
            }
            if (StringUtils.isNotBlank(cond.getTaskName())) {
                predicate.getExpressions().add(
                        builder.like(root.get("name"), "%" + cond.getTaskName() + "%")
                );
            }
            if (null != cond.getCityId()) {
                predicate.getExpressions().add(
                        builder.equal(root.get("areaCode"), cond.getCityId())
                );
            }
            if (StringUtils.isNotBlank(cond.getStartSubmitTime())) {
                try {
                    Date date = simpleDateFormat.parse(cond.getStartSubmitTime());
                    predicate.getExpressions().add(
                            builder.greaterThanOrEqualTo(root.get("createTime"), date)
                    );
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            if (StringUtils.isNotBlank(cond.getEndSubmitTime())) {
                try {
                    Date date = simpleDateFormat.parse(cond.getEndSubmitTime());
                    predicate.getExpressions().add(
                            builder.lessThanOrEqualTo(root.get("createTime"), date)
                    );
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            if (StringUtils.isNotBlank(cond.getAccount())) {
                predicate.getExpressions().add(
                        builder.equal(root.get("creator"), cond.getAccount())
                );
            }
            if (StringUtils.isNotBlank(cond.getTaskStatus()) && !StringUtils.equalsIgnoreCase(cond.getTaskStatus(), ALL)) {
                if (StringUtils.equalsIgnoreCase(cond.getTaskStatus(), LAUNCHED_OR_RUNNING)) {
                    predicate.getExpressions().add(
                            builder.or(builder.equal(root.get("runningStatus"), JobStatus.Running), builder.equal(root.get("runningStatus"), JobStatus.Launched))
                    );
                } else {
                    predicate.getExpressions().add(
                            builder.equal(root.get("runningStatus"), JobStatus.valueOf(cond.getTaskStatus()))
                    );
                }
            }

            return predicate;
        });
    }
}
