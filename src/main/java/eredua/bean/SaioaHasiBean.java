package eredua.bean;

import java.io.Serializable;

import businessLogic.BLFacade;
import domain.Seller;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named("SaioaHasi")
@SessionScoped
public class SaioaHasiBean implements Serializable {
	private static final long serialVersionUID = 1L;

    private String izena;
    private String emaila;
    private String pasahitza;
    private Seller unekoErabiltzailea;
    
    private transient BLFacade blFacade = FacadeBean.getBusinessLogic();
    
    public SaioaHasiBean() {}
    
    public String egiaztatu() {
    	BLFacade facade = FacadeBean.getBusinessLogic();
		System.out.println("SaioaHasiBean -> emaila=" + emaila + ", pasahitza=" + pasahitza);

		if (facade == null) {
			return "error";
		}

		Seller s = facade.isLogin(emaila, pasahitza);
		System.out.println("SaioaHasiBean -> isLogin emaitza=" + s);

		if (s == null) {
			return "error";
		}

		this.unekoErabiltzailea = s;
		this.izena = s.getName();
		return "ok";
    }
	//Getter-ak eta setter-ak
	public void setIzena(String izena) {this.izena=izena;}
	public String getIzena() {return izena;}
	
	public void setEmaila(String emaila) {this.emaila=emaila;}
	public String getEmaila() {return emaila;}
	
	public void setPasahitza(String pasahitza) {this.pasahitza=pasahitza;}
	public String getPasahitza() {return pasahitza;}
	
	public Seller getUnekoErabiltzailea() {return unekoErabiltzailea;}

	public void setUnekoErabiltzailea(Seller unekoErabiltzailea) {this.unekoErabiltzailea = unekoErabiltzailea;}
}
