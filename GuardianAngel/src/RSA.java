import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;

import org.bouncycastle.util.encoders.Base64;

/**
 * @ClassName: RSA
 * @Description: ��Կ����Կ���ɺ�У��
 * @author p7
 * @date 2018��7��12��
 **/
public class RSA {
	public static final String KEY_ALGORTHM = "RSA";//
	public static final String SIGNATURE_ALGORITHM = "MD5withRSA";

	public static final String PUBLIC_KEY = "RSAPublicKey";// ��Կ
	public static final String PRIVATE_KEY = "RSAPrivateKey";// ˽Կ

	/**
	 * BASE64����
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] decryptBASE64(String key) throws Exception {
		return Base64.decode(key.getBytes());//decodeBuffer(key)
	}

	/**
	 * BASE64����
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String encryptBASE64(byte[] key) throws Exception {
		 byte[] encodeBytes=Base64.encode(key);
		return new String(encodeBytes);
	}

	/**
	 * ��ʼ����Կ
	 * 
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Object> initKey() throws Exception {
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KEY_ALGORTHM);
		SecureRandom sc=new SecureRandom("qzyasdfghjkjhgfdsa".getBytes());
		keyPairGenerator.initialize(1024);
		KeyPair keyPair = keyPairGenerator.generateKeyPair();

		// ��Կ
		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
		// ˽Կ
		RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

		Map<String, Object> keyMap = new HashMap<String, Object>(2);
		keyMap.put(PUBLIC_KEY, publicKey);
		keyMap.put(PRIVATE_KEY, privateKey);

		return keyMap;
	}

	/**
	 * ȡ�ù�Կ����ת��ΪString����
	 * 
	 * @param keyMap
	 * @return
	 * @throws Exception
	 */
	public static String getPublicKey(Map<String, Object> keyMap) throws Exception {
		Key key = (Key) keyMap.get(PUBLIC_KEY);
		return encryptBASE64(key.getEncoded());
	}

	/**
	 * ȡ��˽Կ����ת��ΪString����
	 * 
	 * @param keyMap
	 * @return
	 * @throws Exception
	 */
	public static String getPrivateKey(Map<String, Object> keyMap) throws Exception {
		Key key = (Key) keyMap.get(PRIVATE_KEY);
		return encryptBASE64(key.getEncoded());
	}

	/**
	 * �ù�Կ����
	 * 
	 * @param data ��������
	 * @param key  ��Կ
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptByPublicKey(byte[] data, String key) throws Exception {
		// �Թ�Կ����
		byte[] keyBytes = decryptBASE64(key);
		// ȡ��Կ
		X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORTHM);
		Key publicKey = keyFactory.generatePublic(x509EncodedKeySpec);

		// �����ݽ���
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);

		return cipher.doFinal(data);
	}

	/**
	 * ��˽Կ����
	 * 
	 * @param data ��������
	 * @param key  ��Կ
	 * @return
	 * @throws Exception
	 */
	public static byte[] decryptByPrivateKey(byte[] data, String key) throws Exception {
		// ��˽Կ����
		byte[] keyBytes = decryptBASE64(key);

		PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORTHM);
		Key privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
		// �����ݽ���
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE, privateKey);

		return cipher.doFinal(data);
	}

	/**
	 * ��˽Կ����Ϣ��������ǩ��
	 * 
	 * @param data       //��������
	 * @param privateKey //˽Կ
	 * @return
	 * @throws Exception
	 */
	public static String sign(byte[] data, String privateKey) throws Exception {
		// ����˽Կ
		byte[] keyBytes = decryptBASE64(privateKey);
		// ����PKCS8EncodedKeySpec����
		PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(keyBytes);
		// ָ�������㷨
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORTHM);
		// ȡ˽Կ�׶���
		PrivateKey privateKey2 = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
		// ��˽Կ����Ϣ��������ǩ��
		Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
		signature.initSign(privateKey2);
		signature.update(data);

		return encryptBASE64(signature.sign());
	}

	/**
	 * У������ǩ��
	 * 
	 * @param data      ��������
	 * @param publicKey ��Կ
	 * @param sign      ����ǩ��
	 * @return
	 * @throws Exception
	 */
	public static boolean verify(byte[] data, String publicKey, String sign) throws Exception {
		// ���ܹ�Կ
		byte[] keyBytes = decryptBASE64(publicKey);
		// ����X509EncodedKeySpec����
		X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(keyBytes);
		// ָ�������㷨
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORTHM);
		// ȡ��Կ�׶���
		PublicKey publicKey2 = keyFactory.generatePublic(x509EncodedKeySpec);

		Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
		signature.initVerify(publicKey2);
		signature.update(data);
		// ��֤ǩ���Ƿ�����
		return signature.verify(decryptBASE64(sign));

	}

	public static void main(String[] args) throws Exception {
		String content = "{name:tansen,age:25,sex:man,address:����ʡ���������}";

		// 1.��ʼ����Կ˽Կ
		String rsaPublicKey = null;
		String rsaPrivateKey = null;
		try {
			Map<String, Object> map = RSA.initKey();
			rsaPublicKey = getPublicKey(map);
			rsaPrivateKey = getPrivateKey(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(rsaPublicKey.length());
		System.out.println(decryptBASE64(rsaPublicKey).length);
//		// 2.ʹ�ù�Կ����
//				try {
//					System.out.println("����ǰ==" + content);
//					byte[] result_m = RSA.encryptByPublicKey(content.getBytes(), rsaPublicKey);
//					content = encryptBASE64(result_m);
//					System.out.println("���ܺ�==" + content);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//				// 3.˽Կ����
//				try {
//					byte[] b1 = decryptBASE64(content);
//					byte[] b2 = decryptByPrivateKey(b1, rsaPrivateKey);
//					content = new String(b2);
//					System.out.println("���ܺ�==" + content);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//
//				// 4.˽Կ��ǩ
//				String sign = null;
//				try {
//					sign = sign(content.getBytes(), rsaPrivateKey);
//					System.out.println("ǩ��==" + sign);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//				// 5.��Կ��ǩ
//				try {
//					boolean flag = verify(content.getBytes(), rsaPublicKey, sign);
//					System.out.println("��ǩ���==" + flag);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
	}
}