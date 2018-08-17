package cn.libo.msproject.task;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

public class PrintCurrentTimeJobs2 extends QuartzJobBean {
    private static final Log LOG_RECORD = LogFactory.getLog(PrintCurrentTimeJobs2.class);

    @Autowired
    private CheckOrderTimeOutTask checkOrderTimeOutTask;


    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        LOG_RECORD.info("begin to execute task,checkOrderTimeOutTask.CheckTimeOutOrder(20L)" + DateUtils.dateToString(new Date()));

        checkOrderTimeOutTask.CheckTimeOutOrder(20);

        LOG_RECORD.info("end to execute task,checkOrderTimeOutTask.CheckTimeOutOrder(20L)" + DateUtils.dateToString(new Date()));

    }
}

