
function initBootstrapTable(itable, iparams, bconfig) {
	itable.bootstrapTable({ // 对应table标签的id
		url : bconfig.url, // 获取表格数据的url
		cache : false, // 设置为 false 禁用 AJAX 数据缓存， 默认为true
		striped : true, // 表格显示条纹，默认为false
		pagination : bconfig.pagination, // 在表格底部显示分页组件，默认false
		pageList : [10, 15, 20 ], // 设置页面可以显示的数据条数
		pageSize : 20, // 页面数据条数
		pageNumber : 1, // 首页页码
		sidePagination : bconfig.sidePagination, // 设置为服务器端分页
		sortName : bconfig.sortName, // 要排序的字段
		sortOrder : bconfig.sortOrder, // 排序规则
		columns : bconfig.columns,
		onLoadSuccess : function(data) {
			console.info("加载成功");
		},
		onLoadError : function() {
			console.info("加载数据失败");
		}
	});
}


function getOS() {
    var myUserAgent = navigator.userAgent;
    var isWin = (navigator.platform == "Win32") || (navigator.platform == "Windows");
    var isMac = (navigator.platform == "Mac68K") || (navigator.platform == "MacPPC") || (navigator.platform == "Macintosh") || (navigator.platform == "MacIntel");
    if (isMac) return "Mac";
    var isUnix = (navigator.platform == "X11") && !isWin && !isMac;
    if (isUnix) return "Unix";
    var isLinux = (String(navigator.platform).indexOf("Linux") > -1);
    if (isLinux) return "Linux";
    if (isWin) {
        var isWin2K = myUserAgent.indexOf("Windows NT 5.0") > -1 || myUserAgent.indexOf("Windows 2000") > -1;
        if (isWin2K) return "Win2000";
        var isWinXP = myUserAgent.indexOf("Windows NT 5.1") > -1 || myUserAgent.indexOf("Windows XP") > -1;
        if (isWinXP) return "WinXP";
        var isWin2003 = myUserAgent.indexOf("Windows NT 5.2") > -1 || myUserAgent.indexOf("Windows 2003") > -1;
        if (isWin2003) return "Win2003";
        var isWinVista= myUserAgent.indexOf("Windows NT 6.0") > -1 || myUserAgent.indexOf("Windows Vista") > -1;
        if (isWinVista) return "WinVista";
        var isWin7 = myUserAgent.indexOf("Windows NT 6.1") > -1 || myUserAgent.indexOf("Windows 7") > -1;
        if (isWin7) return "Win7";
        var isWin8 = myUserAgent.indexOf("Windows NT 6.2") > -1 || myUserAgent.indexOf("Windows 8") > -1;
        if (isWin8) return "Win8";
        var isWin81 = myUserAgent.indexOf("Windows NT 6.3") > -1 || myUserAgent.indexOf("Windows 8.1") > -1;
        if (isWin81) return "Win8.1";
        var isWin10 = myUserAgent.indexOf("Windows NT 10") > -1 || myUserAgent.indexOf("Windows 10") > -1;
        if (isWin10) return "Win10";
    }
    return "other";
}
var defaltBrowser = {
		"msie": "IE",
		"edge":"Edge",
		"firefox": "Firefox",
		"netscape":"Netscape",
		"opr":"OPR",
		"opera":"Opera",
		"chrome": "Chrome",
		"safari": "Safari"
};

function getBrowserEdition() {
	var myUserAgent = navigator.userAgent;
	if (myUserAgent==undefined||myUserAgent==null||myUserAgent=="") {
		return "其他";
	}
	var browser;
	myUserAgent =  $.trim(myUserAgent.toLowerCase());
	var version = "version";
	var ver_index = myUserAgent.indexOf(version);
	$.each(defaltBrowser,function(key,value) {
		if (myUserAgent.indexOf(key) > -1) {
			if ("msie"==key) {
				browser= value + getVersion(myUserAgent, ver_index > -1 ? version : key);
			} else {
				browser= value;
			}
		return false;
		}
		});
	return browser == null ? "其他" : browser;
}
function getVersion(myUserAgent,str) {
	var start_index = myUserAgent.indexOf(str) + str.length;
	var end_index = myUserAgent.indexOf('.', start_index);
	if (end_index > -1) {
		return myUserAgent.substring(start_index, end_index).replace("/", " ");
	} else {
		return myUserAgent.substring(start_index).replace("/", " ");
	}
}