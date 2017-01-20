package util;

import java.security.MessageDigest;

public class MD5 {
	public static String hash(String text) throws Exception {
		//�ؽ�Ʈ�� md5��ȣȭ �˰����� ����ؼ� ��ȣȭ�Ѵ�.
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(text.getBytes());
		byte[] byteData = md.digest();
		
		//byte�����͸� 16���� ���ڿ��� ��ȯ�ϱ�
		StringBuffer sb = new StringBuffer();
		for (int i=0; i<byteData.length; i++) {
			sb.append(Integer.toString((byteData[i]&0xff)+0x100, 16).substring(1));
		}
		return sb.toString();
	}
	public static void main(String[] args) throws Exception {
		String t = hash("1234");
		System.out.println(t);
	}
}
