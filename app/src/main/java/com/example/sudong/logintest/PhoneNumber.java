package com.example.sudong.logintest;

/*
用于验证手机号码格式是否正确

三大运营商最新号段（2018.08.01）：
移动号段：
134 135 136 137 138 139 147 148 150 151 152 157 158 159 172 178 182 183 184 187 188 198
联通号段：
130 131 132 145 146 155 156 166 171 175 176 185 186
电信号段：
133 149 153 173 174 177 180 181 189 199
虚拟运营商:
170

规律：首位必为1，第二位为3、4、5、6、7、8、9，其他位随意
正则表达式：设置第一位数字为1，因为不确定以后第二位会不会增加其他数字，所以设为0-9,剩余位数也都为0-9
 */

import android.text.TextUtils;

public class PhoneNumber {
    public static boolean verifyPhoneNumber(String phoneNumber) {
        String telRegex = "[1]\\d{10}";
        if (TextUtils.isEmpty(phoneNumber))
            return false;
        else return phoneNumber.matches(telRegex);
    }
}
