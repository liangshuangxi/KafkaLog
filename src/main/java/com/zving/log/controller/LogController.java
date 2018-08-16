package com.zving.log.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zving.framework.ControllerBase;
import com.zving.framework.annotation.AuthPassport;
import com.zving.framework.data.DBUtil;
import com.zving.framework.data.DataTable;
import com.zving.framework.data.Q;
import com.zving.log.util.JSONUtil;

@RestController
@RequestMapping("api/kafka/log")
public class LogController extends ControllerBase {
	@AuthPassport(validate=false)
	@GetMapping("logList")
	public void getLogList() {
		Q q = new Q("select * from ZCKafkaLog");
		$S("total",DBUtil.getCount(q));
		int offset=$I("offset");
		int limit=$I("limit");
		DataTable table = q.fetch(limit,offset/limit);
		$S("rows",JSONUtil.toJSONArray(table));
	}
}
