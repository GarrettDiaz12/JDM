# CRUD                                                                               Diaz Cervera Brian Noe

Desarrolle un programa con un formulario de registro en donde se muestren controles para los diferentes campos de información, una tabla en la parte inferior de la ventana y los botones para agregar, borrar y modificar la información tanto en la tabla (JTable) como en la base de datos.
# Problemática a resolver
Usted ha sido contratado para desarrollar un Software para gestionar el ingreso de personas a un edificio comercial. Dicho Software estará en capacidad de realizar las acciones básicas para la manipulación de la base de datos (CRUD) de cada persona que ingrese al establecimiento se deberá recolectar: Tipo Documento. Identificación. Nombres. Fecha y hora de Ingreso. A quien Visita. Motivo.
# Características solicitadas 
- a) Conectarse al servidor de la base de datos. (Base de datos en red, remota). Crear una interfaz para poder cambiar los valores de conexión a la base de datos. Estos valores deben de guardarse en un archivo de configuración. utilizar un Administrador de esquemas BoxLayout para armar esta interfaz. 
- b) Registrar en la base de datos todas las personas que ingresen al establecimiento, utilizar un Administrador de esquemas GridBagLayout para armar esta interfaz. 
- c) Mostrar el listado de todas las personas que ingresaron (Usar un JTable, debe de permitir realizar scroll en caso de que la lista sobrepase el área visible): Posibilidad de actualizar los datos en caso de errores al momento del registro. Posibilidad de eliminar registros de personas registradas.
- e) Utilice una interfaz de múltiples documentos (MDI): una ventana principal (a la que se le conoce comúnmente como la ventana padre) que contiene otras ventanas (a las que se les conoce comúnmente como ventanas hijas), para administrar varios documentos abiertos que se procesan en paralelo. Utilizar un menú para abrir las diferentes interfaces.
# Pre-requisitos 
- Un de java en este caso (IDE. NetBeans 8.2) 
- Librerías como:
  import java.sql.Connection;
  import java.sql.DriverManager;
  import java.sql.ResultSet;
  import java.sql.SQLException;
  import java.sql.Statement;
  import javax.swing.JOptionPane;
  import java.text.DateFormat;
  import java.text.SimpleDateFormat;
  import java.util.Date;
  import java.awt.BorderLayout;
  import java.awt.Dimension;
  import java.awt.GridLayout;
  import java.awt.event.ActionEvent;
  import java.awt.event.ActionListener;
  import java.awt.event.KeyAdapter;
  import java.awt.event.KeyEvent;
  import java.awt.event.MouseAdapter;
  import java.awt.event.MouseEvent;
  import java.sql.ResultSet;
  import java.sql.ResultSetMetaData;
  import java.sql.SQLException;
  import javax.swing.JButton;
  import javax.swing.JFrame;
  import javax.swing.JLabel;
  import javax.swing.JOptionPane;
  import javax.swing.JPanel;
  import javax.swing.JScrollPane;
  import javax.swing.JTable;
  import javax.swing.JTextField;
  import javax.swing.table.DefaultTableModel;







# Construido con:
-	BoxLayout
-	GridBagLayout
-	JTable
-	JButton
-	Eventos del mouse
-	Driver JDBC
-	XAMPP
-	Creación de base de datos
-	JscrollPanel
-	FreeMysql
-	Dateformart

# Agradecimientos
Agradezco a el maestro por orientarlo levy por la orientación sobre el tema y a mi compañero Leonel Aguirre en ayudarme con las complicaciones que se me presentaron durante en desarrollo.

# Bibliografía
https://platform.netbeans.org/tutorials/nbm-crud.html
file:///C:/Users/valti/Downloads/Como%20programar%20en%20Java%20-%207ma%20Edicion%20-%20P.%20J.%20Deitel.pdf
http://javapiola.blogspot.com/2009/11/tutorial-jtable.html
http://chuwiki.chuidiang.org/index.php?title=GridLayout
http://panamahitek.com/comunicar-java-con-base-de-datos-mysql/
http://chuwiki.chuidiang.org/index.php?title=JScrollPane
https://www.javatpoint.com/java-gridbaglayout

# Ejecución:
https://youtu.be/0P_F7FttJGE
