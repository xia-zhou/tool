package com.cydeer.mse.nacos.demo.config;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.domain.*;
import com.alipay.api.request.*;
import com.alipay.api.response.*;

/**
 * @author song.z
 * @date 2021/12/22 6:34 下午
 */
public class TemplateMiniappTest {

    public static void main(String[] args) throws AlipayApiException {


        //rollback();

        //        build("0.2.3", "0.0.15", "202201BB012f9dcaf23443bca3efac3e48d8cX23",
        //              "{\"extEnable\":true,\"ext\":{\"appName\":\"数立建站\",\"page\":{\"pages/index1/index\":\"738442527689724087\",\"pages/index/index\":\"738441785801232559\"},\"authAppId\":\"2021002141622168\"},\"tabBar\":{\"textColor\":\"#333333\",\"selectedColor\":\"#FF0033\",\"backgroundColor\":\"#ffffff\",\"items\":[{\"activeIcon\":\"https://sl-online-oss.shulidata.com/buildstation/9d9dfc86fdacde9f4773c7e50923a739.JPEG\",\"name\":\"首页\",\"icon\":\"https://sl-online-oss.shulidata.com/buildstation/344be5b978104ccac0e50cb496ef07d0.JPEG\",\"pagePath\":\"pages/index/index\"},{\"activeIcon\":\"https://sl-online-oss.shulidata.com/buildstation/33e546bbc7eee86b11916f886d79e5bb.JPEG\",\"name\":\"订单\",\"icon\":\"https://sl-online-oss.shulidata.com/buildstation/6337decd6baf02924aaca486e7aea2ee.JPEG\",\"pagePath\":\"pages/index1/index\"}]}}");
        //
        //        build("0.1.12", "2.19.64", "202109BB94157b8f173a4836ae00f44b1b2f0X23",
        //              "{\"extEnable\":true,\"ext\":{\"authAppId\":\"2019072665968772\",\"appName\":\"数立营销平台\"}}");
        //        // getCode();
        //        queryAppInfo();
        //        query();
        //
        //        experience("202201BB012f9dcaf23443bca3efac3e48d8cX23", "0.3.1");
        //        queryExperience("202201BB012f9dcaf23443bca3efac3e48d8cX23", "0.3.1");
        // delete();

        //getCode();

        // offLine();
        //gray("2.0.0", "p10", "202206BB92f100f1906c47d297360fc31c059X48");
        online("2.0.0", "202206BB92f100f1906c47d297360fc31c059X48");

    }

    private static void online(String appVersion, String token) throws AlipayApiException {
        AlipayOpenMiniVersionOnlineRequest request = new AlipayOpenMiniVersionOnlineRequest();
        AlipayOpenMiniVersionOnlineModel model = new AlipayOpenMiniVersionOnlineModel();
        model.setAppVersion(appVersion);
        request.setBizModel(model);
        AlipayOpenMiniVersionOnlineResponse response = AlipayClientFactoryForTest.getByAppAuthToken(token).execute(
                request, null, token);
        System.out.println(JSON.toJSONString(response));
    }

    private static void gray(String appVersion, String gray, String token) throws AlipayApiException {
        AlipayOpenMiniVersionGrayOnlineRequest request = new AlipayOpenMiniVersionGrayOnlineRequest();
        AlipayOpenMiniVersionGrayOnlineModel model = new AlipayOpenMiniVersionGrayOnlineModel();
        model.setGrayStrategy(gray);
        model.setAppVersion(appVersion);
        request.setBizModel(model);
        AlipayOpenMiniVersionGrayOnlineResponse response = AlipayClientFactoryForTest.getByAppAuthToken(token).execute(
                request, null, token);
        System.out.println(JSON.toJSONString(response));
    }

