package com.xx.ssm.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	public static void main(String[] args) throws Exception {
		User user = new User();
		user.setId("01");
		user.setName("����");
		user.setAge(33);
		user.setPay(6666.88);
		user.setValid(true);
		user.setOne('E');
		user.setBirthday(new Date(20l * 366 * 24 * 3600 * 1000)); // 1990��

		Link link = new Link();
		link.setAddress("����ʡ��Դ��");
		link.setPhone("13899995555");
		link.setQq("123456");
		user.setLink(link);

		Map map = new HashMap();
		map.put("aa", "this is aa");
		map.put("bb", "this is bb");
		map.put("cc", "this is cc");
		user.setMap(map);

		List list = new ArrayList();
		list.add("�ն�");
		list.add("�����");
		user.setList(list);

		Set set = new HashSet();
		set.add("����");
		set.add("����");
		set.add("ƹ����");
		user.setSet(set);

		ObjectMapper mapper = new ObjectMapper(); // ת����

		// ����01������--json
		String json = mapper.writeValueAsString(user); // ������ת����json
		System.out.println(json);
		/*
		 * ������£�
		 * {"id":"01","name":"����","age":33,"pay":6666.88,"valid":true,"one":"E",
		 * "birthday":1465185448998,
		 * "link":{"phone":"13899995555","address":"����ʡ��Դ��","qq":"123456"},
		 * "map":{"aa":"this is aa","bb":"this is bb","cc":"this is cc"},
		 * "list":["�ն�","�����"], "set":["ƹ����","����","����"]}
		 * 
		 * ע��㣺��1�� ����--������ ��2��List��Set��ת������
		 */

		// ����02��json--map
		Map m = mapper.readValue(json, Map.class); // jsonת����map

		System.out.println("pay��" + m.get("pay").getClass().getName()); // java.lang.Double
		System.out.println("valid��" + m.get("valid").getClass().getName()); // java.lang.Boolean
		System.out.println("birthday��" + m.get("birthday").getClass().getName()); // java.lang.Long
		System.out.println("link��" + m.get("link").getClass().getName()); // java.util.LinkedHashMap
		System.out.println("map��" + m.get("map").getClass().getName()); // java.util.LinkedHashMap
		System.out.println("list��" + m.get("list").getClass().getName()); // java.util.ArrayList
		System.out.println("set��" + m.get("set").getClass().getName()); // java.util.ArrayList
		/*
		 * ������£� pay��java.lang.Double valid��java.lang.Boolean
		 * birthday��java.lang.Long link��java.util.LinkedHashMap
		 * map��java.util.LinkedHashMap list��java.util.ArrayList
		 * set��java.util.ArrayList
		 * 
		 * ע��㣺��1�� ����--������ ��2��map���Ӷ����ת������LinkedHashMap ��3��List��Set��ת��ArrayList
		 */

		// ����03��map--json
		json = mapper.writeValueAsString(m); // mapתjson
		System.out.println(json); // ��֮ǰ��ʽ��ȫ��ͬ��˵������mapת������Ϣû�ж�ʧ

		// ����04��json--����
		User u = mapper.readValue(json, User.class); // jsonתjava���󡣾��⣬ת�ɶ����һ�лָ�����
		System.out.println("pay��" + u.getPay());
		System.out.println("valid��" + u.isValid());
		System.out.println("birthday��" + u.getBirthday());
		System.out.println("link��" + u.getLink());
		System.out.println("map��" + u.getMap());
		System.out.println("list��" + u.getList());
		System.out.println("set��" + u.getSet());

		// ����05������ת��
		byte[] data = mapper.writeValueAsBytes(u); // ����ת�ɶ���������
	}
}
