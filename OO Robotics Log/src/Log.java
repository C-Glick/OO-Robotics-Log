import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JTextField;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSeparator;

public class Log extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

														 //must declare objects before even main method to use in all of the class, must be static
	static LinkedHashMap <Integer, Students> objMap = new LinkedHashMap <Integer, Students>();
	static LinkedHashMap <Integer, String> studentMap = new LinkedHashMap<Integer, String>();
	
	private JPanel contentPane;			//create content pane for the GUI
	private JTextField mLogin;			//create a text field for the GUI
	public static JTextArea txtArea = new JTextArea(); 		//create a text area for live logging

//**********************************************************************************Main Method********************************************************************************************************************************
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {							//create a runnable method, starts the main logging system
				try {
					
					
					Log frame = new Log();				//runs the log() method 
					frame.setVisible(true);				//sets the main window visible
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}); 
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws InvalidFormatException 
	 */
	public Log() throws InvalidFormatException, IOException {
		//final JFrame Jmain = new JFrame();
		addWindowListener(new java.awt.event.WindowAdapter(){		//makes the window listen when you try to close it, intercepts the closing and askes if you really want to close
			public void windowClosing(java.awt.event.WindowEvent windowEvent){
		        if (JOptionPane.showConfirmDialog(contentPane ,"Are you sure you want to stop logging time? \r\n (all students logged in will be logged out)", "Really Close?", 
		                JOptionPane.YES_NO_OPTION,
		                JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
		                try {
							shutdownCheck();		//calls the shut down check method
						} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
							e.printStackTrace();
						}
		            }
			}

		});
		
		
        final JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(1620, 2000));

        final JScrollPane scroll = new JScrollPane(panel);
        scroll.setBounds(0, 24, 1450, 1017);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        panel.setLayout(null);

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(scroll);
        
        JLabel lblTimeLoggingSystem = new JLabel("Time Logging System");
        lblTimeLoggingSystem.setBounds(751, 0, 268, 24);
        lblTimeLoggingSystem.setFont(new Font("SimSun", Font.BOLD, 25));
        getContentPane().add(lblTimeLoggingSystem);
        


		
		
		//sets the data for each frame created in the Students class	
		studentMap.put(2242, "Cassidy Borwig");
		studentMap.put(1856, "Dylan Brewer");
		studentMap.put(2390, "Braden Brown");
		studentMap.put(2456, "Taylor Brown");
		studentMap.put(2391, "Zachary Clark");
		studentMap.put(2288, "Tristin Cleveland");
		studentMap.put(3513, "Hugo Dahlen");
		studentMap.put(1881, "Maya Despenas");
		studentMap.put(2394, "Jayne Eilderts");
		studentMap.put(2035, "Victoria Fernandez");
		studentMap.put(2013, "Jacob Foss");
		studentMap.put(2129, "Colton Glick");
		studentMap.put(6, "Todd Graper");
		studentMap.put(2401, "Katryna Hauser");
		studentMap.put(2248, "Olivia Heerkes");
		studentMap.put(3348, "Adrian Hinz");
		studentMap.put(2109, "Sydney Hoffmann");
		studentMap.put(2132, "Michael Huntley");
		studentMap.put(2, "James Foss");
		studentMap.put(2467, "Jacob Junker");
		studentMap.put(2406, "Emilee Junker");
		studentMap.put(1, "Tyler Strickler");
		studentMap.put(2447, "Tyler Laube");
		studentMap.put(2583, "Alana Ledtje");
		studentMap.put(2086, "Sawyer Loger");
		studentMap.put(2291, "Jon McCallum");
		studentMap.put(2100, "Dylan Messerschmit");
		studentMap.put(2417, "Madyson Mrzlak");
		studentMap.put(1887, "Adriana Murphy");
		studentMap.put(2418, "Malea Neuroth");
		studentMap.put(1889, "Eli Nielsen");
		studentMap.put(5, "John Latusek");
		studentMap.put(3, "Paul Rael");
		studentMap.put(4, "Gail Strickler");
		studentMap.put(2005, "Lauren Vanderlind");
		studentMap.put(2425, "Michaela Wagner");
		studentMap.put(2809, "Joanna Seymour");
		
		int tileX = 10;
		int tileY = 10;
		
		LinkedHashMap <Integer, String> middleMap = new LinkedHashMap<Integer, String>();
		middleMap.putAll(studentMap);

	    Iterator it = middleMap.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();  //pair.getValue()     pair.getKey()
	        final Students student = new Students();
	        student.studentID = (int) pair.getKey();
	        student.name = (String) pair.getValue();
	        student.state = false;
	        student.image = new JLabel((String) pair.getValue());
	        if (Log.class.getResource("/images/"+pair.getValue()+ ".jpg")!=null){									//image size must be 175x232
	        	student.image.setIcon(new ImageIcon(Log.class.getResource("/images/"+pair.getValue()+ ".jpg")));
	        }
	        else{
	        	student.image.setIcon(new ImageIcon(Log.class.getResource("/images/default.jpg")));
	        }
	        student.image.setName(student.name);
		    student.image.setToolTipText(student.name);	
		    student.image.setEnabled(student.state);
		    student.image.setBounds(tileX,tileY,175,232);
			    if (tileX < 1200){
			    	tileX = tileX + 205;
			    }
			    else{
			    	tileX = 10;
			    	tileY = tileY + 285;
			    }
			objMap.put(student.studentID, student);
		    panel.add(student.image);
		    student.image.addMouseListener(new MouseAdapter(){
		    	@Override
		    	public void mouseClicked(MouseEvent arg0){
		    		if(student.image.isEnabled()){
		    			try{
		    				student.image.setEnabled(false);
		    				writeFile(student.name, false, student.studentID);
		    				student.state=false;
		    			} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
		    				e.printStackTrace();
		    			}
		    		}
		    	}
		    	
		    });
	        it.remove(); // avoids a ConcurrentModificationException
	    }

		
		//creates the toolbar and adds it to the content pane
		//JToolBar toolBar = new JToolBar();
		//toolBar.setBounds(0, 0, 189, 28);
	    
	    try {																			//set the look and feel of the program to be the same as the os
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch(Exception ex) {
				System.out.println(ex);
			};
		
        JToolBar toolBar = new JToolBar();
        toolBar.setBounds(0, 0, 206, 24);
        getContentPane().add(toolBar);
        setSize(1920, 1080);
		
		
		//creates text field for logging in and adds it 
		mLogin = new JTextField();
		mLogin.setText("Manual Login");
		toolBar.add(mLogin);
		mLogin.setColumns(10);
		txtArea.setLineWrap(true);
		
		//creates the text area for the live logging and adds it
		txtArea.setEditable(false);
		txtArea.setFont(new Font("Courier New", Font.PLAIN, 16));
		txtArea.setText("CONSOLE LOG:\r\n");
		txtArea.setBounds(1450, 126, 450, 904);
		getContentPane().add(txtArea);
		txtArea.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
	
		final JButton btnSubmit = new JButton("Submit");		//creates submit button
		btnSubmit.addActionListener(new ActionListener() {		//listens
			public void actionPerformed(ActionEvent arg0) {
				int mLoginNumber = Integer.parseInt(mLogin.getText());		//turns any text in the text field into an integer and saves it to the variable 'mLoginNumber'
				if(studentMap.containsKey(mLoginNumber)){			//if the hashmap from Students class contains that number in one of the keys it continues else it displays an error
					String username = studentMap.get(mLoginNumber);		//gets the name of the jLable that corresponds to the entered key, saves it to 'username'
					
/*set state */	Students currentS= null;
					for(Map.Entry entry : objMap.entrySet()){
						if((int) entry.getKey()==mLoginNumber){
							currentS=(Students) entry.getValue();
							currentS.state = !currentS.state;
							currentS.image.setEnabled(!currentS.image.isEnabled());
							break;
						}
					}
					
					
					if (!currentS.state){			//if after the change it is not enabled it runs the following block (logging out)
							try {
								writeFile(username, false, mLoginNumber);			//calls the 'writeFile' method, passes the following information 'username' False and 'mLoginNumber' 
							} catch (FileNotFoundException e) {						//'writeFile(Name of the user, Are they logging in? , what is the users ID);
								System.out.println("File not found");
								e.printStackTrace();
							} catch (IOException e) {
								System.out.println("IO Exception");
								e.printStackTrace();
							} catch (EncryptedDocumentException e) {
								System.out.println("Encrypted Document Exception");
								e.printStackTrace();
							} catch (InvalidFormatException e) {
								System.out.println("Invalid Format Exception");
								e.printStackTrace();
							}
						}
					else{																//If after the change it is enabled it runs the following block (Logging in)
					try {																		
						writeFile(username, true, mLoginNumber);						//calls 'writeFile'
					} catch (IOException e) {											//'writeFile(Name of the user, Are they logging in? , what is the users ID);
						System.out.println("IO Exception");
						e.printStackTrace();
					} catch (EncryptedDocumentException e) {
						System.out.println("Encrypted Document Exception");
						e.printStackTrace();
					} catch (InvalidFormatException e) {
						System.out.println("Invalid Format Exception");
						e.printStackTrace();
					}
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "Theres no user by the code : "+ mLogin.getText());		//message that is displayed if no user idea is found
				}
				mLogin.setText("");			//sets the text in the login field to nothing
				mLogin.requestFocus();		//sets the login field to the main focus for entering the next student ID
			}
		});
		
		toolBar.add(btnSubmit);			//finally add the submit button to the toolbar
		toolBar.getRootPane().setDefaultButton(btnSubmit);
		
		JButton btnOpenRecords = new JButton("Open Records");
		btnOpenRecords.setBounds(387, 0, 112, 21);
		getContentPane().add(btnOpenRecords);
		
	}
	
	
	public static void writeFile (String user, boolean login, int mLoginNumber) throws IOException, EncryptedDocumentException, InvalidFormatException{			//new writeFile method (runs everytime someone logins or out)
		String workingDir = System.getProperty("user.dir") + "\\Activity Log.xls";		//gets the location of where the excel log file should/will be, (is a string)
		Path fileCheck = Paths.get(workingDir);			//converts the String variable workingDir to a path variable
		if(!Files.exists(fileCheck)){					//checks if the excel file exsits, If it does not exsist run the following block of code
			String fileName = "Activity Log.xls";		//sets the file name 
			HSSFWorkbook workbook = new HSSFWorkbook();		//creates a new excel workbook to write in
			Sheet sheet1 = workbook.createSheet("sheet1");					//creates a new sheet called sheet1 in the workbook
			
			writeCell(sheet1,0,0,"Date v | Name >");	//calls the write cell method, writeCell(name of the sheet, x coordinate , y coordinate , text to be written);
			writeCell(sheet1,0,1,"Total Time (hrs.) >");
			writeCell(sheet1,0,2,getDate());			//writeCell(name of the sheet, x coordinate , y coordinate , text to be written);
			
			//get a set of the entries
			Set set = studentMap.entrySet();		//create a set with all the entries of the hashmap in the students class
			
			//get an iterator
			Iterator i = set.iterator();	//create an iterator (still don't fully understand this)
			int x=1;						//create an x variable and set it to 1
			
			while(i.hasNext()){				//Start a while loop, while there are more people to look through keep running this block of code
				Map.Entry me = (Map.Entry)i.next();			//create a map entry (still don't fully understand this)
				String userLoop = (String) me.getValue();		//gets the name of the current user it is looking at. saves it to variable 'userLoop'
				writeCell(sheet1,x,0,userLoop);				//calls writeCell method, writeCell(name of the sheet, x coordinate , y coordinate , text to be written);
				x++;		//adds 1 to x, makes the cell that is to be written to move, i controls what person it is looking at in the hashmap
			}
			FileOutputStream fileOut = new FileOutputStream(fileName);		//set up a new output stream to link java and the excel file
			workbook.write(fileOut);		//after the loop ends it sends all that data to the 'fileOut' output stream to be written to the excel file
			workbook.close();				//closes the workbook to finish
			fileOut.close();				//closes the fileOut stream
			
			writeFile(user,login,mLoginNumber); 		//runs the entire method again, this makes sure to log the person who made the program create the excel file
		}
		else{												//If the file does exist run this code													
			String fileName = "Activity Log.xls";			//sets the file name
			String currentTime = getTime();					//runs the 'getTime' method and saves its return value to 'currentTime'
			int cellX = findX(user);						//runs the 'findX' method and saves its return vales to 'cellX' , findX(name of user);
			int cellY = findY(cellX);						//runs the 'findY' method and saves its return value to 'cellY' , findY(x value);
			
				InputStream inp = new FileInputStream(fileName);		//Creates an input stream to read whats in the file
				Workbook wb = WorkbookFactory.create(inp);				//Create a work book with the workbookFactory method
				Sheet sheet = wb.getSheet("sheet1");					//create a sheet by getting the sheet called sheet1 in the workbook
				Row yCord = sheet.getRow(cellY);						// create a Row variable called 'yCord' from the 'cellY' variable
				Cell targetCell = yCord.getCell(cellX);					//create a cell variable called 'targetCell' by using yCord and getting the cell value from 'cellX'
				
				if(login){					//if login is true (you are logging in) run this block of code
					writeCell(sheet,cellX,cellY,"Log in @"+currentTime);		//calls the 'writeCell' method, writeCell(name of the sheet, x coordinate , y coordinate , text to be written);
					URL loginSound = Log.class.getResource("/sounds/login.wav");		//gets the login sound effect and saves it to the URL variable 'loginSound'
					playSound(loginSound);												//calls the 'playSound' method
					if (txtArea.getLineCount()>= 45){
						txtArea.setText(null);
					}
					txtArea.append(user + " logged in at:" + currentTime +"\r\n");		//does not write to excel file, writes to the live logging in the GUI
				}
				else{					// if login is false (you are logging out) run this block of code
					writeCell(sheet,cellX,cellY,"Log out @"+currentTime);		//calls 'writeCell', writeCell(name of the sheet, x coordinate , y coordinate , text to be written);
					
					String cellString = cellToString(targetCell);
					
					Row totalTime = sheet.getRow(1);
					Cell timeTarget = totalTime.getCell(cellX);
					
					if (timeTarget!=null){
						int loginLocation = cellString.lastIndexOf("Log in @");
						int newTime =hourComp(cellString.substring(loginLocation + 8, loginLocation+12),currentTime);
						
					}
					URL logoutSound = Log.class.getResource("/sounds/logout.wav");			//gets the logout sound
					playSound(logoutSound);													//plays the logout sound
					if (txtArea.getLineCount()>= 45){
						txtArea.setText(null);
					}
					txtArea.append(user + " logged out at:" + currentTime +"\r\n");			//write to the live logging in the GUI
				}
				FileOutputStream fileOut = new FileOutputStream(fileName);					//create the fileoutput stream to write to the excel file
				wb.write(fileOut);						//write to the file
				fileOut.close();						//close the file stream
		} 
	}
	public static String getDate(){					//gets the current date on the system this program is running from
		DateFormat df = new SimpleDateFormat(" MM-dd-yy ");
		Date dateobj = new Date();
		return  df.format(dateobj);
	}
	public static String getTime(){					//gets the current time on the system this program is running from
		DateFormat df = new SimpleDateFormat(" HH,mm ");		//cant use : so replaced with ,
		Date dateobj = new Date();
		return  df.format(dateobj);
	}
	public static int findX(String username) throws IOException{		//find the x value by searching for the users name
		int result=0;			//creates result variable, will use this at the end of the method
		File fileName = new File ("Activity Log.xls");				//sets the file name
		FileInputStream fis = new FileInputStream(fileName);		//creates a input stream to read the file
		HSSFWorkbook wb = new HSSFWorkbook(fis);					//create a workbook from the input stream
		HSSFSheet ws = wb.getSheet("sheet1");						//get the sheet called sheet1 in the workbook
			
			
			int colNum = ws.getRow(0).getLastCellNum();		// colNum is the max x value (measured by the last cell in the first row)    // creates a 'colnum' variable and sets it to the number of the last column in the first row
		
			int y=0;			//creates a 'y' variable and sets it to 0 
			HSSFRow row = ws.getRow(y);		//creates a Row variable called 'row' and sets it to the row that is stated in 'y'
				for(int x=0; x<colNum ; x++){		//starts a for loop, creats 'x' variable, for as long as x is less than 'colNum' run this block of code, add 1 to x everytime the code is run
					HSSFCell cell = row.getCell(x);			//create a cell variable called 'cell' set it to the cell 'x'(x will grow each time the loop runs) in 'row'
					
					String value = cellToString(cell);			//finds the string that is in each cell by calling the cellToString method, cellToSting(a cell variable that you wish to convert to a string);
					if (Objects.equals(value, username)){			// if the string in the cell is the user name run the following code
						result= x;			//sets the 'result' variable to whatever 'x' is
						break;				//breaks out of the loop, we have found the x coordinate so there is no reason to continue 
					}						//if the string in the cell does not match the username continue looping
				}
				wb.close();			//close the workbook
				fis.close();		//close the file input stream
				return result;		//return the 'result' vairable to whoever called this method
		}
		
	public static int findY(int x) throws IOException, EncryptedDocumentException, InvalidFormatException{		//find the y coordinate by searching the first column for the current date
		String currentDate= getDate();		//calls the getDate() method and save it to 'currentDate'
		int result = 0;			//creates the 'result' variable and sets it to 0 
		File fileName = new File ("Activity Log.xls");			//sets the file name
		FileInputStream fis = new FileInputStream(fileName);		//create a file input stream to read the excel file
		HSSFWorkbook wb = new HSSFWorkbook(fis);				//create a work book from the file input stream
		HSSFSheet ws = wb.getSheet("sheet1");					//get the sheet called 'sheet1' from the file input stream

		int rowNum = ws.getLastRowNum() ;			//rowNum is the max y value. POI is 0 based		//get the highest y value with text in the cell (the last date an entry was made)
	
	
		for(int y=0; y<=rowNum; y++){					//start a for loop, create a 'y' variable, for as long as 'y' is less than 'rowNum' run this block of code, and 1 to 'y' everytime this code is run 
			HSSFRow row = ws.getRow(y);					//create a Row variable called 'row' from the worksheet with the 'y' value ('y' grows everytime)
			HSSFCell cell = row.getCell(0);				//looks at the first cell in the 'row' variable
			String value = cellToString(cell);			//calls the cell to string method, cellToSting(a cell variable that you wish to convert to a string);
			if (Objects.equals(value,currentDate )){		//if the value of the cell equals the current date run the following code
				 result = y;		//set 'result' to what ever 'y' is
				break;				//break out of the loop, we found the row that we need 
			}
			if(y==rowNum){			//if we loop through all of the rows and have not found the current date run this code	
				FileInputStream inp = new FileInputStream(fileName);		//create a new input stream to read from
			    Workbook wbf = WorkbookFactory.create(inp);			//create a workbook with the workbook factory method
			    FileOutputStream fileOut = new FileOutputStream(fileName);		//create a file output stream to write to the excel file
			    Sheet sheet = wbf.getSheet("sheet1");				//get the sheet called sheet one from the 'wbf' workbook
			    writeCell(sheet,0,rowNum+1, getDate());				//calls the writeCell method, the y value is 'rowNum' +1 to write in a new row
			     
			    
			    wbf.write(fileOut);		//write to the excel file
			    fileOut.close();		//close the output file stream
				
			    result = rowNum+1;		//set the result to 'rowNum' + 1
				break;					//break out of the loop
				
			}
		}
		wb.close();		//close the workbook at the start of the for loop
		return result;		//return the result to whoever called this method
	}
	@SuppressWarnings("deprecation")
	public static String cellToString(Cell cell){		//converts a cell to a string, cellToString(the cell that you are referencing);
		int type;		//creates a integer called 'type'
		Object result;		//creates a result object
		type=cell.getCellType();		//set 'type' to the cell type
		
		switch (type){			//switch between the possible outcomes of 'type'
		
		case 0 :  //numeric value		//if the type is a number set result to the numeric cell value
			result= cell.getNumericCellValue();
			break;						//break the switch loop
		case 1: //String value			//if the type is a string set result to the string cell value
			result= cell.getStringCellValue();
			break;						//break the switch loop
		default:		//the default is if 'type' fits none of the categories above
			throw new RuntimeException("This type of cell is not supported!");		//throws an exception
		}
		return result.toString();			//return the object variable 'result' as a string value
	}
	public static void writeCell(Sheet sheet, int x, int y, String cellContents){		//writes contents to a cell, writeCell(name of the sheet, x coordinate , y coordinate , text to be written);
		Row r = sheet.getRow(y);		//create a Row variable called 'r' and set it to the row 'y' in the Sheet 'sheet' 
		if (r==null){					//if the row given is blank this creates the row to be able to write to it
			r= sheet.createRow(y);
		}
		
		Cell c = r.getCell(x);		//creates a Cell variable called 'c' and gets the cell that is in row 'r' and is cell number 'x'
		if(c == null){			//if the cell is empty this creates it then writes to it
			c= r.createCell(x);
			c.setCellValue(cellContents);	//sets the value of the cell to whatever was passed to the method in 'cellContents'
		}
		else if(c != null){			//if the cell is not empty this saves what is in it
			String currentContents = c.getStringCellValue();		//saves what is currently in the cell in 'currentContents'
			c.setCellValue(currentContents +" "+ cellContents);		//writes to the cell, 'currentContents' + 'cellContents'		
		}
	}
	public static void playSound(URL Sound){		//plays a sound from the system, playSound (URL of the sound you want to play)
		
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(Sound));
			clip.start();
		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
			e.printStackTrace();
		}
		
	}
	public static int hourComp (String loginTime, String logoutTime){
		int hours=0;
		
		return hours;
	}
	public static void shutdownCheck() throws EncryptedDocumentException, InvalidFormatException, IOException{			//Shutdown checks, logs anyone out who is logged in when you close the program, 
		Set set = objMap.entrySet();																		//this prevents someone having a login time with out a log out time
	
		//get an iterator
		Iterator i = set.iterator();		//set an iterator
		int userLoopID;			//create a 'userLoopID' variable and set it to 0
		String userLoopName;
		
		while(i.hasNext()){				//start the while loop, while there are still more people in the hashmap loop this code
			Map.Entry me = (Map.Entry)i.next();		//create a map entry of 'i'
			Students userLoop = objMap.get(me.getKey());			//create a JLable variable called 'userLoop' and set it to the key of the current map entry
			if (userLoop.state){		//if that user is enabled run this code
				userLoopName = userLoop.name;		//create a 'userLoopName' variable and get the name from the 'userLoop'
				userLoopID = userLoop.studentID;
				
				userLoop.state = false;		//set the JLabel 'userLoop' to disabled (logged out)
				writeFile(userLoopName , false ,userLoopID );		//write the change to the excle file
						}
					}
		System.exit(0);			//close the program  
			}
}
