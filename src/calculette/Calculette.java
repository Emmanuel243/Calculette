package calculette;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

/**
 *
 * @author Emmanuel
 */
public class Calculette {

	public static double valeur = 0.0;
	public static double valeur1 = 0.0;
	public static double tot = 0.0;
	public static double totfe = 0.0;
	public static int moins = 0;
	public static String[] tab_string = {"2nd", "π", "e", "C", "X", "x²", "1/x", "|x|",
		"exp", "mod", "√x", "(", ")", "n!", "÷", "x^y", "7", "8", "9", "x", "10^x", "4", "5", "6", "−", "log", "1", "2", "3", "+",
		"In", "+/-", "0", ".", "="};
	public static JButton[] tab_button = new JButton[tab_string.length];
	public static Color boutC = new Color(45, 45, 45);
	public static JPanel conteneur = new JPanel(new GridLayout(7, 5));
	public static Font police = new Font("Arial", Font.BOLD, 12);
	public static double chiffre;
	public static String operateur = "";
	public static JLabel ecran = new JLabel();
	public static JLabel ecran1 = new JLabel("0");
	public static boolean clicOperateur = false, update = false;
	public static int i = 0;
	public static int x = 0;
	public static int compt = 0;
	public static int taillev = 0;

	public static void main(String[] args) {
		JFrame calc = new JFrame("Calculatrice");
		calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calc.setSize(348, 545);
		calc.setResizable(false);
		JPanel haut = new JPanel();
		Font policeEc = new Font("Arial", Font.BOLD, 25);
		Font policenomC = new Font("Arial", Font.BOLD, 20);
		Color pol = new Color(70, 70, 70);
		JButton deg = new JButton("DEG");
		deg.setBorderPainted(false);
		deg.setBackground(pol);
		deg.setForeground(Color.WHITE);
		deg.setFont(new Font("Arial", Font.BOLD, 11));
		JButton fe = new JButton("F-E");
		fe.setForeground(Color.WHITE);
		fe.setFont(police);
		fe.setBackground(pol);
		fe.setBorderPainted(false);
		fe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				ecran.setText(totfe + "");
				valeur = totfe;
			}
		});
		JPanel msG = new JPanel(new GridLayout(1, 6));
		JButton mc = new JButton("MC");
		mc.setBackground(pol);
		mc.setForeground(new Color(192, 192, 192));
		mc.setFont(police);
		mc.setBorderPainted(false);
		JButton mr = new JButton("MR");
		mr.setBackground(pol);
		mr.setForeground(new Color(192, 192, 192));
		mr.setFont(police);
		mr.setBorderPainted(false);
		JButton mplus = new JButton("M+");
		mplus.setBackground(pol);
		mplus.setForeground(Color.WHITE);
		mplus.setFont(police);
		mplus.setBorderPainted(false);
		JButton mmoins = new JButton("M-");
		mmoins.setBackground(pol);
		mmoins.setForeground(Color.WHITE);
		mmoins.setFont(police);
		mmoins.setBorderPainted(false);
		JButton ms = new JButton("MS");
		ms.setBackground(pol);
		ms.setForeground(Color.WHITE);
		ms.setFont(police);
		ms.setBorderPainted(false);
		JButton m = new JButton("M");
		m.setBackground(pol);
		m.setForeground(new Color(192, 192, 192));
		m.setFont(police);
		m.setBorderPainted(true);
		msG.add(mc);
		msG.add(mr);
		msG.add(mplus);
		msG.add(mmoins);
		msG.add(ms);
		msG.add(m);
		msG.setPreferredSize(new Dimension(330, 24));
		JMenu trigo = new JMenu("< Trigonometrie");
		trigo.setBackground(pol);
		trigo.setForeground(Color.WHITE);
		trigo.setFont(police);
		JMenu fonction = new JMenu("f  Fonction");
		fonction.setBackground(pol);
		fonction.setForeground(Color.WHITE);
		fonction.setFont(police);
		JPanel sectionLab = new JPanel(new GridLayout(1, 2));
		sectionLab.setPreferredSize(new Dimension(335, 20));
		sectionLab.setBackground(pol);
		sectionLab.add(trigo);
		sectionLab.add(fonction);
		JPanel debut = new JPanel();
		debut.setBackground(pol);
		debut.setPreferredSize(new Dimension(330, 60));
		JLabel nomC = new JLabel("Scientifique");
		nomC.setBackground(boutC);
		nomC.setForeground(Color.WHITE);
		nomC.setPreferredSize(new Dimension(210, 45));
		nomC.setFont(policenomC);
		JMenuBar infocacher = new JMenuBar();
		JMenu info = new JMenu("≡");
		info.setBackground(pol);
		info.setFont(policenomC);
		info.setForeground(Color.WHITE);
		infocacher.setBackground(pol);
		infocacher.add(info);
		debut.add(info);
		debut.add(nomC);
		JMenu historique = new JMenu("¤");
		historique.setBackground(pol);
		historique.setFont(policenomC);
		historique.setForeground(Color.WHITE);
		debut.add(info);
		debut.add(nomC);
		debut.add(historique);
		JPanel degfe = new JPanel(new GridLayout(1, 6));
		degfe.setPreferredSize(new Dimension(330, 25));
		degfe.setBackground(pol);
		degfe.add(deg);
		degfe.add(fe);
		degfe.add(new JLabel());
		degfe.add(new JLabel());
		degfe.add(new JLabel());
		degfe.add(new JLabel());
		//On aligne les informations à droite dans le JLabel
		ecran.setHorizontalAlignment(JLabel.RIGHT);
		ecran1.setHorizontalAlignment(JLabel.RIGHT);
		ecran.setPreferredSize(new Dimension(300, 20));
		ecran1.setPreferredSize(new Dimension(300, 25));
		ecran1.setForeground(Color.WHITE);
		ecran.setForeground(new Color(173, 173, 173));
		JPanel ecrP = new JPanel();
		ecrP.setPreferredSize(new Dimension(348, 52));
		ecrP.setBackground(pol);
		ecrP.add(ecran);
		ecrP.add(ecran1);
		haut.setBackground(pol);
		ecran.setFont(policeEc);
		ecran1.setFont(policeEc);
		conteneur.setPreferredSize(new Dimension(348, 285));
		conteneur.setBackground(pol);
		haut.setPreferredSize(new Dimension(348, 210));
		bouttonOp();
		tab_button[34].setBackground(new Color(41, 80, 150));
		tab_button[16].setBackground(new Color(15, 15, 15));
		tab_button[17].setBackground(new Color(15, 15, 15));
		tab_button[18].setBackground(new Color(15, 15, 15));
		tab_button[21].setBackground(new Color(15, 15, 15));
		tab_button[22].setBackground(new Color(15, 15, 15));
		tab_button[23].setBackground(new Color(15, 15, 15));
		tab_button[26].setBackground(new Color(15, 15, 15));
		tab_button[27].setBackground(new Color(15, 15, 15));
		tab_button[28].setBackground(new Color(15, 15, 15));
		tab_button[31].setBackground(new Color(15, 15, 15));
		tab_button[32].setBackground(new Color(15, 15, 15));
		tab_button[33].setBackground(new Color(15, 15, 15));
		JPanel content = new JPanel();
		content.setBackground(pol);
		haut.add(debut);
		haut.add(ecrP);
		haut.add(degfe);
		haut.add(msG);
		haut.add(sectionLab);
		content.add(haut, BorderLayout.NORTH);
		content.add(conteneur);
		calc.add(content);
		calc.setLocationRelativeTo(null);
		calc.setVisible(true);
	}

	public static void bouttonOp() {
		for (i = 0; i < tab_string.length; i++) {
			tab_button[i] = new JButton(tab_string[i]);
			tab_button[i].setBackground(boutC);
			tab_button[i].setForeground(Color.WHITE);
			tab_button[i].setFont(police);
			conteneur.add(tab_button[i], BorderLayout.CENTER);
			String val = tab_string[i];
			switch (i) {
				case 0:
					break;
				case 1:
					tab_button[i].addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							super.mouseClicked(e);
							tot = Math.PI;
							ecran.setText(tot + "");
						}
					});
					break;
				case 2:
					tab_button[i].addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							super.mouseClicked(e);
							tot = Math.E;
							ecran.setText(tot + "");
						}
					});
					break;
				case 3:
					tab_button[i].addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
							update = true;
							taillev = 0;
							ecran.setText("");
							ecran1.setText("0");
							x = 0;
							ecran.setFont(new Font("Arial", Font.BOLD, 25));
							ecran1.setFont(new Font("Arial", Font.BOLD, 25));
							totfe = tot;
							tot = 0.0;
						}

					});
					break;
				case 4:
					tab_button[i].addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							super.mouseClicked(e);
							String chainecar = ecran1.getText();
							char[] car = chainecar.toCharArray();
							ecran1.setText("");
							for (compt = 0; compt < car.length - 1; compt++) {
								//  ecran.setText(ecran.getText().replace(car, ' '));
								ecran1.setText(ecran1.getText() + car[compt]);
								if (car[compt] == '.') {
									taillev = 1;
								}

							}
							if (ecran1.getText().length() == 0) {
								ecran1.setText("0");
							}
							tot = 0.0;
						}

					});
					break;
				case 5:
					tab_button[i].addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							super.mouseClicked(e);
							try {
								valeur = Double.parseDouble(ecran1.getText());
								tot += Math.pow(valeur, 2);
								ecran.setText(tot + "");
							} catch (Exception ex) {
								ecran.setText("Operation Incorrect");
							}
						}

					});
					break;
				case 6:
					tab_button[i].addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							super.mouseClicked(e);
							try {
								valeur = Double.parseDouble(ecran1.getText());
								if (valeur == 0) {
									ecran.setText("Operation Incorrect");
								} else {
									valeur = (1 / valeur);
									tot += valeur;
									ecran.setText(tot + "");
								}
							} catch (Exception exe) {
								ecran.setText("operation incorrect");
							}
						}
					});
					break;
				case 7:
					tab_button[i].addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							super.mouseClicked(e);
							try {
								valeur = Double.parseDouble(ecran1.getText());
								if (valeur <= 0) {
									valeur = valeur * -1;
									tot += valeur;
									ecran.setText(tot + "");
								} else if (valeur == 0.0) {
									tot += valeur;
									ecran.setText(tot + "");
								} else {
									valeur = valeur * 1;
									tot += valeur;
									ecran.setText(tot + "");
								}
							} catch (Exception exe) {
								ecran.setText("operation incorrect");
							}
						}
					});
					break;
				case 8:
					tab_button[i].addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							super.mouseClicked(e);
							try {
								valeur = Double.parseDouble(ecran1.getText());
								tot += Math.exp(valeur);
								ecran.setText(tot + "");

							} catch (Exception ex) {
								ecran.setText("Operation Incorrecte");
							}
						}

					});
					break;
				case 9:
					calcul(tab_string[i]);
					break;
				case 10:
					tab_button[i].addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							super.mouseClicked(e);
							try {
								valeur = Double.parseDouble(ecran1.getText());
								tot += Math.sqrt(valeur);
								ecran.setText(tot + "");
							} catch (Exception ex) {
								ecran.setText("Operation Incorrect");
							}
						}

					});
					break;
				case 11:
					chiffre(val);
					break;
				case 12:
					chiffre(val);
					break;
				case 13:
					tab_button[i].addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							super.mouseClicked(e);
							try {
								valeur = Double.parseDouble(ecran1.getText());
								tot += fact(valeur);
								ecran.setText(tot + "");

							} catch (Exception ex) {
								ecran.setText("Operation Incorrecte");
							}
						}

					});
					break;
				case 14:
					calcul(tab_string[i]);
					break;
				case 15:
					calcul(tab_string[i]);
					break;
				case 16:
					chiffre(val);
					break;
				case 17:
					chiffre(val);
					break;
				case 18:
					chiffre(val);
					break;
				case 19:
					calcul(tab_string[i]);
					break;
				case 20:
					tab_button[i].addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							super.mouseClicked(e);
							try{
							valeur = Double.parseDouble(ecran1.getText());
							tot += Math.pow(10, valeur);
							ecran.setText(tot + "");}catch(NumberFormatException ex){
								ecran.setText("Operation Incorrecte");
							}
						}

					});

					break;
				case 21:
					chiffre(val);
					break;
				case 22:
					chiffre(val);
					break;
				case 23:
					chiffre(val);
					break;
				case 24:
					calcul(tab_string[i]);
					break;
				case 25:
					tab_button[i].addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							super.mouseClicked(e);
							try {
								valeur = Double.parseDouble(ecran1.getText());
								if (valeur > 0.0) {
									tot += Math.log(valeur);
									ecran.setText(tot + "");
								} else if (valeur <= 0) {
									ecran.setText(" ERREUR!! NOMBRE NEGATIF");
								}
							} catch (Exception ex) {
								ecran.setText("Operation Incorrecte");
							}
						}

					});
					break;
				case 26:
					chiffre(val);
					break;
				case 27:
					chiffre(val);
					break;
				case 28:
					chiffre(val);
					break;
				case 29:
					calcul(tab_string[i]);
					break;
				case 30:
					tab_button[i].addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
							try {
								valeur = Double.parseDouble(ecran1.getText());
								if (valeur <= 0) {
									ecran1.setText("Operation Incorrect");
								} else {
									tot += Math.log10(valeur);
									ecran.setText(tot + "");
								}
							} catch (Exception ex) {
								ecran1.setText("Operation Incrorrect");
							}
						}

					});
					break;
				case 31:
					tab_button[i].addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							super.mouseClicked(e);
							try {
								ecran1.setText("" + Double.parseDouble(ecran1.getText()) * -1);
							} catch (Exception ep) {
								ecran1.setText("operation Incorrect");
							}
						}

					});
					break;
				case 32:

					chiffre(val);
					break;
				case 33:
					tab_button[i].addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
							virgule();
						}

					});
					break;
				default:
					calcul(tab_string[i]);
					break;
			}
		}
	}
