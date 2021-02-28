# DemoQA
A Demp project to Write the Framework for the work

**About the Project** 
This Project is where in we must register a Student with personal information. The Project has 6 sections for which framework has to written. The 6 Sectons are:
1. Enter all details into the student registration form and submit
2. Click on the second button and accept the alert
3. Hover over the button and the input field
4. Drag and drop element into specific area
5. Close the small modal
6. Use the date picker to set the date to 1 month in the future

**Files to Be Modified Before Execution**
1. In the File "**RegistrationTestScript.java**" present in driverFactory folder please make the changes:
    i.  "**G:\\anujava\\Demoqa\\PropertyFile\\Project.properties**" to the file of your specified computer
    ii. "**G:\\anujava\\drivers\\chromedriver_win32\\chromedriver.exe**" to the file of your specified computer
    iii. "**G:\\anujava\\Demoqa\\CommonDrivers\\geckodriver.exe**" to the file of your specified computer
    iv. "**C:\\Users\\Personal\\Pictures\\1970-01\\ganesh.jpg**" to the file of your specified computer. This is the image that will be uploaded as part of the registration     
         process.

    Make the above changes (i, ii & iii) for all the files available in the driver factory - **AlertTestScript.java, DatePickerTestScript.java, DragAndDropTestScript.java,**  
    **ModalTestScript.java and ToolTipTestScript.java**
    
**Files to be Executed in order**
1. Enter all details into the student registration form and submit - Run the Test Script - **RegistrationTestScript.java**
2. Click on the second button and accept the alert - Run the Test Script -  **AlertTestScript.java**
3. Hover over the button and the input field - Run the Test Script -  **ToolTipTestScript.java**
4. Drag and drop element into specific area -v **DragAndDropTestScript.java**
5. Close the small modal - Run the Test Script -  **ModalTestScript.java**
6. Use the date picker to set the date to 1 month in the future - Run the Test Script -  **DatePickerTestScript.java**

**Reports that shows to status of the Status**
Additionally, I have developed the Reports which shows whether the report is successful or not. I have created the folder "**ExtentReports**" and the HTML reports are placed here. The reports are as follows:
1.  Alerts.html
2.  Datepicker.html
3.  DragandDrop.html
4.  Modal.html
5.  Registration.html
6.  tootip.html
