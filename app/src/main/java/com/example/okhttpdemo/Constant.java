package com.example.okhttpdemo;

/**
 * Created by guozhk on 16-8-3.
 */
public class Constant {
    public static final String BASE_URL = "http://172.16.0.32:85/App";
    public static final String TASK_LIST = BASE_URL + "/getTaskList";
    //getRecords
    public static final String RECORDS = BASE_URL + "/getRecords";
    public static final String getOrgIdBysim = BASE_URL + "/getOrgIdBysim";
    public static final String getChildOrg = BASE_URL + "/getChildOrg";
    public static final String getAreaList = BASE_URL + "/getAreaList";
    public static final String startWork = BASE_URL + "/startWork";
    public static final String finishWork = BASE_URL + "/finishWork";
    public static final String getAreaById = BASE_URL + "/getAreaById";
    public static final String getUserInfo = BASE_URL + "/getUserInfo";
    public static final String getAlarmType = BASE_URL + "/getAlarmType";
    public static final String changePWD = BASE_URL + "/changePWD";
    public static final String getAllUserInfo = BASE_URL + "/getAllUserInfo";



    public static final String downUrl = "http://mbdapp.iqiyi.com/j/ap/qiyi.196.apk";
    public static final String upload = "http://mbdapp.iqiyi.com/j/ap/qiyi.196.apk";
    public String filesavepath = "/sdcard";


    public static String jsonStr1="{\n" +
            "  \"LONGITUDE\": 116.4999,\n" +
            "  \"LATITUDE\": 40.09547,\n" +
            "  \"BEGIN_TIME\": \"/Date(1465697080000)/\",\n" +
            "  \"STATUS\": \"1\"\n" +
            "}";

    public static String jsonStr2="{\n" +
            "  \"LONGITUDE\": 116.4999,\n" +
            "  \"LATITUDE\": 40.09547,\n" +
            "  \"BEGIN_TIME\": \"/Date(1465697080000)/\",\n" +
            "  \"STATUS\": \"1\",\n" +
            "  \"listBean\": [\n" +
            "    {\n" +
            "      \"LONGITUDE\": 116.4999,\n" +
            "      \"LATITUDE\": 40.09547,\n" +
            "      \"BEGIN_TIME\": \"/Date(1465697080000)/\",\n" +
            "      \"STATUS\": \"1\"\n" +
            "    },\n" +
            "     {\n" +
            "      \"LONGITUDE\": 116.4999,\n" +
            "      \"LATITUDE\": 40.09547,\n" +
            "      \"BEGIN_TIME\": \"/Date(1465697080000)/\",\n" +
            "      \"STATUS\": \"1\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    public static String jsonStr3 = "[\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4999,\n" +
            "    \"LATITUDE\": 40.09547,\n" +
            "    \"BEGIN_TIME\": \"/Date(1465697080000)/\",\n" +
            "    \"STATUS\": \"1\",\n" +
            "    \"listBean\": [\n" +
            "      {\n" +
            "        \"LONGITUDE\": 116.4999,\n" +
            "        \"LATITUDE\": 40.09547,\n" +
            "        \"BEGIN_TIME\": \"/Date(1465697080000)/\",\n" +
            "        \"STATUS\": \"1\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"LONGITUDE\": 116.4999,\n" +
            "        \"LATITUDE\": 40.09547,\n" +
            "        \"BEGIN_TIME\": \"/Date(1465697080000)/\",\n" +
            "        \"STATUS\": \"1\"\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4999,\n" +
            "    \"LATITUDE\": 40.09547,\n" +
            "    \"BEGIN_TIME\": \"/Date(1465697080000)/\",\n" +
            "    \"STATUS\": \"1\",\n" +
            "    \"listBean\": [\n" +
            "      {\n" +
            "        \"LONGITUDE\": 116.4999,\n" +
            "        \"LATITUDE\": 40.09547,\n" +
            "        \"BEGIN_TIME\": \"/Date(1465697080000)/\",\n" +
            "        \"STATUS\": \"1\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"LONGITUDE\": 116.4999,\n" +
            "        \"LATITUDE\": 40.09547,\n" +
            "        \"BEGIN_TIME\": \"/Date(1465697080000)/\",\n" +
            "        \"STATUS\": \"1\"\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "]";

