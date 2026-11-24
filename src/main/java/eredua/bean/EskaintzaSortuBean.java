package eredua.bean;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.primefaces.event.SelectEvent;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

@Named("EskaintzaSortu")
@SessionScoped
public class EskaintzaSortuBean implements Serializable {
	private EgoeraMota mota;
	private static List<EgoeraMota> motak=new ArrayList<EgoeraMota>();
	
	
	private String tituloa;
	private Date data; 
	private String deskripzioa;
	private Double prezioa;

	public EskaintzaSortuBean() {
		motak.add(new EgoeraMota("Berria"));
		motak.add(new EgoeraMota("Apurbat erabilia"));
		motak.add(new EgoeraMota("Zaharra"));
	}
	public EgoeraMota getMota() {
		return mota;
	}
	public void setMota(EgoeraMota mota) {
		this.mota = mota;
		System.out.println("Egoera mota: " + mota.getEgoMota());
	}
	public List<EgoeraMota> getMotak() {
		return motak;
	}
	public void setMotak(List<EgoeraMota> motak) {
		this.motak = motak;
	}

	public void onDateSelect(SelectEvent event) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Data aukeratua: "+event.getObject()));
	}
	
	public String createSale() {
		return "ok";
	}
	
	public String igoArgazkia() {
		return null;
	}
	
	//Getter-ak eta setter-ak
	public String getTituloa() {return tituloa;}

	public void setTituloa(String tituloa) {this.tituloa = tituloa;}

	public Date getData() {return data;}

	public void setData(Date data) {this.data = data;}

	public String getDeskripzioa() {return deskripzioa;}

	public void setDeskripzioa(String deskripzioa) {this.deskripzioa = deskripzioa;}

	public Double getPrezioa() {return prezioa;}

	public void setPrezioa(Double prezioa) {this.prezioa = prezioa;}

}
