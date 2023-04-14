package myFirstWindow;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class myWindowLogic {

	static myOwnWindow myWindow = new myOwnWindow();
	
	
    public static void main(String[] args) 
    {
        
        myWindow.setTitle("�״�� �� �� �ֽ��ϴ�");
        
        JLabel myLabel = new JLabel("���� �����ϴ� �뵵");
        myWindow.add(myLabel);
        myWindow.setLayout(null);
    
        myLabel.setBounds(0, 0, myWindow.getWidth(), myWindow.getHeight() - 25);
        myLabel.setFont( new Font("�ü�", Font.BOLD, 50) );
        myLabel.setVerticalAlignment(SwingConstants.TOP);
        myLabel.setText("�߰����� �ٲ��� �� �־��.");
        
        JButton myButton = new JButton();
        myWindow.add(myButton);
        myButton.setBounds(100, 100, 200, 50);
        myButton.setText("�̰� ��ư��");
        myButton.setFont( new Font("���� ���", Font.BOLD, 30));
        myButton.setToolTipText("�̰� ������ �ȵſ�");
        myButton.setForeground(Color.YELLOW);
        myButton.setBackground(Color.BLACK);
        
        ActionListener listener = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                myWindow.dispose();
            }
        };
        myButton.addActionListener(listener);
        
        JButton fullscreenButton = new JButton();
        
        ActionListener listenForFullscreen = new ActionListener()
        {
            GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsDevice myDevice = graphics.getScreenDevices()[0];
            boolean isFullScreen = false;
            
            @Override
            public void actionPerformed(ActionEvent e)
            {    
            	isFullScreen = myDevice.getFullScreenWindow() == myWindow;
            	
            	if(isFullScreen)
            	{
            		myDevice.setFullScreenWindow(null);
            		fullscreenButton.setText("��üȭ��");
            	}
            	else
            	{
            		myDevice.setFullScreenWindow(myWindow);
            		fullscreenButton.setText("â���");
            	}
            	
            	//System.out.println(graphics.getScreenDevices()[0].getDisplayMode().getWidth());
            	
                //myWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        };
        myWindow.add(fullscreenButton);
        fullscreenButton.setBounds(300, 100, 200, 50);
        fullscreenButton.setText("Ű���ֱ�");
        fullscreenButton.setFont( new Font("���� ���", Font.BOLD, 30));
        fullscreenButton.setToolTipText("â ũ�⸦ Ű����");
        fullscreenButton.setForeground(Color.BLACK);
        fullscreenButton.setBackground(Color.YELLOW);
        
        fullscreenButton.addActionListener(listenForFullscreen);
        
        JTextField myTF = new JTextField();
        myTF.setBounds(100, 300, 200, 50);
        myTF.addActionListener(new ActionListener()
        {
        	@Override
        	public void actionPerformed(ActionEvent e)
        	{
        		myLabel.setText(myTF.getText());
        	}
        });
        
        ButtonGroup myGroup = new ButtonGroup();
        
        JRadioButton firstRadio = new JRadioButton("����");
        firstRadio.setBounds(200, 270, 100, 20);
        myWindow.add(firstRadio);

        JRadioButton secondRadio = new JRadioButton("����");
        secondRadio.setBounds(300, 270, 100, 20);
        //secondRadio.addActionListener(new ActionListener);
    }
}

class action implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        
    }
}

class myOwnWindow extends JFrame
{
    public myOwnWindow()
    {
        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("�̸����� ���غ��Կ�.");
        setVisible(true);
    }
}