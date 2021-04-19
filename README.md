# attraction-analyzer

Classes:
AttractionAnalyser.Java
Program Execution starts from this class. It creates a scene for the welcome pane. And load it.

FxmlDocumentController.java
This is the controller for Welcome Page. It initializes the welcome page and loads Dashboard as the user clicks on the start button.

FXMLDocument.fxml
This is the design file for Welcome pane.

DashBoard.fxml
This is the design file for Dashboard. It contains text fields, buttons, pane, labels and grid view.

DashBoardController.java
It is the controller class for the dashboard. This class communicates with db. and load data into grid view. It also controls the search field and facts buttons.
It creates a corresponding scene to facts buttons. 


ViewHelper.java
This class helps DashBoardController class to read data from database and store that data in helper class.


Fact1Controller.java
This class analysed db data on runtime and Generated bar chart based on results which shows the number of existed placed in ireland.

Fact2Controller.java
This class analysed db data on runtime and Generated pie chart based on places in regions results.

Fact3Controller.java
This class analysed db data on runtime and Generated pointer graphs of Most visited places based on popularity results.

Fact1.fxml
Designer file for Fact 1 (number of existed placed in ireland)

Fact2.fxml
Designer file for Fact 2 (pie chart based on places in regions)

Fact3.fxml
Designer file for Fact 3  (Most visited places based on popularity)


Description of Core Functionalities:
This project was developed using MySQL workbench, Attraction Data from arish Government,
started in eclipes but to use java fxml scene builder i shifted on NetBeans. was having some jdk virsion issue i am now using jdk1.8.0_144

NetBeans 8.1
Oracle 8.1
Mysql 8.017
Jdbc 8.017

This project analyses data generating interesting facts about places in Ireland. It provides the flexible searching of any place.
User can search any place by its tag, name or region of place. It provides 3 different types of facts about given data.
These facts are calculated on runtime. If we change data in the database the facts will automatically change. These facts are represented by 4 different types of graphs. 

Optional Functionality:
➔	Better Java graphics 
➔	Use of different types of graphs
➔	Flexible queries and runtime facts calculation 

Functionalities could be added:
➔	Use of different animation to improve look and feel
➔	More facts implementation 
➔	Customizable Queries
➔ better Commenting.. but i did attached the link of my video demo explaning the code :)
