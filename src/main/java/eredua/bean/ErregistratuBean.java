package eredua.bean;
import java.io.Serializable;

import businessLogic.BLFacade;
import domain.Seller;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

@Named("Erregistratu")
@SessionScoped
public class ErregistratuBean implements Serializable {
	private static final long serialVersionUID = 1L;

    private String izena;
    private String emaila;
    private String pasahitza;
    private String pasahitza2;
    
    private transient BLFacade blFacade = FacadeBean.getBusinessLogic();
    
    public ErregistratuBean() {}
    
    public String egiaztatu() {
    	if (pasahitza2 == null || !pasahitza.equals(pasahitza2)) {
    		System.out.println("Pasahitzak ez dira berdinak." );
  
    		return "error";
    	}
    	
    	BLFacade facade = FacadeBean.getBusinessLogic();
    	
    	if (facade == null) {
    		System.out.println("Ezin izan da konektatu.");
    		
			return "error";
		}
    	
    	Seller s = facade.register(emaila, izena, pasahitza);
    	
    	if (s == null) {
    		System.out.println("Ezin izan da kontua sortu.");
							
    		return "error";
    	}
    	
		return "ok";
    
    }
	//Getter-ak eta setter-ak
	public void setIzena(String izena) {this.izena=izena;}
	public String getIzena() {return izena;}
	
	public void setEmaila(String emaila) {this.emaila=emaila;}
	public String getEmaila() {return emaila;}
	
	public void setPasahitza(String pasahitza) {this.pasahitza=pasahitza;}
	public String getPasahitza() {return pasahitza;}
	
	public void setPasahitza2(String pasahitza2) {this.pasahitza2=pasahitza2;}
	public String getPasahitza2() {return pasahitza2;}
}

