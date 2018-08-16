package com.zving.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zving.framework.ControllerBase;
import com.zving.framework.annotation.AuthPassport;

@RestController
@RequestMapping("/kafka")
public class KafakaController extends ControllerBase {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	@AuthPassport(validate=false)
	@PostMapping("/send")
	public void sendKafka() {
		try {
			kafkaTemplate.send("log", $V("logs"));
			logger.info("kafka：日志发送成功");
			success("kafka：日志发送成功");
		} catch (Exception e) {
			logger.error("kafka：日志发送失败", e);
			fail("kafka：发送失败");
		}
	}

}
