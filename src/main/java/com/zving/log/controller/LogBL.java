package com.zving.log.controller;

import java.util.concurrent.atomic.AtomicInteger;

import com.zving.framework.data.Q;

public class LogBL {
	public static AtomicInteger getMaxLogID() {
		int id = new Q("select max(ID) from ZCKafkaLog").executeInt();
		return new AtomicInteger(id);
	}
}
