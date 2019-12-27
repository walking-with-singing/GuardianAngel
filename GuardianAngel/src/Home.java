import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Home extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 获取屏幕分辨率
	private final Dimension dScreen = Toolkit.getDefaultToolkit().getScreenSize();
	private final int width = dScreen.width;
	private final int height = dScreen.height;
	// 组件
	JRadioButton aes_e = new JRadioButton("用AES加密");
	JRadioButton aes_d = new JRadioButton("用AES解密");
	JRadioButton rsa_e = new JRadioButton("用RSA加密");
	JRadioButton rsa_d = new JRadioButton("用RSA解密");
	JRadioButton rsa_s = new JRadioButton("用RSA加密并签名");
	JRadioButton rsa_v = new JRadioButton("用RSA解密并验证签名");
	ButtonGroup buttonGroup = new ButtonGroup();
	JButton submit = new JButton("确定");
	JPasswordField input=new JPasswordField(20);
	JTextField playout=new JTextField(20);
	public Home() {
		playout.setEditable(false);
		buttonGroup.add(aes_e);
		buttonGroup.add(aes_d);
		buttonGroup.add(rsa_e);
		buttonGroup.add(rsa_d);
		buttonGroup.add(rsa_s);
		buttonGroup.add(rsa_v);
		submit.addActionListener(e -> {
			FileDialog fdl=new FileDialog(this,"选择文件",FileDialog.LOAD);
			fdl.setVisible(true);
			String readPath=fdl.getDirectory()+fdl.getFile();
			

			if(aes_e.isSelected())
			{
				FileDialog fds=new FileDialog(this,"选择文件的保存地址",FileDialog.SAVE);
				fds.setFile(fdl.getFile()+".AES");
				fds.setVisible(true);
				String writePath=fds.getDirectory()+fds.getFile();
				SymmetricEncryption sc=new SymmetricEncryption();
				sc.encryptFile(readPath, writePath, new String(input.getPassword()));
				playout.setText("AES加密成功");
			}else if(aes_d.isSelected())
			{
				FileDialog fds=new FileDialog(this,"选择文件的保存地址",FileDialog.SAVE);
				fds.setFile("AES解密—"+fdl.getFile().substring(0, fdl.getFile().length()-4));
				fds.setVisible(true);
				String writePath=fds.getDirectory()+fds.getFile();
				SymmetricEncryption sc=new SymmetricEncryption();
				sc.decryptFile(readPath, writePath, new String(input.getPassword()));
				playout.setText("AES解密密成功");
			}else if(rsa_e.isSelected())
			{
				FileDialog fds=new FileDialog(this,"选择文件的保存地址",FileDialog.SAVE);
				fds.setFile(fdl.getFile()+".RSA");
				fds.setVisible(true);
				String writePath=fds.getDirectory()+fds.getFile();
				AsymmetricEncryption ae=new AsymmetricEncryption();
				ae.encryptFile(readPath, writePath);
				playout.setText("RSA加密成功");
			}else if(rsa_d.isSelected())
			{
				FileDialog fds=new FileDialog(this,"选择文件的保存地址",FileDialog.SAVE);
				fds.setFile("RSA解密—"+fdl.getFile().substring(0, fdl.getFile().length()-4));
				fds.setVisible(true);
				String writePath=fds.getDirectory()+fds.getFile();
				System.out.println(readPath);
				AsymmetricEncryption ae=new AsymmetricEncryption();
				ae.decryptFile(readPath, writePath);
				playout.setText("RSA解密成功");
			}else if(rsa_s.isSelected())
			{
				FileDialog fds=new FileDialog(this,"选择文件的保存地址",FileDialog.SAVE);
				fds.setFile(fdl.getFile()+".RSAS");
				fds.setVisible(true);
				String writePath=fds.getDirectory()+fds.getFile();
				AsymmetricEncryption ae=new AsymmetricEncryption();
				ae.encryptFileAndSign(readPath, writePath);
				playout.setText("RSA签名加密成功");
			}else if(rsa_v.isSelected())
			{
				FileDialog fds=new FileDialog(this,"选择文件的保存地址",FileDialog.SAVE);
				fds.setFile("RSAS解密—"+fdl.getFile().substring(0, fdl.getFile().length()-5));
				fds.setVisible(true);
				String writePath=fds.getDirectory()+fds.getFile();
				AsymmetricEncryption ae=new AsymmetricEncryption();
				if(ae.decryptFileAndVerify(readPath, writePath)==true)
					playout.setText("RSA解密成功,签名验证无误");
				else
					playout.setText("签名不匹配");
			}
		});
		// 非全屏时尺寸和位置
		this.setSize(width / 2, height / 2);
		this.setLocationRelativeTo(null);
		// 默认关闭窗口设置
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 添加组件
		JPanel pn = new JPanel();
		pn.add(aes_e);
		pn.add(aes_d);
		pn.add(rsa_e);
		pn.add(rsa_d);
		pn.add(rsa_s);
		pn.add(rsa_v);
		this.setLayout(new BorderLayout());
		this.add(pn, BorderLayout.NORTH);
		JPanel pc = new JPanel();
		pc.add(new JLabel("口令："));
		pc.add(input);
		JPanel ps = new JPanel();
		ps.setLayout(new BorderLayout());
		ps.add(playout,BorderLayout.NORTH);
		ps.add(submit,BorderLayout.SOUTH);
		this.add(pc, BorderLayout.CENTER);
		this.add(ps,BorderLayout.SOUTH);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Home();
	}
}
