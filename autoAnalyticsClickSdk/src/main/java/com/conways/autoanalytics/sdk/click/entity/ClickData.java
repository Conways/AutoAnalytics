package com.conways.autoanalytics.sdk.click.entity;

public class ClickData {



    /**
    轨迹id
     */
    private String trackId;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 手机号
     */
    private String userPhoneNumber;
    /**
     * app时间戳
     */
    private Long logTime;
    /**
     * 设备id
     */
    private String deviceId;
    /**
     * 设备类型
     */
    private String deviceType;
    /**
     * 经纬度
     */
    private String longitudeAndLatitude;
    /**
     * 操作系统
     */
    private String osType;
    /**
     * 系统版本
     */
    private String osVersion;
    /**
     * 客户端ip地址
     */
    private String clientIp;
    /**
     * app 版本
     */
    private String appVersion;
    /**
     * 事件类型  1:点击;2: 浏览
     */
    private int eventType;
    /**
     * 0:未知；1:2G；2:3G；3:4G；4:Wifi；5:5G
     */
    private String networkType;
    /**
     * 信号强度
     */
    private String signalIntensity;
    /**
     * 城市编码
     */
    private String cityCode;
    /**
     * 城市名称
     */
    private String cityName;
    /**
     * 当前页面 -带有时间戳
     */
    private String page;
    /**
     * 页面编码 不带时间戳
     */
    private String pageCode;
    /**
     * 页面标题
     */
    private String pageTitle;
    /**
     * 页面标题列表
     */
    private String pageTitleList;
    /**
     * 页面列表 顺序集合
     */
    private String pageList;
    /**
     * 组件名称
     */
    private String componentName;
    /**
     * 点击文案
     */
    private String clickText;
    /**
     * 坐标 横
     */
    private int axisX;
    /**
     * 坐标 竖
     */
    private int axisY;
    /**
     * 设备宽度
     */
    private int deviceWidth;
    /**
     * 设备高度
     */
    private int deviceHeight;
    /**
     * 父布局类型层级
     */
    private String parentMsg;
    /**
     * viewId名称(xxx)，如R.id.xxx
     */
    private String viewIdName;

    public String getTrackId() {
        return trackId;
    }