    public static String jsonStr = "[\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4999,\n" +
            "    \"LATITUDE\": 40.09547,\n" +
            "    \"BEGIN_TIME\": \"/Date(1465697080000)/\",\n" +
            "    \"STATUS\": \"1\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4999,\n" +
            "    \"LATITUDE\": 40.09547,\n" +
            "    \"BEGIN_TIME\": \"/Date(1465697082000)/\",\n" +
            "    \"STATUS\": \"2\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4998,\n" +
            "    \"LATITUDE\": 40.09555,\n" +
            "    \"BEGIN_TIME\": \"/Date(1464437955000)/\",\n" +
            "    \"STATUS\": \"1\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4998,\n" +
            "    \"LATITUDE\": 40.09555,\n" +
            "    \"BEGIN_TIME\": \"/Date(1464437955000)/\",\n" +
            "    \"STATUS\": \"1\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4998,\n" +
            "    \"LATITUDE\": 40.09556,\n" +
            "    \"BEGIN_TIME\": \"/Date(1464437955000)/\",\n" +
            "    \"STATUS\": \"1\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4999,\n" +
            "    \"LATITUDE\": 40.09543,\n" +
            "    \"BEGIN_TIME\": \"/Date(1464437955000)/\",\n" +
            "    \"STATUS\": \"1\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4999,\n" +
            "    \"LATITUDE\": 40.09542,\n" +
            "    \"BEGIN_TIME\": \"/Date(1464437955000)/\",\n" +
            "    \"STATUS\": \"1\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4999,\n" +
            "    \"LATITUDE\": 40.09542,\n" +
            "    \"BEGIN_TIME\": \"/Date(1464437955000)/\",\n" +
            "    \"STATUS\": \"2\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4998,\n" +
            "    \"LATITUDE\": 40.09554,\n" +
            "    \"BEGIN_TIME\": \"/Date(1464437955000)/\",\n" +
            "    \"STATUS\": \"1\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4998,\n" +
            "    \"LATITUDE\": 40.09554,\n" +
            "    \"BEGIN_TIME\": \"/Date(1464437955000)/\",\n" +
            "    \"STATUS\": \"1\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4998,\n" +
            "    \"LATITUDE\": 40.09551,\n" +
            "    \"BEGIN_TIME\": \"/Date(1464437955000)/\",\n" +
            "    \"STATUS\": \"1\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4998,\n" +
            "    \"LATITUDE\": 40.09551,\n" +
            "    \"BEGIN_TIME\": \"/Date(1464437955000)/\",\n" +
            "    \"STATUS\": \"1\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4998,\n" +
            "    \"LATITUDE\": 40.09549,\n" +
            "    \"BEGIN_TIME\": \"/Date(1464437955000)/\",\n" +
            "    \"STATUS\": \"1\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4998,\n" +
            "    \"LATITUDE\": 40.09549,\n" +
            "    \"BEGIN_TIME\": \"/Date(1464437955000)/\",\n" +
            "    \"STATUS\": \"2\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4998,\n" +
            "    \"LATITUDE\": 40.09555,\n" +
            "    \"BEGIN_TIME\": \"/Date(1463059535000)/\",\n" +
            "    \"STATUS\": \"1\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4998,\n" +
            "    \"LATITUDE\": 40.09555,\n" +
            "    \"BEGIN_TIME\": \"/Date(1463059540000)/\",\n" +
            "    \"STATUS\": \"2\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4998,\n" +
            "    \"LATITUDE\": 40.09555,\n" +
            "    \"BEGIN_TIME\": \"/Date(1463059605000)/\",\n" +
            "    \"STATUS\": \"1\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4998,\n" +
            "    \"LATITUDE\": 40.09555,\n" +
            "    \"BEGIN_TIME\": \"/Date(1463059637000)/\",\n" +
            "    \"STATUS\": \"1\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4998,\n" +
            "    \"LATITUDE\": 40.09555,\n" +
            "    \"BEGIN_TIME\": \"/Date(1463059668000)/\",\n" +
            "    \"STATUS\": \"2\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4998,\n" +
            "    \"LATITUDE\": 40.09551,\n" +
            "    \"BEGIN_TIME\": \"/Date(1463059945000)/\",\n" +
            "    \"STATUS\": \"1\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4998,\n" +
            "    \"LATITUDE\": 40.09551,\n" +
            "    \"BEGIN_TIME\": \"/Date(1463059998000)/\",\n" +
            "    \"STATUS\": \"1\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4998,\n" +
            "    \"LATITUDE\": 40.09551,\n" +
            "    \"BEGIN_TIME\": \"/Date(1463060001000)/\",\n" +
            "    \"STATUS\": \"2\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4998,\n" +
            "    \"LATITUDE\": 40.09551,\n" +
            "    \"BEGIN_TIME\": \"/Date(1463060005000)/\",\n" +
            "    \"STATUS\": \"1\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4998,\n" +
            "    \"LATITUDE\": 40.09552,\n" +
            "    \"BEGIN_TIME\": \"/Date(1463060124000)/\",\n" +
            "    \"STATUS\": \"1\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4998,\n" +
            "    \"LATITUDE\": 40.09552,\n" +
            "    \"BEGIN_TIME\": \"/Date(1463060130000)/\",\n" +
            "    \"STATUS\": \"2\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4998,\n" +
            "    \"LATITUDE\": 40.09552,\n" +
            "    \"BEGIN_TIME\": \"/Date(1463060131000)/\",\n" +
            "    \"STATUS\": \"2\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4998,\n" +
            "    \"LATITUDE\": 40.09548,\n" +
            "    \"BEGIN_TIME\": \"/Date(1463060189000)/\",\n" +
            "    \"STATUS\": \"1\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4998,\n" +
            "    \"LATITUDE\": 40.09548,\n" +
            "    \"BEGIN_TIME\": \"/Date(1463060194000)/\",\n" +
            "    \"STATUS\": \"1\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4998,\n" +
            "    \"LATITUDE\": 40.09548,\n" +
            "    \"BEGIN_TIME\": \"/Date(1463060195000)/\",\n" +
            "    \"STATUS\": \"2\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4998,\n" +
            "    \"LATITUDE\": 40.09548,\n" +
            "    \"BEGIN_TIME\": \"/Date(1463060197000)/\",\n" +
            "    \"STATUS\": \"2\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4998,\n" +
            "    \"LATITUDE\": 40.09554,\n" +
            "    \"BEGIN_TIME\": \"/Date(1463060782000)/\",\n" +
            "    \"STATUS\": \"1\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4998,\n" +
            "    \"LATITUDE\": 40.09554,\n" +
            "    \"BEGIN_TIME\": \"/Date(1463060866000)/\",\n" +
            "    \"STATUS\": \"1\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4998,\n" +
            "    \"LATITUDE\": 40.09554,\n" +
            "    \"BEGIN_TIME\": \"/Date(1463060875000)/\",\n" +
            "    \"STATUS\": \"2\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4998,\n" +
            "    \"LATITUDE\": 40.09552,\n" +
            "    \"BEGIN_TIME\": \"/Date(1463061017000)/\",\n" +
            "    \"STATUS\": \"1\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4998,\n" +
            "    \"LATITUDE\": 40.09552,\n" +
            "    \"BEGIN_TIME\": \"/Date(1463061044000)/\",\n" +
            "    \"STATUS\": \"2\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4998,\n" +
            "    \"LATITUDE\": 40.09552,\n" +
            "    \"BEGIN_TIME\": \"/Date(1463061159000)/\",\n" +
            "    \"STATUS\": \"2\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4998,\n" +
            "    \"LATITUDE\": 40.09552,\n" +
            "    \"BEGIN_TIME\": \"/Date(1463061161000)/\",\n" +
            "    \"STATUS\": \"1\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4999,\n" +
            "    \"LATITUDE\": 40.09553,\n" +
            "    \"BEGIN_TIME\": \"/Date(1463101740000)/\",\n" +
            "    \"STATUS\": \"2\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4999,\n" +
            "    \"LATITUDE\": 40.09553,\n" +
            "    \"BEGIN_TIME\": \"/Date(1463101744000)/\",\n" +
            "    \"STATUS\": \"1\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4999,\n" +
            "    \"LATITUDE\": 40.09553,\n" +
            "    \"BEGIN_TIME\": \"/Date(1463102430000)/\",\n" +
            "    \"STATUS\": \"1\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4999,\n" +
            "    \"LATITUDE\": 40.09553,\n" +
            "    \"BEGIN_TIME\": \"/Date(1463102433000)/\",\n" +
            "    \"STATUS\": \"2\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4999,\n" +
            "    \"LATITUDE\": 40.09553,\n" +
            "    \"BEGIN_TIME\": \"/Date(1463102555000)/\",\n" +
            "    \"STATUS\": \"1\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4999,\n" +
            "    \"LATITUDE\": 40.09553,\n" +
            "    \"BEGIN_TIME\": \"/Date(1463102563000)/\",\n" +
            "    \"STATUS\": \"2\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4999,\n" +
            "    \"LATITUDE\": 40.09555,\n" +
            "    \"BEGIN_TIME\": \"/Date(1463102806000)/\",\n" +
            "    \"STATUS\": \"2\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4999,\n" +
            "    \"LATITUDE\": 40.09552,\n" +
            "    \"BEGIN_TIME\": \"/Date(1463103144000)/\",\n" +
            "    \"STATUS\": \"2\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4999,\n" +
            "    \"LATITUDE\": 40.09553,\n" +
            "    \"BEGIN_TIME\": \"/Date(1463103178000)/\",\n" +
            "    \"STATUS\": \"2\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4999,\n" +
            "    \"LATITUDE\": 40.09551,\n" +
            "    \"BEGIN_TIME\": \"/Date(1463103269000)/\",\n" +
            "    \"STATUS\": \"2\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4999,\n" +
            "    \"LATITUDE\": 40.09552,\n" +
            "    \"BEGIN_TIME\": \"/Date(1463105246000)/\",\n" +
            "    \"STATUS\": \"1\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4999,\n" +
            "    \"LATITUDE\": 40.09553,\n" +
            "    \"BEGIN_TIME\": \"/Date(1463105251000)/\",\n" +
            "    \"STATUS\": \"1\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4999,\n" +
            "    \"LATITUDE\": 40.09553,\n" +
            "    \"BEGIN_TIME\": \"/Date(1463105258000)/\",\n" +
            "    \"STATUS\": \"1\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4999,\n" +
            "    \"LATITUDE\": 40.09552,\n" +
            "    \"BEGIN_TIME\": \"/Date(1463105373000)/\",\n" +
            "    \"STATUS\": \"1\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4999,\n" +
            "    \"LATITUDE\": 40.09552,\n" +
            "    \"BEGIN_TIME\": \"/Date(1463105379000)/\",\n" +
            "    \"STATUS\": \"1\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4999,\n" +
            "    \"LATITUDE\": 40.09552,\n" +
            "    \"BEGIN_TIME\": \"/Date(1463105381000)/\",\n" +
            "    \"STATUS\": \"1\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4999,\n" +
            "    \"LATITUDE\": 40.09553,\n" +
            "    \"BEGIN_TIME\": \"/Date(1463105448000)/\",\n" +
            "    \"STATUS\": \"1\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4999,\n" +
            "    \"LATITUDE\": 40.09553,\n" +
            "    \"BEGIN_TIME\": \"/Date(1463105459000)/\",\n" +
            "    \"STATUS\": \"2\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4999,\n" +
            "    \"LATITUDE\": 40.09554,\n" +
            "    \"BEGIN_TIME\": \"/Date(1463109061000)/\",\n" +
            "    \"STATUS\": \"1\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4999,\n" +
            "    \"LATITUDE\": 40.09554,\n" +
            "    \"BEGIN_TIME\": \"/Date(1463109362000)/\",\n" +
            "    \"STATUS\": \"1\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4999,\n" +
            "    \"LATITUDE\": 40.09554,\n" +
            "    \"BEGIN_TIME\": \"/Date(1463109429000)/\",\n" +
            "    \"STATUS\": \"1\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4999,\n" +
            "    \"LATITUDE\": 40.09554,\n" +
            "    \"BEGIN_TIME\": \"/Date(1463109431000)/\",\n" +
            "    \"STATUS\": \"2\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4999,\n" +
            "    \"LATITUDE\": 40.09554,\n" +
            "    \"BEGIN_TIME\": \"/Date(1463109883000)/\",\n" +
            "    \"STATUS\": \"1\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4999,\n" +
            "    \"LATITUDE\": 40.09554,\n" +
            "    \"BEGIN_TIME\": \"/Date(1463109891000)/\",\n" +
            "    \"STATUS\": \"2\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4999,\n" +
            "    \"LATITUDE\": 40.09554,\n" +
            "    \"BEGIN_TIME\": \"/Date(1463110696000)/\",\n" +
            "    \"STATUS\": \"1\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4999,\n" +
            "    \"LATITUDE\": 40.09554,\n" +
            "    \"BEGIN_TIME\": \"/Date(1463110706000)/\",\n" +
            "    \"STATUS\": \"2\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4998,\n" +
            "    \"LATITUDE\": 40.09549,\n" +
            "    \"BEGIN_TIME\": \"/Date(1468041129000)/\",\n" +
            "    \"STATUS\": \"1\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4998,\n" +
            "    \"LATITUDE\": 40.09549,\n" +
            "    \"BEGIN_TIME\": \"/Date(1468041159000)/\",\n" +
            "    \"STATUS\": \"2\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4999,\n" +
            "    \"LATITUDE\": 40.09546,\n" +
            "    \"BEGIN_TIME\": \"/Date(1468043818000)/\",\n" +
            "    \"STATUS\": \"1\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"LONGITUDE\": 116.4999,\n" +
            "    \"LATITUDE\": 40.09544,\n" +
            "    \"BEGIN_TIME\": \"/Date(1468043856000)/\",\n" +
            "    \"STATUS\": \"2\"\n" +
            "  }\n" +
            "]";

}
