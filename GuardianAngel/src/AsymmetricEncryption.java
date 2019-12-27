import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import javax.crypto.spec.SecretKeySpec;

public class AsymmetricEncryption {
	public AsymmetricEncryption() {

	}
	public void initKey()
	{
		String rsaPublicKey = null;
		String rsaPrivateKey = null;
		try {
			Map<String, Object> map = RSA.initKey();
			rsaPublicKey = RSA.getPublicKey(map);
			rsaPrivateKey = RSA.getPrivateKey(map);
			FileOutputStream out = new FileOutputStream("rsaPublicKey2");
			out.write(rsaPublicKey.getBytes());
			out.close();
			out = new FileOutputStream("rsaPrivateKey2");
			out.write(rsaPrivateKey.getBytes());
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void encryptFile(String readPath, String writePath) {

		try {
			AES aes=new AES();
			SecretKeySpec secretKeySpec =aes.initkey(null);
			FileInputStream read = new FileInputStream(readPath);
			FileOutputStream write = new FileOutputStream(writePath);
			FileInputStream readPublicKey = new FileInputStream("rsaPublicKey");
			String publicKey = new String(readPublicKey.readAllBytes());
			//º”√‹∂‘≥∆√‹‘ø
			byte[] b1=RSA.encryptByPublicKey(secretKeySpec.getEncoded(), publicKey);
			//–¥»Î∂‘≥∆√‹‘ø
			write.write(b1);
			write.write(aes.encrypt(read.readAllBytes(), secretKeySpec));
			read.close();
			write.close();
			readPublicKey.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void decryptFile(String readPath, String writePath) {
		try {
			AES aes=new AES();
			FileInputStream read = new FileInputStream(readPath);
			FileOutputStream write = new FileOutputStream(writePath);
			FileInputStream readPrivateKey = new FileInputStream("rsaPrivateKey");
			String privateKey = new String(readPrivateKey.readAllBytes());
			byte[] keydata=read.readNBytes(128);
			byte[] b=RSA.decryptByPrivateKey(keydata, privateKey);
			SecretKeySpec secretKeySpec = new SecretKeySpec(b, "AES");
			write.write(aes.decrypt(read.readAllBytes(), secretKeySpec));
			read.close();
			write.close();
			readPrivateKey.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void encryptFileAndSign(String readPath, String writePath) {
		try {
			AES aes=new AES();
			SecretKeySpec secretKeySpec =aes.initkey(null);
			FileInputStream read = new FileInputStream(readPath);
			byte[] data = read.readAllBytes();
			FileOutputStream write = new FileOutputStream(writePath);
			FileInputStream readPrivateKey = new FileInputStream("rsaPrivateKey2");
			String privateKey2 = new String(readPrivateKey.readAllBytes());
			//«©√˚
			String sign = RSA.sign(data, privateKey2);
			System.out.println(sign.getBytes().length);
			write.write(sign.getBytes());
			//º”√‹
			FileInputStream readPublicKey = new FileInputStream("rsaPublicKey");
			String publicKey = new String(readPublicKey.readAllBytes());
			//º”√‹∂‘≥∆√‹‘ø
			byte[] b1=RSA.encryptByPublicKey(secretKeySpec.getEncoded(), publicKey);
			//–¥»Î∂‘≥∆√‹‘ø
			write.write(b1);
			write.write(aes.encrypt(data, secretKeySpec));
			read.close();
			write.close();
			readPrivateKey.close();
			readPublicKey.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean decryptFileAndVerify(String readPath, String writePath) {
		try {
			AES aes=new AES();

			FileInputStream readPublicKey = new FileInputStream("rsaPublicKey2");
			String publicKey2 = new String(readPublicKey.readAllBytes());
			FileInputStream read = new FileInputStream(readPath);
			String sign = new String(read.readNBytes(172));
			byte[] keydata=read.readNBytes(128);
			byte[] data=read.readAllBytes();
			FileOutputStream write = new FileOutputStream(writePath);
			//Ω‚√‹
			FileInputStream readPrivateKey = new FileInputStream("rsaPrivateKey");
			String privateKey = new String(readPrivateKey.readAllBytes());
			byte[] b=RSA.decryptByPrivateKey(keydata, privateKey);
			SecretKeySpec secretKeySpec = new SecretKeySpec(b, "AES");
			byte[] pdata=aes.decrypt(data, secretKeySpec);
			boolean flag= RSA.verify(pdata, publicKey2, sign);
			write.write(pdata);
			read.close();
			readPublicKey.close();
			readPrivateKey.close();
			write.close();
			return flag;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) {
		AsymmetricEncryption as=new AsymmetricEncryption();
		as.initKey();
//		as1.encryptFile("C:\\Users\\”Í\\Desktop\\ª˙∆˜—ßœ∞∏¥œ∞.pdf", "C:\\Users\\”Í\\Desktop\\ª˙∆˜—ßœ∞∏¥œ∞.pdf.RSA");
//		AsymmetricEncryption as2=new AsymmetricEncryption();
//		as2.decryptFile("C:\\Users\\”Í\\Desktop\\ª˙∆˜—ßœ∞∏¥œ∞.pdf.RSA", "C:\\Users\\”Í\\Desktop\\Ω‚√‹-ª˙∆˜—ßœ∞∏¥œ∞.pdf");
		as.encryptFileAndSign("C:\\Users\\”Í\\Desktop\\ª˙∆˜—ßœ∞∏¥œ∞.pdf", "C:\\Users\\”Í\\Desktop\\ª˙∆˜—ßœ∞∏¥œ∞.pdf.RSAC");
		System.out.println(as.decryptFileAndVerify("C:\\Users\\”Í\\Desktop\\ª˙∆˜—ßœ∞∏¥œ∞.pdf.RSAC", "C:\\Users\\”Í\\Desktop\\RSASΩ‚√‹-ª˙∆˜—ßœ∞∏¥œ∞.pdf"));
//		as.encryptFileAndSign("C:\\Users\\”Í\\ÿ¡’Ò—Â.JPG", "C:\\Users\\”Í\\Desktop\\ª˙∆˜—ßœ∞∏¥œ∞.pdf.RSAC");
		
	}
}