    private static void queryAppInfo() throws AlipayApiException {
        AlipayOpenMiniBaseinfoQueryRequest request = new AlipayOpenMiniBaseinfoQueryRequest();

        AlipayOpenMiniBaseinfoQueryResponse result = AlipayClientFactoryForTest.getByAppAuthToken(
                "202110BB6a04a0c7f4d94d1f90b1fd74465a5X60").execute(request, null,
                                                                    "202110BB6a04a0c7f4d94d1f90b1fd74465a5X60");
        System.out.println(JSON.toJSONString(result));
    }


    private static void delete() throws AlipayApiException {
        AlipayOpenMiniVersionDeleteRequest request = new AlipayOpenMiniVersionDeleteRequest();
        AlipayOpenMiniVersionDeleteModel model = new AlipayOpenMiniVersionDeleteModel();
        request.setBizModel(model);
        model.setAppVersion("0.0.5");

        AlipayOpenMiniVersionDeleteResponse result = AlipayClientFactoryForTest.getByAppAuthToken(
                "202201BB012f9dcaf23443bca3efac3e48d8cX23").execute(request, null,
                                                                    "202201BB012f9dcaf23443bca3efac3e48d8cX23");
        System.out.println(JSON.toJSONString(result));
    }

    private static void query() throws AlipayApiException {
        AlipayOpenMiniVersionBuildQueryRequest request = new AlipayOpenMiniVersionBuildQueryRequest();
        AlipayOpenMiniVersionBuildQueryModel model = new AlipayOpenMiniVersionBuildQueryModel();
        request.setBizModel(model);
        model.setAppVersion("0.3.1");

        AlipayOpenMiniVersionBuildQueryResponse result = AlipayClientFactoryForTest.getByAppAuthToken(
                "202201BB012f9dcaf23443bca3efac3e48d8cX23").execute(request, null,
                                                                    "202201BB012f9dcaf23443bca3efac3e48d8cX23");
        System.out.println(JSON.toJSONString(result));
    }

    private static void getCode() throws AlipayApiException {
        AlipayOpenAppQrcodeCreateRequest request = new AlipayOpenAppQrcodeCreateRequest();
        AlipayOpenAppQrcodeCreateModel model = new AlipayOpenAppQrcodeCreateModel();
        request.setBizModel(model);
        model.setUrlParam("pages/member-benefit/index");
        model.setQueryParam("x=1");
        model.setDescribe("恒康大线下门店轰动");
        AlipayOpenAppQrcodeCreateResponse result = AlipayClientFactoryForTest.getByAppAuthToken(
                "202201BBb5cc5ba6647747669d1ea711ab75aE97").execute(request, null,
                                                                    "202201BBb5cc5ba6647747669d1ea711ab75aE97");
        System.out.println(JSON.toJSONString(result));
    }

    private static void rollback() throws AlipayApiException {
        AlipayOpenMiniVersionRollbackRequest request = new AlipayOpenMiniVersionRollbackRequest();
        AlipayOpenMiniVersionRollbackModel model = new AlipayOpenMiniVersionRollbackModel();
        model.setAppVersion("0.4.9");
        AlipayOpenMiniVersionRollbackResponse result = AlipayClientFactoryForTest.getByAppAuthToken(
                "202112BBd29b9fa7d4c1419aa6ac756438d9cE48").execute(request, null,
                                                                    "202112BBd29b9fa7d4c1419aa6ac756438d9cE48");

        System.out.println(JSON.toJSONString(result));
    }

    private static void cancel() throws AlipayApiException {
        AlipayOpenMiniVersionAuditCancelRequest request = new AlipayOpenMiniVersionAuditCancelRequest();
        AlipayOpenMiniVersionAuditCancelModel model = new AlipayOpenMiniVersionAuditCancelModel();
        model.setAppVersion("0.5.9");
        AlipayOpenMiniVersionAuditCancelResponse result = AlipayClientFactoryForTest.getByAppAuthToken(
                "202112BBd29b9fa7d4c1419aa6ac756438d9cE48").execute(request, null,
                                                                    "202112BBd29b9fa7d4c1419aa6ac756438d9cE48");

        System.out.println(JSON.toJSONString(result));
    }

