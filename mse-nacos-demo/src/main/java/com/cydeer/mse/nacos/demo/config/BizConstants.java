package com.cydeer.mse.nacos.demo.config;

/**
 * @author chentao on 2019-07-22
 */
public interface BizConstants {

    String MINI_APP_BASE_LINK = "https://render.alipay.com/p/s/i/?scheme=";
    String MINI_APP_SCHEME = "alipays://platformapi/startapp?appId=";

    /**
     * 数立服务商编码
     */
    String SHULI_ALIPAY_PID = "2088121146196904";

    String ERR_ORDER_EXISTS = "未查询到订购信息";

    String ERR_INSTANCE_EXISTS = "未查询到小程序构建信息";

    String TOKEN_HEADER_KEY = "atk";

    String SL_ROUTE = "slRoute";

    /**
     * 网关转发的请求标识的值
     */
    String SL_ROUTE_VALUE = "1";

    String PLATFORM_HEADER_KEY = "token";

    String HEADER_SHOP_ID = "shopId";

    /**
     * 平台Token失效时间 30min
     */
    Integer PLATFORM_TOKEN_EXPIRE = 60 * 30;
    /**
     * token的命名空间
     */
    String TOKEN_NAMESPACE = "marketingToken";

    String PWD_DEFAULT_CHARSET = "utf-8";

    /**
     * 分布式锁活动命名空间
     */
    String MARKETING_LOCK_NAMESPACE = "MARKETING_LOCK";

    /**
     * 核销助手小程序ID
     */
    String COUPON_ASSISTANT_APPID = "2021002163688199";

    /**
     * 营销模板小程序类目
     */
    String MARKET_APP_CATEGORY_ID = "107212_108638";

    String MARKET_COMMODITY_ID = "AM010301000000023204";

    /**
     * 营销模板小程序标识
     */
    String MARKET_SOUR = "market";

    String MARKETING_SOUR = "marketing";

    /**
     * 门店助手source
     */
    String AIDES_SOURCE = "couponAssistant";

    /**
     * 鼠栗嗨购
     */
    String SL_HI_BUY_SOUR = "slHiBuy";

    /**
     * 天天抢神券
     */
    String BENEFIT_SOUR = "benefit";

    String MARKETING_USER_GUIDE = "marketingUserGuide";


    /**
     * OSS发票存储命名空间
     */
    String INVOICE_NAMESPACE = "marketing/invoice";

    /**
     * OSS退款凭证命名空间
     */
    String REFUND_VOUCHER_NAMESPACE = "marketing/refund";

    /**
     * OSS评论图片命名空间
     */
    String EVALUATE_NAMESPACE = "marketing/evaluate";

    /**
     * 空格替换符号--
     */
    String EMPTY_REPLACE = "--";

    String ALI_PAY = "ALIPAY";

    /**
     * 订单详情页
     */
    String ORDER_DETAIL_PAGE = "pages%2Fe-commerce%2Forders%2Fdetail%2Findex%3ForderId%3D";

    /**
     * 订单列表页
     */
    String ORDER_LIST_PAGE = "pages%2Forders%2Findex";
    /**
     * 核销助手预约详情页
     */
    String COUPON_ASSISTANT_APPOINTMENT_RECORD_PAGE = "pages%2Fappointment-record-detail%3FrecordId%3D";
    /**
     * 鼠栗嗨购-订单详情页
     */
    String SL_HI_BUY_ORDER_DETAIL_PAGE = "pages%2Forders%2Fdetail%2Findex%3ForderId%3D";
    /**
     * 天天抢神券-订单详情页
     */
    String BENEFIT_ORDER_DETAIL_PAGE = "pages%2Fe-commerce%2Forders%2Fdetail%2Findex%3ForderId%3D";
    /**
     * 鼠栗嗨购-订单详情页,返回拦截路径
     */
    String SL_HI_BUY_ORDER_DETAIL_INTERCEPT_PAGE = "pages%2Fcoupon-list%2Findex%3ForderId%3D";
    /**
     * 我的优惠券列表
     */
    String MY_COUPON_LIST_PAGE = "pages%2Fmy-coupon%2Findex";
    /**
     * 签到页面
     */
    String SIGN_PAGE = "pages%2Fmarketing%2Fpunch%2Findex";

    String ALIPAY_CHANNEL = "1004";

    /**
     * 商户会员信息缓存时间
     */
    Integer MEMBER_INFO_EXPIRE = 5 * 60 * 60;

    /**
     * 默认页码
     */
    Integer DEFAULT_PAGE_NO = 1;

    /**
     * 默认分页显示数
     */
    Integer DEFAULT_PAGE_SIZE = 10;
    /**
     * 最大分页条数
     */
    Integer MAX_PAGE_SIZE = 100;

    /**
     * 默认行业id
     */
    Long DEFAULT_INDUSTRY_ID = 12L;

    /**
     * 默认一级行业id
     */
    Long DEFAULT_PARENT_INDUSTRY_ID = 11L;