    public void setTrackId(String trackId) {
        this.trackId = trackId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public Long getLogTime() {
        return logTime;
    }

    public void setLogTime(Long logTime) {
        this.logTime = logTime;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getLongitudeAndLatitude() {
        return longitudeAndLatitude;
    }

    public void setLongitudeAndLatitude(String longitudeAndLatitude) {
        this.longitudeAndLatitude = longitudeAndLatitude;
    }

    public String getOsType() {
        return osType;
    }

    public void setOsType(String osType) {
        this.osType = osType;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public String getNetworkType() {
        return networkType;
    }

    public void setNetworkType(String networkType) {
        this.networkType = networkType;
    }

    public String getSignalIntensity() {
        return signalIntensity;
    }

    public void setSignalIntensity(String signalIntensity) {
        this.signalIntensity = signalIntensity;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getPageCode() {
        return pageCode;
    }

    public void setPageCode(String pageCode) {
        this.pageCode = pageCode;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public String getPageTitleList() {
        return pageTitleList;
    }

    public void setPageTitleList(String pageTitleList) {
        this.pageTitleList = pageTitleList;
    }

    public String getPageList() {
        return pageList;
    }

    public void setPageList(String pageList) {
        this.pageList = pageList;
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public String getClickText() {
        return clickText;
    }

    public void setClickText(String clickText) {
        this.clickText = clickText;
    }

    public int getAxisX() {
        return axisX;
    }

    public void setAxisX(int axisX) {
        this.axisX = axisX;
    }

    public int getAxisY() {
        return axisY;
    }

    public void setAxisY(int axisY) {
        this.axisY = axisY;
    }

    public int getDeviceWidth() {
        return deviceWidth;
    }

    public void setDeviceWidth(int deviceWidth) {
        this.deviceWidth = deviceWidth;
    }

    public int getDeviceHeight() {
        return deviceHeight;
    }

    public void setDeviceHeight(int deviceHeight) {
        this.deviceHeight = deviceHeight;
    }

    public String getParentMsg() {
        return parentMsg;
    }

    public void setParentMsg(String parentMsg) {
        this.parentMsg = parentMsg;
    }

    public String getViewIdName() {
        return viewIdName;
    }

    public void setViewIdName(String viewIdName) {
        this.viewIdName = viewIdName;
    }

    public static final class AutoAnalyticsDataBuilder {
        private String trackId;
        private String userId;
        private String userPhoneNumber;
        private Long logTime;
        private String deviceId;
        private String deviceType;
        private String longitudeAndLatitude;
        private String osType;
        private String osVersion;
        private String clientIp;
        private String appVersion;
        private int eventType;
        private String networkType;
        private String signalIntensity;
        private String cityCode;
        private String cityName;
        private String page;
        private String pageCode;
        private String pageTitle;
        private String pageTitleList;
        private String pageList;
        private String componentName;
        private String clickText;
        private int axisX;
        private int axisY;
        private int deviceWidth;
        private int deviceHeight;
        private String parentMsg;

        private String viewIdName;

        private AutoAnalyticsDataBuilder() {
        }

        public static AutoAnalyticsDataBuilder anAutoAnalyticsData() {
            return new AutoAnalyticsDataBuilder();
        }

        public AutoAnalyticsDataBuilder trackId(String trackId) {
            this.trackId = trackId;
            return this;
        }

        public AutoAnalyticsDataBuilder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public AutoAnalyticsDataBuilder userPhoneNumber(String userPhoneNumber) {
            this.userPhoneNumber = userPhoneNumber;
            return this;
        }

        public AutoAnalyticsDataBuilder logTime(Long logTime) {
            this.logTime = logTime;
            return this;
        }

        public AutoAnalyticsDataBuilder deviceId(String deviceId) {
            this.deviceId = deviceId;
            return this;
        }

        public AutoAnalyticsDataBuilder deviceType(String deviceType) {
            this.deviceType = deviceType;
            return this;
        }

        public AutoAnalyticsDataBuilder longitudeAndLatitude(String longitudeAndLatitude) {
            this.longitudeAndLatitude = longitudeAndLatitude;
            return this;
        }

        public AutoAnalyticsDataBuilder osType(String osType) {
            this.osType = osType;
            return this;
        }

        public AutoAnalyticsDataBuilder osVersion(String osVersion) {
            this.osVersion = osVersion;
            return this;
        }

        public AutoAnalyticsDataBuilder clientIp(String clientIp) {
            this.clientIp = clientIp;
            return this;
        }

        public AutoAnalyticsDataBuilder appVersion(String appVersion) {
            this.appVersion = appVersion;
            return this;
        }

        public AutoAnalyticsDataBuilder eventType(int eventType) {
            this.eventType = eventType;
            return this;
        }

        public AutoAnalyticsDataBuilder networkType(String networkType) {
            this.networkType = networkType;
            return this;
        }

        public AutoAnalyticsDataBuilder signalIntensity(String signalIntensity) {
            this.signalIntensity = signalIntensity;
            return this;
        }

        public AutoAnalyticsDataBuilder cityCode(String cityCode) {
            this.cityCode = cityCode;
            return this;
        }

        public AutoAnalyticsDataBuilder cityName(String cityName) {
            this.cityName = cityName;
            return this;
        }

        public AutoAnalyticsDataBuilder page(String page) {
            this.page = page;
            return this;
        }

        public AutoAnalyticsDataBuilder pageCode(String pageCode) {
            this.pageCode = pageCode;
            return this;
        }

        public AutoAnalyticsDataBuilder pageTitle(String pageTitle) {
            this.pageTitle = pageTitle;
            return this;
        }

        public AutoAnalyticsDataBuilder pageTitleList(String pageTitleList) {
            this.pageTitleList = pageTitleList;
            return this;
        }

        public AutoAnalyticsDataBuilder pageList(String pageList) {
            this.pageList = pageList;
            return this;
        }

        public AutoAnalyticsDataBuilder componentName(String componentName) {
            this.componentName = componentName;
            return this;
        }

        public AutoAnalyticsDataBuilder clickText(String clickText) {
            this.clickText = clickText;
            return this;
        }

        public AutoAnalyticsDataBuilder axisX(int axisX) {
            this.axisX = axisX;
            return this;
        }

        public AutoAnalyticsDataBuilder axisY(int axisY) {
            this.axisY = axisY;
            return this;
        }

        public AutoAnalyticsDataBuilder deviceWidth(int deviceWidth) {
            this.deviceWidth = deviceWidth;
            return this;
        }

        public AutoAnalyticsDataBuilder deviceHeight(int deviceHeight) {
            this.deviceHeight = deviceHeight;
            return this;
        }

        public AutoAnalyticsDataBuilder parentMsg(String parentMsg) {
            this.parentMsg = parentMsg;
            return this;
        }
        public AutoAnalyticsDataBuilder viewIdName(String viewIdName) {
            this.viewIdName = viewIdName;
            return this;
        }



        public ClickData build() {
            ClickData autoAnalyticsData = new ClickData();
            autoAnalyticsData.setTrackId(trackId);
            autoAnalyticsData.setUserId(userId);
            autoAnalyticsData.setUserPhoneNumber(userPhoneNumber);
            autoAnalyticsData.setLogTime(logTime);
            autoAnalyticsData.setDeviceId(deviceId);
            autoAnalyticsData.setDeviceType(deviceType);
            autoAnalyticsData.setLongitudeAndLatitude(longitudeAndLatitude);
            autoAnalyticsData.setOsType(osType);
            autoAnalyticsData.setOsVersion(osVersion);
            autoAnalyticsData.setClientIp(clientIp);
            autoAnalyticsData.setAppVersion(appVersion);
            autoAnalyticsData.setEventType(eventType);
            autoAnalyticsData.setNetworkType(networkType);
            autoAnalyticsData.setSignalIntensity(signalIntensity);
            autoAnalyticsData.setCityCode(cityCode);
            autoAnalyticsData.setCityName(cityName);
            autoAnalyticsData.setPage(page);
            autoAnalyticsData.setPageCode(pageCode);
            autoAnalyticsData.setPageTitle(pageTitle);
            autoAnalyticsData.setPageTitleList(pageTitleList);
            autoAnalyticsData.setPageList(pageList);
            autoAnalyticsData.setComponentName(componentName);
            autoAnalyticsData.setClickText(clickText);
            autoAnalyticsData.setAxisX(axisX);
            autoAnalyticsData.setAxisY(axisY);
            autoAnalyticsData.setDeviceWidth(deviceWidth);
            autoAnalyticsData.setDeviceHeight(deviceHeight);
            autoAnalyticsData.setParentMsg(parentMsg);
            autoAnalyticsData.setViewIdName(viewIdName);
            return autoAnalyticsData;
        }
    }


    @Override
    public String toString() {
        return "AutoAnalyticsData{" +
                "trackId='" + trackId + '\n' +
                " userId='" + userId + '\n' +
                " userPhoneNumber='" + userPhoneNumber + '\n' +
                " logTime=" + logTime +
                " deviceId='" + deviceId + '\n' +
                " deviceType='" + deviceType + '\n' +
                " longitudeAndLatitude='" + longitudeAndLatitude + '\n' +
                " osType='" + osType + '\n' +
                " osVersion='" + osVersion + '\n' +
                " clientIp='" + clientIp + '\n' +
                " appVersion='" + appVersion + '\n' +
                " eventType=" + eventType +
                " networkType='" + networkType + '\n' +
                " signalIntensity='" + signalIntensity + '\n' +
                " cityCode='" + cityCode + '\n' +
                " cityName='" + cityName + '\n' +
                " page='" + page + '\n' +
                " pageCode='" + pageCode + '\n' +
                " pageTitle='" + pageTitle + '\n' +
                " pageTitleList='" + pageTitleList + '\n' +
                " pageList='" + pageList + '\n' +
                " componentName='" + componentName + '\n' +
                " clickText='" + clickText + '\n' +
                " axisX=" + axisX +'\n' +
                " axisY=" + axisY +'\n' +
                " deviceWidth=" + deviceWidth +'\n' +
                " deviceHeight=" + deviceHeight +'\n' +
                " viewIdName='" + viewIdName + '\n' +
                " parentMsg='" + parentMsg + '\n' +
                '}';
    }
}
