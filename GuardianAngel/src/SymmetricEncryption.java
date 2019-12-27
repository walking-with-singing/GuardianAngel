import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SymmetricEncryption {
	final byte[][] key= {
			{(byte)0x0f,(byte)0x47,(byte)0x0c,(byte)0xaf},
			{(byte)0x15,(byte)0xd9,(byte)0xb7,(byte)0x7f},
			{(byte)0x71,(byte)0xe8,(byte)0xad,(byte)0x67},
			{(byte)0xc9,(byte)0x59,(byte)0xd6,(byte)0x98}
	};
	public static void main(String[] args) {
		SymmetricEncryption sc=new SymmetricEncryption();
		sc.encryptFile("C:\\Users\\”Í\\Desktop\\ª˙∆˜—ßœ∞∏¥œ∞.pdf", "C:\\Users\\”Í\\Desktop\\C.pdf","123456");
		sc.decryptFile("C:\\Users\\”Í\\Desktop\\C.pdf", "C:\\Users\\”Í\\Desktop\\P.pdf","123456");
	}
	public void encryptFile(String readPath,String writePath,String password)
	{
		try {
			AES aes=new AES();
			FileInputStream read=new FileInputStream(readPath);
			byte[] data=read.readAllBytes();
			FileOutputStream write=new FileOutputStream(writePath);
			write.write(aes.encrypt(data, password));
			read.close();
			write.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void decryptFile(String readPath,String writePath,String password)
	{
		try {
			AES aes=new AES();
			FileInputStream read=new FileInputStream(readPath);
			byte[] data=read.readAllBytes();
			FileOutputStream write=new FileOutputStream(writePath);
			write.write(aes.decrypt(data, password));
			read.close();
			write.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
