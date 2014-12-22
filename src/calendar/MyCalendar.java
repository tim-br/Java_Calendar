package calendar;

import java.awt.Point;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

class MyCalendar extends JPanel {

   JLabel date;
   JButton next =null;
   JButton prev = null;
   JButton enter = null;
   JTextField tfYear;
   JTextField tfMonth;
   JTextField tfDay;


   private static String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September"
   								, "October", "November", "December" };
   private static String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday",
   										"Friday", "Saturday"};


   private static int daysInMonth;
   private static int dayOfWeek;
   private static int currentDay = 0;

   private static GregorianCalendar myCal = null;



   public MyCalendar(){

      tfYear = new JTextField("year");
      tfMonth = new JTextField("month");
      tfDay = new JTextField("day");


       myCal = new GregorianCalendar();

       myCal.setLenient(false);
    myCal.set(GregorianCalendar.YEAR, 2003);
    myCal.set(GregorianCalendar.MONTH, 5);
    myCal.set(GregorianCalendar.DATE, 1);

    System.out.println(currentDay);



       next = new JButton("next");
       prev = new JButton("prev");
       enter = new JButton("enter");
       enter.addActionListener(e -> {
       	int year1 = Integer.parseInt(tfYear.getText());
       	int month1 = Integer.parseInt(tfMonth.getText()) - 1;
       	int day1 = Integer.parseInt(tfDay.getText());
       	myCal.set(GregorianCalendar.YEAR, year1);
    		myCal.set(GregorianCalendar.MONTH, month1);
    		myCal.set(GregorianCalendar.DATE, 1);
    		this.date.setText("" + months[myCal.get(Calendar.MONTH)] + " " +myCal.get(Calendar.YEAR));
    		daysInMonth = myCal.getActualMaximum(Calendar.DAY_OF_MONTH); // 28
       	   dayOfWeek  = myCal.get(Calendar.DAY_OF_WEEK);
       	   currentDay = day1;
    		repaint();
       });
       next.addActionListener(e -> {
       	myCal.add(Calendar.MONTH, 1);
       	   this.date.setText("" + months[myCal.get(Calendar.MONTH)] + " " +myCal.get(Calendar.YEAR));
       	   daysInMonth = myCal.getActualMaximum(Calendar.DAY_OF_MONTH); // 28
       	   dayOfWeek  = myCal.get(Calendar.DAY_OF_WEEK);
       	   currentDay = 0;
       	   repaint();
       }
       );
       prev.addActionListener(e -> {
       	myCal.add(Calendar.MONTH, -1);
       	   this.date.setText("" + months[myCal.get(Calendar.MONTH)] + " " +myCal.get(Calendar.YEAR));
       	   System.out.println(daysInMonth);
              daysInMonth = myCal.getActualMaximum(Calendar.DAY_OF_MONTH); // 28
       	  dayOfWeek  = myCal.get(Calendar.DAY_OF_WEEK);
            currentDay = 0;
       	   repaint();
       }
       );
       daysInMonth = myCal.getActualMaximum(Calendar.DAY_OF_MONTH);
       dayOfWeek  = myCal.get(Calendar.DAY_OF_WEEK);
       System.out.println(dayOfWeek);
//	printOut();




      date = new JLabel("" + months[myCal.get(Calendar.MONTH)] + " " +myCal.get(Calendar.YEAR) );


   	add(date);
   	add(prev);
   	add(next);

   	add(tfYear);
   	add(tfMonth);
   	add(tfDay);
   	add(enter);



    }

     private void drawNumbers(Graphics g, int dayOfWeek, int daysInMonth, int currDay) {

        		int count = 1;

    		  	 int y = 80;
       		 int x = 55;
       		 int i;

       		 if(dayOfWeek == 1){
       		 	for(i = 1; i < daysInMonth+1; i++){

       		 	   	if(currDay == count) g.fillOval(x+25, y+5, 20, 20);
       		 	   	count++;
       		 		g.drawString("" + i, x , y);
       		 		x += 75;
       		 		if( i ==7 || i == 14 || i == 21 || i == 28 ){
       		 		    y += 75;
       		 		    x = 55;
       		 	     }
       		 	}


       		 }

       		  if(dayOfWeek == 2){

       		       x += 75;
       		 	for(i = 1; i < daysInMonth+1; i++){
       		 	   if(currDay == count) g.fillOval(x+25, y+5, 20, 20);
       		 	   	count++;
       		 		g.drawString("" + i, x , y);
       		 		x += 75;
       		 			if( i ==6 || i == 13 || i == 20 || i == 27 ){
       		 		    y += 75;
       		 		    x = 55;
       		 	       }
       		 	}


       		 }

       		   if(dayOfWeek == 3){

       		      x += 150;
       		 	for(i = 1; i < daysInMonth+1; i++){
       		 	   if(currDay == count) g.fillOval(x+25, y+5, 20, 20);
       		 	   	count++;
       		 		g.drawString("" + i, x , y);
       		 		x += 75;
       		 			if( i ==5 || i == 12 || i == 19 || i == 26 ){
       		 		    y += 75;
       		 		    x = 55;
       		 	}
       		 	}


       		 }

       		   if(dayOfWeek == 4){
       		      x += 225;
       		 	for(i = 1; i < daysInMonth+1; i++){
       		 	   if(currDay == count) g.fillOval(x+25, y+5, 20, 20);
       		 	   	count++;
       		 		g.drawString("" + i, x , y);
       		 		x += 75;
       		 			if( i ==4 || i == 11 || i == 18 || i == 25 ){
       		 		    y += 75;
       		 		    x = 55;
       		 	}
       		 	}


       		 }

       		  if(dayOfWeek == 5){
       		     x += 300;
       		 	for(i = 1; i < daysInMonth+1; i++){
       		 	   if(currDay == count) g.fillOval(x+25, y+5, 20, 20);
       		 	   	count++;
       		 		g.drawString("" + i, x , y);
       		 		x += 75;
       		 			if( i ==3 || i == 10 || i == 17 || i == 24 ){
       		 		    y += 75;
       		 		    x = 55;
       		 	}
       		 	}


       		 }
       		 if(dayOfWeek == 6){
       		    x += 375;
       		 	for(i = 1; i < daysInMonth+1; i++){
       		 	   if(currDay == count) g.fillOval(x+25, y+5, 20, 20);
       		 	   	count++;
       		 		g.drawString("" + i, x , y);
       		 		x += 75;
       		 			if( i ==2 || i == 9 || i == 16 || i == 23 || i == 30 ){
       		 		    y += 75;
       		 		    x = 55;
       		 	}
       		 	}


       		 }

       		 if(dayOfWeek == 7){
       		    x += 450;
       		 	for(i = 1; i < daysInMonth+1; i++){
       		 	   if(currDay == count) g.fillOval(x+25, y+5, 20, 20);
       		 	   	count++;
       		 		g.drawString("" + i, x , y);
       		 		x += 75;

       		 	if( i ==1 || i == 8 || i == 15 || i == 22 || i == 29){
       		 		    y += 75;
       		 		    x = 55;
       		 	}
       		 	}

       		 }
    	}

    public void printOut(){
        System.out.println("ERA: " + myCal.get(Calendar.ERA));
        System.out.println("YEAR: " + myCal.get(Calendar.YEAR));
       System.out.println("MONTH: " + myCal.get(Calendar.MONTH));
        System.out.println("WEEK_OF_YEAR: " + myCal.get(Calendar.WEEK_OF_YEAR));
       System.out.println("WEEK_OF_MONTH: " + myCal.get(Calendar.WEEK_OF_MONTH));

       System.out.println("DAY_OF_MONTH: " + myCal.get(Calendar.DAY_OF_MONTH));
       System.out.println("DAY_OF_YEAR: " + myCal.get(Calendar.DAY_OF_YEAR));

    }

   private void drawCalendar(Graphics g) {

        g.setColor(Color.blue);

        Dimension size = getSize();
        Insets insets = getInsets();

        int w = size.width - insets.left - insets.right;
        int h = size.height - insets.top - insets.bottom;


         int x = 50;
        for (int i = 0; i < 8; i++) {

           g.drawLine(x, 50, x, 500);
           x = x+75;
        }
        int y = 50;

        for(int i = 0; i < 7; i++){

        	g.drawLine(50, y, 575, y);
        	y += 75;
        }

    }

    public void drawDays(Graphics g){

        int y = 65;
        int x = 55;

         for(int i = 0; i < 6; i++){

        	g.drawString("SUN", x, y);
        	y += 75;

        }
        y = 65;
          for(int i = 0; i < 6; i++){

        	g.drawString("MON", x + 75, y);
        	y += 75;

        }

        y = 65;

           for(int i = 0; i < 6; i++){

        	g.drawString("TUE", x + 150, y);
        	y += 75;

        }

        y = 65;

              for(int i = 0; i < 6; i++){

        	g.drawString("WED", x + 225, y);
        	y += 75;

        }

        y = 65;

              for(int i = 0; i < 6; i++){

        	g.drawString("THU", x + 300, y);
        	y += 75;

        }

        y = 65;

              for(int i = 0; i < 6; i++){

        	g.drawString("FRI", x + 375, y);
        	y += 75;

        }

        y = 65;

              for(int i = 0; i < 6; i++){

        	g.drawString("SAT", x + 450, y);
        	y += 75;

           }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawCalendar(g);
        drawDays(g);
        drawNumbers(g, dayOfWeek, daysInMonth, currentDay);

    	}

    public static void main(String[] args) {
       JFrame f = new JFrame();
       f.getContentPane().add(new MyCalendar());

       f.setSize(630, 580);
       f.setVisible(true);
       f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}