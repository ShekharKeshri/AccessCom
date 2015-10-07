package com.tsm.accesscom.v1.design;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle.ComponentPlacement;


//import org.apache.log4j.Logger;
import com.maxoptra.api.v1.client.TSMRestClient;
import com.maxoptra.api.v1.enums.HTTP_METHOD;
import com.maxoptra.api.v1.model.response.Aoc;
import com.maxoptra.api.v1.model.response.ApiResponse;
import com.maxoptra.api.v1.model.response.Location;
import com.maxoptra.api.v1.model.response.Order;
import com.maxoptra.api.v1.model.response.Performer;
import com.maxoptra.api.v1.model.response.Vehicle;
import com.tsm.accesscom.v1.client.TestAutoScheduling;
import com.tsm.accesscom.v1.util.DateFormat;
import com.tsm.accesscom.v1.util.MaxOptraConfigurationReader;

public class DesignedFrame extends TSMRestClient {

	//final static Logger logger = Logger.getLogger(DesignedFrame.class);

	private JFrame frame;
	private JLabel authenticateLabel;
	private JLabel saveOrderLabel;
	private JLabel updateOrderLabel;
	private JLabel orderStatusLabel;
	private JLabel deleteOrderLabel;
	private JLabel areaOfControls;
	private JLabel getVehicleLabel;
	private JLabel getVehiclesByAocLabel;
	private JLabel getScheduleByVehicleOnDateLabel;
	private JLabel getScheduleByAOCOnDateLabel;
	private JLabel authenticateSchedule;
	private String displayContent;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

//		if (logger.isDebugEnabled()) {
//			logger.debug("This is debug : ");
//		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DesignedFrame window = new DesignedFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
//					if (logger.isDebugEnabled()) {
//						logger.debug("Exception ........................."
//								+ e.getMessage());
//					}
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DesignedFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\Admin\\Desktop\\tsm.png"));
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setBackground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 1071, 613);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/********************************************************* Start Of Authentication Panel ************************************************************************************/

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(new Color(255, 255, 255));
		tabbedPane.setBackground(new Color(0, 0, 0));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING).addGroup(
				groupLayout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE,
								916, Short.MAX_VALUE).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING).addGroup(
				groupLayout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE,
								513, Short.MAX_VALUE).addContainerGap()));

		JPanel panel = new JPanel();
		tabbedPane.addTab("Authenticate", null, panel, null);

		authenticateLabel = new JLabel("New label");

		JButton btnNewButton = new JButton("Authenticate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					// ********************Authenticate
					// User*******************************//
					ApiResponse apiResponse = callRestAPI(
							MaxOptraConfigurationReader
									.getDefaultProperty("maxoptra.url.authenticate"),
							HTTP_METHOD.POST, "Authenticate User", null);
					// *******************************************************************//

				} catch (Exception ex) {
					ex.printStackTrace();
//					if (logger.isDebugEnabled()) {
//						logger.debug("Exception ........................."
//								+ ex.getMessage());
//					}
				}
				authenticateLabel.setText("Authentication Successful !");

			}
		});

		panel.setBackground(new Color(255, 222, 173));

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING)
												.addGroup(
														gl_panel.createSequentialGroup()
																.addGap(349)
																.addComponent(
																		authenticateLabel))
												.addGroup(
														gl_panel.createSequentialGroup()
																.addGap(332)
																.addComponent(
																		btnNewButton)))
								.addContainerGap(629, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel.createSequentialGroup().addGap(174)
						.addComponent(authenticateLabel).addGap(63)
						.addComponent(btnNewButton)
						.addContainerGap(273, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);

		/********************************************************* End Of Authentication Panel **************************************************************************************/

		/********************************************************* Start Of Save Order Panel ***************************************************************************************/
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 222, 173));
		tabbedPane.addTab("Save Order", null, panel_1, null);

		saveOrderLabel = new JLabel("New label");

		JButton btnSaveOrder = new JButton("Save Order");
		btnSaveOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					// ********************Authenticate
					// User*******************************//
					ApiResponse apiResponse = callRestAPI(
							MaxOptraConfigurationReader
									.getDefaultProperty("maxoptra.url.authenticate"),
							HTTP_METHOD.POST, "Authenticate User", null);
					// *******************************************************************//

					saveOrderLabel.setText("Authentication Successful !");

					// ********************Save
					// Order**************************************//
					apiResponse = callRestAPI(MaxOptraConfigurationReader
							.getDefaultProperty("maxoptra.url.saveOrder"),
							HTTP_METHOD.POST, "Save Order", apiResponse);
					// ********************************************************************//

					displayContent = "<html>";
					for (Order order : apiResponse.getOrders().getOrder()) {
						displayContent += order;
						displayContent += "<br>";
					}
					displayContent += "</html>";

					saveOrderLabel.setText(displayContent);
				} catch (Exception ex) {
					ex.printStackTrace();
//					if (logger.isDebugEnabled()) {
//						logger.debug("Exception ........................."
//								+ ex.getMessage());
//					}
				}
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(
				Alignment.LEADING).addGroup(
				Alignment.TRAILING,
				gl_panel_1
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(saveOrderLabel, GroupLayout.DEFAULT_SIZE,
								749, Short.MAX_VALUE).addGap(18)
						.addComponent(btnSaveOrder).addGap(186)));
		gl_panel_1
				.setVerticalGroup(gl_panel_1
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_1
										.createSequentialGroup()
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_1
																		.createSequentialGroup()
																		.addGap(98)
																		.addComponent(
																				btnSaveOrder))
														.addGroup(
																gl_panel_1
																		.createSequentialGroup()
																		.addGap(39)
																		.addComponent(
																				saveOrderLabel,
																				GroupLayout.PREFERRED_SIZE,
																				479,
																				GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(29, Short.MAX_VALUE)));
		panel_1.setLayout(gl_panel_1);

		/********************************************************* End Of Save Order Panel ***************************************************************************************/

		/********************************************************* Start Of Update Order Panel ***********************************************************************************/

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 222, 173));
		tabbedPane.addTab("Update Order", null, panel_2, null);

		updateOrderLabel = new JLabel("New label");

		JButton btnUpdateOrder = new JButton("Update Order");
		btnUpdateOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					// ********************Authenticate
					// User*******************************//
					ApiResponse apiResponse = callRestAPI(
							MaxOptraConfigurationReader
									.getDefaultProperty("maxoptra.url.authenticate"),
							HTTP_METHOD.POST, "Authenticate User", null);
					// *******************************************************************//

					saveOrderLabel.setText("Authentication Successful !");

					// ********************Update
					// Order**************************************//
					apiResponse = callRestAPI(MaxOptraConfigurationReader
							.getDefaultProperty("maxoptra.url.updateOrder"),
							HTTP_METHOD.POST, "Update Order", apiResponse);
					// ********************************************************************//
					displayContent = "<html>";
					for (Order order : apiResponse.getOrders().getOrder()) {
						// System.out.println("apiResponse : "+order);
						if (order != null) {
							displayContent += order;
							displayContent += "<br>";
						}
					}
					displayContent += "</html>";

					updateOrderLabel.setText(displayContent);

				} catch (Exception ex) {
					ex.printStackTrace();
//					if (logger.isDebugEnabled()) {
//						logger.debug("Exception ........................."
//								+ ex.getMessage());
//					}
				}
			}
		});
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(
				Alignment.LEADING).addGroup(
				Alignment.TRAILING,
				gl_panel_2
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(updateOrderLabel,
								GroupLayout.DEFAULT_SIZE, 807, Short.MAX_VALUE)
						.addGap(18).addComponent(btnUpdateOrder).addGap(116)));
		gl_panel_2
				.setVerticalGroup(gl_panel_2
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_2
										.createSequentialGroup()
										.addGroup(
												gl_panel_2
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_2
																		.createSequentialGroup()
																		.addGap(76)
																		.addComponent(
																				btnUpdateOrder))
														.addGroup(
																gl_panel_2
																		.createSequentialGroup()
																		.addGap(28)
																		.addComponent(
																				updateOrderLabel,
																				GroupLayout.PREFERRED_SIZE,
																				491,
																				GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(28, Short.MAX_VALUE)));
		panel_2.setLayout(gl_panel_2);

		/********************************************************* End Of Update_Order_Panel ***************************************************************************************/

		/********************************************************* End Of Order_Status Panel ***************************************************************************************/

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 222, 173));
		tabbedPane.addTab("Order Status", null, panel_3, null);

		orderStatusLabel = new JLabel("New label");

		JButton btnOrderStatus = new JButton("Order Status");
		btnOrderStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// ********************Authenticate
					// User*******************************//
					ApiResponse apiResponse = callRestAPI(
							MaxOptraConfigurationReader
									.getDefaultProperty("maxoptra.url.authenticate"),
							HTTP_METHOD.POST, "Authenticate User", null);
					// *******************************************************************//

					orderStatusLabel.setText("Authentication Successful !");

					// ********************Save
					// Order**************************************//
					apiResponse = callRestAPI(MaxOptraConfigurationReader
							.getDefaultProperty("maxoptra.url.saveOrder"),
							HTTP_METHOD.POST, "Save Order", apiResponse);
					// ********************************************************************//

					// ********************Order
					// Status***********************************//
					String orderString = "";
					for (Order order : apiResponse.getOrders().getOrder()) {
						if (!orderString.equalsIgnoreCase("")) {
							orderString += "*";
						}
						orderString += order.getOrderReference();
					}
					com.maxoptra.api.v1.model.order.status.response.ApiResponse response = callRestAPIForOrderStatus(
							MaxOptraConfigurationReader
									.getDefaultProperty("maxoptra.url.orderStatus")
									+ "?sessionID="
									+ sessionId
									+ "&orders="
									+ orderString, HTTP_METHOD.POST,
							"Order Status", apiResponse);
					// *******************************************************************//

					displayContent = "<html>";
					for (com.maxoptra.api.v1.model.order.status.response.Order order : response
							.getOrderStatusResponse().getOrders().getOrder()) {
						displayContent += order;
						// buffer.append(System.getProperty("line.separator"));
						displayContent += "<br>";
					}
					displayContent += "</html>";

					orderStatusLabel.setText(displayContent);
					// orderStatusLabel.setText("apiResponse : "+buffer);
				} catch (Exception ex) {
					ex.printStackTrace();
//					if (logger.isDebugEnabled()) {
//						logger.debug("Exception ........................."
//								+ ex.getMessage());
//					}
				}
			}

		});
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(gl_panel_3.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel_3
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(orderStatusLabel,
								GroupLayout.PREFERRED_SIZE, 775,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnOrderStatus)
						.addContainerGap(166, Short.MAX_VALUE)));
		gl_panel_3
				.setVerticalGroup(gl_panel_3
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_3
										.createSequentialGroup()
										.addGroup(
												gl_panel_3
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_3
																		.createSequentialGroup()
																		.addGap(98)
																		.addComponent(
																				btnOrderStatus))
														.addGroup(
																gl_panel_3
																		.createSequentialGroup()
																		.addGap(19)
																		.addComponent(
																				orderStatusLabel,
																				GroupLayout.PREFERRED_SIZE,
																				481,
																				GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(47, Short.MAX_VALUE)));
		panel_3.setLayout(gl_panel_3);

		/********************************************************* End Of Order_Status Panel ***************************************************************************************/

		/********************************************************* Start Of Delete Order Panel *************************************************************************************/

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 222, 173));
		tabbedPane.addTab("Delete Order", null, panel_4, null);

		deleteOrderLabel = new JLabel("New label");

		JButton btnDeleteOrder = new JButton("Delete Order");
		btnDeleteOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// ********************Authenticate
					// User*******************************//
					ApiResponse apiResponse = callRestAPI(
							MaxOptraConfigurationReader
									.getDefaultProperty("maxoptra.url.authenticate"),
							HTTP_METHOD.POST, "Authenticate User", null);
					// *******************************************************************//

					orderStatusLabel.setText("Authentication Successful !");

					// ********************Save
					// Order**************************************//
					apiResponse = callRestAPI(MaxOptraConfigurationReader
							.getDefaultProperty("maxoptra.url.saveOrder"),
							HTTP_METHOD.POST, "Save Order", apiResponse);
					// ********************************************************************//

					// *******************Delete
					// Order************************************//
					apiResponse = callRestAPI(MaxOptraConfigurationReader
							.getDefaultProperty("maxoptra.url.deleteOrder"),
							HTTP_METHOD.POST, "Delete Order", apiResponse);
					// *******************************************************************//

					displayContent = "<html>";
					for (Order order : apiResponse.getOrders().getOrder()) {
						// System.out.println("apiResponse : "+order);
						if (order != null) {
							displayContent += order;
							displayContent += "<br>";
						}
					}
					displayContent += "</html>";

					deleteOrderLabel.setText(displayContent);
				} catch (Exception ex) {
					ex.printStackTrace();
//					if (logger.isDebugEnabled()) {
//						logger.debug("Exception ........................."
//								+ ex.getMessage());
//					}
				}
			}
		});
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4
				.setHorizontalGroup(gl_panel_4
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_4
										.createSequentialGroup()
										.addGroup(
												gl_panel_4
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_4
																		.createSequentialGroup()
																		.addGap(435)
																		.addComponent(
																				deleteOrderLabel))
														.addGroup(
																gl_panel_4
																		.createSequentialGroup()
																		.addGap(422)
																		.addComponent(
																				btnDeleteOrder)))
										.addContainerGap(539, Short.MAX_VALUE)));
		gl_panel_4.setVerticalGroup(gl_panel_4.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel_4.createSequentialGroup().addGap(171)
						.addComponent(deleteOrderLabel).addGap(52)
						.addComponent(btnDeleteOrder)
						.addContainerGap(287, Short.MAX_VALUE)));
		panel_4.setLayout(gl_panel_4);

		/********************************************************* End Of Delete Order Panel *************************************************************************************/

		/********************************************************* Start Of Area_Of_Controls Panel ***************************************************************************************/

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 222, 173));
		tabbedPane.addTab("Area Of Controls", null, panel_5, null);

		areaOfControls = new JLabel("New label");

		JButton btnAreaOfControls = new JButton("Area Of Controls");
		btnAreaOfControls.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					// ********************Authenticate
					// User*******************************//
					ApiResponse apiResponse = callRestAPI(
							MaxOptraConfigurationReader
									.getDefaultProperty("maxoptra.url.authenticate"),
							HTTP_METHOD.POST, "Authenticate User", null);
					// *******************************************************************//

					// *******************Area_Of_Controls********************************//
					apiResponse = callRestAPI(
							MaxOptraConfigurationReader
									.getDefaultProperty("maxoptra.url.getAreaOfControls")
									+ "?sessionID=" + sessionId,
							HTTP_METHOD.POST, "Area_Of_Controls", apiResponse);
					// *******************************************************************//

					displayContent = "<html>";
					for (Aoc aoc : apiResponse.getAreaOfControlResponse()
							.getAocs().getAoc()) {
						// System.out.println("apiResponse : "+order);
						displayContent += "Aoc Id: " + aoc.getId();
						displayContent += "   Aoc Name: " + aoc.getId();
						displayContent += "<br>";
					}
					displayContent += "</html>";

					areaOfControls.setText(displayContent);
				} catch (Exception ex) {
					ex.printStackTrace();
//					if (logger.isDebugEnabled()) {
//						logger.debug("Exception ........................."
//								+ ex.getMessage());
//					}
				}
			}
		});
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5
				.setHorizontalGroup(gl_panel_5
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_5
										.createSequentialGroup()
										.addGroup(
												gl_panel_5
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_5
																		.createSequentialGroup()
																		.addGap(420)
																		.addComponent(
																				areaOfControls))
														.addGroup(
																gl_panel_5
																		.createSequentialGroup()
																		.addGap(392)
																		.addComponent(
																				btnAreaOfControls)))
										.addContainerGap(545, Short.MAX_VALUE)));
		gl_panel_5.setVerticalGroup(gl_panel_5.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel_5.createSequentialGroup().addGap(162)
						.addComponent(areaOfControls).addGap(79)
						.addComponent(btnAreaOfControls)
						.addContainerGap(269, Short.MAX_VALUE)));
		panel_5.setLayout(gl_panel_5);

		/********************************************************* End Of Area_Of_Controls Panel ***************************************************************************************/

		/********************************************************* Start Of Get_Vehicless Panel ****************************************************************************************/

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 222, 173));
		tabbedPane.addTab("Get Vehicles", null, panel_6, null);

		getVehicleLabel = new JLabel("New label");

		JButton btnGetVechicles = new JButton("Get Vehicles");
		btnGetVechicles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// ********************Authenticate
					// User*******************************//
					ApiResponse apiResponse = callRestAPI(
							MaxOptraConfigurationReader
									.getDefaultProperty("maxoptra.url.authenticate"),
							HTTP_METHOD.POST, "Authenticate User", null);
					// *******************************************************************//

					// *******************Get
					// Vehicles********************************//
					apiResponse = callRestAPI(
							MaxOptraConfigurationReader
									.getDefaultProperty("maxoptra.url.getVehicles")
									+ "?sessionID="
									+ sessionId
									+ "&date="
									+ DateFormat.getTodayDateInString(),
							HTTP_METHOD.POST, "Get_Vehicles", apiResponse);
					// *******************************************************************//

					displayContent = "<html>";

					displayContent += "Units";
					displayContent += "<br>";
					displayContent += "timeZone : "
							+ apiResponse.getVehiclesResponse().getUnits()
									.getTimeZone();
					displayContent += "  timeZoneOffset : "
							+ apiResponse.getVehiclesResponse().getUnits()
									.getTimeZoneOffset();
					displayContent += "  currency : "
							+ apiResponse.getVehiclesResponse().getUnits()
									.getCurrency();
					displayContent += "  distanceUnits : "
							+ apiResponse.getVehiclesResponse().getUnits()
									.getDistanceUnits();
					displayContent += "  speedUnits : "
							+ apiResponse.getVehiclesResponse().getUnits()
									.getSpeedUnits();
					displayContent += "  durationUnits : "
							+ apiResponse.getVehiclesResponse().getUnits()
									.getDurationUnits();

					for (Vehicle vechicle : apiResponse.getVehiclesResponse()
							.getVehicles().getVehicle()) {
						displayContent += "Vehicle";
						displayContent += "<br>";
						displayContent += "id : " + vechicle.getId();
						displayContent += "  name : " + vechicle.getName();
						displayContent += "  active : " + vechicle.getActive();
						displayContent += "  driverName : "
								+ vechicle.getDriverName();
						displayContent += "  driverPhone : "
								+ vechicle.getDriverPhone();
						displayContent += "  costByDistance : "
								+ vechicle.getCostByDistance();
						displayContent += "  availabilityStartTime : "
								+ vechicle.getAvailabilityStartTime();
						displayContent += "  availabilityEndTime : "
								+ vechicle.getAvailabilityEndTime();
						displayContent += "  aocId : " + vechicle.getAocId();
						displayContent += "<br>";
					}

					displayContent += "</html>";
					getVehicleLabel.setText(displayContent);
				} catch (Exception ex) {
					ex.printStackTrace();
//					if (logger.isDebugEnabled()) {
//						logger.debug("Exception ........................."
//								+ ex.getMessage());
//					}
				}
			}
		});
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6
				.setHorizontalGroup(gl_panel_6
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_6
										.createSequentialGroup()
										.addGroup(
												gl_panel_6
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_6
																		.createSequentialGroup()
																		.addGap(449)
																		.addComponent(
																				getVehicleLabel))
														.addGroup(
																gl_panel_6
																		.createSequentialGroup()
																		.addGap(428)
																		.addComponent(
																				btnGetVechicles)))
										.addContainerGap(527, Short.MAX_VALUE)));
		gl_panel_6.setVerticalGroup(gl_panel_6.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel_6.createSequentialGroup().addGap(207)
						.addComponent(getVehicleLabel).addGap(59)
						.addComponent(btnGetVechicles)
						.addContainerGap(244, Short.MAX_VALUE)));
		panel_6.setLayout(gl_panel_6);

		/********************************************************* End Of Get_Vehicles Panel ****************************************************************************************/

		/********************************************************* Start Of Get_Vehicles_By_Aoc Panel ****************************************************************************************/

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(255, 222, 173));
		tabbedPane.addTab("Get Vehicles By Aoc", null, panel_7, null);

		getVehiclesByAocLabel = new JLabel("New label");

		JButton btnGetVechiclesBy = new JButton("Get Vehicles By AOC");
		btnGetVechiclesBy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// ********************Authenticate
					// User*******************************//
					ApiResponse apiResponse = callRestAPI(
							MaxOptraConfigurationReader
									.getDefaultProperty("maxoptra.url.authenticate"),
							HTTP_METHOD.POST, "Authenticate User", null);
					// *******************************************************************//

					// *******************Get
					// Vehicles_By_Aoc********************************//
					apiResponse = callRestAPI(
							MaxOptraConfigurationReader
									.getDefaultProperty("maxoptra.url.getVehiclesByAoc")
									+ "?sessionID="
									+ sessionId
									+ "&aocID=320&date="
									+ DateFormat.getTodayDateInString(),
							HTTP_METHOD.POST, "Vehicles_By_Aoc", apiResponse);
					// *******************************************************************//

					displayContent = "<html>";

					displayContent += "Units";
					displayContent += "<br>";
					displayContent += "timeZone : "
							+ apiResponse.getVehiclesResponse().getUnits()
									.getTimeZone();
					displayContent += "  timeZoneOffset : "
							+ apiResponse.getVehiclesResponse().getUnits()
									.getTimeZoneOffset();
					displayContent += "  currency : "
							+ apiResponse.getVehiclesResponse().getUnits()
									.getCurrency();
					displayContent += "  distanceUnits : "
							+ apiResponse.getVehiclesResponse().getUnits()
									.getDistanceUnits();
					displayContent += "  speedUnits : "
							+ apiResponse.getVehiclesResponse().getUnits()
									.getSpeedUnits();
					displayContent += "  durationUnits : "
							+ apiResponse.getVehiclesResponse().getUnits()
									.getDurationUnits();

					for (Vehicle vechicle : apiResponse.getVehiclesResponse()
							.getVehicles().getVehicle()) {
						displayContent += "Vehicle";
						displayContent += "<br>";
						displayContent += "id : " + vechicle.getId();
						displayContent += "  name : " + vechicle.getName();
						displayContent += "  active : " + vechicle.getActive();
						displayContent += "  driverName : "
								+ vechicle.getDriverName();
						displayContent += "  driverPhone : "
								+ vechicle.getDriverPhone();
						displayContent += "  costByDistance : "
								+ vechicle.getCostByDistance();
						displayContent += "  availabilityStartTime : "
								+ vechicle.getAvailabilityStartTime();
						displayContent += "  availabilityEndTime : "
								+ vechicle.getAvailabilityEndTime();
						displayContent += "  aocId : " + vechicle.getAocId();
						displayContent += "<br>";
					}

					displayContent += "</html>";
					getVehiclesByAocLabel.setText(displayContent);
				} catch (Exception ex) {
					ex.printStackTrace();
//					if (logger.isDebugEnabled()) {
//						logger.debug("Exception ........................."
//								+ ex.getMessage());
//					}
				}
			}
		});
		GroupLayout gl_panel_7 = new GroupLayout(panel_7);
		gl_panel_7
				.setHorizontalGroup(gl_panel_7
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_7
										.createSequentialGroup()
										.addGroup(
												gl_panel_7
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_7
																		.createSequentialGroup()
																		.addGap(420)
																		.addComponent(
																				getVehiclesByAocLabel))
														.addGroup(
																gl_panel_7
																		.createSequentialGroup()
																		.addGap(392)
																		.addComponent(
																				btnGetVechiclesBy)))
										.addContainerGap(523, Short.MAX_VALUE)));
		gl_panel_7.setVerticalGroup(gl_panel_7.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel_7.createSequentialGroup().addGap(169)
						.addComponent(getVehiclesByAocLabel).addGap(70)
						.addComponent(btnGetVechiclesBy)
						.addContainerGap(271, Short.MAX_VALUE)));
		panel_7.setLayout(gl_panel_7);

		/********************************************************* End Of Get_Vehicles_By_Aoc Panel ****************************************************************************************/

		/********************************************************* Start Of Get_Schedule_By_AOC_On_Date Panel ****************************************************************************************/

		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(255, 222, 173));
		tabbedPane.addTab("Get Schedule By AOC On Date", null, panel_8, null);

		getScheduleByAOCOnDateLabel = new JLabel("New label");

		JButton btnGetScheduleBy = new JButton("Get Schedule By AOC On Date");
		btnGetScheduleBy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// ********************Authenticate
					// User*******************************//
					ApiResponse apiResponse = callRestAPI(
							MaxOptraConfigurationReader
									.getDefaultProperty("maxoptra.url.authenticate"),
							HTTP_METHOD.POST, "Authenticate User", null);
					// *******************************************************************//

					// *******************Get
					// Schedule_By_AOC_On_Date********************************//
					apiResponse = callRestAPI(
							MaxOptraConfigurationReader
									.getDefaultProperty("maxoptra.url.getScheduleByAOCOnDate")
									+ "?sessionID="
									+ sessionId
									+ "&date="
									+ DateFormat.getTodayDateInString()
									+ "&aocID=320", HTTP_METHOD.POST,
							"Schedule_By_AOC_On_Date", apiResponse);
					// *******************************************************************//

					// System.out.println("Units");
					displayContent = "<html>";
					for (Performer performer : apiResponse
							.getScheduleResponse().getPerformers()
							.getPerformer()) {
						displayContent += "Performer";
						displayContent += "<br>";
						displayContent += "id : " + performer.getId();
						displayContent += "<br>";
						displayContent += "vehicle : ";
						displayContent += "<br>";
						displayContent += "name : " + performer.getName();
						displayContent += "<br>";
						displayContent += "aocId : " + performer.getAocId();
						displayContent += "<br>";
						displayContent += "runDay : " + performer.getRunDay();
						displayContent += "<br>";
						displayContent += "planDistance : "
								+ performer.getPlanDistance();
						displayContent += "<br>";
						displayContent += "planDuration : "
								+ performer.getPlanDuration();
						displayContent += "<br>";
						displayContent += "runStartTime : "
								+ performer.getRunStartTime();
						displayContent += "<br>";
						displayContent += "runEndTime : "
								+ performer.getRunEndTime();
						displayContent += "<br>";
						displayContent += "availabilityStartTime : "
								+ performer.getAvailabilityStartTime();
						displayContent += "<br>";
						displayContent += "availabilityEndTime : "
								+ performer.getAvailabilityEndTime();
						displayContent += "<br>";
						displayContent += "cost : " + performer.getCost();
						displayContent += "<br>";

						for (Location location : performer.getLocation()) {
							System.out.println("Location");
							displayContent += "<br>";

							if (location.getNumber() != null) {
								System.out.println("number : "
										+ location.getNumber());
								displayContent += "<br>";
							}

							displayContent += "locationType : "
									+ location.getLocationType();
							displayContent += "<br>";
							displayContent += "name : " + location.getName();
							displayContent += "<br>";
							displayContent += "address : "
									+ location.getAddress();
							displayContent += "<br>";
							displayContent += "latitude : "
									+ location.getLatitude();
							displayContent += "<br>";
							displayContent += "longitude : "
									+ location.getLongitude();
							displayContent += "<br>";
							displayContent += "planArrivalTime : "
									+ location.getPlanArrivalTime();
							displayContent += "<br>";
							displayContent += "planDepartureTime : "
									+ location.getPlanDepartureTime();
							displayContent += "<br>";

							if (location.getOrder() != null) {
								displayContent += "Order";
								displayContent += "<br>";
								displayContent += "orderReference : "
										+ location.getOrder()
												.getOrderReference();
								displayContent += "<br>";
								displayContent += "status : "
										+ location.getOrder().getStatus();
								displayContent += "<br>";
								displayContent += "duration : "
										+ location.getOrder().getDuration();
								displayContent += "<br>";
								displayContent += "comments : "
										+ location.getOrder().getComments();
								displayContent += "<br>";
								displayContent += "instructions : "
										+ location.getOrder().getInstructions();
								displayContent += "<br>";
								displayContent += "price : "
										+ location.getOrder().getPrice();
								displayContent += "<br>";
							}
						}
					}

					displayContent += "</html>";

					getScheduleByAOCOnDateLabel.setText(displayContent);
				} catch (Exception ex) {
					ex.printStackTrace();
//					if (logger.isDebugEnabled()) {
//						logger.debug("Exception ........................."
//								+ ex.getMessage());
//					}
				}
			}
		});
		GroupLayout gl_panel_8 = new GroupLayout(panel_8);
		gl_panel_8.setHorizontalGroup(gl_panel_8.createParallelGroup(
				Alignment.LEADING).addGroup(
				Alignment.TRAILING,
				gl_panel_8
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(getScheduleByAOCOnDateLabel,
								GroupLayout.PREFERRED_SIZE, 801,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 16,
								Short.MAX_VALUE).addComponent(btnGetScheduleBy)
						.addGap(44)));
		gl_panel_8
				.setVerticalGroup(gl_panel_8
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_8
										.createSequentialGroup()
										.addGroup(
												gl_panel_8
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_8
																		.createSequentialGroup()
																		.addGap(51)
																		.addComponent(
																				btnGetScheduleBy))
														.addGroup(
																gl_panel_8
																		.createSequentialGroup()
																		.addGap(31)
																		.addComponent(
																				getScheduleByAOCOnDateLabel,
																				GroupLayout.DEFAULT_SIZE,
																				505,
																				Short.MAX_VALUE)))
										.addContainerGap()));
		panel_8.setLayout(gl_panel_8);

		/********************************************************* End Of Get_Schedule_By_AOC_On_Date Panel ****************************************************************************************/

		/********************************************************* Start Of Get_Schedule_By_Vehicle_On_Date Panel ****************************************************************************************/

		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(255, 222, 173));
		tabbedPane.addTab("Get Schedule By Vehicle On Date", null, panel_9,
				null);

		getScheduleByVehicleOnDateLabel = new JLabel("New label");

		JButton btnGetScheduleBy_1 = new JButton(
				"Get Schedule By Vehicle On Date");
		btnGetScheduleBy_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// ********************Authenticate
					// User*******************************//
					ApiResponse apiResponse = callRestAPI(
							MaxOptraConfigurationReader
									.getDefaultProperty("maxoptra.url.authenticate"),
							HTTP_METHOD.POST, "Authenticate User", null);
					// *******************************************************************//

					// *******************Get
					// Schedule_By_Vehicle_On_Date********************************//
					apiResponse = callRestAPI(
							MaxOptraConfigurationReader
									.getDefaultProperty("maxoptra.url.getScheduleByVehicleOnDate")
									+ "?sessionID="
									+ sessionId
									+ "&date="
									+ DateFormat.getTodayDateInString()
									+ "&vehicleID=7208", HTTP_METHOD.POST,
							"Schedule_By_Vehicle_On_Date", apiResponse);
					// *******************************************************************//

					displayContent = "<html>";
					for (Performer performer : apiResponse
							.getScheduleResponse().getPerformers()
							.getPerformer()) {
						displayContent += "Performer";
						displayContent += "<br>";
						displayContent += "id : " + performer.getId();
						displayContent += "<br>";
						displayContent += "vehicle : ";
						displayContent += "<br>";
						displayContent += "name : " + performer.getName();
						displayContent += "<br>";
						displayContent += "aocId : " + performer.getAocId();
						displayContent += "<br>";
						displayContent += "runDay : " + performer.getRunDay();
						displayContent += "<br>";
						displayContent += "planDistance : "
								+ performer.getPlanDistance();
						displayContent += "<br>";
						displayContent += "planDuration : "
								+ performer.getPlanDuration();
						displayContent += "<br>";
						displayContent += "runStartTime : "
								+ performer.getRunStartTime();
						displayContent += "<br>";
						displayContent += "runEndTime : "
								+ performer.getRunEndTime();
						displayContent += "<br>";
						displayContent += "availabilityStartTime : "
								+ performer.getAvailabilityStartTime();
						displayContent += "<br>";
						displayContent += "availabilityEndTime : "
								+ performer.getAvailabilityEndTime();
						displayContent += "<br>";
						displayContent += "cost : " + performer.getCost();
						displayContent += "<br>";

						for (Location location : performer.getLocation()) {
							System.out.println("Location");
							displayContent += "<br>";

							if (location.getNumber() != null) {
								System.out.println("number : "
										+ location.getNumber());
								displayContent += "<br>";
							}

							displayContent += "locationType : "
									+ location.getLocationType();
							displayContent += "<br>";
							displayContent += "name : " + location.getName();
							displayContent += "<br>";
							displayContent += "address : "
									+ location.getAddress();
							displayContent += "<br>";
							displayContent += "latitude : "
									+ location.getLatitude();
							displayContent += "<br>";
							displayContent += "longitude : "
									+ location.getLongitude();
							displayContent += "<br>";
							displayContent += "planArrivalTime : "
									+ location.getPlanArrivalTime();
							displayContent += "<br>";
							displayContent += "planDepartureTime : "
									+ location.getPlanDepartureTime();
							displayContent += "<br>";

							if (location.getOrder() != null) {
								displayContent += "Order";
								displayContent += "<br>";
								displayContent += "orderReference : "
										+ location.getOrder()
												.getOrderReference();
								displayContent += "<br>";
								displayContent += "status : "
										+ location.getOrder().getStatus();
								displayContent += "<br>";
								displayContent += "duration : "
										+ location.getOrder().getDuration();
								displayContent += "<br>";
								displayContent += "comments : "
										+ location.getOrder().getComments();
								displayContent += "<br>";
								displayContent += "instructions : "
										+ location.getOrder().getInstructions();
								displayContent += "<br>";
								displayContent += "price : "
										+ location.getOrder().getPrice();
								displayContent += "<br>";
							}
						}
					}

					displayContent += "</html>";

					getScheduleByVehicleOnDateLabel.setText(displayContent);
				} catch (Exception ex) {
					ex.printStackTrace();
//					if (logger.isDebugEnabled()) {
//						logger.debug("Exception ........................."
//								+ ex.getMessage());
//					}
				}
			}
		});
		GroupLayout gl_panel_9 = new GroupLayout(panel_9);
		gl_panel_9.setHorizontalGroup(gl_panel_9.createParallelGroup(
				Alignment.LEADING).addGroup(
				Alignment.TRAILING,
				gl_panel_9
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(getScheduleByVehicleOnDateLabel,
								GroupLayout.PREFERRED_SIZE, 498,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 282,
								Short.MAX_VALUE)
						.addComponent(btnGetScheduleBy_1).addGap(71)));
		gl_panel_9
				.setVerticalGroup(gl_panel_9
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_9
										.createSequentialGroup()
										.addGroup(
												gl_panel_9
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_9
																		.createSequentialGroup()
																		.addGap(128)
																		.addComponent(
																				btnGetScheduleBy_1))
														.addGroup(
																gl_panel_9
																		.createSequentialGroup()
																		.addGap(28)
																		.addComponent(
																				getScheduleByVehicleOnDateLabel,
																				GroupLayout.DEFAULT_SIZE,
																				492,
																				Short.MAX_VALUE)))
										.addContainerGap()));
		panel_9.setLayout(gl_panel_9);

		JPanel panel_10 = new JPanel();
		tabbedPane.addTab("Schedule Authenticate", null, panel_10, null);

		authenticateSchedule = new JLabel("New label");

		JButton btnAuthenticateSchedule = new JButton("Authenticate Schedule");
		btnAuthenticateSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					displayContent = "<html>";

					displayContent += TestAutoScheduling.autoSchedule();

					displayContent += "</html>";

					authenticateSchedule.setText(displayContent);
				} catch (Exception ex) {
					ex.printStackTrace();
				}

			}
		});
		GroupLayout gl_panel_10 = new GroupLayout(panel_10);
		gl_panel_10.setHorizontalGroup(gl_panel_10.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel_10
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(authenticateSchedule,
								GroupLayout.PREFERRED_SIZE, 598,
								GroupLayout.PREFERRED_SIZE).addGap(87)
						.addComponent(btnAuthenticateSchedule)
						.addContainerGap(266, Short.MAX_VALUE)));
		gl_panel_10
				.setVerticalGroup(gl_panel_10
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_10
										.createSequentialGroup()
										.addGroup(
												gl_panel_10
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_10
																		.createSequentialGroup()
																		.addGap(53)
																		.addComponent(
																				authenticateSchedule,
																				GroupLayout.PREFERRED_SIZE,
																				430,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_panel_10
																		.createSequentialGroup()
																		.addGap(204)
																		.addComponent(
																				btnAuthenticateSchedule)))
										.addContainerGap(48, Short.MAX_VALUE)));
		panel_10.setLayout(gl_panel_10);

		/********************************************************* End Of Get_Schedule_By_Vehicle_On_Date Panel ****************************************************************************************/

	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
		}
	}
}