    /**
     * 淘宝联盟专区ID
     */
    Long TBK_LOCATION = 10000L;

    /**
     * 支付中心分配的业务应用id，集分宝发放使用
     */
    Long BIZ_APP_ID = 551786175908462650L;

    /**
     * 多规格名称分隔符
     */
    String ATTRIBUTE_NAME_RELATION_SEPARATE = ";";

    /**
     * 模板小程序ID
     */
    String TEMPLATE_APP_ID = "2019072465934510";

    String YUAN = "¥";

    /**
     * 商品标签数量
     */
    int COMMODITY_LABEL_SIZE = 3;

    /**
     * 商品标签:多款可选
     */
    String COMMODITY_LABEL_MULTIPLE_SKU = "多款可选";

    /**
     * 商品标签:包邮
     */
    String COMMODITY_LABEL_FREE_EXPRESS = "全国包邮";

    /**
     * 商品收藏总量
     */
    int COMMODITY_COLLECT_MAX_SIZE = 100;

    /**
     * 成本价监控模板
     */
    String COST_PRICE_MONITOR_TEMPLATE = "订单编号:%s，发生资金亏损\n" + "商户名称:%s\n" + "实收金额:%s元\n" + "订单成本:%s元\n" + "订单运费:%s元\n" + "商品信息:%s\n";

    /**
     * 订单金额监控模板
     */
    String ORDER_AMOUNT_MONITOR_TEMPLATE = "订单异常:%s，订单实收金额和商品总实收金额不匹配\n" + "商户名称:%s\n" + "订单实收:%s元\n" + "运费:%s元\n" + "商品总金额:%s元\n" + "商品信息:%s\n";
    /**
     * 券包发放优惠券异常告警
     */
    String VOUCHER_PACK_SEND_FAIL_TEMPLETE = "WARN-券包发放异常operationId:%s，优惠券发放失败\n" + "商户名称:%s\n" + "优惠券模版id:%s\n" + "用户id:%s\n" + "msg:%s\n";

    /**
     * 订单商品基本信息
     */
    String ORDER_COMMODITY_BASE_INFO = "\n\t商品名称:%s" + " 商品ID:%s";

    /**
     * 订单商品信息
     */
    String ORDER_COMMODITY_INFO = "\n\t名称:%s" + " 数量:%s" + " 成本总价:%s元" + " 商品ID:%s" + " 备注:%s";

    /**
     * 成本价短信监控
     */
    String SMS_COST_PRICE_MONITOR = "【几羊嗨购】自营电商出现资金亏损的订单，请及时确认";

    /**
     * 抽奖次数获取文案
     */
    String LOTTERY_TIMES_CONSUME = "消费满%s元，可获%s次抽奖";
    /**
     * 抽奖次数获取文案
     */
    String LOTTERY_TIMES_COMMODITY_AMOUNT = "购指定商品满%s元，可获%s次抽奖";
    /**
     * 抽奖次数获取文案
     */
    String LOTTERY_TIMES_BUY_COMMODITY = "购指定商品，可获%s次抽奖";
    /**
     * 直辖市
     */
    String MUNICIPALITY = "北京市,天津市,上海市，重庆市";


    String SHOP_EXPLAIN_KEY = "购买次数";
    String SHOP_EXPLAIN_VALUE = "不限购";
    String POINT_RULE_REPLACE_CONTENT = "每消费1元可获得%s积分，不满1积分时抹零，";
    String MEMBER_RULE_REPLACE_CONTENT = "每消费1元可获得%s成长值，不满1成长值时抹零。";
    int EXCHANGE = 100;

    interface IdTag {
        String BIZ_NO = "biz_no";

        String MARKET_USER_ADDRESS = "market_user_address";
        String MARKET_USER_VOUCHER = "market_user_voucher";

        String MARKET_SALE_ORDER = "market_sale_order";
        String MARKET_PARENT_SALE_ORDER = "market_parent_sale_order";

        String MARKET_ACTIVITY_ORDER = "market_activity_order";


        String MARKET_COMMODITY_EVALUATE = "market_commodity_evaluate";

        String MARKET_ORDER_REFUND_ID = "market_order_refund_id";

        String MARKET_ORDER_REFUND_APPLY_ID = "market_order_refund_apply_id";


        String MERCHANT_CARD_RECEIVE = "merchant_card_receive";
        String HEADING_POINTS_RECORD = "heading_points_record";

        /**
         * 通知到支付宝的outbizno生成
         */
        String VOUCHER_VERIFY_NOTIFY_ALIPAY = "VOUCHER_VERIFY_NOTIFY_ALIPAY";
        String GROUP_SEND_PLAN = "group_send_plan";
        String MERCHANT_APP_LINK = "merchant_app_link";

        String UNIONPAY_BLIND_BOX_ORDER = "UNIONPAY_BLIND_BOX_ORDER";

        String STORE_APPOINTMENT_RECORD = "store_appointment_record";

        /**
         * 提货码
         */
        String PICK_UP_CODE = "pick_up_code";
    }

}