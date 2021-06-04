package maniv.billcalcuclator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JSeparator;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BillCalculatorGUI extends JDialog {

	private static final long serialVersionUID = 7474804731034659026L;
	
	private final JPanel contentPanel = new JPanel();
	private JLabel lblLoadTag;
	private JComboBox<String> cboLoad;
	private long consumedUnit;
	private float billAmount;
	
	private JTextField txtConsumedUnit;
	private JTextField txtBillAmount;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			BillCalculatorGUI dialog = new BillCalculatorGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public BillCalculatorGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(BillCalculatorGUI.class.getResource("/Image/icon.png")));
		
		setResizable(false);
		setModalityType(ModalityType.DOCUMENT_MODAL);
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setDefaultLookAndFeelDecorated(false);
		setTitle("Bill Calculator");
		
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		int width = 406;
		int height = 250;
		int x = ((int)d.getWidth()-(width))/2;
		int y =  ((int)d.getHeight()-(height))/2;
		
		setBounds(x, y, 406, 250);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 245, 238));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel pnlYear = new JPanel();
		pnlYear.setBounds(5, 5, 381, 164);
		pnlYear.setBorder(new LineBorder(Color.LIGHT_GRAY));
		pnlYear.setBackground(new Color(255, 245, 238));
		pnlYear.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Category");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(26, 22, 56, 14);
		pnlYear.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Consumed");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(0, 53, 82, 14);
		pnlYear.add(lblNewLabel_3);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(238, 130, 238));
		panel.setBounds(10, 111, 361, 42);
		pnlYear.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Bill Amount");
		lblNewLabel_6.setBounds(0, 15, 72, 14);
		panel.add(lblNewLabel_6);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txtBillAmount = new JTextField();
		txtBillAmount.setEditable(false);
		txtBillAmount.setBackground(new Color(238, 130, 238));
		txtBillAmount.setOpaque(false);
		txtBillAmount.setBounds(93, 5, 250, 31);
		panel.add(txtBillAmount);
		txtBillAmount.setText("RS. 0.0");
		txtBillAmount.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtBillAmount.setColumns(10);
		
		JComboBox<String> cboCategory = new JComboBox<String>();
		cboCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtBillAmount.setText("0.0");
				if(cboCategory.getSelectedIndex()==0) {
					lblLoadTag.setVisible(true);
					cboLoad.setVisible(true);
				}else {
					lblLoadTag.setVisible(false);
					cboLoad.setVisible(false);
				}
			}
		});
		cboCategory.setModel(new DefaultComboBoxModel<String>(new String[] {"Domestic Consumer"}));
		cboCategory.setBounds(104, 19, 248, 20);
		pnlYear.add(cboCategory);
		
		cboLoad = new JComboBox<String>();
		cboLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtBillAmount.setText("0.0");
			}
		});
		cboLoad.setModel(new DefaultComboBoxModel<String>(new String[] {"5 Amp.", "15 Amp.", "30 Amp."}));
		cboLoad.setBounds(268, 55, 84, 20);
		pnlYear.add(cboLoad);
		
		lblLoadTag = new JLabel("Load");
		lblLoadTag.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLoadTag.setBounds(212, 58, 46, 14);
		pnlYear.add(lblLoadTag);
		
		
		
		txtConsumedUnit = new JTextField();
		txtConsumedUnit.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				txtBillAmount.setText("0.0");
			}
		});
		txtConsumedUnit.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtConsumedUnit.selectAll();
			}
		});
		txtConsumedUnit.setText("0");
		txtConsumedUnit.setBounds(104, 55, 98, 20);
		pnlYear.add(txtConsumedUnit);
		txtConsumedUnit.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 101, 380, 2);
		pnlYear.add(separator);
		
		JLabel lblNewLabel_3_1 = new JLabel("Units");
		lblNewLabel_3_1.setBounds(36, 66, 46, 14);
		pnlYear.add(lblNewLabel_3_1);
		contentPanel.setLayout(null);

		contentPanel.add(pnlYear);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 228, 225));
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Calculate");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(txtConsumedUnit.getText().equals("")) {
							txtConsumedUnit.setText("0");
							consumedUnit = 0;
						}else {
							consumedUnit = Long.parseLong(txtConsumedUnit.getText());
						}
		
						if(cboCategory.getSelectedIndex()==0) {
							String load = cboLoad.getSelectedItem().toString();
							billAmount = CalculateBill.billDomestic(load, consumedUnit);
							
						}else {
							//Code here for non domestic consumers bill
						}
						txtBillAmount.setText("RS. "+Float.toString(billAmount));
					}
					
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		
		cboLoad.setVisible(true);
		
	}
}
