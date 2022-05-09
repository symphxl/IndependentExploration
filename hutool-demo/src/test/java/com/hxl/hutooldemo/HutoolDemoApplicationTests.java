package com.hxl.hutooldemo;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.DesensitizedUtil;
import cn.hutool.core.util.IdcardUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import com.hxl.hutooldemo.controller.TestController;
import com.hxl.hutooldemo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootTest
class HutoolDemoApplicationTests {
    //private static Logger logger = Logger.getLogger(HutoolDemoApplicationTests.class);
    Logger logger = Logger.getLogger(HutoolDemoApplicationTests.class.getName());

    User user = new User().setAge(18).setName("周杰伦");


    @Test
    void contextLoads() {
        //if (StrUtil.isEmpty(user.getName())){
        if (StrUtil.isNotEmpty(user.getName())) {
            System.out.println("有值");
        }

    }

    @Test
    void test1() {
        Method[] methods = ReflectUtil.getMethods(TestController.class);
        Method meth = ReflectUtil.getMethod(User.class, "getNames");
        for (Method method : methods) {
            System.out.println(method);
        }
    }

    @Test
    void test2() {
        //转换为字符串
        int a = 1;
        String aStr = Convert.toStr(a);
        //转换为指定类型数组
        String[] b = {"1", "2", "3", "4"};
        Integer[] bArr = Convert.toIntArray(b);
        //转换为日期对象
        String dateStr = "2017-05-06";
        Date date = Convert.toDate(dateStr);
        //转换为列表
        String[] strArr = {"a", "b", "c", "d"};
        List<String> strList = Convert.toList(String.class, strArr);

        //logger.info("annotationUtil annotations:{}");
    }

    @Test
    void test3() {
        //去除字符串前后缀
        String s = StrUtil.removeSuffix("a.jpg", ".jpg");
        System.out.println(s);
        String s1 = StrUtil.removePrefix("a.jpg", "a.");
        System.out.println(s1);
        //格式化字符串,{}占位符
        String template = "wtf:{}{}";
        String str2 = StrUtil.format(template, "流弊","礼拜");
        System.out.println(str2);
    }

    @Test
    void test4() {
        String ID_18 = "340822199402255817";
        boolean validCard = IdcardUtil.isValidCard(ID_18);
        System.out.println(validCard);

        //年龄
        DateTime date = DateUtil.parse("2022-05-06");
        int age = IdcardUtil.getAgeByIdCard(ID_18, date);
        System.out.println(age);

        //生日
        String birth = IdcardUtil.getBirthByIdCard(ID_18);
        System.out.println(birth);

        //省份
        String province = IdcardUtil.getProvinceByIdCard(ID_18);
        System.out.println(province);

        String s = DesensitizedUtil.idCardNum(ID_18, 2, 1);
        //System.out.println(s);
        logger.log(Level.INFO,"输出信息: {0}",s);

        String name = "蚂蚁小哥";
        String age1 = "24";
        logger.log(Level.INFO, "姓名：{0} 年龄：{1}", new Object[]{name, age1});

    }

    @Test
    void test5() {
        String ID_18 = "340822199402255817";

        String s = DesensitizedUtil.idCardNum(ID_18, 2, 1);
        //System.out.println(s);
        logger.log(Level.INFO,"输出信息: {0}",s);

        String name = "蚂蚁小哥";
        String age1 = "24";
        logger.log(Level.INFO, "姓名：{0} 年龄：{1}", new Object[]{name, age1});

    }
}
