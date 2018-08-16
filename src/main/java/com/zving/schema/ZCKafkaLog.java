package com.zving.schema;

import com.zving.framework.annotation.dao.Column;
import com.zving.framework.annotation.dao.Indexes;
import com.zving.framework.annotation.dao.Table;
import com.zving.framework.data.DataTypes;
import com.zving.framework.orm.DAO;
import com.zving.framework.utility.StringUtil;

/**
 * <b>ZCKafkaLog(日志表)</b><br>
 * PrimaryKeys: <b>ID</b><br>
 */
@Table("ZCKafkaLog")
@Indexes("")
public class ZCKafkaLog extends DAO<ZCKafkaLog> {
	private static final long serialVersionUID = 1L;

	@Column(name = "ID", type = DataTypes.LONG, mandatory = true, pk = true)
	protected Long ID;

	@Column(name = "IP", type = DataTypes.STRING, length = 50)
	protected String IP;

	@Column(name = "OS", type = DataTypes.STRING, length = 50)
	protected String OS;

	@Column(name = "BrowserEdition", type = DataTypes.STRING, length = 50)
	protected String BrowserEdition;

	@Column(name = "ResidenceTime", type = DataTypes.LONG)
	protected Long ResidenceTime;

	@Column(name = "StartTime", type = DataTypes.LONG)
	protected Long StartTime;

	@Column(name = "EndTime", type = DataTypes.LONG)
	protected Long EndTime;

	@Column(name = "UserAgent", type = DataTypes.STRING, length = 200)
	protected String UserAgent;

	/**
	 * <b>ID(ID)</b>,<b>LONG</b>,<b>primary key</b>,<b>mandatory</b><br>
	 */
	public long getID() {
		if (ID == null) {
			return 0;
		}
		return ID;
	}

	/**
	 * <b>ID(ID)</b>, <b>LONG</b>, part of <b>Primary Keys</b>, <b>mandatory</b><br>
	 */
	public void setID(long iD) {
		this.ID = new Long(iD);
	}

	/**
	 * <b>ID(ID)</b>, <b>LONG</b>, , part of <b>Primary Keys</b>,
	 * <b>mandatory</b><br>
	 */
	public void setID(String iD) {
		if (StringUtil.isNull(iD)) {
			this.ID = null;
			return;
		}
		this.ID = new Long(iD);
	}

	/**
	 * <b>IP(IP地址)</b>,<b>STRING</b><br>
	 */
	public String getIP() {
		return IP;
	}

	/**
	 * <b>IP(IP地址)</b>, <b>STRING</b><br>
	 */
	public void setIP(String iP) {
		this.IP = iP;
	}

	/**
	 * <b>OS(操作系统)</b>,<b>STRING</b><br>
	 */
	public String getOS() {
		return OS;
	}

	/**
	 * <b>OS(操作系统)</b>, <b>STRING</b><br>
	 */
	public void setOS(String oS) {
		this.OS = oS;
	}

	/**
	 * <b>BrowserEdition(浏览器版本)</b>,<b>STRING</b><br>
	 */
	public String getBrowserEdition() {
		return BrowserEdition;
	}

	/**
	 * <b>BrowserEdition(浏览器版本)</b>, <b>STRING</b><br>
	 */
	public void setBrowserEdition(String browserEdition) {
		this.BrowserEdition = browserEdition;
	}

	/**
	 * <b>ResidenceTime(停留时间)</b>,<b>LONG</b><br>
	 */
	public long getResidenceTime() {
		if (ResidenceTime == null) {
			return 0;
		}
		return ResidenceTime;
	}

	/**
	 * <b>ResidenceTime(停留时间)</b>, <b>LONG</b><br>
	 */
	public void setResidenceTime(long residenceTime) {
		this.ResidenceTime = new Long(residenceTime);
	}

	/**
	 * <b>ResidenceTime(停留时间)</b>, <b>LONG</b>, <br>
	 */
	public void setResidenceTime(String residenceTime) {
		if (StringUtil.isNull(residenceTime)) {
			this.ResidenceTime = null;
			return;
		}
		this.ResidenceTime = new Long(residenceTime);
	}

	/**
	 * <b>StartTime(进入时间)</b>,<b>LONG</b><br>
	 */
	public long getStartTime() {
		if (StartTime == null) {
			return 0;
		}
		return StartTime;
	}

	/**
	 * <b>StartTime(进入时间)</b>, <b>LONG</b><br>
	 */
	public void setStartTime(long startTime) {
		this.StartTime = new Long(startTime);
	}

	/**
	 * <b>StartTime(进入时间)</b>, <b>LONG</b>, <br>
	 */
	public void setStartTime(String startTime) {
		if (StringUtil.isNull(startTime)) {
			this.StartTime = null;
			return;
		}
		this.StartTime = new Long(startTime);
	}

	/**
	 * <b>EndTime(离开时间)</b>,<b>LONG</b><br>
	 */
	public long getEndTime() {
		if (EndTime == null) {
			return 0;
		}
		return EndTime;
	}

	/**
	 * <b>EndTime(离开时间)</b>, <b>LONG</b><br>
	 */
	public void setEndTime(long endTime) {
		this.EndTime = new Long(endTime);
	}

	/**
	 * <b>EndTime(离开时间)</b>, <b>LONG</b>, <br>
	 */
	public void setEndTime(String endTime) {
		if (StringUtil.isNull(endTime)) {
			this.EndTime = null;
			return;
		}
		this.EndTime = new Long(endTime);
	}

	/**
	 * <b>UserAgent(用户代理)</b>,<b>STRING</b><br>
	 */
	public String getUserAgent() {
		return UserAgent;
	}

	/**
	 * <b>UserAgent(用户代理)</b>, <b>STRING</b><br>
	 */
	public void setUserAgent(String userAgent) {
		this.UserAgent = userAgent;
	}

}