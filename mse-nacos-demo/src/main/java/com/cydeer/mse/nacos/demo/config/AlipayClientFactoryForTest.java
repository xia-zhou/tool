package com.cydeer.mse.nacos.demo.config;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author song.z
 * @date 2021/11/24 6:01 下午
 */
public class AlipayClientFactoryForTest {
    private final static Logger LOGGER = LoggerFactory.getLogger(AlipayClientFactoryForTest.class);
    private final static Map<String, String> publicKeyMap = new HashMap<>();
    private final static Map<String, AlipayClient> clientMap = new HashMap<>();
    //private final static String gateway = "https://openapi.alipay.com/gateway.do";
    private final static String gateway = "https://openapipre.alipay.com/gateway.do";
    private final static String format = "json";
    private final static String charset = "utf-8";
    private final static String signType = "RSA2";


    static {
        String appId = "2019073066068224";
        String privateKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC6nzvYkjgo3BQVofUcQd7fiY5lwCx7cVCIoqjugBtMof2sq2hvnaUDmKVPWiOXK3kPPE4CvLePOilvOxRIAKrxt6+FJtvcK9epiLwMWPD6UbU1tKFvjMNqkkK9b5tmUFdGwI2uwdkGTlu8C7dWl0wPsnOv8xiJ1rV4iTlFTHcgC62fN4lYTOQdedimJfoCfPONP8unLjkZCqe9hqGLgGYG8qnT0mDCptgCInd14eeElsVQQUX3KB21wqUOR06OsgODAHl5uvIxn925knGhSR4TC8owlBENDJVTUJVjIjXXfpUgibjhJRotsZTdrps1V+IVQJUh4V4YZt6MUfCVEUR1AgMBAAECggEAOwwm419gZY08zZtw8n/lBNWBOLCVYnl4AcN1sADYomae3QNfB/HZREoIBBOBL1OR+kAabsNHUQoWEhufTyjm7ZQw9PBWoFM+6WVaGo4JsSopK9T7P1BKhG3CsC2f/b9t3fUO3zx2bohcfiM23y7/4feUoxdHrFVDFeBVPpfzGTAN0fUbZFyaY03hcfWAmt2Hjf/R/UN3AN6di5SfeQkqghzQY9OOVt+oxB8hMQYyYqlF91eX7BU85lgX5RlgVu58kQ9/WgEETgBHCwaJcWU3pnCsgtEnpH54CYgJs4m9e0nxGNakAjkq3NEw+6BVXvZp6pvbRoeqnhh6GamqOYbAAQKBgQDwFqWDhYXfzKoRYJgX6f5pBP2bOBVQ4Cv6PUSSNwfvknsN2JDZkPPjjpnd7a55RDRT1gCXwj44TgvokUxY6/KRKM/MSJK0jM1nKSArgmiyc/4CeY4zt4EsHX5Ncd/SB7Xm+R3s1+tqYmRI1VNtmS9aPhCE6Bz+BuzDuTct7ZC2xQKBgQDG/Xj4E6qWfVn9ys1CSeZpmYzbIvsG+8NwI/v/W969bUQF2aCDgoONSyPLHEIBgAsHMsbQIvkxT8A9UCAHNlFg+aVphOfd2n5zQ6MCRQRCZBY8zsFjyG6dQnZjpr9qEhAIlrujbsqDRpwjk/6GHM2Oi0O+ax0NbeIaNKNnWwux8QKBgQC481kxxkxpKUrh9B12XqXD1TpgtoWFNgvqzAPk90u/vIHbGrgLQmT/Kb1Sf2TmuintY3A1eEdiLI1z7Wp5HdpRBLV/U3DgcY9SJxZHLkDlKAHHekiXgoeZqma/1jdrntD8S3BIIdWSsJU8nkmUpmsaA7HKEN00u7Ts2eOuF9JhWQKBgQCTv97TLB8MkFSCadOQNbjcjcOVblq/a65IlJ9mkrtHIVtRkK5rFzxAbBtOk1O7M2x80snl/yHR6GpP3C97y2wPOi4EtEdJZhNf2EevxrkL5q7QRaA4S7k+EPxAr64Ovwyio/D8v6WkZYhHrnpc8AP8pBEP0Q6ISx+H36+4bVS4sQKBgEuM3GKruigTeH36saGlZbglwpgwn7ihxfc/tGtwPcvmWdtVp6w/Hx9Ze9hxNGufM59kEhTEqcHz4knzbOrL3uGRmCc22Hh+qKLHOVzMMCPE8h2Bv9dFftE0Ga1JXQm+8E4kDGmx05ZNxxXCnfrCLnwWoEEODlyVfMRaiSWB544w";
        String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAuDoy6SDaJqjZiIXalia0pqxnkIMj+mL2mjW2RolKjqXph6HGryRk9mDsrt51XCvVGQSXTdmkHEeDRfh0xyrsqEIGoo2NBIqmJOmPhv9sxu3wFF4j9pq3KD9DRJZjf7VYw7JWtwKBujCo87d4pRKnPm/S+9+d5X/ixUruoS3w+q1PL+A8qCcp4BB2lMrKYcmfX+yuwS3SSsYamGYG13/jz3fqQkZe/8E6gWE3xFND8QNMtKB641Yd5wsUyKPPI35lBC60Hb4IPLJ8C7zKII5YwBokH22bAk+d56IEVhw82gB8KqrXpTMsC1FDjCMDkRMO9ZCGaQSRtHAE0+/PWy+W4wIDAQAB";
        AlipayClient client = new DefaultAlipayClient(gateway, appId, privateKey, format, charset, publicKey, signType);
        clientMap.put(BizConstants.MARKETING_SOUR, client);
        publicKeyMap.put(BizConstants.MARKETING_SOUR, publicKey);

        String marketAppId = "2019041964002007";
        String marketPrivateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQC8EOqi1y4WgHJhskMXoJEG57RJmT7rRRBquEpDKy7NmrsnJ2wxmiAtqJeYOdSPRIGj3LwyU1Py17EFikvvEFIHQqzx9bH0m+f0m3Xy3BxgniPZ8SbQTfQinqWfyyZALvfv3HkIh8e5f098SuIfo/2nHC/ZJSYResqiUfZZleKGoqE2USL2Wz9RI7GbvRSplDL8ELJM5FOM5jNA6M9WYt7gQd8aFn44PrC1EGXXQeLBkqCefj9S4H4xkjh3tUnIMgokH6jHB6oN7MoWijGpBE1PtNjiJAooJ1tP5zFM04LRT84tOg2AzylN4Wp+mESHOQLXfefwuGkNQfK2qJ/YyX6/AgMBAAECggEAS2zNbbm3NjcVqLEBz3wKLibHW60mWt08FFENF5s+Dh+8Z5ub/Ni/hxBSnC61XTAwfjONFvHsfTycNoico6h7/YV0LyZG1L+ia6vdxiUZDHbgEgxxcKGTBD90VX34PU2ZCo31zMIIDBFPI540ylPO6zKWzhPkDKaeljMhBhTi4POvIxiilUhVQ8NX0QQLAItemaZjqR9bRfiEkZZrbxjUI0IhWcxdLfEZTCjHrOJ9NPuPdOhC6hwOszV+V0kPlRA9Ap4ayHI7ZVnKG7MvfPldwdDCTE7qXGFFdeJ/sGt3ihEZv6y4RemIOikurGpcZth6bHC/dsE0lp8Lwn6EofreoQKBgQD4/4JOuyZ3t0dDFN1KAJC8RA7EN1GRCi8arTrZMBn/WoJ1MmfpsrvJVwAScCKBCQK2qvwz34hJRUhO093QOxMmP6UKKj0HWq8JFmBciHf1oCo8E+4xYzL6LyShZlL+LuwxsWM/ScL++ehwqpskqAoCm8PoXGNU0W5GslJmHpqF2wKBgQDBWsT0vlBgebbDLnBAbX/8OLf5E1K/B8MwAn0swWDNLAC9+rdbHMRmwFZWOwnvEc9VvxJjyWBNZX0NAdsR8Dv48QhM0ANIl4egJMW3NHynhVMETzElSrRkBOeYyyk2E/LTmm/WVPNT3IKmKtt+r7kPOT3CQ0CD2mTPam0kVXqp7QKBgQCbFfGgffp4qCPviShHNlDvoegcmGPqVZB/KhQ0QDyBCmuk+U81hMhnoBOAaG1lNyqEgbzxxjFJiah+yIEoeBL2SL/Ps/0s/nN00oYUPD+TMj38C2HZSvLuVryW9neMr8cXMGgjfBrC2v7GZcyZqTwK4d/Ecv6/Tm5EBD9EMZ2G7wKBgB/HHkWnHaiteFcdw78i//zhCYN7JIdW7EJwtkfrxFAUIk8W7Jmh4bmNdOMZMunCwJO0In6Z8yTlQCcqHeoV1JV2b8nICjIdDWJJiOEyVCZoKBu2NDqPy5QAplubUDueDbOvVyAfuBoZTLOoqYhpsv2Ih9jsmqbQ9u6L7EIjdlSFAoGAKbjZ/YITJWTzRgr0ak6zcXoOz7UO5OJF/1NQdfLqZ/maU/04CVPXV2EUO/rbDtn7+cSXqzPPqgkIS6XDpfAHgXY1hyF3ZhepotNPCblE1F3QjNXXxer5F1cw3GlfJUWZFApsxDY2SqrHaSc5+TKwJGzg9zciAlq20330/Z+T0xc=";
        String marketPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjo0ujPzEaJJPwcsAvJIJzgs0KBkL8W8oOqs/17Hdz5HjxwIGnhL0gKjj0a2A9N5wt7zxoMqSDMw2oRAKSR1+1UI0WZSYxTtPH2lwCAfo3lkEQoOOK10eHs0UFg1aTc2BLvyWEpJo4q3nqB366uE9ld4DvS+/KEwlFhSAzOqjAP1ro5AReX7pewNfdGuMmfTmtQkxUNJInKaXKpxnmvAOxgrNoNxL0NsLPMAqrMmOzITlmSRoWnoLHYzAPQjKUtRWh1e0edzkV7ivKPbTgIKykgfjRviBtJxu9wYZfP4t/1I3egRYDcc1aRUE9jQHoxO9SIwLZQsB7SIvHdNowNbI2QIDAQAB";
        AlipayClient marketClient = new DefaultAlipayClient(gateway, marketAppId, marketPrivateKey, format, charset,
                                                            marketPublicKey, signType);
        clientMap.put(BizConstants.MARKET_SOUR, marketClient);
        publicKeyMap.put(BizConstants.MARKET_SOUR, marketPublicKey);

        String surveyAppId = "2019041963940925";
        String surveyPrivateKey = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCBZzQ1o+p10rgU2RW+D31+StbkCCUzDKZ2YmRj3JgNtZDTbHyG/I+OuR7tLMwPEqSgokBIV76X1/mpnrPUCBevCivZaFt7U1RqRB4fecUS+YRIdaccZmIRKY6ZtZH/QSFkwPL1Y6b6zC7gbcSqCCzQ5OUgrD2PzBc9QIqAW+JgLBER0vVbBsufB1R/7zaERJvbxlOGW1nyNFoT9yhXztY+SPDeumLzy9S+qDwKvmd3qf1Osz4NUmKnwewYBNUNsBluvoRtLh5jpdIE84RtA/yfAhQwEh5y5LMfrz7f2FFNYCv5TsEBcSP6st9tRih3z1posQumMJlCm4myqfUzv2VxAgMBAAECggEAI9/xyIE2Cg4uPJFmhreSqgWjh7p+XaW/LIjgnhLVEM/qY8Lqzx2LyxylZ0mJFRCtFV+GBMhWrZARxiWaY0kPD9b5Cx/0ZL9YYtGZrE49BaKpOtFrT+NOgsWLpC+DV0m+MUmQ0dkbvOIIiO3FnQIBMrSSlTlLI+eH9dJD04wluVV5RqJwg8kB0s4yyk+yDEBUm3VSMhQ8crZT1U6aShK5yeMiWUj5IlWUv31Ek12RuhaxHwQQhJi6FmIrDmCFqB1GRbCAJfCcSzF64QItS+LKuFdwub7Xe5a0fiaQQ8KRpxviJAKKrFspQm95dxOWVRNFjtniOl850e/b9/zjOv7M1QKBgQC2cHu/OIKJdF7RBldhsu/d+432lxIhwBiFazWOOpGGvjxSppJ0VGntkg4QBlQth4Q3epKV3GOiIh9Q3ArFrl97iQnlS39M0sJ5n71lhclnsCOBlIRq9+g6ElM9bp1DBC0e7Gm+fWj1UFhxd+bJUOmiOzwu92QlC6qXnSpbcVMrkwKBgQC1lEiHFA2SBFVVEdP2S886PJEMyRihR3jjFA8dzaUu+NRMGOoAPqi3xlK8LTBtmLpKs2h63ly23m0kmnviXDAbGddtEFdxkvLJbpgySkQHD0Yll1jDEmh4ltkh6kBgQGnxHI2O3fTMydHfDPVW1F01Dg7SVlJR2NMwZE4yv+Z1awKBgFG3ooYtXrMI7+t6hqtZRf3NTnJUiqeZbqJcOhnh/As5rLVsrQ70PJpQIIJnA099cuiSu5PqqqoV1KcYWK7hAx3HbSpKndOgV8G4nlIaEfOivtSs3H85WcihKq3KnSBGf5tpU5gifl/bRDJW/YXQ+0VSeQukfjPlvNy6Zh2dbh6HAoGAKyfK9Q+3CfUtssJB9k+eOOEcOEWzLOGnwZCK5zJxB/DrxApH0zcRMlxYXZD/6Yxa+lYZhtpCftPubLyqpOn0JPzHToyLu9qJCYbXdVxhPqxKp7SIzBQb8E0p3f2mvzmP9FYs7r+h5uowjyqtRK3EWU+2BheuCPXXe7DbRQSG6XECgYA6gsVJd+3gDGQUTo5SrGc6V7z+Wjh/7rYOGpq3e/816gBwa/Cqq9eTvihFr04Avt6JBkMhRGRIQSyDimpbU/dNXYwEVkmcZCCghAjeRScwCk+tdH6qx+59vSJ54eCiGV2wJKqTAfF+v4EOcVTUSTgG24Vqi3tyrOBWeHQVCVowLA==";
        String surveyPubKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjo0ujPzEaJJPwcsAvJIJzgs0KBkL8W8oOqs/17Hdz5HjxwIGnhL0gKjj0a2A9N5wt7zxoMqSDMw2oRAKSR1+1UI0WZSYxTtPH2lwCAfo3lkEQoOOK10eHs0UFg1aTc2BLvyWEpJo4q3nqB366uE9ld4DvS+/KEwlFhSAzOqjAP1ro5AReX7pewNfdGuMmfTmtQkxUNJInKaXKpxnmvAOxgrNoNxL0NsLPMAqrMmOzITlmSRoWnoLHYzAPQjKUtRWh1e0edzkV7ivKPbTgIKykgfjRviBtJxu9wYZfP4t/1I3egRYDcc1aRUE9jQHoxO9SIwLZQsB7SIvHdNowNbI2QIDAQAB";
        AlipayClient surveyClient = new DefaultAlipayClient(gateway, surveyAppId, surveyPrivateKey, format, charset,
                                                            surveyPubKey, signType);
        clientMap.put("survey", surveyClient);

        String slHiBuyAppId = "2021001192678548";
        String slHiBuyPrivateKey = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCkASmip8euFZJAxginA+gPKXelQEgY+kWRQIjQsNb5H/gGV7SUCz4NXKdGmvahdUJF5NNgn2+iLGFEOhBCu1+uDSUpl3wJpP+xgKuFcHvs8THMFQ9GWWGDz4ovluuzfSW1n8HSzkvpEdTbdvSK6tB/bCuG6omdh8fZEhIj7GVJMrGQ7YTKwF3gI/TCi1fMRBZ2QFzr8Yg0AQSNbOZVPDwimzLU4mLu/MAcQZPHI16BgI7MpvyDmbS9RQ3SDGPTISQ60RPgJq2oOsWbwXGvrusHWqJbQJ8sgVCFc3XMosv+ecqJbj663HzF2FdVA984WPK4I+nocnwgsRcN7PS8Q+c5AgMBAAECggEAN6MxVb3njtZAlHraSpaXrjUaItSI4Phei2VCRNIJS+CdisFMQIED3xKUqO4/Rwz5m66CSyArhe/aW4P7KjhYwDozZkW+zaLNH5GQHqfHUt2MUDjAwtPlsgrBTV28vlpxZYk5/uL/e6UR+hYD5fC9JM00gwOkBe4fTTPFNaynu8nMnBMALzwAuF/78T27VsdVxJDqvUTrCc01D6h10cClxQEEE+FZUdEVWaRvJpp/vSpVh3NDCn9PcxYLjVivLrYjJhcEj7RRDeLL292MCSyCjIC6NEjanxldJdPJgzATXLQ7DHHKc24kTMBdLmQXjGPvFUn59OiITYF2tlxXJykOVQKBgQDYIdk3IDsMGm+EYkMO67Skk14zaT7uyMvYP7Ci/SjJ3uRqvPTFT/nV1yT35RuCyJQk/fNe+GeQzRRRG4HIfmfmC9CuY1/dCbG41ccIGw5OqgNDsTQJ8th6YFTdZ3l6o8JWn2rnlldbpG2xB7Ymaw33Q9HCCBJMxEiWjU6ZA79fhwKBgQDCQcBlFW4ShO2auTk0o/a2HD2JeyXslED3JKVd7ap2oep4CPFpxRLKpJ1jdjydB70jfcrPsRjmwfFavnAGgKiv0RaK7Il1Fr9gupXzRe58aXZ5PUiHLZ2YeLn3hw2VseiQiu3JX+eRuzILp5i0Vx1qDDrb+Ypk+L37g0/2VKCzPwKBgQCrF+CEKxeTNToiakb7gMu3nJFt0VroXDxCK+kAnbe0VqYrePmrWOxFw9KYCt4EYhQkVIRcIfiaQD5dFpFezfIhwiioZDJ3ID14PIMaf5CL5TpAU/8GASAtgCSuQEOCOjCVsg1G11TATyImihw/vW+I1j8ugoU6EAgGZkZaCwVr8QJ/VPxvL8owXenKCeb/IAib5xBz27IE5Xv28CkYL//KlBxCeEFxXNTbY8yhDuKrogfAt8ZQ9IyGWG6BKTIn0LB5HHJdamoRuSg6khcPg18U91kse95T3NAYIpyuv5xWVSeAl7wwS+mpZhh/zJmGNV/nfn3bQmHqKkKo22CXmy1rIQKBgQCPHHDGYfP2OzzQR6MKKQrdNceU3VJk6pfnRCn9ai5bO5IwPecuDkrJ0OVe7AM8kp4PWOA9rFSKHCpTTW7O3tXgd704mxfVhoaLskG0sV/15crFF4TDxKvqFUOGKDQdW21NpdudQPOoxjpBauJQqGH4FjaHFzPVp7DOoarJ0IKw1Q==";
        String slHiBuyPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlV9mVSz32aL1y9bQMed9ZQoca8RwVYIizHbYieyraR6gb/n1C2MPaBCNPfnoS3f2iTwwVO0rik1phov4Cwo+FaGW917DDOsT+DIburuWytxEW7cuLrC/r3RNOF8SiqHCrCxKpnSiFFc1nIRAYs9uHE7e3tfubjVNon94rc8pMPvuho9VukZUil6l3+OmIuFPwv6OjB3+B+Yvqom+eL+bw1FZsT3vur4iOlxKGV123tYDo8I0ByzNOkgP0l53lBF21YMTTeCDBbHxDe+rZ/Guqy1nsHb1tqe/YUu1cnMhVhg1fn7DUXt+Had4ykN0LOMZiOCWayAW7X89vwfDLkJUdwIDAQAB";
        AlipayClient slHiBuyClient = new DefaultAlipayClient(gateway, slHiBuyAppId, slHiBuyPrivateKey, format, charset,
                                                             slHiBuyPublicKey, signType);
        clientMap.put(BizConstants.SL_HI_BUY_SOUR, slHiBuyClient);
        publicKeyMap.put(BizConstants.SL_HI_BUY_SOUR, slHiBuyPublicKey);

        String benefitAppId = "2021001166654412";
        String benefitPrivateKey = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDV4DlUwNP7VGbHieQqSepPbPJWgbbDOSNedLI9nvxgoLLnGac2D8x+N9pf6ihxnBT1T4Vc//tQs774soU9z7pG3GzxjditHKNI9koK9AUV6PptMFsUojFDfyALndJoKRAVyUFJSkVOFqI2sJL8tVjkaRB+jOjzADh6g+SfNjTZQ4G5mKMfB0LnCL+lMjn7UQOzv8zv2VCVvp/MNdVC35G6l9jU7pM387XjkI1jlROfbBy013dnGSzntrseFESHqTH/XmCBdGEoKsW4Q6r8uT4uWeBfqWMwnjT/eNw6e8wt/KsvslnpSphaaJdjrniMPP18gJKT9SXoFzkmuj7a+1khAgMBAAECggEBAI/bBpTkMnE9Xvhd3lM3blvICuR20ShUmV6iHXVnJ5gS3uKklZy+WayYAtE63cM02b/6odhg8XhhvlTnNsnRnBinkLuUziX6OjYMOtdNNNJ851xkBw9E3N/qdPJ7UBfxbrlIqhoS07TncmpYsDU8ATN5G7gTLWitQE/fwPn56ugqzTp01qCAvKwDJA+OrgFDAWJNpFoxCOezIuFdUlqpVtU9FQfjxx23AaLjEl8/ptM5YPDjU587PP0KF0nrh1sFEh0rArOh6QMuYFZNZVRWcNWPevErkMcoUug8xVTPgcfg7UjUkP4/aumF4Nyb3jcrEeY+vxDs6L+62ZtG6Uf0DFUCgYEA/HQYcXq6Ms94md8ncpMIOX6oJ7UmlEXVH7IBMjzEdxxiqHw1c4a9Km8u4i9StWWNwf5yWcFC1OGfd5No6ivMSvVs6w0X3+214REZPbQ6w6tyJQS3Vzg4+692wzLgE+yxoilhCRNu05Ab5kxcG/k3y3Usl99dmSNpvfO2W4/ny3sCgYEA2OFkDl71HPr2V29pzD7Oox2JeuTGLDZh1AeBGw2cZioO9l7c3m48DFdDs1sia67HKgDl0YaZf1s3c+37+4lomFiQdQDtmGxFYQumAy6PI6YRVvChcGgaFhBI0usWsJ8sQqpZ4IUEDG0MxzELb42PQaqXHLLWmQ8b2cSJSdq2DRMCgYAtms9bmJ8QVLhlm5FlujfvIvk/ixL4EBFrE13x9FZNahxMcXu6bem4Q7OFeqUHTdwo4k1H94iaKlQDZua5/sV9+Q3+/DOG6UtE6DDWG7vN4yfQliSEpgxtMwpSQtuF3elM8QqteAw6Pbs8hCjTiNbSc01l9hzTcDlG7kLQEZP/BwKBgQCKcZ54Wf9n53/XIqTLn5Ayqck37M/gKzrZqYyto0uiH9j7RmUBjCbCzfXGiTd4u9IhKv+Jd72GgcjtNQ60a+ubzHUya0xAD2VeZJwtzcvLute4wtSbN6jnSq/iC/Wo+4K6b5n964tBD1+ny9P7+sZm6amaxUKd4/ooUgA9Z+LshwKBgQCXQyCdgXkyNhl4wgnM7Z7batvhcB0ORegxnYA7vSKMpw5W4pzCtFsrMN+/ge5cR3XJWNwCgAgHPhxcU1f4GVdaWx1rlLBFhVpGj8coOVUN6JPZcDQg/yP3nhy6l6RrzvIzmAxBzWUKUArdWHAAFaSKXmOdh0+KVUKvt5yMLXmCCg==";
        String benefitPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEApYRTrGQgw3lTEpkHg+VLv9TqM/oAgCufNVJ2e3EdeOLNma3sohl0hvc9zQdtaXDa/OnncQIYsC2gsUCtbeXmhpi12EyxDpGEQoq1RH22fsnLcv4CWBqKw9V0JskxkE4n8dNsMUjWWpqlwoSGve98SJKDAt3wVYarbpqH9dMS2dzWM1/sLjx5+VNtqDqSAeARLJe7K0It8bbiCquNmAf5wIf9SOadM06tr1NVTo9eJFHZCjiPNaRcAJlT5JuEJT6blgbbj179HUH0dO/GCYtTvHyd+zIMSC+xDl7FOMtZUxu53T0ixCU8aOAQss3XX10bRa+H7UWe6o1f4TTGVzxDBwIDAQAB";
        AlipayClient benefitClient = new DefaultAlipayClient(gateway, benefitAppId, benefitPrivateKey, format, charset,
                                                             benefitPublicKey, signType);
        clientMap.put(BizConstants.BENEFIT_SOUR, benefitClient);
        publicKeyMap.put(BizConstants.BENEFIT_SOUR, benefitPublicKey);
    }

    /**
     * 获取支付宝客户端实例
     *
     * @param clientSource 客户端来源
     * @return
     */
    public static AlipayClient getInstance(String clientSource) {
        return clientMap.get(clientSource);
    }

    /**
     * 根据appAuthToken获取客户端
     *
     * @param appAuthToken
     * @return
     */
    public static AlipayClient getByAppAuthToken(String appAuthToken) {
        if (StringUtils.isNotBlank(appAuthToken)) {
            return getInstance(BizConstants.MARKET_SOUR);
        }
        return getInstance(BizConstants.SL_HI_BUY_SOUR);
    }


}
