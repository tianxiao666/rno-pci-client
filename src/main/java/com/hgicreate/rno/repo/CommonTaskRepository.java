package com.hgicreate.rno.repo;


import com.hgicreate.rno.model.AbstractTask;
import com.hgicreate.rno.model.Job;
import com.hgicreate.rno.model.JobStatus;
import com.hgicreate.rno.web.rest.vm.TaskQueryVm;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 作业数据层的抽象接口，其他作业继承该接口享受公共方法。
 *
 * @author chen.c10
 */
@NoRepositoryBean
public interface CommonTaskRepository<T extends AbstractTask, ID extends Serializable> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {
    String ALL = "ALL";
    String LAUNCHED_OR_RUNNING = "LaunchedOrRunning";

    /**
     * 通过任务状态与创建时间降序排列取第一个作业
     *
     * @param runningStatus 任务状态
     * @return 作业对象
     */
    T findFirstByJobRunningStatusOrderByJobCreateTimeDesc(JobStatus runningStatus);

    /**
     * 通过条件查询作业列表
     *
     * @param cond 查询条件
     * @return 作业列表
     */
    default List<T> findAll(TaskQueryVm cond) {
        return findAll((root, query, builder) -> {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Predicate predicate = builder.conjunction();
            if (cond.getCityId() > 0) {
                predicate.getExpressions().add(
                        builder.equal(root.get("areaId"), cond.getCityId())
                );
            }

            // 任务记录表
            Join<T, Job> join = root.join("job", JoinType.INNER);
            if (StringUtils.isNotBlank(cond.getStartSubmitTime())) {
                try {
                    Date date = simpleDateFormat.parse(cond.getStartSubmitTime());
                    predicate.getExpressions().add(
                            builder.greaterThanOrEqualTo(join.get("createTime"), date)
                    );
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            if (StringUtils.isNotBlank(cond.getEndSubmitTime())) {
                try {
                    Date date = simpleDateFormat.parse(cond.getEndSubmitTime());
                    predicate.getExpressions().add(
                            builder.lessThanOrEqualTo(join.get("createTime"), date)
                    );
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            if (StringUtils.isNotBlank(cond.getAccount())) {
                predicate.getExpressions().add(
                        builder.equal(join.get("creator"), cond.getAccount())
                );
            }
            if (StringUtils.isNotBlank(cond.getTaskName())) {
                predicate.getExpressions().add(
                        builder.like(join.get("name"), "%" + cond.getTaskName() + "%")
                );
            }
            if (StringUtils.isNotBlank(cond.getTaskStatus()) && !StringUtils.equalsIgnoreCase(cond.getTaskStatus(), ALL)) {
                if (StringUtils.equalsIgnoreCase(cond.getTaskStatus(), LAUNCHED_OR_RUNNING)) {
                    predicate.getExpressions().add(
                            builder.or(builder.equal(join.get("runningStatus"), JobStatus.Running), builder.equal(join.get("runningStatus"), JobStatus.Launched))
                    );
                } else {
                    predicate.getExpressions().add(
                            builder.equal(join.get("runningStatus"), JobStatus.valueOf(cond.getTaskStatus()))
                    );
                }
            }
            return predicate;
        });
    }
}