    private static void experience(String token, String version) throws AlipayApiException {
        AlipayOpenMiniExperienceCreateRequest request = new AlipayOpenMiniExperienceCreateRequest();
        AlipayOpenMiniExperienceCreateModel model = new AlipayOpenMiniExperienceCreateModel();
        model.setAppVersion(version);
        request.setBizModel(model);
        AlipayOpenMiniExperienceCreateResponse result = AlipayClientFactoryForTest.getByAppAuthToken(token).execute(
                request, null, token);

        System.out.println(JSON.toJSONString(result));
    }

    private static void queryExperience(String token, String version) throws AlipayApiException {
        AlipayOpenMiniExperienceQueryRequest request = new AlipayOpenMiniExperienceQueryRequest();
        AlipayOpenMiniExperienceQueryModel model = new AlipayOpenMiniExperienceQueryModel();
        model.setAppVersion(version);
        request.setBizModel(model);
        AlipayOpenMiniExperienceQueryResponse result = AlipayClientFactoryForTest.getByAppAuthToken(token).execute(
                request, null, token);

        System.out.println(JSON.toJSONString(result));
    }

    private static void build(String appVersion, String templateVersion, String appAuthToken, String ext)
            throws AlipayApiException {
        AlipayOpenMiniVersionUploadRequest buildRequest = new AlipayOpenMiniVersionUploadRequest();
        AlipayOpenMiniVersionUploadModel buildModel = new AlipayOpenMiniVersionUploadModel();
        //buildRequest.setBizModel(buildModel);
        buildModel.setAppVersion(appVersion);
        buildModel.setTemplateId("2021002126684893");
        buildModel.setTemplateVersion(templateVersion);
        buildModel.setExt(ext);
        String data = "{\"app_version\":\"0.2.5\",\"ext\":{\"extEnable\":true,\"ext\":{\"appName\":\"数立建站\",\"page\":{\"pages/index1/index\":\"738442527689724087\",\"pages/index/index\":\"738441785801232559\"},\"authAppId\":\"2021002141622168\"},\"tabBar\":{\"textColor\":\"#333333\",\"selectedColor\":\"#FF0033\",\"backgroundColor\":\"#ffffff\",\"items\":[{\"activeIcon\":\"https://sl-online-oss.shulidata.com/buildstation/9d9dfc86fdacde9f4773c7e50923a739.JPEG\",\"name\":\"首页\",\"icon\":\"https://sl-online-oss.shulidata.com/buildstation/344be5b978104ccac0e50cb496ef07d0.JPEG\",\"pagePath\":\"pages/index/index\"},{\"activeIcon\":\"https://sl-online-oss.shulidata.com/buildstation/33e546bbc7eee86b11916f886d79e5bb.JPEG\",\"name\":\"订单\",\"icon\":\"https://sl-online-oss.shulidata.com/buildstation/6337decd6baf02924aaca486e7aea2ee.JPEG\",\"pagePath\":\"pages/index1/index\"}]}},\"template_id\":\"2021002126684893\",\"template_version\":\"0.0.15\"}";
        buildRequest.setBizContent(data);
        AlipayOpenMiniVersionUploadResponse result = AlipayClientFactoryForTest.getByAppAuthToken(appAuthToken).execute(
                buildRequest, null, appAuthToken);
        System.out.println(JSON.toJSONString(result));

    }

    private static void offLine() throws AlipayApiException {
        AlipayOpenMiniVersionOfflineRequest offlineRequest = new AlipayOpenMiniVersionOfflineRequest();
        AlipayOpenMiniVersionOfflineModel model = new AlipayOpenMiniVersionOfflineModel();
        model.setAppVersion("0.1.5");
        offlineRequest.setBizModel(model);

        AlipayOpenMiniVersionOfflineResponse response1 = AlipayClientFactoryForTest.getByAppAuthToken(
                "202108BBb99f3a243f854bc2be6549909cb21X80").execute(offlineRequest, null,
                                                                    "202108BBb99f3a243f854bc2be6549909cb21X80");

        System.out.println(JSON.toJSONString(response1));
    }
}
