package com.cym.service;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.stereotype.Service;

/**
 * @description
 * 
 * @author Yaman
 * @createDate 2020/06/02
 */
@Service(value = "selfDefineName") // 自定义bean id="selfDefineName"
public class UserService {
	public static void main(String[] args) {

		System.out.println(toChineseNum(109.003f));
		System.out.println(toChineseNum(10090.030f));
		System.out.println(toChineseNum(100009000.300f));
		System.out.println(toChineseNum(190000.000f));
	}

	public void test() {
		System.out.println("selfDefineName");
	}

	public static void sortArr(int[] arr) {
		Arrays.sort(arr);
		int i, j, maxIndex, tem;
		for (i = 0; i < arr.length; i++) {
			maxIndex = i;
			for (j = 0; j < arr.length; j++) {
				if (arr[j] > arr[maxIndex]) {
					maxIndex = j;
				}
			}
			tem = arr[i];
			arr[i] = arr[maxIndex];
			arr[maxIndex] = tem;
		}
	}

	static final char[] cNum = { '零', '壹', '貳', '叁', '肆', '伍', '陸', '柒', '捌', '玖' };
	static final char[] cUnit = { '圓', '拾', '佰', '仟', '萬', '億', '角', '分', '厘' };

	public static String toChineseNum(long money) {
		if(money == 0) {
			return "";
		}
		if(money < 0) {
			money=-money;
		}
		char[] str = Long.toString(money).toCharArray();
		int len = str.length;
		int moreBit = len % 4;
		int bit = len / 4 + (moreBit > 0 ? 1 : 0);
		if (moreBit == 0) {
			moreBit = 4;
		}
		char target = ' ';
		int zero = 0;// 計算以四位數字爲單位的數字中存在零的個數
		
		StringBuilder result = new StringBuilder("");
		for (int index = 0; index < len; index += moreBit, moreBit = 4) {
			for (int indexAdd = 0; indexAdd < moreBit; indexAdd++) {
				target = str[index + indexAdd];
				// 多個零跳過多餘的零
				if (target == '0' && str[index + indexAdd - 1] == '0') {
					zero += 1;
					continue;
				} else {
					// 中文數字
					result.append(cNum[target - '0']);

					// 單位 ==> 拾/佰/仟
					if (indexAdd < moreBit - 1) {
						if (target != '0')
							result.append(cUnit[moreBit - indexAdd - 1]);
					}
				}
			}
			// 刪除 XX零億/萬/圓 中的 零
			if (target == '0') {
				result.deleteCharAt(result.length() - 1);
			}
			// 單位 ==> 圓/萬/億
			if (bit > 1) {
				// 是否存在四個連續的零在同一單位上
				if (zero < 3)
					result.append(cUnit[3 + (--bit)]);
			} else {
				result.append(cUnit[0]);
				break;
			}
			zero = 0;
		}
		return result.toString();
	}

	/**
	 * 小數數字轉中文大寫
	 * 
	 * @param money ==> -1 < money < 1
	 * @return
	 */
	public static String toChineseDecimalNum(float money) {
		System.out.println(money);
		char[] str = Float.toString(money).toCharArray();
		StringBuilder result = new StringBuilder();
		char target = ' ';
		int len = (str.length > 5 ? 5 : str.length);
		for (int i = 2; i < len; i++) {
			target = str[i];
			if (target == '0' && str[i - 1] == target)
				continue;
			result.append(cNum[target - '0']);
			if (target != '0') {
				result.append(cUnit[i + 4]);
			}
		}
		// 刪除末尾 零
		if (target == '0') {
			result.deleteCharAt(result.length() - 1);
		}
		return result.toString();
	}

	public static String toChineseNum(float money) {
		BigDecimal deci = new BigDecimal(Float.toString(money));
		deci.intValue();
		long a = deci.longValue();
		BigDecimal lon = new BigDecimal(Long.toString(a));
		deci = deci.subtract(lon);
		return toChineseNum(lon.longValue()) + toChineseDecimalNum(deci.floatValue());
	}

}
