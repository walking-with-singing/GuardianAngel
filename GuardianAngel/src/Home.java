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
	// ��ȡ��Ļ�ֱ���
	private final Dimension dScreen = Toolkit.getDefaultToolkit().getScreenSize();
	private final int width = dScreen.width;
	private final int height = dScreen.height;
	// ���
	JRadioButton aes_e = new JRadioButton("��AES����");
	JRadioButton aes_d = new JRadioButton("��AES����");
	JRadioButton rsa_e = new JRadioButton("��RSA����");
	JRadioButton rsa_d = new JRadioButton("��RSA����");
	JRadioButton rsa_s = new JRadioButton("��RSA���ܲ�ǩ��");
	JRadioButton rsa_v = new JRadioButton("��RSA���ܲ���֤ǩ��");
	ButtonGroup buttonGroup = new ButtonGroup();
	JButton submit = new JButton("ȷ��");
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
			FileDialog fdl=new FileDialog(this,"ѡ���ļ�",FileDialog.LOAD);
			fdl.setVisible(true);
			String readPath=fdl.getDirectory()+fdl.getFile();
			

			if(aes_e.isSelected())
			{
				FileDialog fds=new FileDialog(this,"ѡ���ļ��ı����ַ",FileDialog.SAVE);
				fds.setFile(fdl.getFile()+".AES");
				fds.setVisible(true);
				String writePath=fds.getDirectory()+fds.getFile();
				SymmetricEncryption sc=new SymmetricEncryption();
				sc.encryptFile(readPath, writePath, new String(input.getPassword()));
				playout.setText("AES���ܳɹ�");
			}else if(aes_d.isSelected())
			{
				FileDialog fds=new FileDialog(this,"ѡ���ļ��ı����ַ",FileDialog.SAVE);
				fds.setFile("AES���ܡ�"+fdl.getFile().substring(0, fdl.getFile().length()-4));
				fds.setVisible(true);
				String writePath=fds.getDirectory()+fds.getFile();
				SymmetricEncryption sc=new SymmetricEncryption();
				sc.decryptFile(readPath, writePath, new String(input.getPassword()));
				playout.setText("AES�����ܳɹ�");
			}else if(rsa_e.isSelected())
			{
				FileDialog fds=new FileDialog(this,"ѡ���ļ��ı����ַ",FileDialog.SAVE);
				fds.setFile(fdl.getFile()+".RSA");
				fds.setVisible(true);
				String writePath=fds.getDirectory()+fds.getFile();
				AsymmetricEncryption ae=new AsymmetricEncryption();
				ae.encryptFile(readPath, writePath);
				playout.setText("RSA���ܳɹ�");
			}else if(rsa_d.isSelected())
			{
				FileDialog fds=new FileDialog(this,"ѡ���ļ��ı����ַ",FileDialog.SAVE);
				fds.setFile("RSA���ܡ�"+fdl.getFile().substring(0, fdl.getFile().length()-4));
				fds.setVisible(true);
				String writePath=fds.getDirectory()+fds.getFile();
				System.out.println(readPath);
				AsymmetricEncryption ae=new AsymmetricEncryption();
				ae.decryptFile(readPath, writePath);
				playout.setText("RSA���ܳɹ�");
			}else if(rsa_s.isSelected())
			{
				FileDialog fds=new FileDialog(this,"ѡ���ļ��ı����ַ",FileDialog.SAVE);
				fds.setFile(fdl.getFile()+".RSAS");
				fds.setVisible(true);
				String writePath=fds.getDirectory()+fds.getFile();
				AsymmetricEncryption ae=new AsymmetricEncryption();
				ae.encryptFileAndSign(readPath, writePath);
				playout.setText("RSAǩ�����ܳɹ�");
			}else if(rsa_v.isSelected())
			{
				FileDialog fds=new FileDialog(this,"ѡ���ļ��ı����ַ",FileDialog.SAVE);
				fds.setFile("RSAS���ܡ�"+fdl.getFile().substring(0, fdl.getFile().length()-5));
				fds.setVisible(true);
				String writePath=fds.getDirectory()+fds.getFile();
				AsymmetricEncryption ae=new AsymmetricEncryption();
				if(ae.decryptFileAndVerify(readPath, writePath)==true)
					playout.setText("RSA���ܳɹ�,ǩ����֤����");
				else
					playout.setText("ǩ����ƥ��");
			}
		});
		// ��ȫ��ʱ�ߴ��λ��
		this.setSize(width / 2, height / 2);
		this.setLocationRelativeTo(null);
		// Ĭ�Ϲرմ�������
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ������
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
		pc.add(new JLabel("���"));
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
