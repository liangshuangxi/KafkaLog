package com.zving.kafka;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

@Configuration
@EnableKafka
public class KafkaConsumerConf {

	@Value("${spring.kafka.consumer.bootstrap-servers}")
	private String servers;
	@Value("${spring.kafka.consumer.group-id}")
	private String groupid;
	@Value("${spring.kafka.consumer.auto-commit-interval}")
	private String interval;
	@Value("${spring.kafka.consumer.auto-offset-reset}")
	private String offsetReset;
	@Value("${spring.kafka.consumer.enable-auto-commit}")
	private String autoCommit;
	@Value("${spring.kafka.consumer.session-timeout-ms}")
	private String timeout;
	@Value("${spring.kafka.consumer.max-poll-records}")
	private String records;
	@Value("${spring.kafka.consumer.fetch-min-bytes}")
	private String min_bytes;

	public Map<String, Object> consumerConfigs() {
		Map<String, Object> propsMap = new HashMap<>();
		propsMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, servers);
		propsMap.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, autoCommit);
		propsMap.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, interval);
		propsMap.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, timeout);
		propsMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		propsMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		propsMap.put(ConsumerConfig.GROUP_ID_CONFIG, groupid);
		propsMap.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, offsetReset);
		propsMap.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, records);
		propsMap.put(ConsumerConfig.FETCH_MIN_BYTES_CONFIG, min_bytes);
		return propsMap;
	}

	@Bean
	public ConsumerFactory<String, String> consumerFactory() {
		return new DefaultKafkaConsumerFactory<>(consumerConfigs());
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		factory.setBatchListener(true);
		factory.setConcurrency(5);
		factory.getContainerProperties().setPollTimeout(4000);
		return factory;
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> kafkaMicrocourseListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		factory.setBatchListener(true);
		factory.setConcurrency(10);
		factory.getContainerProperties().setPollTimeout(4000);
		return factory;
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		factory.setConcurrency(3);
		factory.getContainerProperties().setPollTimeout(4000);
		return factory;
	}

	@Bean
	public LogListener logListener() {
		return new LogListener();
	}
}
