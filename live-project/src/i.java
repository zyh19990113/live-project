import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.regex.*;
public class i
{
	int w2,h2,w,h;ImageIcon i2;
	JButton shang,xiao,food,wear;
	public static void main(String[] args){new i().f();}
	void f()
	{
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		w2=d.width;h2=d.height;
		i2=new ImageIcon("1.jpg");
		w=i2.getIconWidth();h=i2.getIconHeight();
		Font f2=new Font("宋体",Font.PLAIN,w/20);
		JFrame f=new JFrame("福州商圈测评");
		f.setBounds(w2/2-w/2,h2/2-h/2,w,h);
		JLabel l=new JLabel(new ImageIcon("1.jpg"));l.setBounds(0,0,w,h);
		JPanel p=(JPanel)f.getContentPane();p.setOpaque(false);p.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//必须用Integer.valueOf(Integer.MIN_VALUE)，为啥？？？？？？？小心!!!!!!!!
		f.getLayeredPane().add(l,Integer.valueOf(Integer.MIN_VALUE));
		shang = new JButton("福州最受欢迎的商圈");
		xiao = new JButton("<html>福州性价比最高的餐厅<br>（计算需要大约5秒时间）</html>");
		food = new JButton("福州最佳美食聚集地");
		wear = new JButton("福州服饰类综合评分最高的商圈");
		shang.setBounds(w/4,h/4,w/4,h/4);
		xiao.setBounds(w/2,h/4,w/4,h/4);
		food.setBounds(w/4,h/2,w/4,h/4);
		wear.setBounds(w/2,h/2,w/4,h/4);
		shang.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
		{
			JFrame f=new JFrame("商圈");
			f.setBounds(0,0,w,h);
			JLabel l=new JLabel(i2);l.setBounds(0,0,w,h);f.getLayeredPane().add(l,Integer.valueOf(Integer.MIN_VALUE));
			JPanel p=(JPanel)f.getContentPane();p.setOpaque(false);
			l=new JLabel("<html>福州最受欢迎的商圈：<br>东街口</html>");p.add(l);l.setFont(f2);
			f.setVisible(true);
		}});
		//店名a，地址b，人均价格i，评分j
		class j
		{
			String a,b;float i,j;
			j(String c,String d,String e,String f){a=c;b=d;i=Float.valueOf(e);j=Float.valueOf(f);}
			public String toString(){return"店名："+a+"<br>地址："+b+"<br>人均价格："+i+"<br>评分："+j;}
		}
		Comparator c=new Comparator<j>(){public int compare(j i,j j){return j.j>i.j?1:-1;}};
		Set<j>a=new TreeSet<>(c),a2=new TreeSet<>(c),a3=new TreeSet<>(c),a4=new TreeSet<>(c);
		xiao.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
		{try{
			int i;String s,t;Matcher m;float g;j b;
			Pattern p=Pattern.compile("(?s)name\":\"(.*?)\".*?address\":\"(.*?)\".*?price\":\"(.*?)\".*?overall_rating\":\"(.*?)\"");
			for(i=0;i<40;i++)
			{
				s=u2s("http://api.map.baidu.com/place/v2/search?query=美食&region=福州市&output=json&scope=2&page_num="+i+"&ak=3TvW6jKuuezSbpXGIZgzDf8GC1kASM1a");
				//System.out.println(s);
				//name":".."..address":".."..price":".."..overall_rating":".."
				m=p.matcher(s);
				for(;m.find();)
				{
					//System.out.println("店名："+m.group(1)+"，地址："+m.group(2)+"，人均价格："+m.group(3)+"，评分："+m.group(4));
					g=Float.valueOf(t=m.group(3));
					b=new j(m.group(1),m.group(2),t,m.group(4));
					if(g<50)a.add(b);
					else if(g<100)a2.add(b);
					else if(g<200)a3.add(b);
					else a4.add(b);
				}
			}
			//113 69 22 6
			//105 78 38 9
			//System.out.println(a.size()+" "+a2.size()+" "+a3.size()+" "+a4.size());
			j[]b1=a.toArray(new j[0]),b2=a2.toArray(new j[0]),b3=a3.toArray(new j[0]),b4=a4.toArray(new j[0]);
			JFrame f=new JFrame("福州人均消费50以下的性价比最高的前五家美食餐厅");
			f.setBounds(0,0,w,h);
			JLabel l=new JLabel(i2);l.setBounds(0,0,w,h);f.getLayeredPane().add(l,Integer.valueOf(Integer.MIN_VALUE));
			JPanel p2=(JPanel)f.getContentPane();p2.setOpaque(false);
			for(s="<html>",i=0;i<Math.min(b1.length,5);i++)
			{
				s+="第"+(i+1)+"名：<br>"+b1[i]+"<br><br>";
			}
			l=new JLabel(s+"</html>");p2.add(l);
			f.setVisible(true);
			f=new JFrame("福州人均消费50-100的性价比最高的前五家美食餐厅");
			f.setBounds(w2-w,0,w,h);
			l=new JLabel(i2);l.setBounds(0,0,w,h);f.getLayeredPane().add(l,Integer.valueOf(Integer.MIN_VALUE));
			p2=(JPanel)f.getContentPane();p2.setOpaque(false);
			for(s="<html>",i=0;i<Math.min(b2.length,5);i++)
			{
				s+="第"+(i+1)+"名：<br>"+b2[i]+"<br><br>";
			}
			l=new JLabel(s+"</html>");p2.add(l);
			f.setVisible(true);
			f=new JFrame("福州人均消费100-200的性价比最高的前五家美食餐厅");
			f.setBounds(0,h2-h,w,h);
			l=new JLabel(i2);l.setBounds(0,0,w,h);f.getLayeredPane().add(l,Integer.valueOf(Integer.MIN_VALUE));
			p2=(JPanel)f.getContentPane();p2.setOpaque(false);
			for(s="<html>",i=0;i<Math.min(b3.length,5);i++)
			{
				s+="第"+(i+1)+"名：<br>"+b3[i]+"<br><br>";
			}
			l=new JLabel(s+"</html>");p2.add(l);
			f.setVisible(true);
			f=new JFrame("福州人均消费200以上的性价比最高的前五家美食餐厅");
			f.setBounds(w2-w,h2-h,w,h);
			l=new JLabel(i2);l.setBounds(0,0,w,h);f.getLayeredPane().add(l,Integer.valueOf(Integer.MIN_VALUE));
			p2=(JPanel)f.getContentPane();p2.setOpaque(false);
			for(s="<html>",i=0;i<Math.min(b4.length,5);i++)
			{
				s+="第"+(i+1)+"名：<br>"+b4[i]+"<br><br>";
			}
			l=new JLabel(s+"</html>");p2.add(l);
			f.setVisible(true);
		}catch(Exception ex){ex.printStackTrace();}}});
		food.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
		{
			JFrame f = new JFrame("美食");
			f.setBounds(0,h2-h,w,h);
			JLabel l=new JLabel(i2);l.setBounds(0,0,w,h);f.getLayeredPane().add(l,Integer.valueOf(Integer.MIN_VALUE));
			JPanel p=(JPanel)f.getContentPane();p.setOpaque(false);
			l=new JLabel("<html>福州最佳美食聚集地：<br>宝龙万象</html>");p.add(l);l.setFont(f2);
			f.setVisible(true);
		}});
		wear.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
		{
			JFrame f = new JFrame("服饰");
			f.setBounds(w2-w,h2-h,w,h);
			JLabel l=new JLabel(i2);l.setBounds(0,0,w,h);f.getLayeredPane().add(l,Integer.valueOf(Integer.MIN_VALUE));
			JPanel p=(JPanel)f.getContentPane();p.setOpaque(false);
			l=new JLabel("<html>福州服饰类综合评分最高的商圈：<br>新店</html>");p.add(l);l.setFont(f2);
			f.setVisible(true);
		}});
		p.add(shang);p.add(xiao);p.add(food);p.add(wear);
		f.setVisible(true);
	}
	static String u2s(String u,String v)
	{String s="";try{
		HttpURLConnection c=(HttpURLConnection)new URL(u).openConnection();
		c.setDoOutput(true);//c.setRequestProperty("Content-Type","application/json");
		PrintStream o=new PrintStream(c.getOutputStream());o.print(v);o.close();
		InputStream i;if(c.getResponseCode()==200)i=c.getInputStream();else i=c.getErrorStream();
		byte[]b=new byte[8192];int l;
		for(;(l=i.read(b))!=-1;)s+=new String(b,0,l,"utf8");
		i.close();
	}catch (IOException e){e.printStackTrace(); }return s;}
	static String u2s(String u)
	{String s="";try{
		HttpURLConnection c=(HttpURLConnection)new URL(u).openConnection();
		InputStream i;if(c.getResponseCode()==200)i=c.getInputStream();else i=c.getErrorStream();
		byte[]b=new byte[8192];int l;
		//必须加"utf8"，否则转成exe后会乱码，小心!!!!!!!!
		for(;(l=i.read(b))!=-1;)s+=new String(b,0,l,"utf8");
		i.close();
	}catch(Exception e){e.printStackTrace();}return s;}
	static String u2s2(String u){return u2s(u,"");}
}