//methode pour cliquez sur les chiffres

	/**
	 *
	 * @param chaine
	 */
	public static void chiffre(String chaine) {
		tab_button[i].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				if (ecran1.getText().length() <= 1 && x < 1) {
					if (ecran1.getText().equals("0")) {
						ecran1.setText("");
						x = 1;
					} else {
						ecran1.setText(ecran1.getText());
					}
				}
				if (ecran1.getText().length() < 32) {
					if (ecran1.getText().length() > 20 && ecran1.getText().length() < 27) {
						ecran1.setFont(new Font("Arial", Font.BOLD, 25 - 6));
					} else if (ecran1.getText().length() >= 27) {
						ecran1.setFont(new Font("Arial", Font.BOLD, 25 - 8));
					}
					tab_button[3].setText("CE");
					ecran1.setText(ecran1.getText() + chaine);
					tot = 0.0;
				}
			}
		});
	}

	public static void calcul(String op) {
		tab_button[i].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				char[] opCar = {'−', '+', '÷', 'd', 'x', '^'};
				if (op.equals("+") && ecran1.getText() != null) {
					if (ecran.getText().length() == 0) {
						ecran.setText(ecran1.getText());
						ecran1.setText("");
						valeur = Double.parseDouble(ecran.getText());
						ecran.setText(ecran.getText() + "+");
					} else if (tot != 0.0) {
						valeur = tot;
						ecran.setText(ecran.getText() + "+");
						ecran1.setText("");
					} else if (ecran.getText().equals(totfe + "")) {
						valeur = totfe;
						ecran.setText(ecran.getText() + "+");
						ecran1.setText("");
					}
				}
				if (op.equals("x^y") && ecran1.getText() != null) {
					if (ecran.getText().length() == 0) {
						ecran.setText(ecran1.getText());
						ecran1.setText("");
						valeur = Double.parseDouble(ecran.getText());
						ecran.setText(ecran.getText() + "^");
					} else if (tot != 0.0) {
						valeur = tot;
						ecran.setText(ecran.getText() + "^");
						ecran1.setText("");
					} else if (ecran.getText().equals(totfe + "")) {
						valeur = totfe;
						ecran.setText(ecran.getText() + "^");
						ecran1.setText("");
					}
				}
				if (op.equals("−") && ecran1.getText() != null) {
					if (ecran.getText().length() == 0) {
						if (ecran1.getText().equals("0") || ecran1.getText() == null) {
							ecran1.setText("-");
						} else {
							ecran.setText(ecran1.getText());
							ecran1.setText("");
							valeur = Double.parseDouble(ecran.getText());
							ecran.setText(ecran.getText() + "−");
						}
					} else if (tot != 0.0) {
						valeur = tot;
						ecran.setText(ecran.getText() + "−");
						ecran1.setText("");
					} else if (ecran.getText().equals(totfe + "")) {
						valeur = totfe;
						ecran.setText(ecran.getText() + "−");
						ecran1.setText("");
					}
				}
				if (op.equals("÷") && ecran1.getText() != null) {
					if (ecran.getText().length() == 0) {
						ecran.setText(ecran1.getText());
						ecran1.setText("");
						valeur = Double.parseDouble(ecran.getText());
						ecran.setText(ecran.getText() + "÷");
					} else if (tot != 0.0) {
						valeur = tot;
						ecran.setText(ecran.getText() + "÷");
						ecran1.setText("");
					} else if (ecran.getText().equals(totfe + "")) {
						valeur = totfe;
						ecran.setText(ecran.getText() + "÷");
						ecran1.setText("");
					}
				}
				if (op.equals("mod") && ecran1.getText() != null) {
					if (ecran.getText().length() == 0) {
						ecran.setText(ecran1.getText());
						ecran1.setText("");
						valeur = Double.parseDouble(ecran.getText());
						ecran.setText(ecran.getText() + "mod");
					} else if (tot != 0.0) {
						valeur = tot;
						ecran.setText(ecran.getText() + "mod");
						ecran1.setText("");
					} else if (ecran.getText().equals(totfe + "")) {
						valeur = totfe;
						ecran.setText(ecran.getText() + "mod");
						ecran1.setText("");
					}
				}
				if (op.equals("x") && ecran1.getText() != null) {
					if (ecran.getText().length() == 0) {
						ecran.setText(ecran1.getText());
						ecran1.setText("");
						valeur = Double.parseDouble(ecran.getText());
						ecran.setText(ecran.getText() + "x");
					} else if (tot != 0.0) {
						valeur = tot;
						ecran.setText(ecran.getText() + "x");
						ecran1.setText("");
					} else if (ecran.getText().equals(totfe + "")) {
						valeur = totfe;
						ecran.setText(ecran.getText() + "x");
						ecran1.setText("");
					}
				}
				if (op.equals("=")) {
					try {
						if (ecran.getText().length() == 0) {
							tot += Double.parseDouble(ecran1.getText());
							ecran.setText(tot + "");
						} else {
							String signe = ecran.getText();
							char[] car = signe.toCharArray();
							char s = car[car.length - 1];
							if (s == '+') {
								valeur1 = Double.parseDouble(ecran1.getText());
								tot += valeur + valeur1;
								ecran.setText(tot + "");
							}
							if (s == '−') {
								valeur1 = Double.parseDouble(ecran1.getText());
								tot += valeur - valeur1;
								ecran.setText(tot + "");
							}
							if (s == '^') {
								valeur1 = Double.parseDouble(ecran1.getText());
								tot += Math.pow(valeur, valeur1);
								ecran.setText(tot + "");
							}
							if (s == '÷') {
								valeur1 = Double.parseDouble(ecran1.getText());
								if (valeur1 != 0) {
									tot += valeur / valeur1;
									ecran.setText(tot + "");
								} else {
									ecran.setText("DIVISION  PAR  ZERO  IMPOSSIBLE ");
								}
							}
							if (s == 'x') {
								valeur1 = Double.parseDouble(ecran1.getText());
								tot += valeur * valeur1;
								ecran.setText(tot + "");
							}
							if (s == 'd') {
								valeur1 = Double.parseDouble(ecran1.getText());
								tot += valeur % valeur1;
								ecran.setText(tot + "");
							}
						}

					} catch (NumberFormatException ev) {
						ecran1.setText("Operation Incorrecte");
					} catch (Exception ex) {
						ecran1.setText("Operation Incorrecte");
					}
				}
			}

		});
	}

	public static double fact(double x) {
		double res = 1;
		if (x >= 0) {
			for (int i = 2; i <= x; i++) {
				res = res * i;
			}
			return res;
		} else {
			return 0;
		}
	}

	public static void virgule() {
		taillev = 0;
		String valeur = ecran1.getText();
		char[] tabvaleur = valeur.toCharArray();
		for (compt = 0; compt < tabvaleur.length; compt++) {
			if (tabvaleur[compt] == '.') {
				taillev++;
			}
		}
		if (taillev == 0) {
			if (tabvaleur[tabvaleur.length - 1] == '(') {
				ecran1.setText(ecran1.getText() + "0.");
			} else {
				ecran1.setText(ecran1.getText() + ".");
			}
		}
	}

}
