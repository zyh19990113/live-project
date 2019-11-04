


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class i2 {
	
	
	
	public static void main(String[] args) {
		new i2();
	}
	
	public i2()
	{
		JFrame f=new JFrame("背景图片测试");
		ImageIcon i=new ImageIcon("1.jpg");
		int w=i.getIconWidth(),h=i.getIconHeight();
		f.setBounds(0,0,w,h);
		JLabel l=new JLabel(i);l.setBounds(0,0,w,h);f.getLayeredPane().add(l,Integer.valueOf(Integer.MIN_VALUE));
		JPanel p=(JPanel)f.getContentPane();p.setOpaque(false);p.setLayout(null);
		JButton b=new JButton("测试按钮");p.add(b);b.setBounds(0,0,w/2,h/2);
		b=new JButton("测试按钮2");p.add(b);b.setBounds(w/2,0,w/2,h/2);
		//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setVisible(true);
	}
	
}/*
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class i2 {
	
	private JFrame frame = new JFrame("背景图片测试");
	
	private JPanel imagePanel;
	
	private ImageIcon background;
	
	public static void main(String[] args) {
		new i2();
	}
	
	public i2() {
		background = new ImageIcon("1.jpg");// 背景图片
		JLabel label = new JLabel(background);// 把背景图片显示在一个标签里面
		// 把标签的大小位置设置为图片刚好填充整个面板
		label.setBounds(0, 0, background.getIconWidth(),
			background.getIconHeight());
		// 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
		imagePanel = (JPanel) frame.getContentPane();
		imagePanel.setOpaque(false);
		// 内容窗格默认的布局管理器为BorderLayout
		imagePanel.setLayout(null);
		//imagePanel.add(new JButton("测试按钮"));
		//imagePanel.add(new JButton("测试按钮"));
		JButton b=new JButton("测试按钮");imagePanel.add(b);b.setBounds(0,0,400,300);
		b=new JButton("测试按钮2");imagePanel.add(b);b.setBounds(400,0,400,300);
		//frame.getLayeredPane().setLayout(null);
		// 把背景图片添加到分层窗格的最底层作为背景
		frame.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(background.getIconWidth(), background.getIconHeight());
		frame.setResizable(false);
		frame.setVisible(true);
	}
}*/