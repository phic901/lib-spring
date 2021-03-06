package com.khh.security.encrypt;

import javax.persistence.AttributeConverter;

import com.omnicns.java.convert.ConvertUtil;
import com.omnicns.java.jpa.convert.AttributeViewControllConverter;
import com.omnicns.java.string.StringUtil;
/*
http://egloos.zum.com/sweeper/v/3064808
부정형 전방 탐색 (?!) <-> (?=) 긍정형 전방 탐색
부정형 후방 탐색 (?<!) <-> (?<=) 긍정형 후방 탐색
*/
//회사명	앞 3글자 까지만 표시 - 여러 건 노출 시 적용 (예) 옴니씨***
public class PrivacyCompanyFormater extends PrivacyEncryptor implements AttributeConverter<String, String>, AttributeViewControllConverter<String, String>{
	String regex = "(?<=^...).*";
	char mask = '*';
	@Override
	public String convertToViewAttribute(String attribute) {
		if(null!=attribute){
			char[] c = new char[StringUtil.find(attribute, regex).group().length()];
			ConvertUtil.fill(c, mask);
			attribute = attribute.replaceAll(regex, new String(c));
		}
		return attribute;
	}

}
