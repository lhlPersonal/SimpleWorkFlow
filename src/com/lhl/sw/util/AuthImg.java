package com.lhl.sw.util;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.awt.*;
import java.awt.image.*;
import java.util.*;
import javax.imageio.*; 


@WebServlet(urlPatterns={"/WEB-INF/content/authImg.jsp"})
public class AuthImg
	extends HttpServlet
{
	//����ͼ����֤���л����ַ������
	private final Font mFont =
		new Font("Arial Black", Font.PLAIN, 16);
	//����ͼ����֤��Ĵ�С
	private final int IMG_WIDTH = 100;
	private final int IMG_HEIGTH = 18;
	//����һ����ȡ�����ɫ�ķ���
	private Color getRandColor(int fc,int bc)
	{
		Random random = new Random();
		if(fc > 255) fc = 255;
		if(bc > 255) bc=255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		//�õ������ɫ
		return new Color(r , g , b);
	}
	//��дservice��������ɶԿͻ��˵���Ӧ
	public void service(HttpServletRequest request,
		HttpServletResponse response) 
		throws ServletException, IOException
	{
		//���ý�ֹ����
		response.setHeader("Pragma","No-cache");
		response.setHeader("Cache-Control","no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");
		BufferedImage image = new BufferedImage
			(IMG_WIDTH , IMG_HEIGTH , BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		Random random = new Random();
		g.setColor(getRandColor(200 , 250));
		//��䱳��ɫ
		g.fillRect(1, 1, IMG_WIDTH - 1, IMG_HEIGTH - 1);
		//Ϊͼ����֤����Ʊ߿�
		g.setColor(new Color(102 , 102 , 102));
		g.drawRect(0, 0, IMG_WIDTH - 1, IMG_HEIGTH - 1);
		g.setColor(getRandColor(160,200));
		//�����������
		for (int i = 0 ; i < 80 ; i++)
		{
			int x = random.nextInt(IMG_WIDTH - 1);
			int y = random.nextInt(IMG_HEIGTH - 1);
			int xl = random.nextInt(6) + 1;
			int yl = random.nextInt(12) + 1;
			g.drawLine(x , y , x + xl , y + yl);
		}
		g.setColor(getRandColor(160,200));
		//�����������
		for (int i = 0 ; i < 80 ; i++)
		{
			int x = random.nextInt(IMG_WIDTH - 1);
			int y = random.nextInt(IMG_HEIGTH - 1);
			int xl = random.nextInt(12) + 1;
			int yl = random.nextInt(6) + 1;
			g.drawLine(x , y , x - xl , y - yl);
		}
		//���û����ַ������
		g.setFont(mFont);
		//���ڱ���ϵͳ��ɵ�����ַ�
		String sRand = "";
		for (int i = 0 ; i < 6 ; i++)
		{
			String tmp = getRandomChar();
			sRand += tmp;
			//��ȡ�����ɫ
			g.setColor(new Color(20 + random.nextInt(110)
				,20 + random.nextInt(110)
				,20 + random.nextInt(110)));
			//��ͼƬ�ϻ���ϵͳ��ɵ�����ַ�
			g.drawString(tmp , 15 * i + 10,15);
		}
		//��ȡHttpSesssion����
		HttpSession session = request.getSession(true);
		//������ַ����HttpSesssion������ 
		session.setAttribute("rand" , sRand);
		g.dispose();
		//������������ͼƬ
		ImageIO.write(image, "JPEG", response.getOutputStream());
	}
	//�����ȡ����ַ���
	private String getRandomChar()
	{
		//���һ��0��1��2���������
		int rand = (int)Math.round(Math.random() * 2);
		long itmp = 0;
		char ctmp = '\u0000';
		switch (rand)
		{
			//��ɴ�д��ĸ
			case 1:
				itmp = Math.round(Math.random() * 25 + 65);
				ctmp = (char)itmp;
				return String.valueOf(ctmp);
			//���Сд��ĸ
			case 2:
				itmp = Math.round(Math.random() * 25 + 97);
				ctmp = (char)itmp;
				return String.valueOf(ctmp);
			//�������
			default :
				itmp = Math.round(Math.random() * 9);
				return  itmp + "";
		}
	}
}