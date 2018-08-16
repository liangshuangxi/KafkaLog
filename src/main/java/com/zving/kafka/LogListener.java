package com.zving.kafka;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.zving.framework.Current;
import com.zving.framework.data.Transaction;
import com.zving.framework.json.JSON;
import com.zving.framework.json.JSONObject;
import com.zving.log.controller.LogBL;
import com.zving.schema.ZCKafkaLog;

@Component
public class LogListener {
	private static final Logger LOGGER = LoggerFactory.getLogger(LogListener.class);
	private static AtomicInteger maxId = LogBL.getMaxLogID();
	private static boolean lasted = false;

	@KafkaListener(topics = { "log" }, containerFactory = "kafkaListenerContainerFactory")
	public void listen(List<String> data) {
		if (data == null | data.size() < 1) {
			return;
		}
		try {
			Transaction trans = Current.getTransaction();
			for (String log : data) {
				JSONObject logInfo = JSON.parseJSONObject(log);
				ZCKafkaLog kafkaLog = new ZCKafkaLog();
				kafkaLog.setValue(logInfo);
				if (!lasted) {
					maxId = LogBL.getMaxLogID();
					lasted = true;
				}
				kafkaLog.setID(maxId.incrementAndGet());
				trans.insert(kafkaLog);
			}
			if (trans.commit()) {
				LOGGER.info("日志记录插入成功！");
			} else {
				LOGGER.info("日志记录插入失败！" + trans.getExceptionMessage());
			}

		} catch (Exception e) {
			LOGGER.info("日志记录插入失败！" + e.getMessage());
			e.printStackTrace();
		}
	}
}