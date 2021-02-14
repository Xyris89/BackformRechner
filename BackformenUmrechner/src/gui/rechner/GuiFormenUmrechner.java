/* Bekannte Bugs und noch nicht vorhandene Fetures:
 * - Optik verschönern
 * - Code optimieren
 */

package gui.rechner;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Rechteck;
import geometry.Zylinder;
import objekts.Zutat;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class GuiFormenUmrechner extends JFrame {

    private JPanel contentPane;
    private JLabel lblFormEins;
    private JRadioButton rdbtnRechteckigFormEins;
    private JRadioButton rdbtnRundFormEins;
    private JLabel lblFormZwei;
    private JRadioButton rdbtnRechteckigFormZwei;
    private JRadioButton rdbtnRundFormZwei;
    private JLabel lblEingabeEinsFormEins;
    private JLabel lblEingabeZweiFormEins;
    private JLabel lblEingabeDreiFormEins;
    private JLabel lblEingabeEinsFormZwei;
    private JLabel lblEingabeZweiFormZwei;
    private JLabel lblEingabeDreiFormZwei;
    private JTextField textEingabeEinsFormEins;
    private JTextField textEingabeZweiFormEins;
    private JTextField textEingabeDreiFormEins;
    private JTextField textEingabeEinsFormZwei;
    private JTextField textEingabeZweiFormZwei;
    private JTextField textEingabeDreiFormZwei;
    private JButton btnUmrechnen;
    private JLabel lblAusgabe;
    private JScrollPane scrollPaneFormEins;
    private JList<String> listFormEins;
    private JLabel lblZutatName;
    private JTextField textZutatname;
    private JButton btnHinzufuegen;
    private JLabel lblMenge;
    private JTextField textMenge;
    private JLabel lblEinheit;
    private JTextField textEinheit;
    private JButton btnBearbeiten;
    private JScrollPane scrollPaneFormZwei;
    private JList<String> listFormZwei;

    private ArrayList<Zutat> zutaten = new ArrayList<>();
    private ArrayList<Zutat> berechneteZutaten = new ArrayList<>();
    private DefaultListModel<String> zutatFormEins;
    private DefaultListModel<String> zutatFormZwei;
    private JButton btnUebernehmen;
    private JButton btnLoeschen;

    private int i = 0;
    private JLabel lblSeiteAcm;
    private JLabel lblForm1HoeheCM;
    private JLabel lblForm1SteiteBcm;

    private ImageIcon icon = new ImageIcon("res/liga.jpg");

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    GuiFormenUmrechner frame = new GuiFormenUmrechner();
		    frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Create the frame.
     */
    public GuiFormenUmrechner() {
	setTitle("Backformen - Umrechner Beta 1.0");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 440, 350);
	setLocationRelativeTo(null);
	setIconImage(icon.getImage());
	setResizable(false);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	lblFormEins = new JLabel("Form 1:");
	lblFormEins.setBounds(10, 10, 46, 14);
	contentPane.add(lblFormEins);

	rdbtnRechteckigFormEins = new JRadioButton("Rechteckig");
	rdbtnRechteckigFormEins.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		rdbtnRundFormEins.setSelected(false);
		rdbtnRechteckigFormEins.setSelected(true);
		lblEingabeZweiFormEins.setVisible(true);
		textEingabeZweiFormEins.setVisible(true);

		textEingabeDreiFormEins.setText("4");
		lblEingabeEinsFormEins.setText("Seite a:");
	    }
	});
	rdbtnRechteckigFormEins.setSelected(true);
	rdbtnRechteckigFormEins.setBounds(10, 30, 100, 23);
	contentPane.add(rdbtnRechteckigFormEins);

	rdbtnRundFormEins = new JRadioButton("Rund");
	rdbtnRundFormEins.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		rdbtnRundFormEins.setSelected(true);
		rdbtnRechteckigFormEins.setSelected(false);
		lblEingabeZweiFormEins.setVisible(false);
		textEingabeZweiFormEins.setVisible(false);

		textEingabeDreiFormEins.setText("6");
		lblEingabeEinsFormEins.setText("Durchmesser:");
	    }
	});
	rdbtnRundFormEins.setBounds(110, 30, 60, 23);
	contentPane.add(rdbtnRundFormEins);

	lblFormZwei = new JLabel("Form 2:");
	lblFormZwei.setBounds(10, 140, 46, 14);
	contentPane.add(lblFormZwei);

	rdbtnRechteckigFormZwei = new JRadioButton("Rechteckig");
	rdbtnRechteckigFormZwei.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		rdbtnRechteckigFormZwei.setSelected(true);
		rdbtnRundFormZwei.setSelected(false);
		lblEingabeZweiFormZwei.setVisible(true);
		textEingabeZweiFormZwei.setVisible(true);

		textEingabeDreiFormZwei.setText("4");
		lblEingabeEinsFormZwei.setText("Seite a:");
	    }
	});
	rdbtnRechteckigFormZwei.setSelected(true);
	rdbtnRechteckigFormZwei.setBounds(10, 160, 100, 23);
	contentPane.add(rdbtnRechteckigFormZwei);

	rdbtnRundFormZwei = new JRadioButton("Rund");
	rdbtnRundFormZwei.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		rdbtnRechteckigFormZwei.setSelected(false);
		rdbtnRundFormZwei.setSelected(true);
		lblEingabeZweiFormZwei.setVisible(false);
		textEingabeZweiFormZwei.setVisible(false);

		textEingabeDreiFormZwei.setText("6");
		lblEingabeEinsFormZwei.setText("Durchmesser:");
	    }
	});
	rdbtnRundFormZwei.setBounds(110, 160, 60, 23);
	contentPane.add(rdbtnRundFormZwei);

	lblEingabeEinsFormEins = new JLabel("Seite a:");
	lblEingabeEinsFormEins.setBounds(10, 55, 90, 14);
	contentPane.add(lblEingabeEinsFormEins);

	lblEingabeZweiFormEins = new JLabel("Seite b:");
	lblEingabeZweiFormEins.setBounds(10, 95, 46, 14);
	contentPane.add(lblEingabeZweiFormEins);

	lblEingabeDreiFormEins = new JLabel("H\u00F6he:");
	lblEingabeDreiFormEins.setBounds(100, 55, 46, 14);
	contentPane.add(lblEingabeDreiFormEins);

	lblEingabeEinsFormZwei = new JLabel("Seite a:");
	lblEingabeEinsFormZwei.setBounds(10, 185, 90, 14);
	contentPane.add(lblEingabeEinsFormZwei);

	lblEingabeZweiFormZwei = new JLabel("Seite b:");
	lblEingabeZweiFormZwei.setBounds(10, 225, 46, 14);
	contentPane.add(lblEingabeZweiFormZwei);

	lblEingabeDreiFormZwei = new JLabel("H\u00F6he:");
	lblEingabeDreiFormZwei.setBounds(100, 185, 46, 14);
	contentPane.add(lblEingabeDreiFormZwei);

	textEingabeEinsFormEins = new JTextField();
	textEingabeEinsFormEins.setBounds(10, 70, 40, 20);
	contentPane.add(textEingabeEinsFormEins);
	textEingabeEinsFormEins.setColumns(10);

	textEingabeZweiFormEins = new JTextField();
	textEingabeZweiFormEins.setBounds(10, 110, 40, 20);
	contentPane.add(textEingabeZweiFormEins);
	textEingabeZweiFormEins.setColumns(10);

	textEingabeDreiFormEins = new JTextField();
	textEingabeDreiFormEins.setText("4");
	textEingabeDreiFormEins.setBounds(100, 70, 40, 20);
	contentPane.add(textEingabeDreiFormEins);
	textEingabeDreiFormEins.setColumns(10);

	textEingabeEinsFormZwei = new JTextField();
	textEingabeEinsFormZwei.setBounds(10, 200, 40, 20);
	contentPane.add(textEingabeEinsFormZwei);
	textEingabeEinsFormZwei.setColumns(10);

	textEingabeZweiFormZwei = new JTextField();
	textEingabeZweiFormZwei.setBounds(10, 240, 40, 20);
	contentPane.add(textEingabeZweiFormZwei);
	textEingabeZweiFormZwei.setColumns(10);

	textEingabeDreiFormZwei = new JTextField();
	textEingabeDreiFormZwei.setText("4");
	textEingabeDreiFormZwei.setBounds(100, 200, 40, 20);
	contentPane.add(textEingabeDreiFormZwei);
	textEingabeDreiFormZwei.setColumns(10);

	btnUmrechnen = new JButton("Umrechnen");
	btnUmrechnen.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		umrechnen();
	    }
	});
	btnUmrechnen.setBounds(10, 270, 142, 23);
	contentPane.add(btnUmrechnen);

	lblAusgabe = new JLabel("Unterschied:");
	lblAusgabe.setBounds(10, 295, 142, 14);
	contentPane.add(lblAusgabe);

	scrollPaneFormEins = new JScrollPane();
	scrollPaneFormEins.setBounds(180, 80, 230, 105);
	contentPane.add(scrollPaneFormEins);

	listFormEins = new JList<String>();
	listFormEins.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	scrollPaneFormEins.setViewportView(listFormEins);
	zutatFormEins = new DefaultListModel<>();
	listFormEins.setModel(zutatFormEins);

	lblZutatName = new JLabel("Zutatname:");
	lblZutatName.setBounds(180, 10, 86, 14);
	contentPane.add(lblZutatName);

	textZutatname = new JTextField();
	textZutatname.addKeyListener(new KeyAdapter() {
	    @Override
	    public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		    textMenge.requestFocus();
		    textMenge.selectAll();
		}
	    }
	});
	textZutatname.setBounds(180, 25, 120, 20);
	contentPane.add(textZutatname);
	textZutatname.setColumns(10);

	btnHinzufuegen = new JButton("Hinzuf\u00FCgen");
	btnHinzufuegen.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		addList();
	    }
	});
	btnHinzufuegen.setBounds(180, 50, 110, 23);
	contentPane.add(btnHinzufuegen);

	lblMenge = new JLabel("Menge:");
	lblMenge.setBounds(310, 10, 46, 14);
	contentPane.add(lblMenge);

	textMenge = new JTextField();
	textMenge.addKeyListener(new KeyAdapter() {
	    @Override
	    public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		    textEinheit.requestFocus();
		    textEinheit.selectAll();
		}
	    }
	});
	textMenge.setBounds(310, 25, 60, 20);
	contentPane.add(textMenge);
	textMenge.setColumns(10);

	lblEinheit = new JLabel("Einheit:");
	lblEinheit.setBounds(380, 10, 46, 14);
	contentPane.add(lblEinheit);

	textEinheit = new JTextField();
	textEinheit.addKeyListener(new KeyAdapter() {
	    @Override
	    public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		    textZutatname.requestFocus();
		    textZutatname.selectAll();
		    
		    if (btnHinzufuegen.isVisible()) {
			addList();
		    }
		    if (btnUebernehmen.isVisible()) {
			changeListEntry();
		    }
		}
	    }
	});
	textEinheit.setBounds(380, 25, 30, 20);
	contentPane.add(textEinheit);
	textEinheit.setColumns(10);

	btnBearbeiten = new JButton("Bearbeiten");
	btnBearbeiten.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		try {
		    i = listFormEins.getSelectedIndex();

		    textZutatname.setText(zutaten.get(i).getName());
		    textMenge.setText(String.valueOf((int) zutaten.get(i).getAnzahl()));
		    textEinheit.setText(zutaten.get(i).getEinheit());
		    
		    textZutatname.requestFocus();
		    textZutatname.selectAll();

		    btnUebernehmen.setVisible(true);
		    btnLoeschen.setVisible(true);
		    btnBearbeiten.setVisible(false);
		    btnHinzufuegen.setVisible(false);
		} catch (Exception e2) {
		    JOptionPane.showMessageDialog(null, "Bitte wählen Sie eine Zutat in der oberen Liste aus");
		}
	    }
	});
	btnBearbeiten.setBounds(300, 50, 110, 23);
	contentPane.add(btnBearbeiten);

	scrollPaneFormZwei = new JScrollPane();
	scrollPaneFormZwei.setBounds(180, 195, 230, 105);
	contentPane.add(scrollPaneFormZwei);

	listFormZwei = new JList<String>();
	zutatFormZwei = new DefaultListModel<>();
	listFormZwei.setModel(zutatFormZwei);
	listFormZwei.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	scrollPaneFormZwei.setViewportView(listFormZwei);

	btnUebernehmen = new JButton("\u00DCbernehmen");
	btnUebernehmen.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		changeListEntry();
	    }
	});
	btnUebernehmen.setVisible(false);
	btnUebernehmen.setBounds(180, 50, 110, 23);
	contentPane.add(btnUebernehmen);

	btnLoeschen = new JButton("L\u00F6schen");
	btnLoeschen.setVisible(false);
	btnLoeschen.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		zutaten.remove(i);
		zutatFormEins.remove(i);

		btnUebernehmen.setVisible(false);
		btnLoeschen.setVisible(false);
		btnBearbeiten.setVisible(true);
		btnHinzufuegen.setVisible(true);
	    }
	});
	btnLoeschen.setBounds(300, 50, 110, 23);
	contentPane.add(btnLoeschen);

	lblSeiteAcm = new JLabel("cm");
	lblSeiteAcm.setBounds(55, 75, 25, 14);
	contentPane.add(lblSeiteAcm);

	lblForm1HoeheCM = new JLabel("cm");
	lblForm1HoeheCM.setBounds(145, 75, 25, 14);
	contentPane.add(lblForm1HoeheCM);

	lblForm1SteiteBcm = new JLabel("cm");
	lblForm1SteiteBcm.setBounds(54, 115, 25, 14);
	contentPane.add(lblForm1SteiteBcm);
    }
    
    private void changeListEntry() {
	if (textZutatname.getText().isEmpty() || textMenge.getText().isEmpty() || textEinheit.getText().isEmpty()) {
	    JOptionPane.showMessageDialog(null, "Bitte alle Felder ausfüllen!");
	    return;
	}
	int getAnzahl = 0;
	String getName = textZutatname.getText();
	try {
	    getAnzahl = Integer.parseInt(textMenge.getText());
	} catch (NumberFormatException e) {
	    JOptionPane.showMessageDialog(null, "Bitte geben Sie bei der Menge nur Zahlen ein!");
	}
	
	String getEinheit = textEinheit.getText();

	Zutat z = new Zutat(getName, getAnzahl, getEinheit);

	zutaten.set(i, z);
	zutatFormEins.set(i, getAnzahl + getEinheit + " " + getName);

	btnUebernehmen.setVisible(false);
	btnLoeschen.setVisible(false);
	btnBearbeiten.setVisible(true);
	btnHinzufuegen.setVisible(true);
    }

    private void umrechnen() {
	double formEins;
	double formZwei;
	double prozent;
	if (textEingabeEinsFormEins.getText().isEmpty()
		|| (textEingabeZweiFormEins.getText().isEmpty() && rdbtnRechteckigFormEins.isSelected())
		|| textEingabeDreiFormEins.getText().isEmpty() || textEingabeEinsFormZwei.getText().isEmpty()
		|| (textEingabeZweiFormZwei.getText().isEmpty() && rdbtnRechteckigFormZwei.isSelected())
		|| textEingabeDreiFormEins.getText().isEmpty()) {
	    JOptionPane.showMessageDialog(null, "Bitte alle Felder ausfüllen!");
	    return;
	}
	// Form 1

	formEins = form1();
	// Form 2
	formZwei = form2();
	// Prozent

	if (formEins <= 0 || formZwei <= 0) {
	    return;
	}

	prozent = prozent(formEins, formZwei);

	berechneListe2(prozent);
	lblAusgabe.setText(Math.round(prozent) + "%");
    }

    private double form1() {
	try {
	    if (rdbtnRechteckigFormEins.isSelected()) {

		double a = 0;
		double b = 0;
		double h = 0;

		try {
		    a = Double.parseDouble(textEingabeEinsFormEins.getText());
		    b = Double.parseDouble(textEingabeZweiFormEins.getText());
		    h = Double.parseDouble(textEingabeDreiFormEins.getText());
		} catch (NumberFormatException e) {
		    JOptionPane.showMessageDialog(null, "Bitte gibt nur gültige Zahlen ein");
		    return 0;
		}

		Rechteck r = new Rechteck(a, b, h);
		return r.getVolumen();
	    } else {

		double d;
		double h;

		d = Double.parseDouble(textEingabeEinsFormEins.getText());
		h = Double.parseDouble(textEingabeDreiFormEins.getText());

		Zylinder z = new Zylinder(d, h);
		return z.getVolumen();
	    }
	} catch (NumberFormatException e) {
	    JOptionPane.showMessageDialog(null, "Bitte gibt nur gültige Zahlen ein");
	    return 0;
	}
    }

    private double form2() {
	try {
	    if (rdbtnRechteckigFormZwei.isSelected()) {
		double a = Double.parseDouble(textEingabeEinsFormZwei.getText());
		double b = Double.parseDouble(textEingabeZweiFormZwei.getText());
		double h = Double.parseDouble(textEingabeDreiFormZwei.getText());

		Rechteck r = new Rechteck(a, b, h);
		return r.getVolumen();

	    } else {

		double d;
		double h;

		d = Double.parseDouble(textEingabeEinsFormZwei.getText());
		h = Double.parseDouble(textEingabeDreiFormZwei.getText());

		Zylinder z = new Zylinder(d, h);
		return z.getVolumen();
	    }
	} catch (NumberFormatException e) {
	    JOptionPane.showMessageDialog(null, "Bitte gibt nur gültige Zahlen ein");
	    return 0;
	}

    }

    private double prozent(double eins, double zwei) {
	double prozent = 100 / eins * zwei;
	return prozent;
    }

    private void addList() {
	if (textZutatname.getText().isEmpty() || textMenge.getText().isEmpty() || textEinheit.getText().isEmpty()) {
	    JOptionPane.showMessageDialog(null, "Bitte alle Felder ausfüllen!");
	    return;
	}

	String getName = textZutatname.getText();
	int getAnzahl = 0;
	try {
	    getAnzahl = Integer.parseInt(textMenge.getText());
	} catch (NumberFormatException e) {
	    JOptionPane.showMessageDialog(null, "Bitte gib als Menge nur ein Zahl ein!");
	    return;
	}

	String getEinheit = textEinheit.getText();

	Zutat z = new Zutat(getName, getAnzahl, getEinheit);
	zutaten.add(z);

	zutatFormEins.addElement(getAnzahl + getEinheit + " " + getName);
    }

    private void berechneListe2(double prozent) {

	if (zutaten.size() <= 0) {
	    JOptionPane.showMessageDialog(null, "Bitte fügen Sie erst Zutaten hinzu!");
	    return;
	}

	berechneteZutaten.clear();

	System.out.println(zutaten.get(0).getAnzahl());

	for (int i = 0; i < zutaten.size(); i++) {
	    berechneteZutaten
		    .add(new Zutat(zutaten.get(i).getName(), zutaten.get(i).getAnzahl(), zutaten.get(i).getEinheit()));
	    berechneteZutaten.get(i).setAnzahl(berechneteZutaten.get(i).getAnzahl() * prozent / 100);
	}

	zutatFormZwei.clear();

	for (int i = 0; i < berechneteZutaten.size(); i++) {
	    String ausgabe = Math.round(berechneteZutaten.get(i).getAnzahl()) + berechneteZutaten.get(i).getEinheit()
		    + " " + berechneteZutaten.get(i).getName();

	    zutatFormZwei.addElement(ausgabe);
	}
    }
}
