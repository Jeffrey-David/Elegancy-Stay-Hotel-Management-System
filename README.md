# Elegancy-Stay-Hotel-Management-System
An hotel management system with the use of JSPs and Java Servlets.
## Objective:
The Objective of our project is to design, develop, and deploy a dynamic hotel booking website using programming languages to showcase the technical expertise and capabilities of our team members. Our team goal is to create an advanced hotel booking website that is user friendly and not only caters to the hotel's booking specific requirements but also demonstrates creativity of web development techniques. 
The primary purpose of this project is to streamline the hotel booking process, enhance user experience, and provide an efficient solution for managing room reservations. The project targets both customers and hotel administrators, offering the following key features.
______________________________________________
## Features completed:

### Admin Side:

#### 1.	Admin Registration Functionality
●	The registration page is a form to collect personal data of the admin along with E-mail ID and password. This data is sent to the servlet.

●	A hashing function is created with (email+password) as salt and hashes using SHA-512.

●	The servlet uses the hashing function to hash the password and then it uses DBFactory class to connect to database and insert the data along with Email ID and hashed password.

#### 2.	Admin Login Functionality
●	The login page is a form to collect email ID and Password. The data is sent to the servlet.

●	The servlet hashes the password using the same hashing function and checks with the database to authenticate.

#### 3.	Add Rooms
●	The Add Rooms page is a form where the admin can add new rooms by giving details and image for the room.

●	These details are sent to the servlet and stored in database. The image is stored as BLOB file.

#### 4.	List Rooms
●	List rooms page shows the different rooms that are in the database.

●	Each room has a delete button which will remove the room from database and a edit button to edit the room information.

#### 5.	List bookings 
●	List Bookings page shows the bookings that have been made by users. It has a view button that shows the specific booking with detailed information.

#### 6.	Visualize
●	The visualize button in homepage redirects to the page that asks for start and end date and has two buttons.

●	View Room Occupancy: This button redirects to a page that draws a bar chart of number of rooms booked for each room type int the date range.

●	View Daily Occupancy: This button redirects to a page that shows a line chart for each date within the date range with each line representing each room type.

#### 7.	List Queries
●	The list queries page shows the queries made by the users. The queries are sorted to show the unresolved ones at the top.

●	The unresolved queries have a Resolve button to make the query as resolved.

#### 8.	Search Functionality
●	The search button is placed at the top which can be used to find the list of functionalities.
__________________________________________________
### User Functionality

#### 1.	Book Room Functionality
●	The user is first navigated to a page which lists the different room types available from which the user can choose.

●	The user is redirected to a page that asks for Check-in and Check-out dates to check if the room is available on the dates.

●	If the room is available, it redirects to a form that collects all the data related to booking. The form has some fields like total cost that are calculated and non editable.

●	After Successful booking the user is shown with the success page.

#### 2.	View Bookings
●	The user can use this functionality to view their booking history.

●	The user is asked to enter his email ID and the booking related to the Email Id given is populated and has a button to pay if not paid.

#### 3.	Payment
●	The users can click the ‘Pay Now’ button in the View Bookings. 

●	It will redirect to a payment page that asks for payment method and card details.

#### 4.	Ask Query
●	Every page has a footer that has the ‘Contact Us’ link which redirects to the add query page.

●	The user can fill in their Email ID and query there. This would be then saved to the database.

#### 5.	Search Functionality
●	The search button is used to find the list of functionalities that are available for users.
__________________________________________________

### Setup Guide:

●	Download and install JRE version 17.

●	Download and install XAMPP.

●	Download and import the WAR file into your development environment.

●	The database is deployed in the AWS RDS instance and the project automatically uses it.

●	Use the provided database setup queries to create tables and insert dummy data if you want to create an own database. You will also have to change the DBFactory.

●	Configure the database connection in your project.

●	Ensure Apache Tomcat 10.1 is installed.

●	Configure your project to run on the Tomcat server.

●	Deploy the project and access it in a web browser for testing.
__________________________________________________

### Screenshots

![image](https://github.com/Jeffrey-David/Elegancy-Stay-Hotel-Management-System/assets/66271004/d788edb8-f2a0-40f2-8827-c6cfd57c56f5)

![image](https://github.com/Jeffrey-David/Elegancy-Stay-Hotel-Management-System/assets/66271004/d04de799-7ca2-4c15-ad06-bf9aaad8a934)

![image](https://github.com/Jeffrey-David/Elegancy-Stay-Hotel-Management-System/assets/66271004/217f2a07-646e-4404-880e-94b82b8a2e67)


![image](https://github.com/Jeffrey-David/Elegancy-Stay-Hotel-Management-System/assets/66271004/256efb08-816a-4e86-a4ad-36f6df69e19b)

